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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.af6;
import com.baidu.tieba.ao8;
import com.baidu.tieba.bt7;
import com.baidu.tieba.ca5;
import com.baidu.tieba.da5;
import com.baidu.tieba.et7;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.ft7;
import com.baidu.tieba.ht7;
import com.baidu.tieba.iv4;
import com.baidu.tieba.lf6;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.nf6;
import com.baidu.tieba.ni;
import com.baidu.tieba.ot7;
import com.baidu.tieba.q9;
import com.baidu.tieba.qe6;
import com.baidu.tieba.rp4;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.xi;
import com.baidu.tieba.yp4;
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
/* loaded from: classes4.dex */
public class CommonEmotionCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BaseWebView b;
    public NewFaceGroupDownloadModel c;
    public RelativeLayout d;
    public ca5 e;
    public da5 f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes4.dex */
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
                    qe6.o().k(str);
                }
                if (et7.i().c(arrayList, true)) {
                    this.b.I1("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    this.b.I1("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                ni.a(this.a.x);
                xi.P(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f045e));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                List<MyEmotionGroupData> f = et7.i().f();
                if (f == null || f.isEmpty()) {
                    this.a.I1("javascript:__js_bridge_emoticon_has_action()");
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
                commonEmotionCenterFragment.I1("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
                this.a.I1("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
                this.a.I1("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes4.dex */
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
            this.a.I1("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes4.dex */
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
                et7.i().j(new ArrayList(Arrays.asList(this.a.optString("id").split(","))), true);
                this.b.I1("javascript:__js_bridge_emoticon_sort_action()");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ht7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

        @Override // com.baidu.tieba.ht7
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

        @Override // com.baidu.tieba.ht7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.I1("javascript:__js_bridge_emoticon_save_action(0)");
        }

        @Override // com.baidu.tieba.ht7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.I1("javascript:__js_bridge_emoticon_save_action(1)");
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.I1("javascript:__js_bridge_emoticon_refresh_has_action()");
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao8) && ((ao8) customResponsedMessage.getData()).m() == 1) {
                this.a.I1("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    commonEmotionCenterFragment.I1("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                                BdToast.b(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f060f)).i();
                                this.a.H1(1, null);
                                return;
                            }
                            if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                                str = (String) hashMap.get("upload_msg");
                            }
                            this.a.H1(0, str);
                            return;
                        }
                        this.a.H1(0, null);
                        return;
                    }
                    this.a.H1(0, null);
                    return;
                }
                this.a.H1(0, null);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.M1();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class o implements ht7 {
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

        @Override // com.baidu.tieba.ht7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.I1("javascript:__js_bridge_emoticon_down_process_action(-1)");
        }

        @Override // com.baidu.tieba.ht7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0 && i < 100) {
                CommonEmotionCenterFragment commonEmotionCenterFragment = this.a;
                commonEmotionCenterFragment.I1("javascript:__js_bridge_emoticon_down_process_action(" + i + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        @Override // com.baidu.tieba.ht7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.I1("javascript:__js_bridge_emoticon_down_process_action(100)");
        }
    }

    /* loaded from: classes4.dex */
    public class p implements nf6 {
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

        @Override // com.baidu.tieba.nf6
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), 25021)));
            }
        }

        @Override // com.baidu.tieba.nf6
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), true, 25021)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    this.c.showToast(R.string.obfuscated_res_0x7f0f14fb);
                    this.c.I1("javascript:__js_bridge_emoticon_attend_action(0)");
                } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                    AntiHelper.u(this.c.getPageContext().getPageActivity(), this.a.getErrorString());
                } else if (this.a.getErrorCode() != 0) {
                    this.c.showToast(this.a.getErrorString());
                    this.c.I1("javascript:__js_bridge_emoticon_attend_action(0)");
                } else {
                    ao8 ao8Var = (ao8) obj;
                    if (ao8Var != null) {
                        TbadkApplication.getInst().addLikeForum(this.b);
                        ao8Var.x(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ao8Var));
                        this.c.I1("javascript:__js_bridge_emoticon_attend_action(1)");
                        return;
                    }
                    CommonEmotionCenterFragment commonEmotionCenterFragment = this.c;
                    commonEmotionCenterFragment.showToast(commonEmotionCenterFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c7f));
                    this.c.I1("javascript:__js_bridge_emoticon_attend_action(0)");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                yp4.a("CommonEmotionCenterFragment", webView);
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
                    this.a.m();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.S1();
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
                    this.a.Q1();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.getPageContext() != null && this.a.getPageContext().getPageActivity() != null) {
                    this.a.R1();
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
                    if (this.a.K1(str) || (dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str})) == 1 || dealOneLinkWithOutJumpWebView == 0) {
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

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            lf6 lf6Var = new lf6(getPageContext().getPageActivity(), 1);
            lf6Var.d(new p(this));
            Rect rect = new Rect();
            getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            lf6Var.showAtLocation(this.d, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (ot7.l().r()) {
                G1(1, null);
            } else if (ot7.l().k() == null) {
                G1(0, null);
            } else {
                FaceGroupDraft k2 = ot7.l().k();
                if (!TextUtils.isEmpty(k2.getFailMsg())) {
                    G1(2, k2.getFailMsg());
                } else {
                    G1(2, null);
                }
            }
        }
    }

    public final void I1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && this.b != null) {
            this.h.post(new n(this, str));
        }
    }

    public final void N1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                et7.i().d(optString, new h(this));
            }
        }
    }

    public final void T1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                showToast(optString);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            this.h = new Handler(Looper.getMainLooper());
            registerListener(this.i);
            registerListener(this.l);
            registerListener(this.j);
            registerListener(this.k);
        }
    }

    public final void A1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        if (ft7.o().q()) {
            I1("javascript:__js_bridge_emoticon_down_process_action(-1)");
            xi.O(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0604);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
        String optString = jSONObject.optString("id");
        if (this.c == null) {
            this.c = new NewFaceGroupDownloadModel();
        }
        this.c.z(optString, Boolean.TRUE, new o(this));
    }

    public final void O1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            ShareItem shareItem = new ShareItem();
            shareItem.v = jSONObject.optString("title");
            shareItem.w = jSONObject.optString("content");
            shareItem.x = jSONObject.optString("linkUrl");
            shareItem.z = Uri.parse(jSONObject.optString("imageUri"));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public final void v1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            LikeModel likeModel = new LikeModel(getPageContext());
            likeModel.setFrom("emotion_center_follow");
            likeModel.setLoadDataCallBack(new q(this, likeModel, optString2));
            likeModel.Q(optString2, String.valueOf(optString));
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bt7.b().a(new c(this));
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getArguments() != null && !TextUtils.isEmpty(getArguments().getString("key_load_url"))) {
            this.a = getArguments().getString("key_load_url");
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.b == null) {
            return;
        }
        if (this.g) {
            I1("javascript:window.reload_page()");
        } else {
            I1(this.a);
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ca5 ca5Var = new ca5(getPageContext().getPageActivity());
            this.e = ca5Var;
            ca5Var.attachView(this.d, false);
            this.e.onChangeSkinType();
        }
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            da5 da5Var = this.f;
            if (da5Var != null) {
                da5Var.dettachView(this.d);
                this.f = null;
            }
            BaseWebView baseWebView = this.b;
            if (baseWebView != null) {
                baseWebView.setVisibility(0);
            }
        }
    }

    public void m() {
        ca5 ca5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (ca5Var = this.e) != null) {
            ca5Var.dettachView(this.d);
            this.e = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            x1();
        }
    }

    public final JSONObject C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
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

    public final void E1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getPageContext().getPageActivity(), jSONObject.optInt("id"), 25024)));
        }
    }

    public final void L1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) {
            if (ft7.o().q()) {
                I1("javascript:__js_bridge_emoticon_sort_action()");
                xi.O(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0604);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
            bt7.b().a(new g(this, jSONObject));
        }
    }

    public final void y1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("pck_id");
            af6 t = af6.t();
            String str = "";
            if (optInt != -1) {
                str = "" + optInt;
            }
            t.g(optString, str);
            I1("javascript:__js_bridge_emoticon_coll_action(2)");
        }
    }

    public final void z1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, jSONObject) == null) {
            if (ft7.o().q()) {
                I1("javascript:__js_bridge_emoticon_del_action(0)");
                xi.O(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f0604);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
            bt7.b().a(new a(this, jSONObject));
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(getPageContext().getPageActivity(), 25021)));
    }

    public final void G1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                I1("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
                return;
            }
            I1("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
        }
    }

    public final void H1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                I1("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
                return;
            }
            I1("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
        }
    }

    public final boolean K1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), str)));
                return true;
            }
            JSONObject C1 = C1(str);
            if (C1 == null) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                A1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                z1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                O1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                B1();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                P1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                T1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                L1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                y1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                N1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                E1(C1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                F1();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                J1();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                v1(C1);
                return true;
            } else if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                return true;
            } else {
                x1();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void P1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("pos");
            String optString3 = jSONObject.optString("neg");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                I1("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
            iv4 iv4Var = new iv4(getPageContext().getPageActivity());
            iv4Var.setMessage(optString);
            iv4Var.setPositiveButton(optString2, new d(this));
            iv4Var.setNegativeButton(optString3, new e(this));
            iv4Var.setOnCalcelListener(new f(this));
            iv4Var.create(getPageContext()).show();
        }
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && getPageContext() != null && getPageContext().getPageActivity() != null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c7f);
            if (this.f == null) {
                da5 da5Var = new da5(getPageContext().getPageActivity(), new m(this));
                this.f = da5Var;
                da5Var.onChangeSkinType();
            }
            BaseWebView baseWebView = this.b;
            if (baseWebView != null) {
                baseWebView.setVisibility(8);
            }
            this.f.m(string);
            this.f.attachView(this.d, false);
            this.f.p();
            this.f.k(getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = new RelativeLayout(getPageContext().getPageActivity());
            this.b = new BaseWebView(getPageContext().getPageActivity());
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.d.addView(this.b);
            this.b.setWebViewClient(new r(this, null));
            rp4.g(getPageContext().getPageActivity());
            D1();
            I1(this.a);
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }
}
