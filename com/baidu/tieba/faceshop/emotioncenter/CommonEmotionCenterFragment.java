package com.baidu.tieba.faceshop.emotioncenter;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.er9;
import com.baidu.tieba.f05;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.fk5;
import com.baidu.tieba.gs4;
import com.baidu.tieba.h27;
import com.baidu.tieba.hr9;
import com.baidu.tieba.ir9;
import com.baidu.tieba.j27;
import com.baidu.tieba.kr9;
import com.baidu.tieba.m17;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.rr9;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w17;
import com.baidu.tieba.w4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CommonEmotionCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public TbWebView b;
    public NewFaceGroupDownloadModel c;
    public RelativeLayout d;
    public LoadingView e;
    public fk5 f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ CommonEmotionCenterFragment b;

        public a(CommonEmotionCenterFragment commonEmotionCenterFragment, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonEmotionCenterFragment;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.a.optString("id").split(",")));
                for (String str : arrayList) {
                    m17.o().k(str);
                }
                if (hr9.i().c(arrayList, true)) {
                    this.b.X2("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    this.b.X2("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ CommonEmotionCenterFragment b;

        public b(CommonEmotionCenterFragment commonEmotionCenterFragment, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonEmotionCenterFragment;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public c(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f = hr9.i().f();
                if (f == null || f.isEmpty()) {
                    this.a.X2("javascript:__js_bridge_emoticon_has_action()");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (MyEmotionGroupData myEmotionGroupData : f) {
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        sb.append(",");
                    }
                }
                CommonEmotionCenterFragment commonEmotionCenterFragment = this.a;
                commonEmotionCenterFragment.X2("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public d(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                this.a.X2("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public e(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                this.a.X2("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public f(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.X2("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ CommonEmotionCenterFragment b;

        public g(CommonEmotionCenterFragment commonEmotionCenterFragment, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonEmotionCenterFragment;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hr9.i().j(new ArrayList(Arrays.asList(this.a.optString("id").split(","))), true);
                this.b.X2("javascript:__js_bridge_emoticon_sort_action()");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements kr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        @Override // com.baidu.tieba.kr9
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public h(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // com.baidu.tieba.kr9
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.X2("javascript:__js_bridge_emoticon_save_action(0)");
        }

        @Override // com.baidu.tieba.kr9
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.X2("javascript:__js_bridge_emoticon_save_action(1)");
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(CommonEmotionCenterFragment commonEmotionCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.X2("javascript:__js_bridge_emoticon_refresh_has_action()");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(CommonEmotionCenterFragment commonEmotionCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData) && ((LikeReturnData) customResponsedMessage.getData()).isLike() == 1) {
                this.a.X2("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(CommonEmotionCenterFragment commonEmotionCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof EmotionPackageData)) {
                EmotionPackageData emotionPackageData = (EmotionPackageData) customResponsedMessage.getData();
                if (emotionPackageData.has_vote == 0 && emotionPackageData.id > 0) {
                    CommonEmotionCenterFragment commonEmotionCenterFragment = this.a;
                    commonEmotionCenterFragment.X2("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(CommonEmotionCenterFragment commonEmotionCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = null;
                if (hashMap != null && !hashMap.isEmpty()) {
                    if (hashMap.containsKey("upload_result")) {
                        if (hashMap.get("upload_result") != null && (hashMap.get("upload_result") instanceof Boolean)) {
                            if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                                BdToast.makeText(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f071b)).show();
                                this.a.W2(1, null);
                                return;
                            }
                            if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                                str = (String) hashMap.get("upload_msg");
                            }
                            this.a.W2(0, str);
                            return;
                        }
                        this.a.W2(0, null);
                        return;
                    }
                    this.a.W2(0, null);
                    return;
                }
                this.a.W2(0, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public m(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CommonEmotionCenterFragment b;

        public n(CommonEmotionCenterFragment commonEmotionCenterFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonEmotionCenterFragment;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                this.b.b.loadUrl(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements kr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public o(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // com.baidu.tieba.kr9
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.X2("javascript:__js_bridge_emoticon_down_process_action(-1)");
        }

        @Override // com.baidu.tieba.kr9
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0 && i < 100) {
                CommonEmotionCenterFragment commonEmotionCenterFragment = this.a;
                commonEmotionCenterFragment.X2("javascript:__js_bridge_emoticon_down_process_action(" + i + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        @Override // com.baidu.tieba.kr9
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.X2("javascript:__js_bridge_emoticon_down_process_action(100)");
        }
    }

    /* loaded from: classes5.dex */
    public class p implements j27 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public p(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        @Override // com.baidu.tieba.j27
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), 25021)));
            }
        }

        @Override // com.baidu.tieba.j27
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), true, 25021)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CommonEmotionCenterFragment c;

        public q(CommonEmotionCenterFragment commonEmotionCenterFragment, LikeModel likeModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment, likeModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = commonEmotionCenterFragment;
            this.a = likeModel;
            this.b = str;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    this.c.showToast(R.string.unfollow_title);
                    this.c.X2("javascript:__js_bridge_emoticon_attend_action(0)");
                } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                    AntiHelper.u(this.c.getPageContext().getPageActivity(), this.a.getErrorString());
                } else if (this.a.getErrorCode() != 0) {
                    this.c.showToast(this.a.getErrorString());
                    this.c.X2("javascript:__js_bridge_emoticon_attend_action(0)");
                } else {
                    LikeReturnData likeReturnData = (LikeReturnData) obj;
                    if (likeReturnData != null) {
                        TbadkApplication.getInst().addLikeForum(this.b);
                        likeReturnData.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                        this.c.X2("javascript:__js_bridge_emoticon_attend_action(1)");
                        return;
                    }
                    CommonEmotionCenterFragment commonEmotionCenterFragment = this.c;
                    commonEmotionCenterFragment.showToast(commonEmotionCenterFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e70));
                    this.c.X2("javascript:__js_bridge_emoticon_attend_action(0)");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        public r(CommonEmotionCenterFragment commonEmotionCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmotionCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmotionCenterFragment;
        }

        public /* synthetic */ r(CommonEmotionCenterFragment commonEmotionCenterFragment, i iVar) {
            this(commonEmotionCenterFragment);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                gs4.a("CommonEmotionCenterFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.a.getPageContext() != null && this.a.getPageContext().getPageActivity() != null) {
                    this.a.hideLoadingView();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.h3();
                        this.a.g = true;
                    }
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.getPageContext() != null && this.a.getPageContext().getPageActivity() != null) {
                    this.a.f3();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.getPageContext() != null && this.a.getPageContext().getPageActivity() != null) {
                    this.a.g3();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int dealOneLinkWithOutJumpWebView;
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isNull(str) && this.a.getPageContext() != null && this.a.getPageContext().getPageActivity() != null) {
                    if (this.a.Z2(str) || (dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str})) == 1 || dealOneLinkWithOutJumpWebView == 0) {
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    public CommonEmotionCenterFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.i = new i(this, 2921054);
        this.j = new j(this, 2001266);
        this.k = new k(this, 2921062);
        this.l = new l(this, 2921040);
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (rr9.l().r()) {
                V2(1, null);
            } else if (rr9.l().k() == null) {
                V2(0, null);
            } else {
                FaceGroupDraft k2 = rr9.l().k();
                if (!TextUtils.isEmpty(k2.getFailMsg())) {
                    V2(2, k2.getFailMsg());
                } else {
                    V2(2, null);
                }
            }
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h27 h27Var = new h27(getPageContext().getPageActivity(), 1);
            h27Var.d(new p(this));
            Rect rect = new Rect();
            getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            h27Var.showAtLocation(this.d, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
        }
    }

    public final void X2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && this.b != null) {
            this.h.post(new n(this, str));
        }
    }

    public final void c3(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                hr9.i().d(optString, new h(this));
            }
        }
    }

    public final void i3(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jSONObject) == null) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                showToast(optString);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            this.h = new Handler(Looper.getMainLooper());
            registerListener(this.i);
            registerListener(this.l);
            registerListener(this.j);
            registerListener(this.k);
        }
    }

    public final void L2(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            LikeModel likeModel = new LikeModel(getPageContext());
            likeModel.setFrom("emotion_center_follow");
            likeModel.setLoadDataCallBack(new q(this, likeModel, optString2));
            likeModel.g0(optString2, String.valueOf(optString));
        }
    }

    public final void P2(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        if (ir9.o().q()) {
            X2("javascript:__js_bridge_emoticon_down_process_action(-1)");
            BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0710);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
        String optString = jSONObject.optString("id");
        if (this.c == null) {
            this.c = new NewFaceGroupDownloadModel();
        }
        this.c.O(optString, Boolean.TRUE, new o(this));
    }

    public final void d3(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jSONObject) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            ShareItem shareItem = new ShareItem();
            shareItem.title = jSONObject.optString("title");
            shareItem.content = jSONObject.optString("content");
            shareItem.linkUrl = jSONObject.optString(GameAssistConstKt.KEY_LINKURL);
            shareItem.imageUri = Uri.parse(jSONObject.optString("imageUri"));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public final void N2(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("pck_id");
            w17 t = w17.t();
            String str = "";
            if (optInt != -1) {
                str = "" + optInt;
            }
            t.g(optString, str);
            X2("javascript:__js_bridge_emoticon_coll_action(2)");
        }
    }

    public final void O2(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            if (ir9.o().q()) {
                X2("javascript:__js_bridge_emoticon_del_action(0)");
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0710);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
            er9.b().a(new a(this, jSONObject));
        }
    }

    public final JSONObject R2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!str.contains("data=")) {
                return null;
            }
            try {
                return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void T2(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getPageContext().getPageActivity(), jSONObject.optInt("id"), 25024)));
        }
    }

    public final void a3(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (ir9.o().q()) {
                X2("javascript:__js_bridge_emoticon_sort_action()");
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0710);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
            er9.b().a(new g(this, jSONObject));
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            er9.b().a(new c(this));
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getArguments() != null && !TextUtils.isEmpty(getArguments().getString("key_load_url"))) {
            this.a = getArguments().getString("key_load_url");
        }
    }

    public void b3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.b == null) {
            return;
        }
        if (this.g) {
            X2("javascript:window.reload_page()");
        } else {
            X2(this.a);
        }
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LoadingView loadingView = new LoadingView(getPageContext().getPageActivity());
            this.e = loadingView;
            loadingView.attachView(this.d, false);
            this.e.onChangeSkinType();
        }
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            fk5 fk5Var = this.f;
            if (fk5Var != null) {
                fk5Var.dettachView(this.d);
                this.f = null;
            }
            TbWebView tbWebView = this.b;
            if (tbWebView != null) {
                tbWebView.setVisibility(0);
            }
        }
    }

    public void hideLoadingView() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (loadingView = this.e) != null) {
            loadingView.dettachView(this.d);
            this.e = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            M2();
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(getPageContext().getPageActivity(), 25021)));
    }

    public final void V2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                X2("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
                return;
            }
            X2("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
        }
    }

    public final void W2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                X2("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
                return;
            }
            X2("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
        }
    }

    public final boolean Z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), str)));
                return true;
            }
            JSONObject R2 = R2(str);
            if (R2 == null) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                P2(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                O2(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                d3(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                Q2();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                e3(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                i3(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                a3(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                N2(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                c3(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                T2(R2);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                U2();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                Y2();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                L2(R2);
                return true;
            } else if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                return true;
            } else {
                M2();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void e3(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("pos");
            String optString3 = jSONObject.optString("neg");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                X2("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
            f05 f05Var = new f05(getPageContext().getPageActivity());
            f05Var.setMessage(optString);
            f05Var.setPositiveButton(optString2, new d(this));
            f05Var.setNegativeButton(optString3, new e(this));
            f05Var.setOnCalcelListener(new f(this));
            f05Var.create(getPageContext()).show();
        }
    }

    public void g3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && getPageContext() != null && getPageContext().getPageActivity() != null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e70);
            if (this.f == null) {
                fk5 fk5Var = new fk5(getPageContext().getPageActivity(), new m(this));
                this.f = fk5Var;
                fk5Var.onChangeSkinType();
            }
            TbWebView tbWebView = this.b;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
            }
            this.f.m(string);
            this.f.attachView(this.d, false);
            this.f.q();
            this.f.k(getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = new RelativeLayout(getPageContext().getPageActivity());
            this.b = new TbWebView(getPageContext().getPageActivity());
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.d.addView(this.b);
            this.b.setWebViewClient(new r(this, null));
            BrowserHelper.initCookie(getPageContext().getPageActivity());
            S2();
            X2(this.a);
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }
}
