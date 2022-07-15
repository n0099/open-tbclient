package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.at4;
import com.repackage.bt4;
import com.repackage.cj8;
import com.repackage.ct4;
import com.repackage.dj8;
import com.repackage.ej8;
import com.repackage.et4;
import com.repackage.gt4;
import com.repackage.it4;
import com.repackage.je6;
import com.repackage.jt4;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.ok6;
import com.repackage.pk6;
import com.repackage.qg;
import com.repackage.r95;
import com.repackage.rk6;
import com.repackage.rl4;
import com.repackage.se5;
import com.repackage.sk6;
import com.repackage.sl4;
import com.repackage.tk6;
import com.repackage.us4;
import com.repackage.vg;
import com.repackage.xs4;
import com.repackage.y85;
import com.repackage.zl4;
import com.repackage.zs4;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements je6 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> A;
    public static boolean z;
    public transient /* synthetic */ FieldHolder $fh;
    public rk6 d;
    public String e;
    public String f;
    public int g;
    public ScrollBridgeWebview h;
    public View i;
    public NoNetworkView j;
    public FrameLayout k;
    public FrameLayout l;
    public cj8 m;
    public tk6 n;
    public zs4 o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String u;
    public ej8 v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public final View.OnClickListener y;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public a(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                    return;
                }
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideNetRefreshView(specialFrsWebFragment.l);
                this.a.k.setVisibility(0);
                this.a.l.setVisibility(8);
                this.a.p = true;
                this.a.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public b(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // com.repackage.xs4
        public void a(List<Long> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (Long l : list) {
                sb.append(str);
                sb.append(l);
                str = "_";
            }
            vg a = r95.a();
            a.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ej8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public c(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // com.repackage.ej8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.m != null) {
                    return this.a.m.b(this.a.h, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SpecialFrsWebFragment specialFrsWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i)};
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
            this.a = specialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SpecialFrsWebFragment specialFrsWebFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i)};
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
            this.a = specialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.a.a)) {
                return;
            }
            this.a.q = true;
            SpecialFrsWebFragment specialFrsWebFragment = this.a;
            specialFrsWebFragment.showLoadingView(specialFrsWebFragment.k);
            SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
            specialFrsWebFragment2.i2(specialFrsWebFragment2.a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ScrollBridgeWebview.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public f(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void a(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends bt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SpecialFrsWebFragment specialFrsWebFragment, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = specialFrsWebFragment;
        }

        @ct4(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.c.o2();
            }
        }

        @Override // com.repackage.bt4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends it4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SpecialFrsWebFragment specialFrsWebFragment, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = specialFrsWebFragment;
        }

        @Override // com.repackage.it4
        @ct4(isAsync = false, value = "scanBigImages")
        public void sanBigImages(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.sanBigImages(jSONObject);
                TiebaStatic.log(new StatisticItem("c12338").param("fid", jSONObject.optInt("fid")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends bt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SpecialFrsWebFragment specialFrsWebFragment, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = specialFrsWebFragment;
        }

        @ct4(isAsync = false, value = "skinToLogin")
        private void skinToLogin() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || TbadkCoreApplication.isLogin()) {
                return;
            }
            ViewHelper.skipToLoginActivity(this.c.getPageContext().getPageActivity());
        }

        @Override // com.repackage.bt4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_SKIN_TO_LOGIN" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j extends bt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShareItem a;
            public final /* synthetic */ j b;

            public a(j jVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.m2(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SpecialFrsWebFragment specialFrsWebFragment, zs4 zs4Var) {
            super(zs4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, zs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zs4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = specialFrsWebFragment;
        }

        @ct4(isAsync = false, value = "share")
        private void share(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                SpecialFrsWebFragment specialFrsWebFragment = this.c;
                specialFrsWebFragment.t = true;
                specialFrsWebFragment.u = optString5;
            }
            qg.a().post(new a(this, this.c.s1(optString, optString4, optString2, optString3)));
        }

        @Override // com.repackage.bt4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public k(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.h != null) {
                        this.a.h.destroy();
                        this.a.h = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public l(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.a.h == null) {
                    return;
                }
                this.a.q = false;
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideLoadingView(specialFrsWebFragment.k);
                SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
                specialFrsWebFragment2.a = str;
                specialFrsWebFragment2.h.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (this.a.p) {
                    this.a.p = false;
                }
                String title = this.a.h.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    this.a.C1(title);
                }
                this.a.d.o(this.a.w1());
                this.a.d.p(this.a.x1());
                this.a.d.n(this.a.v1());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.h == null) {
                    return;
                }
                if (this.a.p) {
                    this.a.q = true;
                    SpecialFrsWebFragment specialFrsWebFragment = this.a;
                    specialFrsWebFragment.showLoadingView(specialFrsWebFragment.k);
                }
                this.a.a = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.h == null) {
                    return;
                }
                this.a.h.stopLoading();
                this.a.k2(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                zl4.a("SpecialFrsWebFragment", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.a.p) {
                    this.a.p = false;
                    return false;
                } else if (!this.a.Z1(str) || TbadkCoreApplication.isLogin() || this.a.getPageContext() == null) {
                    if (!this.a.j2(str) && this.a.getPageContext() != null && this.a.h.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            this.a.s = true;
                        }
                        if (!this.a.u1(str)) {
                            if (this.a.r) {
                                return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str}) == 0;
                            }
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{str}, true);
                        } else {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str});
                            return dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1;
                        }
                    }
                    return true;
                } else {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public m(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.a.startActivity(intent);
            }
        }

        public /* synthetic */ m(SpecialFrsWebFragment specialFrsWebFragment, c cVar) {
            this(specialFrsWebFragment);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-439207698, "Lcom/baidu/tieba/frs/gametabs/SpecialFrsWebFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-439207698, "Lcom/baidu/tieba/frs/gametabs/SpecialFrsWebFragment;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        A = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        A.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        A.put(Share.QQDENGLU, "qq_zone");
        A.put(Share.SINAWEIBO, "sina_weibo");
        A.put(Share.QQWEIBO, "qq_weibo");
    }

    public SpecialFrsWebFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.p = true;
        this.r = false;
        this.t = false;
        this.v = new c(this);
        this.w = new d(this, 0);
        this.x = new e(this, 2005016);
        this.y = new a(this);
    }

    @Override // com.repackage.je6
    public NavigationBar N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rk6 rk6Var = this.d;
            if (rk6Var != null) {
                return rk6Var.j();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final dj8 X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, dj8.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (dj8) runTask.getData();
        }
        return (dj8) invokeV.objValue;
    }

    public void Y1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.h == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(this.h, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final boolean Z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public View a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h == null) {
                ScrollBridgeWebview scrollBridgeWebview = new ScrollBridgeWebview(getPageContext().getPageActivity());
                this.h = scrollBridgeWebview;
                scrollBridgeWebview.setNeedDisAllowParentInterceptTouchEvent(true);
                this.h.getSettings().setJavaScriptEnabled(true);
                this.h.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.h.getSettings().setAllowFileAccess(true);
                this.h.getSettings().setDatabaseEnabled(true);
                this.h.getSettings().setDomStorageEnabled(true);
                this.h.getSettings().setSupportZoom(true);
                this.h.getSettings().setBuiltInZoomControls(true);
                this.h.getSettings().setUseWideViewPort(true);
                this.h.getSettings().setLoadWithOverviewMode(true);
                this.h.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
                this.h.setHorizontalScrollBarEnabled(false);
                this.h.setHorizontalScrollbarOverlay(false);
                this.h.setInitialScale(100);
                this.h.setScrollBarStyle(33554432);
                this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.h.setWebViewClient(new l(this));
                this.h.setDownloadListener(new m(this, null));
                pk6 pk6Var = new pk6(getPageContext());
                pk6Var.a(this.v);
                this.h.setWebChromeClient(pk6Var);
                this.h.setOnScrollChangeListener(new f(this));
                CompatibleUtile.getInstance().removeJavascriptInterface(this.h);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                zs4 n = et4.n(isHybridBridgeEnabled, this.h, null);
                this.o = n;
                if (isHybridBridgeEnabled) {
                    n.d(new g(this, n));
                    n.d(new gt4(n));
                    n.d(new h(this, n));
                    n.d(new sl4(n));
                    n.d(new jt4(n));
                    n.d(new sk6(n));
                    n.d(new ok6(n, this.e));
                    n.d(new i(this, n));
                    n.d(new j(this, n));
                }
            }
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public ShareItem b2(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, str, str2, str3, str4)) == null) ? s1(str, str2, str3, str4) : (ShareItem) invokeLLLL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public final SparseArray<String> c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final void d2(Intent intent, int i2) {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, intent, i2) == null) && this.t) {
            this.t = false;
            if (intent == null) {
                return;
            }
            String str = A.get(intent.getStringExtra("share_to"));
            HashMap hashMap = new HashMap();
            boolean z2 = i2 == -1;
            hashMap.put("bid", this.u);
            hashMap.put("result", Boolean.valueOf(z2));
            hashMap.put("channel", str);
            at4 j2 = at4.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            zs4 zs4Var = this.o;
            if (zs4Var != null) {
                zs4Var.c(j2);
            }
            if (StringUtils.isNull(this.a) || !this.a.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1 || (scrollBridgeWebview = this.h) == null) {
                return;
            }
            scrollBridgeWebview.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            rl4.g(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final boolean f2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), se5.c(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean g2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
                return false;
            }
            int parseInt = Integer.parseInt(se5.c(str, "fid="));
            int parseInt2 = Integer.parseInt(se5.c(str, "gameid="));
            String c2 = se5.c(str, "gamename=");
            tk6 tk6Var = this.n;
            if (tk6Var != null) {
                tk6Var.a(getPageContext(), c2, parseInt2, parseInt);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.g;
            if (i2 == 102) {
                return "a055";
            }
            if (i2 == 103) {
                return "a056";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v85
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? super.getCurrentPageSourceKeyList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public y85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            y85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(ng.g(d(), 0L));
            }
            return pageStayDurationItem;
        }
        return (y85) invokeV.objValue;
    }

    public final boolean h2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
                return false;
            }
            String c2 = se5.c(str, "tid=");
            if (StringUtils.isNull(c2)) {
                return true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(c2, null, "game_news")));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || this.h == null) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.h, str);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.r = true;
            }
            i2(this.a);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, tk6.class);
            if (runTask != null) {
                tk6 tk6Var = (tk6) runTask.getData();
                this.n = tk6Var;
                if (tk6Var != null) {
                    tk6Var.init();
                }
            }
        }
    }

    public final boolean j2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? g2(str) || n2(str) || h2(str) || f2(str) : invokeL.booleanValue;
    }

    public void k2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            ScrollBridgeWebview scrollBridgeWebview = this.h;
            if (scrollBridgeWebview != null) {
                this.a = scrollBridgeWebview.getUrl();
                this.h.stopLoading();
            }
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            if (getPageContext() != null) {
                showNetRefreshView(this.l, getPageContext().getString(R.string.obfuscated_res_0x7f0f14e6), null, getPageContext().getString(R.string.obfuscated_res_0x7f0f0f98), false, this.y);
            }
        }
    }

    public void l2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.g = i2;
        }
    }

    public void m2(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, shareItem) == null) || shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, c2())));
    }

    public final boolean n2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
                return false;
            }
            String c2 = se5.c(str, "packagename=");
            if (StringUtils.isNull(c2)) {
                return true;
            }
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(c2));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || z) {
            return;
        }
        z = true;
        us4.a().b(16, new b(this));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.d == null) {
                this.d = new rk6(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 24007) {
                d2(intent, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            rk6 rk6Var = this.d;
            if (rk6Var != null) {
                rk6Var.l(i2);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.d(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.e = bundle.getString("fid");
                this.f = bundle.getString("fname");
            } else if (getArguments() != null) {
                this.e = getArguments().getString("fid");
                this.f = getArguments().getString("fname");
            }
            cj8 cj8Var = new cj8();
            this.m = cj8Var;
            cj8Var.a(new XiubaTbJsBridge(getPageContext()));
            this.m.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.m.a(X1());
            e2();
            registerListener(2001446, this.w, getBaseFragmentActivity().getUniqueId());
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d078e, (ViewGroup) null);
            this.i = inflate;
            this.j = (NoNetworkView) inflate.findViewById(R.id.obfuscated_res_0x7f092439);
            this.k = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0924cd);
            this.l = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0915f5);
            if (this.d == null) {
                this.d = new rk6(getPageContext());
            }
            this.d.k((NavigationBar) this.i.findViewById(R.id.obfuscated_res_0x7f092437), this);
            a2();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092437);
            this.k.setLayoutParams(layoutParams);
            ScrollBridgeWebview scrollBridgeWebview = this.h;
            if (scrollBridgeWebview != null && (parent = scrollBridgeWebview.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.h);
            }
            this.k.addView(this.h);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.x);
            tk6 tk6Var = this.n;
            if (tk6Var != null) {
                tk6Var.release();
                this.n = null;
            }
            rk6 rk6Var = this.d;
            if (rk6Var != null) {
                rk6Var.m();
            }
            cj8 cj8Var = this.m;
            if (cj8Var != null) {
                cj8Var.g();
            }
            ScrollBridgeWebview scrollBridgeWebview = this.h;
            if (scrollBridgeWebview != null) {
                scrollBridgeWebview.getSettings().setBuiltInZoomControls(true);
                this.h.setVisibility(8);
                qg.a().postDelayed(new k(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.h == null) {
                    return;
                }
                if (this.p) {
                    initData();
                }
                try {
                    this.h.onResume();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Y1("onResume");
                return;
            }
            ScrollBridgeWebview scrollBridgeWebview = this.h;
            if (scrollBridgeWebview == null) {
                return;
            }
            try {
                scrollBridgeWebview.onPause();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            Y1(MissionEvent.MESSAGE_PAUSE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            rk6 rk6Var = this.d;
            if (rk6Var != null) {
                rk6Var.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("fid", this.e);
                bundle.putString("fname", this.f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.q || TextUtils.isEmpty(this.a) || !ni.z()) {
            return;
        }
        i2(this.a);
    }
}
