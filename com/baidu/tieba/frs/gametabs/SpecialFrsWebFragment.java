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
import c.a.s0.e1.v0;
import c.a.s0.s.z.q;
import c.a.t0.d1.r0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.share.Share;
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
/* loaded from: classes12.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean C;
    public static HashMap<String, String> D;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final View.OnClickListener B;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.d1.k2.d f43481g;

    /* renamed from: h  reason: collision with root package name */
    public String f43482h;

    /* renamed from: i  reason: collision with root package name */
    public String f43483i;

    /* renamed from: j  reason: collision with root package name */
    public int f43484j;
    public ScrollBridgeWebview k;
    public View l;
    public NoNetworkView m;
    public boolean mShareResultToFe;
    public FrameLayout n;
    public FrameLayout o;
    public c.a.t0.w3.n0.a p;
    public c.a.t0.d1.l2.a q;
    public c.a.s0.s.z.l r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public String w;
    public c.a.t0.w3.n0.c x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes12.dex */
    public class a extends c.a.s0.s.z.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43485c;

        /* renamed from: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class RunnableC1913a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f43486e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f43487f;

            public RunnableC1913a(a aVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43487f = aVar;
                this.f43486e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43487f.f43485c.showShareDialog(this.f43486e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialFrsWebFragment specialFrsWebFragment, c.a.s0.s.z.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.s0.s.z.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43485c = specialFrsWebFragment;
        }

        @c.a.s0.s.z.o(isAsync = false, value = "share")
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
                SpecialFrsWebFragment specialFrsWebFragment = this.f43485c;
                specialFrsWebFragment.mShareResultToFe = true;
                specialFrsWebFragment.w = optString5;
            }
            c.a.d.f.m.e.a().post(new RunnableC1913a(this, this.f43485c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // c.a.s0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43488e;

        public b(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43488e = specialFrsWebFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f43488e.k != null) {
                        this.f43488e.k.destroy();
                        this.f43488e.k = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43489e;

        public c(SpecialFrsWebFragment specialFrsWebFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43489e = specialFrsWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.a.d.f.p.l.z()) {
                    this.f43489e.showToast(R.string.neterror);
                    return;
                }
                SpecialFrsWebFragment specialFrsWebFragment = this.f43489e;
                specialFrsWebFragment.hideNetRefreshView(specialFrsWebFragment.o);
                this.f43489e.n.setVisibility(0);
                this.f43489e.o.setVisibility(8);
                this.f43489e.s = true;
                this.f43489e.forceRefresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements c.a.s0.s.z.j {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // c.a.s0.s.z.j
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
            c.a.d.f.n.a a = c.a.s0.s0.j.a();
            a.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance(AlbumActivityConfig.FROM_WEB_VIEW, a);
        }
    }

    /* loaded from: classes12.dex */
    public class e implements c.a.t0.w3.n0.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // c.a.t0.w3.n0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.p != null) {
                    return this.a.p.b(this.a.k, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SpecialFrsWebFragment specialFrsWebFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.forceRefresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SpecialFrsWebFragment specialFrsWebFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.a.mUrl)) {
                return;
            }
            this.a.t = true;
            SpecialFrsWebFragment specialFrsWebFragment = this.a;
            specialFrsWebFragment.showLoadingView(specialFrsWebFragment.n);
            SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
            specialFrsWebFragment2.loadUrl(specialFrsWebFragment2.mUrl);
        }
    }

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialFrsWebFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SpecialFrsWebFragment specialFrsWebFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && this.a.v) {
                if (this.a.k != null) {
                    this.a.k.reload();
                }
                this.a.v = false;
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void a(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends c.a.s0.s.z.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43490c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SpecialFrsWebFragment specialFrsWebFragment, c.a.s0.s.z.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.s0.s.z.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43490c = specialFrsWebFragment;
        }

        @c.a.s0.s.z.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f43490c.L();
            }
        }

        @Override // c.a.s0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class k extends c.a.s0.s.z.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43491d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SpecialFrsWebFragment specialFrsWebFragment, c.a.s0.s.z.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.s0.s.z.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43491d = specialFrsWebFragment;
        }

        @Override // c.a.s0.s.z.s.c
        @c.a.s0.s.z.o(isAsync = false, value = "scanBigImages")
        public void sanBigImages(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.sanBigImages(jSONObject);
                TiebaStatic.log(new StatisticItem("c12338").param("fid", jSONObject.optInt("fid")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l extends c.a.s0.s.z.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43492c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SpecialFrsWebFragment specialFrsWebFragment, c.a.s0.s.z.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.s0.s.z.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43492c = specialFrsWebFragment;
        }

        @c.a.s0.s.z.o(isAsync = false, value = "skinToLogin")
        private void skinToLogin() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || TbadkCoreApplication.isLogin()) {
                return;
            }
            ViewHelper.skipToLoginActivity(this.f43492c.getPageContext().getPageActivity());
        }

        @Override // c.a.s0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_SKIN_TO_LOGIN" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class m extends c.a.s0.s.z.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f43493c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SpecialFrsWebFragment specialFrsWebFragment, c.a.s0.s.z.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialFrsWebFragment, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.s0.s.z.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43493c = specialFrsWebFragment;
        }

        @c.a.s0.s.z.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null && ViewHelper.checkUpIsLogin(this.f43493c.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                String optString2 = jSONObject.optString("comment_id");
                Intent intent = new Intent(this.f43493c.getFragmentActivity(), FrsGameSubPbActivity.class);
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, Integer.valueOf(optString));
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID, optString2);
                this.f43493c.startActivityForResult(intent, 1001);
            }
        }

        @Override // c.a.s0.s.z.n
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_COMMENT_FLOOR" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.k == null) {
                    return;
                }
                this.a.t = false;
                SpecialFrsWebFragment specialFrsWebFragment = this.a;
                specialFrsWebFragment.hideLoadingView(specialFrsWebFragment.n);
                SpecialFrsWebFragment specialFrsWebFragment2 = this.a;
                specialFrsWebFragment2.mUrl = str;
                specialFrsWebFragment2.k.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (this.a.s) {
                    this.a.s = false;
                }
                String title = this.a.k.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    this.a.setUrlTitle(title);
                }
                this.a.f43481g.o(this.a.isNeedShowNavigationBar());
                this.a.f43481g.p(this.a.isNeedShowShareItem());
                this.a.f43481g.n(this.a.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.a.k == null) {
                    return;
                }
                if (this.a.s) {
                    this.a.t = true;
                    SpecialFrsWebFragment specialFrsWebFragment = this.a;
                    specialFrsWebFragment.showLoadingView(specialFrsWebFragment.n);
                }
                this.a.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                if (this.a.k == null) {
                    return;
                }
                this.a.k.stopLoading();
                this.a.onReceivedError(i2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                c.a.s0.m.f.a("SpecialFrsWebFragment", webView);
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
                if (this.a.s) {
                    this.a.s = false;
                    return false;
                } else if (!this.a.D(str) || TbadkCoreApplication.isLogin() || this.a.getPageContext() == null) {
                    if (!this.a.J(str) && this.a.getPageContext() != null && this.a.k.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            this.a.v = true;
                        }
                        if (!this.a.isNeedNativeWebViewOpen(str)) {
                            if (this.a.u) {
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

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialFrsWebFragment;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) || StringUtils.isNull(str)) {
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
        D = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        D.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        D.put(Share.QQDENGLU, "qq_zone");
        D.put(Share.SINAWEIBO, "sina_weibo");
        D.put(Share.QQWEIBO, "qq_weibo");
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
        this.k = null;
        this.s = true;
        this.u = false;
        this.v = false;
        this.mShareResultToFe = false;
        this.x = new e(this);
        this.y = new f(this, 0);
        this.z = new g(this, 2005016);
        this.A = new h(this, 2001227);
        this.B = new c(this);
    }

    public final c.a.t0.w3.n0.b C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, c.a.t0.w3.n0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (c.a.t0.w3.n0.b) runTask.getData();
        }
        return (c.a.t0.w3.n0.b) invokeV.objValue;
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public final SparseArray<String> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public final void F(Intent intent, int i2) {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, intent, i2) == null) && this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent == null) {
                return;
            }
            String str = D.get(intent.getStringExtra("share_to"));
            HashMap hashMap = new HashMap();
            boolean z = i2 == -1;
            hashMap.put("bid", this.w);
            hashMap.put("result", Boolean.valueOf(z));
            hashMap.put("channel", str);
            c.a.s0.s.z.m j2 = c.a.s0.s.z.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            c.a.s0.s.z.l lVar = this.r;
            if (lVar != null) {
                lVar.c(j2);
            }
            if (StringUtils.isNull(this.mUrl) || !this.mUrl.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1 || (scrollBridgeWebview = this.k) == null) {
                return;
            }
            scrollBridgeWebview.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public final boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), v0.c(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
                return false;
            }
            int parseInt = Integer.parseInt(v0.c(str, "fid="));
            int parseInt2 = Integer.parseInt(v0.c(str, "gameid="));
            String c2 = v0.c(str, "gamename=");
            c.a.t0.d1.l2.a aVar = this.q;
            if (aVar != null) {
                aVar.a(getPageContext(), c2, parseInt2, parseInt);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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

    public final boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? H(str) || K(str) || I(str) || G(str) : invokeL.booleanValue;
    }

    public final boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || C) {
            return;
        }
        C = true;
        c.a.s0.s.z.g.a().b(16, new d(this));
    }

    public void addJsPromptInterface(c.a.t0.w3.n0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || bVar == null) {
            return;
        }
        this.p.a(bVar);
    }

    public void callHiddenWebViewMethod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.k == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(this.k, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.k == null) {
                ScrollBridgeWebview scrollBridgeWebview = new ScrollBridgeWebview(getPageContext().getPageActivity());
                this.k = scrollBridgeWebview;
                scrollBridgeWebview.setNeedDisAllowParentInterceptTouchEvent(true);
                this.k.getSettings().setJavaScriptEnabled(true);
                this.k.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.k.getSettings().setAllowFileAccess(true);
                this.k.getSettings().setDatabaseEnabled(true);
                this.k.getSettings().setDomStorageEnabled(true);
                this.k.getSettings().setSupportZoom(true);
                this.k.getSettings().setBuiltInZoomControls(true);
                this.k.getSettings().setUseWideViewPort(true);
                this.k.getSettings().setLoadWithOverviewMode(true);
                this.k.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.k.setHorizontalScrollBarEnabled(false);
                this.k.setHorizontalScrollbarOverlay(false);
                this.k.setInitialScale(100);
                this.k.setScrollBarStyle(33554432);
                this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.k.setWebViewClient(new n(this));
                this.k.setDownloadListener(new o(this, null));
                c.a.t0.d1.k2.b bVar = new c.a.t0.d1.k2.b(getPageContext());
                bVar.a(this.x);
                this.k.setWebChromeClient(bVar);
                this.k.setOnScrollChangeListener(new i(this));
                CompatibleUtile.getInstance().removeJavascriptInterface(this.k);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                c.a.s0.s.z.l n2 = q.n(isHybridBridgeEnabled, this.k, null);
                this.r = n2;
                if (isHybridBridgeEnabled) {
                    n2.d(new j(this, n2));
                    n2.d(new c.a.s0.s.z.s.a(n2));
                    n2.d(new k(this, n2));
                    n2.d(new c.a.s0.m.b(n2));
                    n2.d(new c.a.s0.s.z.s.d(n2));
                    n2.d(new c.a.t0.d1.k2.e(n2));
                    n2.d(new c.a.t0.d1.k2.a(n2, this.f43482h));
                    n2.d(new l(this, n2));
                    n2.d(new m(this, n2));
                    n2.d(new a(this, n2));
                }
            }
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    public final void forceRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.t || TextUtils.isEmpty(this.mUrl) || !c.a.d.f.p.l.z()) {
            return;
        }
        loadUrl(this.mUrl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = this.f43484j;
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.getCurrentPageSourceKeyList() : (List) invokeV.objValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f43482h : (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f43483i : (String) invokeV.objValue;
    }

    @Override // c.a.t0.d1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.t0.d1.k2.d dVar = this.f43481g;
            if (dVar != null) {
                return dVar.j();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.s0.q0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.s0.q0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(c.a.d.f.m.b.g(getForumId(), 0L));
            }
            return pageStayDurationItem;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    public ShareItem getShareContent(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, str, str2, str3, str4)) == null) ? createShareContent(str, str2, str3, str4) : (ShareItem) invokeLLLL.objValue;
    }

    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.s0.m.a.f(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            String str = this.mUrl;
            if (str != null && str.contains("redirect=1")) {
                this.u = true;
            }
            loadUrl(this.mUrl);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, c.a.t0.d1.l2.a.class);
            if (runTask != null) {
                c.a.t0.d1.l2.a aVar = (c.a.t0.d1.l2.a) runTask.getData();
                this.q = aVar;
                if (aVar != null) {
                    aVar.init();
                }
            }
        }
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || this.k == null) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.k, str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f43481g == null) {
                this.f43481g = new c.a.t0.d1.k2.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048601, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 1001) {
                if (i2 == 24007) {
                    F(intent, i3);
                }
            } else if (i3 != 1002 || this.r == null) {
            } else {
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "0");
                hashMap.put("errMsg", "success");
                c.a.s0.s.z.m j2 = c.a.s0.s.z.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                c.a.s0.s.z.l lVar = this.r;
                if (lVar != null) {
                    lVar.c(j2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            c.a.t0.d1.k2.d dVar = this.f43481g;
            if (dVar != null) {
                dVar.l(i2);
            }
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f43482h = bundle.getString("fid");
                this.f43483i = bundle.getString("fname");
            } else if (getArguments() != null) {
                this.f43482h = getArguments().getString("fid");
                this.f43483i = getArguments().getString("fname");
            }
            c.a.t0.w3.n0.a aVar = new c.a.t0.w3.n0.a();
            this.p = aVar;
            aVar.a(new XiubaTbJsBridge(getPageContext()));
            this.p.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.p.a(C());
            initCookie();
            registerListener(2001446, this.y, getBaseFragmentActivity().getUniqueId());
            MessageManager.getInstance().registerListener(this.z);
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.special_frs_web_index, (ViewGroup) null);
            this.l = inflate;
            this.m = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.n = (FrameLayout) this.l.findViewById(R.id.webview_container_layout);
            this.o = (FrameLayout) this.l.findViewById(R.id.no_data_container);
            if (this.f43481g == null) {
                this.f43481g = new c.a.t0.d1.k2.d(getPageContext());
            }
            this.f43481g.k((NavigationBar) this.l.findViewById(R.id.view_navigation_bar), this);
            createWebView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.n.setLayoutParams(layoutParams);
            ScrollBridgeWebview scrollBridgeWebview = this.k;
            if (scrollBridgeWebview != null && (parent = scrollBridgeWebview.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.k);
            }
            this.n.addView(this.k);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.l;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.A);
            c.a.t0.d1.l2.a aVar = this.q;
            if (aVar != null) {
                aVar.release();
                this.q = null;
            }
            c.a.t0.d1.k2.d dVar = this.f43481g;
            if (dVar != null) {
                dVar.m();
            }
            c.a.t0.w3.n0.a aVar2 = this.p;
            if (aVar2 != null) {
                aVar2.f();
            }
            ScrollBridgeWebview scrollBridgeWebview = this.k;
            if (scrollBridgeWebview != null) {
                scrollBridgeWebview.getSettings().setBuiltInZoomControls(true);
                this.k.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(new b(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.k == null) {
                    return;
                }
                if (this.s) {
                    initData();
                }
                try {
                    this.k.onResume();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                callHiddenWebViewMethod("onResume");
            } else {
                ScrollBridgeWebview scrollBridgeWebview = this.k;
                if (scrollBridgeWebview == null) {
                    return;
                }
                try {
                    scrollBridgeWebview.onPause();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
            }
            this.v = false;
        }
    }

    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            ScrollBridgeWebview scrollBridgeWebview = this.k;
            if (scrollBridgeWebview != null) {
                this.mUrl = scrollBridgeWebview.getUrl();
                this.k.stopLoading();
            }
            this.n.setVisibility(8);
            this.o.setVisibility(0);
            if (getPageContext() != null) {
                showNetRefreshView(this.o, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.refresh), false, this.B);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            c.a.t0.d1.k2.d dVar = this.f43481g;
            if (dVar != null) {
                dVar.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("fid", this.f43482h);
                bundle.putString("fname", this.f43483i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public void removePromptInterface(c.a.t0.w3.n0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) || bVar == null) {
            return;
        }
        this.p.g(bVar);
    }

    public void setTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.f43484j = i2;
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, shareItem) == null) || shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, E())));
    }
}
