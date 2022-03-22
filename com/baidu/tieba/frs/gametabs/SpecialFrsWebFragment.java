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
import c.a.o0.c1.v0;
import c.a.o0.r.b0.q;
import c.a.p0.f1.r0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
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
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean A;
    public static HashMap<String, String> B;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f1.a2.d f32634d;

    /* renamed from: e  reason: collision with root package name */
    public String f32635e;

    /* renamed from: f  reason: collision with root package name */
    public String f32636f;

    /* renamed from: g  reason: collision with root package name */
    public int f32637g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollBridgeWebview f32638h;
    public View i;
    public NoNetworkView j;
    public FrameLayout k;
    public FrameLayout l;
    public c.a.p0.a4.o0.a m;
    public c.a.p0.f1.b2.a n;
    public c.a.o0.r.b0.l o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String u;
    public c.a.p0.a4.o0.c v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public final View.OnClickListener z;

    /* loaded from: classes5.dex */
    public class a extends c.a.o0.r.b0.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f32639c;

        /* renamed from: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1848a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShareItem a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f32640b;

            public RunnableC1848a(a aVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32640b = aVar;
                this.a = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32640b.f32639c.w1(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialFrsWebFragment specialFrsWebFragment, c.a.o0.r.b0.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.o0.r.b0.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32639c = specialFrsWebFragment;
        }

        @c.a.o0.r.b0.o(isAsync = false, value = "share")
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
                SpecialFrsWebFragment specialFrsWebFragment = this.f32639c;
                specialFrsWebFragment.t = true;
                specialFrsWebFragment.u = optString5;
            }
            c.a.d.f.m.e.a().post(new RunnableC1848a(this, this.f32639c.C0(optString, optString4, optString2, optString3)));
        }

        @Override // c.a.o0.r.b0.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.f32638h != null) {
                        this.a.f32638h.destroy();
                        this.a.f32638h = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.a.d.f.p.l.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
                    return;
                }
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideNetRefreshView(specialFrsWebFragment.l);
                this.a.k.setVisibility(0);
                this.a.l.setVisibility(8);
                this.a.p = true;
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.a.o0.r.b0.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public d(SpecialFrsWebFragment specialFrsWebFragment) {
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

        @Override // c.a.o0.r.b0.j
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
            c.a.d.f.n.a a = c.a.o0.r0.j.a();
            a.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, a);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.p0.a4.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public e(SpecialFrsWebFragment specialFrsWebFragment) {
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

        @Override // c.a.p0.a4.o0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.m != null) {
                    return this.a.m.b(this.a.f32638h, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SpecialFrsWebFragment specialFrsWebFragment, int i) {
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
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SpecialFrsWebFragment specialFrsWebFragment, int i) {
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
            specialFrsWebFragment2.s1(specialFrsWebFragment2.a);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SpecialFrsWebFragment specialFrsWebFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && this.a.s) {
                if (this.a.f32638h != null) {
                    this.a.f32638h.reload();
                }
                this.a.s = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ScrollBridgeWebview.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public i(SpecialFrsWebFragment specialFrsWebFragment) {
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

    /* loaded from: classes5.dex */
    public class j extends c.a.o0.r.b0.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f32641c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SpecialFrsWebFragment specialFrsWebFragment, c.a.o0.r.b0.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.o0.r.b0.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32641c = specialFrsWebFragment;
        }

        @c.a.o0.r.b0.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f32641c.y1();
            }
        }

        @Override // c.a.o0.r.b0.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends c.a.o0.r.b0.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f32642d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SpecialFrsWebFragment specialFrsWebFragment, c.a.o0.r.b0.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.o0.r.b0.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32642d = specialFrsWebFragment;
        }

        @Override // c.a.o0.r.b0.s.c
        @c.a.o0.r.b0.o(isAsync = false, value = "scanBigImages")
        public void sanBigImages(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.sanBigImages(jSONObject);
                TiebaStatic.log(new StatisticItem("c12338").param("fid", jSONObject.optInt("fid")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends c.a.o0.r.b0.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f32643c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SpecialFrsWebFragment specialFrsWebFragment, c.a.o0.r.b0.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.o0.r.b0.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32643c = specialFrsWebFragment;
        }

        @c.a.o0.r.b0.o(isAsync = false, value = "skinToLogin")
        private void skinToLogin() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || TbadkCoreApplication.isLogin()) {
                return;
            }
            ViewHelper.skipToLoginActivity(this.f32643c.getPageContext().getPageActivity());
        }

        @Override // c.a.o0.r.b0.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_SKIN_TO_LOGIN" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m extends c.a.o0.r.b0.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f32644c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SpecialFrsWebFragment specialFrsWebFragment, c.a.o0.r.b0.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.o0.r.b0.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32644c = specialFrsWebFragment;
        }

        @c.a.o0.r.b0.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null && ViewHelper.checkUpIsLogin(this.f32644c.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                String optString2 = jSONObject.optString("comment_id");
                Intent intent = new Intent(this.f32644c.getFragmentActivity(), FrsGameSubPbActivity.class);
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, Integer.valueOf(optString));
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID, optString2);
                this.f32644c.startActivityForResult(intent, 1001);
            }
        }

        @Override // c.a.o0.r.b0.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_COMMENT_FLOOR" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public n(SpecialFrsWebFragment specialFrsWebFragment) {
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
                if (this.a.f32638h == null) {
                    return;
                }
                this.a.q = false;
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideLoadingView(specialFrsWebFragment.k);
                SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
                specialFrsWebFragment2.a = str;
                specialFrsWebFragment2.f32638h.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (this.a.p) {
                    this.a.p = false;
                }
                String title = this.a.f32638h.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    this.a.L0(title);
                }
                this.a.f32634d.o(this.a.G0());
                this.a.f32634d.p(this.a.H0());
                this.a.f32634d.n(this.a.F0());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.f32638h == null) {
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
                if (this.a.f32638h == null) {
                    return;
                }
                this.a.f32638h.stopLoading();
                this.a.u1(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                c.a.o0.l.h.a("SpecialFrsWebFragment", webView);
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
                } else if (!this.a.j1(str) || TbadkCoreApplication.isLogin() || this.a.getPageContext() == null) {
                    if (!this.a.t1(str) && this.a.getPageContext() != null && this.a.f32638h.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            this.a.s = true;
                        }
                        if (!this.a.E0(str)) {
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

    /* loaded from: classes5.dex */
    public class o implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        public o(SpecialFrsWebFragment specialFrsWebFragment) {
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

        public /* synthetic */ o(SpecialFrsWebFragment specialFrsWebFragment, e eVar) {
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
        B = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        B.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        B.put(Share.QQDENGLU, "qq_zone");
        B.put(Share.SINAWEIBO, "sina_weibo");
        B.put(Share.QQWEIBO, "qq_weibo");
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
        this.f32638h = null;
        this.p = true;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = new e(this);
        this.w = new f(this, 0);
        this.x = new g(this, 2005016);
        this.y = new h(this, 2001227);
        this.z = new c(this);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32636f : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32635e : (String) invokeV.objValue;
    }

    @Override // c.a.p0.f1.r0
    public NavigationBar d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.f1.a2.d dVar = this.f32634d;
            if (dVar != null) {
                return dVar.j();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.o0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.f32637g;
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.o0.p0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getCurrentPageSourceKeyList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.o0.p0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.o0.p0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(c.a.d.f.m.b.g(c(), 0L));
            }
            return pageStayDurationItem;
        }
        return (c.a.o0.p0.d) invokeV.objValue;
    }

    public final c.a.p0.a4.o0.b h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, c.a.p0.a4.o0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (c.a.p0.a4.o0.b) runTask.getData();
        }
        return (c.a.p0.a4.o0.b) invokeV.objValue;
    }

    public void i1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.f32638h == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(this.f32638h, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String str = this.a;
            if (str != null && str.contains("redirect=1")) {
                this.r = true;
            }
            s1(this.a);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, c.a.p0.f1.b2.a.class);
            if (runTask != null) {
                c.a.p0.f1.b2.a aVar = (c.a.p0.f1.b2.a) runTask.getData();
                this.n = aVar;
                if (aVar != null) {
                    aVar.init();
                }
            }
        }
    }

    public final boolean j1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public View k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f32638h == null) {
                ScrollBridgeWebview scrollBridgeWebview = new ScrollBridgeWebview(getPageContext().getPageActivity());
                this.f32638h = scrollBridgeWebview;
                scrollBridgeWebview.setNeedDisAllowParentInterceptTouchEvent(true);
                this.f32638h.getSettings().setJavaScriptEnabled(true);
                this.f32638h.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.f32638h.getSettings().setAllowFileAccess(true);
                this.f32638h.getSettings().setDatabaseEnabled(true);
                this.f32638h.getSettings().setDomStorageEnabled(true);
                this.f32638h.getSettings().setSupportZoom(true);
                this.f32638h.getSettings().setBuiltInZoomControls(true);
                this.f32638h.getSettings().setUseWideViewPort(true);
                this.f32638h.getSettings().setLoadWithOverviewMode(true);
                this.f32638h.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
                this.f32638h.setHorizontalScrollBarEnabled(false);
                this.f32638h.setHorizontalScrollbarOverlay(false);
                this.f32638h.setInitialScale(100);
                this.f32638h.setScrollBarStyle(33554432);
                this.f32638h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f32638h.setWebViewClient(new n(this));
                this.f32638h.setDownloadListener(new o(this, null));
                c.a.p0.f1.a2.b bVar = new c.a.p0.f1.a2.b(getPageContext());
                bVar.a(this.v);
                this.f32638h.setWebChromeClient(bVar);
                this.f32638h.setOnScrollChangeListener(new i(this));
                CompatibleUtile.getInstance().removeJavascriptInterface(this.f32638h);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                c.a.o0.r.b0.l n2 = q.n(isHybridBridgeEnabled, this.f32638h, null);
                this.o = n2;
                if (isHybridBridgeEnabled) {
                    n2.d(new j(this, n2));
                    n2.d(new c.a.o0.r.b0.s.a(n2));
                    n2.d(new k(this, n2));
                    n2.d(new c.a.o0.l.b(n2));
                    n2.d(new c.a.o0.r.b0.s.d(n2));
                    n2.d(new c.a.p0.f1.a2.e(n2));
                    n2.d(new c.a.p0.f1.a2.a(n2, this.f32635e));
                    n2.d(new l(this, n2));
                    n2.d(new m(this, n2));
                    n2.d(new a(this, n2));
                }
            }
            return this.f32638h;
        }
        return (View) invokeV.objValue;
    }

    public ShareItem l1(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, str2, str3, str4)) == null) ? C0(str, str2, str3, str4) : (ShareItem) invokeLLLL.objValue;
    }

    public final SparseArray<String> m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    public final void n1(Intent intent, int i2) {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048589, this, intent, i2) == null) && this.t) {
            this.t = false;
            if (intent == null) {
                return;
            }
            String str = B.get(intent.getStringExtra("share_to"));
            HashMap hashMap = new HashMap();
            boolean z = i2 == -1;
            hashMap.put("bid", this.u);
            hashMap.put("result", Boolean.valueOf(z));
            hashMap.put("channel", str);
            c.a.o0.r.b0.m j2 = c.a.o0.r.b0.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            c.a.o0.r.b0.l lVar = this.o;
            if (lVar != null) {
                lVar.c(j2);
            }
            if (StringUtils.isNull(this.a) || !this.a.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1 || (scrollBridgeWebview = this.f32638h) == null) {
                return;
            }
            scrollBridgeWebview.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.o0.l.a.f(getBaseFragmentActivity().getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f32634d == null) {
                this.f32634d = new c.a.p0.f1.a2.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 1001) {
                if (i2 == 24007) {
                    n1(intent, i3);
                }
            } else if (i3 != 1002 || this.o == null) {
            } else {
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "0");
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "success");
                c.a.o0.r.b0.m j2 = c.a.o0.r.b0.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                c.a.o0.r.b0.l lVar = this.o;
                if (lVar != null) {
                    lVar.c(j2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            c.a.p0.f1.a2.d dVar = this.f32634d;
            if (dVar != null) {
                dVar.l(i2);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f32635e = bundle.getString("fid");
                this.f32636f = bundle.getString("fname");
            } else if (getArguments() != null) {
                this.f32635e = getArguments().getString("fid");
                this.f32636f = getArguments().getString("fname");
            }
            c.a.p0.a4.o0.a aVar = new c.a.p0.a4.o0.a();
            this.m = aVar;
            aVar.a(new XiubaTbJsBridge(getPageContext()));
            this.m.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.m.a(h1());
            o1();
            registerListener(2001446, this.w, getBaseFragmentActivity().getUniqueId());
            MessageManager.getInstance().registerListener(this.x);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d078f, (ViewGroup) null);
            this.i = inflate;
            this.j = (NoNetworkView) inflate.findViewById(R.id.obfuscated_res_0x7f0923d1);
            this.k = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f09244d);
            this.l = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091581);
            if (this.f32634d == null) {
                this.f32634d = new c.a.p0.f1.a2.d(getPageContext());
            }
            this.f32634d.k((NavigationBar) this.i.findViewById(R.id.obfuscated_res_0x7f0923cf), this);
            k1();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923cf);
            this.k.setLayoutParams(layoutParams);
            ScrollBridgeWebview scrollBridgeWebview = this.f32638h;
            if (scrollBridgeWebview != null && (parent = scrollBridgeWebview.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f32638h);
            }
            this.k.addView(this.f32638h);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.y);
            c.a.p0.f1.b2.a aVar = this.n;
            if (aVar != null) {
                aVar.release();
                this.n = null;
            }
            c.a.p0.f1.a2.d dVar = this.f32634d;
            if (dVar != null) {
                dVar.m();
            }
            c.a.p0.a4.o0.a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.g();
            }
            ScrollBridgeWebview scrollBridgeWebview = this.f32638h;
            if (scrollBridgeWebview != null) {
                scrollBridgeWebview.getSettings().setBuiltInZoomControls(true);
                this.f32638h.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(new b(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.f32638h == null) {
                    return;
                }
                if (this.p) {
                    initData();
                }
                try {
                    this.f32638h.onResume();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                i1("onResume");
            } else {
                ScrollBridgeWebview scrollBridgeWebview = this.f32638h;
                if (scrollBridgeWebview == null) {
                    return;
                }
                try {
                    scrollBridgeWebview.onPause();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                i1(MissionEvent.MESSAGE_PAUSE);
            }
            this.s = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            c.a.p0.f1.a2.d dVar = this.f32634d;
            if (dVar != null) {
                dVar.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("fid", this.f32635e);
                bundle.putString("fname", this.f32636f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public final boolean p1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), v0.c(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.q || TextUtils.isEmpty(this.a) || !c.a.d.f.p.l.z()) {
            return;
        }
        s1(this.a);
    }

    public final boolean q1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
                return false;
            }
            int parseInt = Integer.parseInt(v0.c(str, "fid="));
            int parseInt2 = Integer.parseInt(v0.c(str, "gameid="));
            String c2 = v0.c(str, "gamename=");
            c.a.p0.f1.b2.a aVar = this.n;
            if (aVar != null) {
                aVar.a(getPageContext(), c2, parseInt2, parseInt);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean r1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
                return false;
            }
            String c2 = v0.c(str, "tid=");
            if (StringUtils.isNull(c2)) {
                return true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(c2, null, "game_news")));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || this.f32638h == null) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.f32638h, str);
    }

    public final boolean t1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? q1(str) || x1(str) || r1(str) || p1(str) : invokeL.booleanValue;
    }

    public void u1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            ScrollBridgeWebview scrollBridgeWebview = this.f32638h;
            if (scrollBridgeWebview != null) {
                this.a = scrollBridgeWebview.getUrl();
                this.f32638h.stopLoading();
            }
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            if (getPageContext() != null) {
                showNetRefreshView(this.l, getPageContext().getString(R.string.obfuscated_res_0x7f0f1499), null, getPageContext().getString(R.string.obfuscated_res_0x7f0f0f62), false, this.z);
            }
        }
    }

    public void v1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.f32637g = i2;
        }
    }

    public void w1(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, shareItem) == null) || shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, m1())));
    }

    public final boolean x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
                return false;
            }
            String c2 = v0.c(str, "packagename=");
            if (StringUtils.isNull(c2)) {
                return true;
            }
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(c2));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || A) {
            return;
        }
        A = true;
        c.a.o0.r.b0.g.a().b(16, new d(this));
    }
}
