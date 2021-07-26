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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.a.p0.b1.p0;
import d.a.p0.s.y.q;
import d.a.q0.u0.q0;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements q0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean E;
    public static HashMap<String, String> F;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public final View.OnClickListener D;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.u0.x1.d f15898h;

    /* renamed from: i  reason: collision with root package name */
    public String f15899i;
    public String j;
    public int k;
    public ScrollBridgeWebview l;
    public View m;
    public NoNetworkView n;
    public FrameLayout o;
    public FrameLayout p;
    public d.a.q0.h3.l0.a q;
    public d.a.q0.u0.y1.a r;
    public d.a.p0.s.y.l s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;
    public d.a.q0.h3.l0.c z;

    /* loaded from: classes4.dex */
    public class a extends d.a.p0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15900c;

        /* renamed from: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0201a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f15901e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f15902f;

            public RunnableC0201a(a aVar, ShareItem shareItem) {
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
                this.f15902f = aVar;
                this.f15901e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15902f.f15900c.G1(this.f15901e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialFrsWebFragment specialFrsWebFragment, d.a.p0.s.y.l lVar) {
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
                    super((d.a.p0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15900c = specialFrsWebFragment;
        }

        @d.a.p0.s.y.o(isAsync = false, value = "share")
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
                SpecialFrsWebFragment specialFrsWebFragment = this.f15900c;
                specialFrsWebFragment.x = true;
                specialFrsWebFragment.y = optString5;
            }
            d.a.d.e.m.e.a().post(new RunnableC0201a(this, this.f15900c.M0(optString, optString4, optString2, optString3)));
        }

        @Override // d.a.p0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15903e;

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
            this.f15903e = specialFrsWebFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f15903e.l != null) {
                        this.f15903e.l.destroy();
                        this.f15903e.l = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15904e;

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
            this.f15904e = specialFrsWebFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!d.a.d.e.p.j.z()) {
                    this.f15904e.showToast(R.string.neterror);
                    return;
                }
                SpecialFrsWebFragment specialFrsWebFragment = this.f15904e;
                specialFrsWebFragment.hideNetRefreshView(specialFrsWebFragment.p);
                this.f15904e.o.setVisibility(0);
                this.f15904e.p.setVisibility(8);
                this.f15904e.t = true;
                this.f15904e.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.p0.s.y.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15905a;

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
            this.f15905a = specialFrsWebFragment;
        }

        @Override // d.a.p0.s.y.j
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
            d.a.d.e.n.a a2 = d.a.p0.o0.j.a();
            a2.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance("webview", a2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.q0.h3.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15906a;

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
            this.f15906a = specialFrsWebFragment;
        }

        @Override // d.a.q0.h3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f15906a.q != null) {
                    return this.f15906a.q.b(this.f15906a.l, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15907a;

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
            this.f15907a = specialFrsWebFragment;
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
                this.f15907a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15908a;

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
            this.f15908a = specialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(this.f15908a.f12158e)) {
                return;
            }
            this.f15908a.u = true;
            SpecialFrsWebFragment specialFrsWebFragment = this.f15908a;
            specialFrsWebFragment.showLoadingView(specialFrsWebFragment.o);
            SpecialFrsWebFragment specialFrsWebFragment2 = this.f15908a;
            specialFrsWebFragment2.C1(specialFrsWebFragment2.f12158e);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15909a;

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
            this.f15909a = specialFrsWebFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && this.f15909a.w) {
                if (this.f15909a.l != null) {
                    this.f15909a.l.reload();
                }
                this.f15909a.w = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ScrollBridgeWebview.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15910a;

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
            this.f15910a = specialFrsWebFragment;
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

    /* loaded from: classes4.dex */
    public class j extends d.a.p0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15911c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SpecialFrsWebFragment specialFrsWebFragment, d.a.p0.s.y.l lVar) {
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
                    super((d.a.p0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15911c = specialFrsWebFragment;
        }

        @d.a.p0.s.y.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f15911c.I1();
            }
        }

        @Override // d.a.p0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends d.a.p0.s.y.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15912d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SpecialFrsWebFragment specialFrsWebFragment, d.a.p0.s.y.l lVar) {
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
                    super((d.a.p0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15912d = specialFrsWebFragment;
        }

        @Override // d.a.p0.s.y.s.c
        @d.a.p0.s.y.o(isAsync = false, value = "scanBigImages")
        public void sanBigImages(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.sanBigImages(jSONObject);
                TiebaStatic.log(new StatisticItem("c12338").param("fid", jSONObject.optInt("fid")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.a.p0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15913c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SpecialFrsWebFragment specialFrsWebFragment, d.a.p0.s.y.l lVar) {
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
                    super((d.a.p0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15913c = specialFrsWebFragment;
        }

        @d.a.p0.s.y.o(isAsync = false, value = "skinToLogin")
        private void skinToLogin() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || TbadkCoreApplication.isLogin()) {
                return;
            }
            ViewHelper.skipToLoginActivity(this.f15913c.getPageContext().getPageActivity());
        }

        @Override // d.a.p0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_SKIN_TO_LOGIN" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d.a.p0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15914c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SpecialFrsWebFragment specialFrsWebFragment, d.a.p0.s.y.l lVar) {
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
                    super((d.a.p0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15914c = specialFrsWebFragment;
        }

        @d.a.p0.s.y.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null && ViewHelper.checkUpIsLogin(this.f15914c.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                String optString2 = jSONObject.optString("comment_id");
                Intent intent = new Intent(this.f15914c.getFragmentActivity(), FrsGameSubPbActivity.class);
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, Integer.valueOf(optString));
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID, optString2);
                this.f15914c.startActivityForResult(intent, 1001);
            }
        }

        @Override // d.a.p0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_COMMENT_FLOOR" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class n extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15915a;

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
            this.f15915a = specialFrsWebFragment;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.f15915a.l == null) {
                    return;
                }
                this.f15915a.u = false;
                SpecialFrsWebFragment specialFrsWebFragment = this.f15915a;
                specialFrsWebFragment.hideLoadingView(specialFrsWebFragment.o);
                SpecialFrsWebFragment specialFrsWebFragment2 = this.f15915a;
                specialFrsWebFragment2.f12158e = str;
                specialFrsWebFragment2.l.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (this.f15915a.t) {
                    this.f15915a.t = false;
                }
                String title = this.f15915a.l.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    this.f15915a.V0(title);
                }
                this.f15915a.f15898h.o(this.f15915a.Q0());
                this.f15915a.f15898h.p(this.f15915a.R0());
                this.f15915a.f15898h.n(this.f15915a.P0());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f15915a.l == null) {
                    return;
                }
                if (this.f15915a.t) {
                    this.f15915a.u = true;
                    SpecialFrsWebFragment specialFrsWebFragment = this.f15915a;
                    specialFrsWebFragment.showLoadingView(specialFrsWebFragment.o);
                }
                this.f15915a.f12158e = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                if (this.f15915a.l == null) {
                    return;
                }
                this.f15915a.l.stopLoading();
                this.f15915a.E1(i2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.f15915a.t) {
                    this.f15915a.t = false;
                    return false;
                } else if (!this.f15915a.t1(str) || TbadkCoreApplication.isLogin() || this.f15915a.getPageContext() == null) {
                    if (!this.f15915a.D1(str) && this.f15915a.getPageContext() != null && this.f15915a.l.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            this.f15915a.w = true;
                        }
                        if (!this.f15915a.O0(str)) {
                            if (this.f15915a.v) {
                                return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f15915a.getPageContext(), new String[]{str}) == 0;
                            }
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f15915a.getPageContext(), new String[]{str}, true);
                        } else {
                            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f15915a.getPageContext(), new String[]{str});
                            return dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1;
                        }
                    }
                    return true;
                } else {
                    ViewHelper.skipToLoginActivity(this.f15915a.getPageContext().getPageActivity());
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialFrsWebFragment f15916a;

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
            this.f15916a = specialFrsWebFragment;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.f15916a.startActivity(intent);
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
        F = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        F.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        F.put(Share.QQDENGLU, "qq_zone");
        F.put(Share.SINAWEIBO, "sina_weibo");
        F.put(Share.QQWEIBO, "qq_weibo");
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
        this.l = null;
        this.t = true;
        this.v = false;
        this.w = false;
        this.x = false;
        this.z = new e(this);
        this.A = new f(this, 0);
        this.B = new g(this, 2005016);
        this.C = new h(this, 2001227);
        this.D = new c(this);
    }

    public final boolean A1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
                return false;
            }
            int parseInt = Integer.parseInt(p0.c(str, "fid="));
            int parseInt2 = Integer.parseInt(p0.c(str, "gameid="));
            String c2 = p0.c(str, "gamename=");
            d.a.q0.u0.y1.a aVar = this.r;
            if (aVar != null) {
                aVar.a(getPageContext(), c2, parseInt2, parseInt);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean B1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
                return false;
            }
            String c2 = p0.c(str, "tid=");
            if (StringUtils.isNull(c2)) {
                return true;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(c2, null, "game_news")));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.l == null) {
            return;
        }
        CompatibleUtile.getInstance().loadUrl(this.l, str);
    }

    public final boolean D1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? A1(str) || H1(str) || B1(str) || z1(str) : invokeL.booleanValue;
    }

    public void E1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            ScrollBridgeWebview scrollBridgeWebview = this.l;
            if (scrollBridgeWebview != null) {
                this.f12158e = scrollBridgeWebview.getUrl();
                this.l.stopLoading();
            }
            this.o.setVisibility(8);
            this.p.setVisibility(0);
            if (getPageContext() != null) {
                showNetRefreshView(this.p, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.refresh), false, this.D);
            }
        }
    }

    public void F1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.k = i2;
        }
    }

    public void G1(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, w1())));
    }

    public final boolean H1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
                return false;
            }
            String c2 = p0.c(str, "packagename=");
            if (StringUtils.isNull(c2)) {
                return true;
            }
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(c2));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || E) {
            return;
        }
        E = true;
        d.a.p0.s.y.g.a().b(16, new d(this));
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.k;
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

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.m0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? super.getCurrentPageSourceKeyList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.p0.m0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.p0.m0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.q(d.a.d.e.m.b.f(h(), 0L));
            }
            return pageStayDurationItem;
        }
        return (d.a.p0.m0.d) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f15899i : (String) invokeV.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String str = this.f12158e;
            if (str != null && str.contains("redirect=1")) {
                this.v = true;
            }
            C1(this.f12158e);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, d.a.q0.u0.y1.a.class);
            if (runTask != null) {
                d.a.q0.u0.y1.a aVar = (d.a.q0.u0.y1.a) runTask.getData();
                this.r = aVar;
                if (aVar != null) {
                    aVar.init();
                }
            }
        }
    }

    @Override // d.a.q0.u0.q0
    public NavigationBar j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d.a.q0.u0.x1.d dVar = this.f15898h;
            if (dVar != null) {
                return dVar.j();
            }
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.f15898h == null) {
                this.f15898h = new d.a.q0.u0.x1.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 1001) {
                if (i2 == 24007) {
                    x1(intent, i3);
                }
            } else if (i3 != 1002 || this.s == null) {
            } else {
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "0");
                hashMap.put("errMsg", "success");
                d.a.p0.s.y.m j2 = d.a.p0.s.y.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                d.a.p0.s.y.l lVar = this.s;
                if (lVar != null) {
                    lVar.c(j2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            d.a.q0.u0.x1.d dVar = this.f15898h;
            if (dVar != null) {
                dVar.l(i2);
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f15899i = bundle.getString("fid");
                this.j = bundle.getString("fname");
            } else if (getArguments() != null) {
                this.f15899i = getArguments().getString("fid");
                this.j = getArguments().getString("fname");
            }
            d.a.q0.h3.l0.a aVar = new d.a.q0.h3.l0.a();
            this.q = aVar;
            aVar.a(new XiubaTbJsBridge(getPageContext()));
            this.q.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
            this.q.a(r1());
            y1();
            registerListener(2001446, this.A, getBaseFragmentActivity().getUniqueId());
            MessageManager.getInstance().registerListener(this.B);
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.special_frs_web_index, (ViewGroup) null);
            this.m = inflate;
            this.n = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
            this.o = (FrameLayout) this.m.findViewById(R.id.webview_container_layout);
            this.p = (FrameLayout) this.m.findViewById(R.id.no_data_container);
            if (this.f15898h == null) {
                this.f15898h = new d.a.q0.u0.x1.d(getPageContext());
            }
            this.f15898h.k((NavigationBar) this.m.findViewById(R.id.view_navigation_bar), this);
            u1();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.o.setLayoutParams(layoutParams);
            ScrollBridgeWebview scrollBridgeWebview = this.l;
            if (scrollBridgeWebview != null && (parent = scrollBridgeWebview.getParent()) != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.l);
            }
            this.o.addView(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.m;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().unRegisterListener(this.C);
            d.a.q0.u0.y1.a aVar = this.r;
            if (aVar != null) {
                aVar.release();
                this.r = null;
            }
            d.a.q0.u0.x1.d dVar = this.f15898h;
            if (dVar != null) {
                dVar.m();
            }
            d.a.q0.h3.l0.a aVar2 = this.q;
            if (aVar2 != null) {
                aVar2.f();
            }
            ScrollBridgeWebview scrollBridgeWebview = this.l;
            if (scrollBridgeWebview != null) {
                scrollBridgeWebview.getSettings().setBuiltInZoomControls(true);
                this.l.setVisibility(8);
                d.a.d.e.m.e.a().postDelayed(new b(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.l == null) {
                    return;
                }
                if (this.t) {
                    initData();
                }
                try {
                    this.l.onResume();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                s1(MissionEvent.MESSAGE_RESUME);
            } else {
                ScrollBridgeWebview scrollBridgeWebview = this.l;
                if (scrollBridgeWebview == null) {
                    return;
                }
                try {
                    scrollBridgeWebview.onPause();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                s1(MissionEvent.MESSAGE_PAUSE);
            }
            this.w = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            d.a.q0.u0.x1.d dVar = this.f15898h;
            if (dVar != null) {
                dVar.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("fid", this.f15899i);
                bundle.putString("fname", this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    public final d.a.q0.h3.l0.b r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.a.q0.h3.l0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (d.a.q0.h3.l0.b) runTask.getData();
        }
        return (d.a.q0.h3.l0.b) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.u || TextUtils.isEmpty(this.f12158e) || !d.a.d.e.p.j.z()) {
            return;
        }
        C1(this.f12158e);
    }

    public void s1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || this.l == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(this.l, new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final boolean t1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.contains("tieba_check_login=1");
        }
        return invokeL.booleanValue;
    }

    public View u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.l == null) {
                ScrollBridgeWebview scrollBridgeWebview = new ScrollBridgeWebview(getPageContext().getPageActivity());
                this.l = scrollBridgeWebview;
                scrollBridgeWebview.setNeedDisAllowParentInterceptTouchEvent(true);
                this.l.getSettings().setJavaScriptEnabled(true);
                this.l.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.l.getSettings().setAllowFileAccess(true);
                this.l.getSettings().setDatabaseEnabled(true);
                this.l.getSettings().setDomStorageEnabled(true);
                this.l.getSettings().setSupportZoom(true);
                this.l.getSettings().setBuiltInZoomControls(true);
                this.l.getSettings().setUseWideViewPort(true);
                this.l.getSettings().setLoadWithOverviewMode(true);
                this.l.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.l.setHorizontalScrollBarEnabled(false);
                this.l.setHorizontalScrollbarOverlay(false);
                this.l.setInitialScale(100);
                this.l.setScrollBarStyle(33554432);
                this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.l.setWebViewClient(new n(this));
                this.l.setDownloadListener(new o(this, null));
                d.a.q0.u0.x1.b bVar = new d.a.q0.u0.x1.b(getPageContext());
                bVar.a(this.z);
                this.l.setWebChromeClient(bVar);
                this.l.setOnScrollChangeListener(new i(this));
                CompatibleUtile.getInstance().removeJavascriptInterface(this.l);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                d.a.p0.s.y.l o2 = q.o(isHybridBridgeEnabled, this.l, null);
                this.s = o2;
                if (isHybridBridgeEnabled) {
                    o2.d(new j(this, o2));
                    o2.d(new d.a.p0.s.y.s.a(o2));
                    o2.d(new k(this, o2));
                    o2.d(new d.a.p0.m.b(o2));
                    o2.d(new d.a.p0.s.y.s.d(o2));
                    o2.d(new d.a.q0.u0.x1.e(o2));
                    o2.d(new d.a.q0.u0.x1.a(o2, this.f15899i));
                    o2.d(new l(this, o2));
                    o2.d(new m(this, o2));
                    o2.d(new a(this, o2));
                }
            }
            return this.l;
        }
        return (View) invokeV.objValue;
    }

    public ShareItem v1(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048607, this, str, str2, str3, str4)) == null) ? M0(str, str2, str3, str4) : (ShareItem) invokeLLLL.objValue;
    }

    public final SparseArray<String> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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

    public final void x1(Intent intent, int i2) {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048609, this, intent, i2) == null) && this.x) {
            this.x = false;
            if (intent == null) {
                return;
            }
            String str = F.get(intent.getStringExtra("share_to"));
            HashMap hashMap = new HashMap();
            boolean z = i2 == -1;
            hashMap.put("bid", this.y);
            hashMap.put("result", Boolean.valueOf(z));
            hashMap.put("channel", str);
            d.a.p0.s.y.m j2 = d.a.p0.s.y.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            d.a.p0.s.y.l lVar = this.s;
            if (lVar != null) {
                lVar.c(j2);
            }
            if (StringUtils.isNull(this.f12158e) || !this.f12158e.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1 || (scrollBridgeWebview = this.l) == null) {
                return;
            }
            scrollBridgeWebview.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            d.a.p0.m.a.f(getBaseFragmentActivity().getApplicationContext());
        }
    }

    public final boolean z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), p0.c(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
            return true;
        }
        return invokeL.booleanValue;
    }
}
