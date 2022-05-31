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
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.ag8;
import com.repackage.ai;
import com.repackage.al4;
import com.repackage.b76;
import com.repackage.dq4;
import com.repackage.gl7;
import com.repackage.ji;
import com.repackage.jl7;
import com.repackage.kl7;
import com.repackage.l76;
import com.repackage.li;
import com.repackage.ml7;
import com.repackage.s35;
import com.repackage.sk4;
import com.repackage.t35;
import com.repackage.tl7;
import com.repackage.w76;
import com.repackage.y76;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonEmotionCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BaseWebView b;
    public NewFaceGroupDownloadModel c;
    public RelativeLayout d;
    public s35 e;
    public t35 f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
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
                    b76.o().k(str);
                }
                if (jl7.i().c(arrayList, true)) {
                    this.b.V0("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    this.b.V0("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                ai.a(this.a.w);
                li.O(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f044d));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                List<MyEmotionGroupData> f = jl7.i().f();
                if (f == null || f.isEmpty()) {
                    this.a.V0("javascript:__js_bridge_emoticon_has_action()");
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
                commonEmotionCenterFragment.V0("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                this.a.V0("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                this.a.V0("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.V0("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                jl7.i().j(new ArrayList(Arrays.asList(this.a.optString("id").split(","))), true);
                this.b.V0("javascript:__js_bridge_emoticon_sort_action()");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ml7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmotionCenterFragment a;

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

        @Override // com.repackage.ml7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.V0("javascript:__js_bridge_emoticon_save_action(0)");
            }
        }

        @Override // com.repackage.ml7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.repackage.ml7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.V0("javascript:__js_bridge_emoticon_save_action(1)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.V0("javascript:__js_bridge_emoticon_refresh_has_action()");
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag8) && ((ag8) customResponsedMessage.getData()).n() == 1) {
                this.a.V0("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (emotionPackageData.has_vote != 0 || emotionPackageData.id <= 0) {
                    return;
                }
                CommonEmotionCenterFragment commonEmotionCenterFragment = this.a;
                commonEmotionCenterFragment.V0("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (hashMap == null || hashMap.isEmpty()) {
                    this.a.U0(0, null);
                } else if (!hashMap.containsKey("upload_result")) {
                    this.a.U0(0, null);
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    this.a.U0(0, null);
                } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    BdToast.c(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f05ed)).n();
                    this.a.U0(1, null);
                } else {
                    if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                        str = (String) hashMap.get("upload_msg");
                    }
                    this.a.U0(0, str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.Z0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.b == null) {
                return;
            }
            this.b.b.loadUrl(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements ml7 {
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

        @Override // com.repackage.ml7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.V0("javascript:__js_bridge_emoticon_down_process_action(-1)");
            }
        }

        @Override // com.repackage.ml7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i <= 0 || i >= 100) {
                return;
            }
            CommonEmotionCenterFragment commonEmotionCenterFragment = this.a;
            commonEmotionCenterFragment.V0("javascript:__js_bridge_emoticon_down_process_action(" + i + SmallTailInfo.EMOTION_SUFFIX);
        }

        @Override // com.repackage.ml7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.V0("javascript:__js_bridge_emoticon_down_process_action(100)");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements y76 {
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

        @Override // com.repackage.y76
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), 25021)));
            }
        }

        @Override // com.repackage.y76
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), true, 25021)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    this.c.showToast(R.string.obfuscated_res_0x7f0f14aa);
                    this.c.V0("javascript:__js_bridge_emoticon_attend_action(0)");
                } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                    AntiHelper.u(this.c.getPageContext().getPageActivity(), this.a.getErrorString());
                } else if (this.a.getErrorCode() != 0) {
                    this.c.showToast(this.a.getErrorString());
                    this.c.V0("javascript:__js_bridge_emoticon_attend_action(0)");
                } else {
                    ag8 ag8Var = (ag8) obj;
                    if (ag8Var != null) {
                        this.c.showToast(R.string.obfuscated_res_0x7f0f02b3);
                        TbadkApplication.getInst().addLikeForum(this.b);
                        ag8Var.y(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, ag8Var));
                        this.c.V0("javascript:__js_bridge_emoticon_attend_action(1)");
                        return;
                    }
                    CommonEmotionCenterFragment commonEmotionCenterFragment = this.c;
                    commonEmotionCenterFragment.showToast(commonEmotionCenterFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c33));
                    this.c.V0("javascript:__js_bridge_emoticon_attend_action(0)");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.a.getPageContext() == null || this.a.getPageContext().getPageActivity() == null) {
                    return;
                }
                this.a.g();
                if (ji.z()) {
                    this.a.f1();
                    this.a.g = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.getPageContext() == null || this.a.getPageContext().getPageActivity() == null) {
                    return;
                }
                this.a.d1();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.getPageContext() == null || this.a.getPageContext().getPageActivity() == null) {
                    return;
                }
                this.a.e1();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                al4.a("CommonEmotionCenterFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
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
                    if (this.a.X0(str) || (dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str})) == 1 || dealOneLinkWithOutJumpWebView == 0) {
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ r(CommonEmotionCenterFragment commonEmotionCenterFragment, i iVar) {
            this(commonEmotionCenterFragment);
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

    public final void J0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return;
        }
        LikeModel likeModel = new LikeModel(getPageContext());
        likeModel.setFrom("emotion_center_follow");
        likeModel.setLoadDataCallBack(new q(this, likeModel, optString2));
        likeModel.P(optString2, String.valueOf(optString));
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (tl7.l().r()) {
                T0(1, null);
            } else if (tl7.l().k() == null) {
                T0(0, null);
            } else {
                FaceGroupDraft k2 = tl7.l().k();
                if (!TextUtils.isEmpty(k2.getFailMsg())) {
                    T0(2, k2.getFailMsg());
                } else {
                    T0(2, null);
                }
            }
        }
    }

    public final void L0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("pck_id");
            l76 t = l76.t();
            String str = "";
            if (optInt != -1) {
                str = "" + optInt;
            }
            t.g(optString, str);
            V0("javascript:__js_bridge_emoticon_coll_action(2)");
        }
    }

    public final void M0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            if (kl7.o().q()) {
                V0("javascript:__js_bridge_emoticon_del_action(0)");
                li.N(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f05e2);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
            gl7.b().a(new a(this, jSONObject));
        }
    }

    public final void N0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (kl7.o().q()) {
                V0("javascript:__js_bridge_emoticon_down_process_action(-1)");
                li.N(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f05e2);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.c == null) {
                this.c = new NewFaceGroupDownloadModel();
            }
            this.c.y(optString, Boolean.TRUE, new o(this));
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gl7.b().a(new c(this));
        }
    }

    public final JSONObject P0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str.contains("data=")) {
                try {
                    return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || getArguments() == null || TextUtils.isEmpty(getArguments().getString("key_load_url"))) {
            return;
        }
        this.a = getArguments().getString("key_load_url");
    }

    public final void R0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getPageContext().getPageActivity(), jSONObject.optInt("id"), 25024)));
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(getPageContext().getPageActivity(), 25021)));
        }
    }

    public final void T0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                V0("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
                return;
            }
            V0("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
        }
    }

    public final void U0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                V0("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
                return;
            }
            V0("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
        }
    }

    public final void V0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.b == null) {
            return;
        }
        this.h.post(new n(this, str));
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w76 w76Var = new w76(getPageContext().getPageActivity(), 1);
            w76Var.d(new p(this));
            Rect rect = new Rect();
            getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            w76Var.showAtLocation(this.d, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
        }
    }

    public final boolean X0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                    sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), str)));
                    return true;
                }
                JSONObject P0 = P0(str);
                if (P0 == null) {
                    return false;
                }
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                    N0(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                    M0(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                    b1(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                    O0();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                    c1(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                    g1(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                    Y0(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                    L0(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                    a1(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                    R0(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                    S0();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                    W0();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                    J0(P0);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                    K0();
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void Y0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            if (kl7.o().q()) {
                V0("javascript:__js_bridge_emoticon_sort_action()");
                li.N(getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f05e2);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
            gl7.b().a(new g(this, jSONObject));
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.b == null) {
            return;
        }
        if (this.g) {
            V0("javascript:window.reload_page()");
        } else {
            V0(this.a);
        }
    }

    public final void a1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            jl7.i().d(optString, new h(this));
        }
    }

    public final void b1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jSONObject) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            ShareItem shareItem = new ShareItem();
            shareItem.u = jSONObject.optString("title");
            shareItem.v = jSONObject.optString("content");
            shareItem.w = jSONObject.optString("linkUrl");
            shareItem.y = Uri.parse(jSONObject.optString("imageUri"));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public final void c1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("pos");
            String optString3 = jSONObject.optString("neg");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                V0("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
            dq4 dq4Var = new dq4(getPageContext().getPageActivity());
            dq4Var.setMessage(optString);
            dq4Var.setPositiveButton(optString2, new d(this));
            dq4Var.setNegativeButton(optString3, new e(this));
            dq4Var.setOnCalcelListener(new f(this));
            dq4Var.create(getPageContext()).show();
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            s35 s35Var = new s35(getPageContext().getPageActivity());
            this.e = s35Var;
            s35Var.attachView(this.d, false);
            this.e.onChangeSkinType();
        }
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || getPageContext() == null || getPageContext().getPageActivity() == null) {
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c33);
        if (this.f == null) {
            t35 t35Var = new t35(getPageContext().getPageActivity(), new m(this));
            this.f = t35Var;
            t35Var.onChangeSkinType();
        }
        BaseWebView baseWebView = this.b;
        if (baseWebView != null) {
            baseWebView.setVisibility(8);
        }
        this.f.m(string);
        this.f.attachView(this.d, false);
        this.f.p();
        this.f.k(getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070295));
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            t35 t35Var = this.f;
            if (t35Var != null) {
                t35Var.dettachView(this.d);
                this.f = null;
            }
            BaseWebView baseWebView = this.b;
            if (baseWebView != null) {
                baseWebView.setVisibility(0);
            }
        }
    }

    public void g() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (s35Var = this.e) == null) {
            return;
        }
        s35Var.dettachView(this.d);
        this.e = null;
    }

    public final void g1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jSONObject) == null) {
            String optString = jSONObject.optString("content");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            showToast(optString);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = new RelativeLayout(getPageContext().getPageActivity());
            this.b = new BaseWebView(getPageContext().getPageActivity());
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.d.addView(this.b);
            this.b.setWebViewClient(new r(this, null));
            sk4.g(getPageContext().getPageActivity());
            Q0();
            V0(this.a);
            return this.d;
        }
        return (View) invokeLLL.objValue;
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
            K0();
        }
    }
}
