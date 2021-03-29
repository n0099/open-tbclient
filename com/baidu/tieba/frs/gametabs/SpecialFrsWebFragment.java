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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidubce.auth.NTLMEngineImpl;
import d.b.h0.r.y.q;
import d.b.h0.z0.n0;
import d.b.i0.p0.r0;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements r0 {
    public static boolean E = false;
    public static HashMap<String, String> F;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p0.y1.d f16482h;
    public String i;
    public String j;
    public int k;
    public View m;
    public NoNetworkView n;
    public FrameLayout o;
    public FrameLayout p;
    public d.b.i0.c3.l0.a q;
    public d.b.i0.p0.z1.a r;
    public d.b.h0.r.y.l s;
    public boolean u;
    public String y;
    public ScrollBridgeWebview l = null;
    public boolean t = true;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public d.b.i0.c3.l0.c z = new e();
    public CustomMessageListener A = new f(0);
    public CustomMessageListener B = new g(2005016);
    public CustomMessageListener C = new h(2001227);
    public final View.OnClickListener D = new c();

    /* loaded from: classes4.dex */
    public class a extends d.b.h0.r.y.n {

        /* renamed from: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0191a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f16484e;

            public RunnableC0191a(ShareItem shareItem) {
                this.f16484e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                SpecialFrsWebFragment.this.y1(this.f16484e);
            }
        }

        public a(d.b.h0.r.y.l lVar) {
            super(lVar);
        }

        @d.b.h0.r.y.o(isAsync = false, value = "share")
        private void share(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                SpecialFrsWebFragment specialFrsWebFragment = SpecialFrsWebFragment.this;
                specialFrsWebFragment.x = true;
                specialFrsWebFragment.y = optString5;
            }
            d.b.b.e.m.e.a().post(new RunnableC0191a(SpecialFrsWebFragment.this.E0(optString, optString4, optString2, optString3)));
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_Share";
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (SpecialFrsWebFragment.this.l != null) {
                    SpecialFrsWebFragment.this.l.destroy();
                    SpecialFrsWebFragment.this.l = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.b.e.p.j.z()) {
                SpecialFrsWebFragment.this.showToast(R.string.neterror);
                return;
            }
            SpecialFrsWebFragment specialFrsWebFragment = SpecialFrsWebFragment.this;
            specialFrsWebFragment.hideNetRefreshView(specialFrsWebFragment.p);
            SpecialFrsWebFragment.this.o.setVisibility(0);
            SpecialFrsWebFragment.this.p.setVisibility(8);
            SpecialFrsWebFragment.this.t = true;
            SpecialFrsWebFragment.this.E();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.h0.r.y.j {
        public d() {
        }

        @Override // d.b.h0.r.y.j
        public void a(List<Long> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (Long l : list) {
                sb.append(str);
                sb.append(l);
                str = "_";
            }
            d.b.b.e.n.a a2 = d.b.h0.m0.j.a();
            a2.a("frame_delta", sb.toString());
            BdStatisticsManager.getInstance().performance("webview", a2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.i0.c3.l0.c {
        public e() {
        }

        @Override // d.b.i0.c3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (SpecialFrsWebFragment.this.q != null) {
                return SpecialFrsWebFragment.this.q.b(SpecialFrsWebFragment.this.l, str, jsPromptResult);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                SpecialFrsWebFragment.this.E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || StringUtils.isNull(SpecialFrsWebFragment.this.f13091e)) {
                return;
            }
            SpecialFrsWebFragment.this.u = true;
            SpecialFrsWebFragment specialFrsWebFragment = SpecialFrsWebFragment.this;
            specialFrsWebFragment.showLoadingView(specialFrsWebFragment.o);
            SpecialFrsWebFragment specialFrsWebFragment2 = SpecialFrsWebFragment.this;
            specialFrsWebFragment2.u1(specialFrsWebFragment2.f13091e);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && SpecialFrsWebFragment.this.w) {
                if (SpecialFrsWebFragment.this.l != null) {
                    SpecialFrsWebFragment.this.l.reload();
                }
                SpecialFrsWebFragment.this.w = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ScrollBridgeWebview.a {
        public i() {
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void a(int i, int i2, int i3, int i4) {
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i, int i2, int i3, int i4) {
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.b.h0.r.y.n {
        public j(d.b.h0.r.y.l lVar) {
            super(lVar);
        }

        @d.b.h0.r.y.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            SpecialFrsWebFragment.this.A1();
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_Performance";
        }
    }

    /* loaded from: classes4.dex */
    public class k extends d.b.h0.r.y.s.c {
        public k(d.b.h0.r.y.l lVar) {
            super(lVar);
        }

        @Override // d.b.h0.r.y.s.c
        @d.b.h0.r.y.o(isAsync = false, value = "scanBigImages")
        public void sanBigImages(JSONObject jSONObject) throws JSONException {
            super.sanBigImages(jSONObject);
            TiebaStatic.log(new StatisticItem("c12338").param("fid", jSONObject.optInt("fid")));
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.b.h0.r.y.n {
        public l(d.b.h0.r.y.l lVar) {
            super(lVar);
        }

        @d.b.h0.r.y.o(isAsync = false, value = "skinToLogin")
        private void skinToLogin() {
            if (TbadkCoreApplication.isLogin()) {
                return;
            }
            ViewHelper.skipToLoginActivity(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_SKIN_TO_LOGIN";
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d.b.h0.r.y.n {
        public m(d.b.h0.r.y.l lVar) {
            super(lVar);
        }

        @d.b.h0.r.y.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            if (jSONObject != null && ViewHelper.checkUpIsLogin(SpecialFrsWebFragment.this.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                String optString2 = jSONObject.optString("comment_id");
                Intent intent = new Intent(SpecialFrsWebFragment.this.getFragmentActivity(), FrsGameSubPbActivity.class);
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, Integer.valueOf(optString));
                intent.putExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID, optString2);
                SpecialFrsWebFragment.this.startActivityForResult(intent, 1001);
            }
        }

        @Override // d.b.h0.r.y.n
        public String g() {
            return "TBHY_COMMON_COMMENT_FLOOR";
        }
    }

    /* loaded from: classes4.dex */
    public class n extends WebViewClient {
        public n() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (SpecialFrsWebFragment.this.l == null) {
                return;
            }
            SpecialFrsWebFragment.this.u = false;
            SpecialFrsWebFragment specialFrsWebFragment = SpecialFrsWebFragment.this;
            specialFrsWebFragment.hideLoadingView(specialFrsWebFragment.o);
            SpecialFrsWebFragment specialFrsWebFragment2 = SpecialFrsWebFragment.this;
            specialFrsWebFragment2.f13091e = str;
            specialFrsWebFragment2.l.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
            if (SpecialFrsWebFragment.this.t) {
                SpecialFrsWebFragment.this.t = false;
            }
            String title = SpecialFrsWebFragment.this.l.getTitle();
            if (!TextUtils.isEmpty(title)) {
                SpecialFrsWebFragment.this.N0(title);
            }
            SpecialFrsWebFragment.this.f16482h.o(SpecialFrsWebFragment.this.I0());
            SpecialFrsWebFragment.this.f16482h.p(SpecialFrsWebFragment.this.J0());
            SpecialFrsWebFragment.this.f16482h.n(SpecialFrsWebFragment.this.H0());
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SpecialFrsWebFragment.this.l == null) {
                return;
            }
            if (SpecialFrsWebFragment.this.t) {
                SpecialFrsWebFragment.this.u = true;
                SpecialFrsWebFragment specialFrsWebFragment = SpecialFrsWebFragment.this;
                specialFrsWebFragment.showLoadingView(specialFrsWebFragment.o);
            }
            SpecialFrsWebFragment.this.f13091e = str;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (SpecialFrsWebFragment.this.l == null) {
                return;
            }
            SpecialFrsWebFragment.this.l.stopLoading();
            SpecialFrsWebFragment.this.w1(i);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (SpecialFrsWebFragment.this.t) {
                SpecialFrsWebFragment.this.t = false;
                return false;
            } else if (!SpecialFrsWebFragment.this.l1(str) || TbadkCoreApplication.isLogin() || SpecialFrsWebFragment.this.getPageContext() == null) {
                if (!SpecialFrsWebFragment.this.v1(str) && SpecialFrsWebFragment.this.getPageContext() != null && SpecialFrsWebFragment.this.l.isShown()) {
                    if (str.startsWith("tdoudiscount:")) {
                        SpecialFrsWebFragment.this.w = true;
                    }
                    if (!SpecialFrsWebFragment.this.G0(str)) {
                        if (SpecialFrsWebFragment.this.v) {
                            return UrlManager.getInstance().dealOneLinkWithOutJumpWebView(SpecialFrsWebFragment.this.getPageContext(), new String[]{str}) == 0;
                        }
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) SpecialFrsWebFragment.this.getPageContext(), new String[]{str}, true);
                    } else {
                        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(SpecialFrsWebFragment.this.getPageContext(), new String[]{str});
                        return dealOneLinkWithOutJumpWebView == 0 || dealOneLinkWithOutJumpWebView == 1;
                    }
                }
                return true;
            } else {
                ViewHelper.skipToLoginActivity(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                return false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements DownloadListener {
        public o() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                SpecialFrsWebFragment.this.startActivity(intent);
            }
        }

        public /* synthetic */ o(SpecialFrsWebFragment specialFrsWebFragment, e eVar) {
            this();
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        F = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        F.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        F.put(Share.QQDENGLU, "qq_zone");
        F.put(Share.SINAWEIBO, "sina_weibo");
        F.put(Share.QQWEIBO, "qq_weibo");
    }

    public final void A1() {
        if (E) {
            return;
        }
        E = true;
        d.b.h0.r.y.g.a().b(16, new d());
    }

    public final void E() {
        if (this.u || TextUtils.isEmpty(this.f13091e) || !d.b.b.e.p.j.z()) {
            return;
        }
        u1(this.f13091e);
    }

    @Override // d.b.i0.p0.r0
    public NavigationBar Q() {
        d.b.i0.p0.y1.d dVar = this.f16482h;
        if (dVar != null) {
            return dVar.j();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        int i2 = this.k;
        if (i2 == 102) {
            return "a055";
        }
        if (i2 == 103) {
            return "a056";
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        return super.getCurrentPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.b.h0.k0.d getPageStayDurationItem() {
        d.b.h0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q(d.b.b.e.m.b.f(h(), 0L));
        }
        return pageStayDurationItem;
    }

    public String h() {
        return this.i;
    }

    public String i() {
        return this.j;
    }

    public final void initData() {
        String str = this.f13091e;
        if (str != null && str.contains("redirect=1")) {
            this.v = true;
        }
        u1(this.f13091e);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, d.b.i0.p0.z1.a.class);
        if (runTask != null) {
            d.b.i0.p0.z1.a aVar = (d.b.i0.p0.z1.a) runTask.getData();
            this.r = aVar;
            if (aVar != null) {
                aVar.init();
            }
        }
    }

    public final d.b.i0.c3.l0.b j1() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.b.i0.c3.l0.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (d.b.i0.c3.l0.b) runTask.getData();
    }

    public void k1(String str) {
        if (this.l != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.l, new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final boolean l1(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    public View m1() {
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
            this.l.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
            this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.l.setWebViewClient(new n());
            this.l.setDownloadListener(new o(this, null));
            d.b.i0.p0.y1.b bVar = new d.b.i0.p0.y1.b(getPageContext());
            bVar.a(this.z);
            this.l.setWebChromeClient(bVar);
            this.l.setOnScrollChangeListener(new i());
            CompatibleUtile.getInstance().removeJavascriptInterface(this.l);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            d.b.h0.r.y.l o2 = q.o(isHybridBridgeEnabled, this.l, null);
            this.s = o2;
            if (isHybridBridgeEnabled) {
                o2.d(new j(o2));
                o2.d(new d.b.h0.r.y.s.a(o2));
                o2.d(new k(o2));
                o2.d(new d.b.h0.l.b(o2));
                o2.d(new d.b.h0.r.y.s.d(o2));
                o2.d(new d.b.i0.p0.y1.e(o2));
                o2.d(new d.b.i0.p0.y1.a(o2, this.i));
                o2.d(new l(o2));
                o2.d(new m(o2));
                o2.d(new a(o2));
            }
        }
        return this.l;
    }

    public ShareItem n1(String str, String str2, String str3, String str4) {
        return E0(str, str2, str3, str4);
    }

    public final SparseArray<String> o1() {
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f16482h == null) {
            this.f16482h = new d.b.i0.p0.y1.d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1001) {
            if (i2 == 24007) {
                p1(intent, i3);
            }
        } else if (i3 != 1002 || this.s == null) {
        } else {
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "0");
            hashMap.put("errMsg", "success");
            d.b.h0.r.y.m j2 = d.b.h0.r.y.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
            d.b.h0.r.y.l lVar = this.s;
            if (lVar != null) {
                lVar.c(j2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        d.b.i0.p0.y1.d dVar = this.f16482h;
        if (dVar != null) {
            dVar.l(i2);
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.i = bundle.getString("fid");
            this.j = bundle.getString("fname");
        } else if (getArguments() != null) {
            this.i = getArguments().getString("fid");
            this.j = getArguments().getString("fname");
        }
        d.b.i0.c3.l0.a aVar = new d.b.i0.c3.l0.a();
        this.q = aVar;
        aVar.a(new XiubaTbJsBridge(getPageContext()));
        this.q.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
        this.q.a(j1());
        q1();
        registerListener(2001446, this.A, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.B);
        MessageManager.getInstance().registerListener(this.C);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.special_frs_web_index, (ViewGroup) null);
        this.m = inflate;
        this.n = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.o = (FrameLayout) this.m.findViewById(R.id.webview_container_layout);
        this.p = (FrameLayout) this.m.findViewById(R.id.no_data_container);
        if (this.f16482h == null) {
            this.f16482h = new d.b.i0.p0.y1.d(getPageContext());
        }
        this.f16482h.k((NavigationBar) this.m.findViewById(R.id.view_navigation_bar), this);
        m1();
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.B);
        MessageManager.getInstance().unRegisterListener(this.C);
        d.b.i0.p0.z1.a aVar = this.r;
        if (aVar != null) {
            aVar.release();
            this.r = null;
        }
        d.b.i0.p0.y1.d dVar = this.f16482h;
        if (dVar != null) {
            dVar.m();
        }
        d.b.i0.c3.l0.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.f();
        }
        ScrollBridgeWebview scrollBridgeWebview = this.l;
        if (scrollBridgeWebview != null) {
            scrollBridgeWebview.getSettings().setBuiltInZoomControls(true);
            this.l.setVisibility(8);
            d.b.b.e.m.e.a().postDelayed(new b(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
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
            k1(MissionEvent.MESSAGE_RESUME);
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
            k1(MissionEvent.MESSAGE_PAUSE);
        }
        this.w = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.b.i0.p0.y1.d dVar = this.f16482h;
        if (dVar != null) {
            dVar.l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("fid", this.i);
            bundle.putString("fname", this.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public final void p1(Intent intent, int i2) {
        ScrollBridgeWebview scrollBridgeWebview;
        if (this.x) {
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
            d.b.h0.r.y.m j2 = d.b.h0.r.y.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            d.b.h0.r.y.l lVar = this.s;
            if (lVar != null) {
                lVar.c(j2);
            }
            if (StringUtils.isNull(this.f13091e) || !this.f13091e.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1 || (scrollBridgeWebview = this.l) == null) {
                return;
            }
            scrollBridgeWebview.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public void q1() {
        d.b.h0.l.a.f(getBaseFragmentActivity().getApplicationContext());
    }

    public final boolean r1(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), n0.c(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    public final boolean s1(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
            return false;
        }
        int parseInt = Integer.parseInt(n0.c(str, "fid="));
        int parseInt2 = Integer.parseInt(n0.c(str, "gameid="));
        String c2 = n0.c(str, "gamename=");
        d.b.i0.p0.z1.a aVar = this.r;
        if (aVar != null) {
            aVar.a(getPageContext(), c2, parseInt2, parseInt);
            return true;
        }
        return true;
    }

    public final boolean t1(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
            return false;
        }
        String c2 = n0.c(str, "tid=");
        if (StringUtils.isNull(c2)) {
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(c2, null, PbActivityConfig.KEY_FROM_NEWS)));
        return true;
    }

    public void u1(String str) {
        if (this.l != null) {
            CompatibleUtile.getInstance().loadUrl(this.l, str);
        }
    }

    public final boolean v1(String str) {
        return s1(str) || z1(str) || t1(str) || r1(str);
    }

    public void w1(int i2) {
        ScrollBridgeWebview scrollBridgeWebview = this.l;
        if (scrollBridgeWebview != null) {
            this.f13091e = scrollBridgeWebview.getUrl();
            this.l.stopLoading();
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        if (getPageContext() != null) {
            showNetRefreshView(this.p, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.refresh), false, this.D);
        }
    }

    public void x1(int i2) {
        this.k = i2;
    }

    public void y1(ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, o1())));
    }

    public final boolean z1(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
            return false;
        }
        String c2 = n0.c(str, "packagename=");
        if (StringUtils.isNull(c2)) {
            return true;
        }
        getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(c2));
        return true;
    }
}
