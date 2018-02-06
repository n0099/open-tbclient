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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.hybrid.h;
import com.baidu.tbadk.core.hybrid.k;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.hybrid.r;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.browser.a implements am {
    private String cZU;
    private ImageView clk;
    private NoNetworkView dRt;
    private FrameLayout dRu;
    private ImageView dRv;
    private com.baidu.tieba.frs.b.a dRw;
    private boolean isLoading;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private m mHybridBridge;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private static boolean sFrameLostTracked = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    private ScrollBridgeWebview clu = null;
    private boolean clp = true;
    private boolean dRx = false;
    private boolean dRy = false;
    protected boolean mShareResultToFe = false;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.frs.gametabs.c.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (c.this.jsBridge != null) {
                return c.this.jsBridge.b(str, jsPromptResult);
            }
            return false;
        }
    };
    private CustomMessageListener cdm = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametabs.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                        c.this.XL();
                    }
                }
            }
        }
    };
    private CustomMessageListener cdn = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametabs.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(c.this.mUrl)) {
                c.this.isLoading = true;
                c.this.showLoadingView(c.this.dRu);
                c.this.loadUrl(c.this.mUrl);
            }
        }
    };
    private CustomMessageListener dRz = new CustomMessageListener(2001227) { // from class: com.baidu.tieba.frs.gametabs.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && c.this.dRy) {
                if (c.this.clu != null) {
                    c.this.clu.reload();
                }
                c.this.dRy = false;
            }
        }
    };

    static {
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cZU = bundle.getString(ImageViewerConfig.FORUM_ID);
        } else if (getArguments() != null) {
            this.cZU = getArguments().getString(ImageViewerConfig.FORUM_ID);
        }
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new com.baidu.tbadk.browser.c(getPageContext().getPageActivity()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        initCookie();
        registerListener(2001446, this.cdm, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.cdn);
        MessageManager.getInstance().registerListener(this.dRz);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.special_frs_web_index, (ViewGroup) null);
        this.dRt = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.dRu = (FrameLayout) this.mRootView.findViewById(d.g.webview_container_layout);
        ayK();
        setNavBarVisibility(isNeedShowNavigationBar());
        aN(isNeedShowShareItem());
        gk(isNeedShowMenuItem());
        createWebView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dRu.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.dRu.setLayoutParams(layoutParams);
        if (this.clu != null && (parent = this.clu.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.clu);
        }
        this.dRu.addView(this.clu);
        return this.mRootView;
    }

    public void ayK() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNavigationBar.showBottomLine(true);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_return_bg_s, d.f.icon_return_bg);
        this.mNavigationBar.setTitleText("");
        aj.d(this.mNavigationBar.mTextTitle, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.t(getPageContext().getPageActivity(), d.e.ds24), 0);
        this.dRv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.dRv.setLayoutParams(layoutParams);
        this.dRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.c.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.a(c.this.createShareContent(null, null, null, null));
            }
        });
        aj.a(this.dRv, d.f.icon_nav_share_selector, d.f.icon_nav_share_selector);
        this.clk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.clk.setLayoutParams(layoutParams);
        this.clk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.c.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNull(c.this.cZU)) {
                    c.this.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(c.this.getPageContext().getPageActivity(), c.this.cZU, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            }
        });
        if (this.clk != null) {
            aj.a(this.clk, d.f.btn_more_selector_s, d.f.btn_more_selector);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.mNavigationBar.setVisibility(0);
        } else {
            this.mNavigationBar.setVisibility(8);
        }
    }

    public void aN(boolean z) {
        if (this.dRv != null) {
            if (z) {
                this.dRv.setVisibility(0);
            } else {
                this.dRv.setVisibility(8);
            }
        }
    }

    public void gk(boolean z) {
        if (z) {
            this.clk.setVisibility(0);
        } else {
            this.clk.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cZU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.clu != null) {
                if (this.clp) {
                    initData();
                }
                try {
                    this.clu.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callHiddenWebViewMethod("onResume");
            } else {
                return;
            }
        } else if (this.clu != null) {
            try {
                this.clu.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod("onPause");
        } else {
            return;
        }
        this.dRy = false;
    }

    private void initData() {
        if (this.mUrl != null && this.mUrl.contains("redirect=1")) {
            this.dRx = true;
        }
        loadUrl(this.mUrl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, com.baidu.tieba.frs.b.a.class);
        if (runTask != null) {
            this.dRw = (com.baidu.tieba.frs.b.a) runTask.getData();
            if (this.dRw != null) {
                this.dRw.init();
            }
        }
    }

    protected void callHiddenWebViewMethod(String str) {
        if (this.clu != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.clu, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public View createWebView() {
        if (this.clu == null) {
            this.clu = new ScrollBridgeWebview(getPageContext().getPageActivity());
            this.clu.setNeedDisAllowParentInterceptTouchEvent(true);
            this.clu.getSettings().setJavaScriptEnabled(true);
            this.clu.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.clu.getSettings().setAllowFileAccess(true);
            this.clu.getSettings().setDatabaseEnabled(true);
            this.clu.getSettings().setDomStorageEnabled(true);
            this.clu.getSettings().setSupportZoom(true);
            this.clu.getSettings().setBuiltInZoomControls(true);
            this.clu.getSettings().setUseWideViewPort(true);
            this.clu.getSettings().setLoadWithOverviewMode(true);
            this.clu.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.clu.setHorizontalScrollBarEnabled(false);
            this.clu.setHorizontalScrollbarOverlay(false);
            this.clu.setInitialScale(100);
            this.clu.setScrollBarStyle(33554432);
            this.clu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.clu.setWebViewClient(new a());
            this.clu.setDownloadListener(new b());
            com.baidu.tieba.frs.gametabs.b bVar = new com.baidu.tieba.frs.gametabs.b(getPageContext());
            bVar.setOnJsPromptCallback(this.jsCallback);
            this.clu.setWebChromeClient(bVar);
            this.clu.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.frs.gametabs.c.13
                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void l(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void m(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void onScrollChanged(int i, int i2, int i3, int i4) {
                }
            });
            CompatibleUtile.getInstance().removeJavascriptInterface(this.clu);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            m a2 = r.a(isHybridBridgeEnabled, this.clu, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new o(a2) { // from class: com.baidu.tieba.frs.gametabs.c.14
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.o
                    public String ww() {
                        return "TBHY_COMMON_Performance";
                    }

                    @p(BC = false, value = "trackFPS")
                    private void trackFPS() {
                        c.this.trackFPS();
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2) { // from class: com.baidu.tieba.frs.gametabs.c.15
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.a.c
                    @p(BC = false, value = "scanBigImages")
                    public void sanBigImages(JSONObject jSONObject) throws JSONException {
                        super.sanBigImages(jSONObject);
                        TiebaStatic.log(new ak("c12338").s(ImageViewerConfig.FORUM_ID, jSONObject.optInt(ImageViewerConfig.FORUM_ID)));
                    }
                });
                a2.a(new com.baidu.tbadk.browser.d(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.d(a2));
                a2.a(new e(a2));
                a2.a(new com.baidu.tieba.frs.gametabs.a(a2, this.cZU));
                a2.a(new o(a2) { // from class: com.baidu.tieba.frs.gametabs.c.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.o
                    public String ww() {
                        return "TBHY_COMMON_SKIN_TO_LOGIN";
                    }

                    @p(BC = false, value = "skinToLogin")
                    private void skinToLogin() {
                        if (!TbadkCoreApplication.isLogin()) {
                            ay.aZ(c.this.getPageContext().getPageActivity());
                        }
                    }
                });
                a2.a(new o(a2) { // from class: com.baidu.tieba.frs.gametabs.c.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.o
                    public String ww() {
                        return "TBHY_COMMON_GAME_COMMENT";
                    }

                    @p(BC = false, value = "gameComment")
                    private void goToGameComment(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt(WBConstants.GAME_PARAMS_SCORE);
                            int optInt2 = jSONObject.optInt("forum_id");
                            Intent intent = new Intent(c.this.getFragmentActivity(), FrsGameCommentActivity.class);
                            intent.putExtra(WBConstants.GAME_PARAMS_SCORE, optInt);
                            intent.putExtra("forum_id", optInt2);
                            c.this.startActivityForResult(intent, 1);
                        }
                    }
                });
                a2.a(new o(a2) { // from class: com.baidu.tieba.frs.gametabs.c.4
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.o
                    public String ww() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @p(BC = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && ay.ba(c.this.getPageContext().getPageActivity())) {
                            String optString = jSONObject.optString("forum_id");
                            String optString2 = jSONObject.optString("comment_id");
                            Intent intent = new Intent(c.this.getFragmentActivity(), FrsGameSubPbActivity.class);
                            intent.putExtra("arg_forum_id", Integer.valueOf(optString));
                            intent.putExtra("arg_main_tower_id", optString2);
                            c.this.startActivityForResult(intent, 1001);
                        }
                    }
                });
                a2.a(new o(a2) { // from class: com.baidu.tieba.frs.gametabs.c.5
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.o
                    public String ww() {
                        return "TBHY_COMMON_Share";
                    }

                    @p(BC = false, value = "share")
                    private void share(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString("bid");
                            if (!StringUtils.isNULL(optString5)) {
                                c.this.mShareResultToFe = true;
                                c.this.mBid = optString5;
                            }
                            final com.baidu.tbadk.coreExtra.c.d createShareContent = c.this.createShareContent(optString, optString4, optString2, optString3);
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.c.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.a(createShareContent);
                                }
                            });
                        }
                    }
                });
            }
        }
        return this.clu;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, wI())));
        }
    }

    private SparseArray<String> wI() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void loadUrl(String str) {
        if (this.clu != null) {
            CompatibleUtile.getInstance().loadUrl(this.clu, str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == 2 && this.mHybridBridge != null) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "0");
                hashMap.put("errMsg", ImagesInvalidReceiver.SUCCESS);
                n a2 = n.a("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
            }
        } else if (i == 1001) {
            if (i2 == 1002 && this.mHybridBridge != null) {
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("errNo", "0");
                hashMap2.put("errMsg", ImagesInvalidReceiver.SUCCESS);
                n a3 = n.a("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap2, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a3);
                }
            }
        } else if (i == 24007) {
            handleShareResult(intent, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.cdn);
        MessageManager.getInstance().unRegisterListener(this.dRz);
        if (this.dRw != null) {
            this.dRw.release();
            this.dRw = null;
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.jsBridge != null) {
            this.jsBridge.bxv();
        }
        if (this.clu != null) {
            this.clu.getSettings().setBuiltInZoomControls(true);
            this.clu.setVisibility(8);
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.c.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.clu != null) {
                            c.this.clu.destroy();
                            c.this.clu = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (c.this.clu != null) {
                c.this.isLoading = false;
                c.this.hideLoadingView(c.this.dRu);
                c.this.mUrl = str;
                c.this.clu.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (c.this.clp) {
                    c.this.clp = false;
                }
                c.this.setNavBarVisibility(c.this.isNeedShowNavigationBar());
                c.this.aN(c.this.isNeedShowShareItem());
                c.this.gk(c.this.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (c.this.clu != null) {
                c.this.clu.stopLoading();
                c.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (c.this.clu != null) {
                if (c.this.clp) {
                    c.this.isLoading = true;
                    c.this.showLoadingView(c.this.dRu);
                }
                c.this.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.this.clp) {
                c.this.clp = false;
                return false;
            } else if (!c.this.ma(str) || TbadkCoreApplication.isLogin() || c.this.getPageContext() == null) {
                if (!c.this.iW(str) && c.this.getPageContext() != null && c.this.clu.isShown()) {
                    if (str.startsWith("tdoudiscount:")) {
                        c.this.dRy = true;
                    }
                    if (!c.this.cs(str)) {
                        if (c.this.dRx) {
                            return aw.Du().b(c.this.getPageContext(), new String[]{str}) == 0;
                        }
                        aw.Du().a(c.this.getPageContext(), new String[]{str}, true);
                    } else {
                        return aw.Du().b(c.this.getPageContext(), new String[]{str}) == 0;
                    }
                }
                return true;
            } else {
                ay.aZ(c.this.getPageContext().getPageActivity());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ma(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iW(String str) {
        return mb(str) || md(str) || me(str) || mc(str);
    }

    private boolean mb(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gamedemo?")) {
            return false;
        }
        int parseInt = Integer.parseInt(z.ar(str, "fid="));
        int parseInt2 = Integer.parseInt(z.ar(str, "gameid="));
        String ar = z.ar(str, "gamename=");
        if (this.dRw != null) {
            this.dRw.a(getPageContext(), ar, parseInt2, parseInt);
        }
        return true;
    }

    private boolean mc(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://frsdetail?")) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), z.ar(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    private boolean md(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gameinvoke?")) {
            return false;
        }
        String ar = z.ar(str, "packagename=");
        if (!StringUtils.isNull(ar)) {
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(ar));
        }
        return true;
    }

    private boolean me(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://pb?")) {
            return false;
        }
        String ar = z.ar(str, "tid=");
        if (!StringUtils.isNull(ar)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(ar, null, PbActivityConfig.KEY_FROM_NEWS)));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements DownloadListener {
        private b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!StringUtils.isNull(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    c.this.startActivity(intent);
                }
            }
        }
    }

    public void initCookie() {
        com.baidu.tbadk.browser.b.aH(getBaseFragmentActivity().getApplicationContext());
    }

    public void onReceivedError(int i) {
        if (this.clu != null) {
            this.mUrl = this.clu.getUrl();
            this.clu.stopLoading();
        }
    }

    private com.baidu.tieba.tbadkCore.e.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        if (!sFrameLostTracked) {
            sFrameLostTracked = true;
            h.Bs().a(16, new k() { // from class: com.baidu.tieba.frs.gametabs.c.7
                @Override // com.baidu.tbadk.core.hybrid.k
                public void z(List<Long> list) {
                    if (list != null && list.size() != 0) {
                        String str = "";
                        StringBuilder sb = new StringBuilder();
                        Iterator<Long> it = list.iterator();
                        while (true) {
                            String str2 = str;
                            if (it.hasNext()) {
                                sb.append(str2);
                                sb.append(it.next());
                                str = "_";
                            } else {
                                com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.k.o.nn();
                                nn.l("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", nn);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XL() {
        if (!this.isLoading && !TextUtils.isEmpty(this.mUrl) && j.oJ()) {
            loadUrl(this.mUrl);
        }
    }

    private void handleShareResult(Intent intent, int i) {
        if (this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent != null) {
                String str = mShareToTypes.get(intent.getStringExtra("share_to"));
                HashMap hashMap = new HashMap();
                boolean z = i == -1;
                hashMap.put("bid", this.mBid);
                hashMap.put("result", Boolean.valueOf(z));
                hashMap.put("channel", str);
                n a2 = n.a("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1) {
                    this.clu.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
                }
            }
        }
    }
}
