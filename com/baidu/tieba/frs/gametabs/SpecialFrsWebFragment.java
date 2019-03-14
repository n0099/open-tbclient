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
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.hybrid.g;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements ah {
    private FrameLayout aqr;
    private String ela;
    private d fpf;
    private NoNetworkView fpg;
    private FrameLayout fph;
    private com.baidu.tieba.frs.b.a fpi;
    private boolean isLoading;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private String mForumName;
    private l mHybridBridge;
    private View mRootView;
    private int mTabId;
    private static boolean sFrameLostTracked = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    private ScrollBridgeWebview dpD = null;
    private boolean ddc = true;
    private boolean fpj = false;
    private boolean fpk = false;
    protected boolean mShareResultToFe = false;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (SpecialFrsWebFragment.this.jsBridge != null) {
                return SpecialFrsWebFragment.this.jsBridge.a(str, jsPromptResult);
            }
            return false;
        }
    };
    private CustomMessageListener dgw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                        SpecialFrsWebFragment.this.aCt();
                    }
                }
            }
        }
    };
    private CustomMessageListener dgx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(SpecialFrsWebFragment.this.mUrl)) {
                SpecialFrsWebFragment.this.isLoading = true;
                SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.aqr);
                SpecialFrsWebFragment.this.loadUrl(SpecialFrsWebFragment.this.mUrl);
            }
        }
    };
    private CustomMessageListener fpl = new CustomMessageListener(2001227) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && SpecialFrsWebFragment.this.fpk) {
                if (SpecialFrsWebFragment.this.dpD != null) {
                    SpecialFrsWebFragment.this.dpD.reload();
                }
                SpecialFrsWebFragment.this.fpk = false;
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.kY()) {
                SpecialFrsWebFragment.this.hideNetRefreshView(SpecialFrsWebFragment.this.fph);
                SpecialFrsWebFragment.this.aqr.setVisibility(0);
                SpecialFrsWebFragment.this.fph.setVisibility(8);
                SpecialFrsWebFragment.this.ddc = true;
                SpecialFrsWebFragment.this.aCt();
                return;
            }
            SpecialFrsWebFragment.this.showToast(d.j.neterror);
        }
    };

    static {
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    public com.baidu.tbadk.coreExtra.c.d q(String str, String str2, String str3, String str4) {
        return createShareContent(str, str2, str3, str4);
    }

    public String getForumId() {
        return this.ela;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void qW(int i) {
        this.mTabId = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.ela = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME);
        } else if (getArguments() != null) {
            this.ela = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.mForumName = getArguments().getString(ImageViewerConfig.FORUM_NAME);
        }
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new com.baidu.tbadk.browser.b(getPageContext().getPageActivity()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        initCookie();
        registerListener(2001446, this.dgw, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.dgx);
        MessageManager.getInstance().registerListener(this.fpl);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.special_frs_web_index, (ViewGroup) null);
        this.fpg = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        this.aqr = (FrameLayout) this.mRootView.findViewById(d.g.webview_container_layout);
        this.fph = (FrameLayout) this.mRootView.findViewById(d.g.no_data_container);
        if (this.fpf == null) {
            this.fpf = new d(getPageContext());
        }
        this.fpf.a((NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar), this);
        createWebView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aqr.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aqr.setLayoutParams(layoutParams);
        if (this.dpD != null && (parent = this.dpD.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.dpD);
        }
        this.aqr.addView(this.dpD);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fpf != null) {
            this.fpf.onChangeSkinType(i);
        }
        if (this.fpg != null) {
            this.fpg.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fpf != null) {
            this.fpf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fpf == null) {
            this.fpf = new d(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.FORUM_ID, this.ela);
            bundle.putString(ImageViewerConfig.FORUM_NAME, this.mForumName);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dpD != null) {
                if (this.ddc) {
                    initData();
                }
                try {
                    this.dpD.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callHiddenWebViewMethod("onResume");
            } else {
                return;
            }
        } else if (this.dpD != null) {
            try {
                this.dpD.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod("onPause");
        } else {
            return;
        }
        this.fpk = false;
    }

    private void initData() {
        if (this.mUrl != null && this.mUrl.contains("redirect=1")) {
            this.fpj = true;
        }
        loadUrl(this.mUrl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, com.baidu.tieba.frs.b.a.class);
        if (runTask != null) {
            this.fpi = (com.baidu.tieba.frs.b.a) runTask.getData();
            if (this.fpi != null) {
                this.fpi.init();
            }
        }
    }

    protected void callHiddenWebViewMethod(String str) {
        if (this.dpD != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.dpD, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public View createWebView() {
        if (this.dpD == null) {
            this.dpD = new ScrollBridgeWebview(getPageContext().getPageActivity());
            this.dpD.setNeedDisAllowParentInterceptTouchEvent(true);
            this.dpD.getSettings().setJavaScriptEnabled(true);
            this.dpD.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.dpD.getSettings().setAllowFileAccess(true);
            this.dpD.getSettings().setDatabaseEnabled(true);
            this.dpD.getSettings().setDomStorageEnabled(true);
            this.dpD.getSettings().setSupportZoom(true);
            this.dpD.getSettings().setBuiltInZoomControls(true);
            this.dpD.getSettings().setUseWideViewPort(true);
            this.dpD.getSettings().setLoadWithOverviewMode(true);
            this.dpD.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.dpD.setHorizontalScrollBarEnabled(false);
            this.dpD.setHorizontalScrollbarOverlay(false);
            this.dpD.setInitialScale(100);
            this.dpD.setScrollBarStyle(33554432);
            this.dpD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.dpD.setWebViewClient(new a());
            this.dpD.setDownloadListener(new b());
            com.baidu.tieba.frs.gametabs.b bVar = new com.baidu.tieba.frs.gametabs.b(getPageContext());
            bVar.setOnJsPromptCallback(this.jsCallback);
            this.dpD.setWebChromeClient(bVar);
            this.dpD.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.9
                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void h(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void i(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void onScrollChanged(int i, int i2, int i3, int i4) {
                }
            });
            CompatibleUtile.getInstance().removeJavascriptInterface(this.dpD);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.dpD, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String VJ() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(abJ = false, value = "trackFPS")
                    private void trackFPS() {
                        SpecialFrsWebFragment.this.trackFPS();
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.a.c
                    @o(abJ = false, value = "scanBigImages")
                    public void sanBigImages(JSONObject jSONObject) throws JSONException {
                        super.sanBigImages(jSONObject);
                        TiebaStatic.log(new am("c12338").T(ImageViewerConfig.FORUM_ID, jSONObject.optInt(ImageViewerConfig.FORUM_ID)));
                    }
                });
                a2.a(new com.baidu.tbadk.browser.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.d(a2));
                a2.a(new e(a2));
                a2.a(new com.baidu.tieba.frs.gametabs.a(a2, this.ela));
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String VJ() {
                        return "TBHY_COMMON_SKIN_TO_LOGIN";
                    }

                    @o(abJ = false, value = "skinToLogin")
                    private void skinToLogin() {
                        if (!TbadkCoreApplication.isLogin()) {
                            bc.cY(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.13
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String VJ() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(abJ = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && bc.cZ(SpecialFrsWebFragment.this.getPageContext().getPageActivity())) {
                            String optString = jSONObject.optString("forum_id");
                            String optString2 = jSONObject.optString("comment_id");
                            Intent intent = new Intent(SpecialFrsWebFragment.this.getFragmentActivity(), FrsGameSubPbActivity.class);
                            intent.putExtra(FrsGameSubPbActivityConfig.ARG_FORUM_ID, Integer.valueOf(optString));
                            intent.putExtra(FrsGameSubPbActivityConfig.ARG_MAIN_TOWER_ID, optString2);
                            SpecialFrsWebFragment.this.startActivityForResult(intent, 1001);
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String VJ() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(abJ = false, value = TbConfig.TMP_SHARE_DIR_NAME)
                    private void share(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString("bid");
                            if (!StringUtils.isNULL(optString5)) {
                                SpecialFrsWebFragment.this.mShareResultToFe = true;
                                SpecialFrsWebFragment.this.mBid = optString5;
                            }
                            final com.baidu.tbadk.coreExtra.c.d createShareContent = SpecialFrsWebFragment.this.createShareContent(optString, optString4, optString2, optString3);
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SpecialFrsWebFragment.this.a(createShareContent);
                                }
                            });
                        }
                    }
                });
            }
        }
        return this.dpD;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, VV())));
        }
    }

    private SparseArray<String> VV() {
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
        if (this.dpD != null) {
            CompatibleUtile.getInstance().loadUrl(this.dpD, str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001) {
            if (i2 == 1002 && this.mHybridBridge != null) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "0");
                hashMap.put("errMsg", "success");
                m a2 = m.a("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
            }
        } else if (i == 24007) {
            handleShareResult(intent, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.dgx);
        MessageManager.getInstance().unRegisterListener(this.fpl);
        if (this.fpi != null) {
            this.fpi.release();
            this.fpi = null;
        }
        if (this.fpf != null) {
            this.fpf.onDestroy();
        }
        if (this.jsBridge != null) {
            this.jsBridge.ceV();
        }
        if (this.dpD != null) {
            this.dpD.getSettings().setBuiltInZoomControls(true);
            this.dpD.setVisibility(8);
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SpecialFrsWebFragment.this.dpD != null) {
                            SpecialFrsWebFragment.this.dpD.destroy();
                            SpecialFrsWebFragment.this.dpD = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (SpecialFrsWebFragment.this.dpD != null) {
                SpecialFrsWebFragment.this.isLoading = false;
                SpecialFrsWebFragment.this.hideLoadingView(SpecialFrsWebFragment.this.aqr);
                SpecialFrsWebFragment.this.mUrl = str;
                SpecialFrsWebFragment.this.dpD.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (SpecialFrsWebFragment.this.ddc) {
                    SpecialFrsWebFragment.this.ddc = false;
                }
                String title = SpecialFrsWebFragment.this.dpD.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    SpecialFrsWebFragment.this.kq(title);
                }
                SpecialFrsWebFragment.this.fpf.setNavBarVisibility(SpecialFrsWebFragment.this.isNeedShowNavigationBar());
                SpecialFrsWebFragment.this.fpf.db(SpecialFrsWebFragment.this.isNeedShowShareItem());
                SpecialFrsWebFragment.this.fpf.jI(SpecialFrsWebFragment.this.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (SpecialFrsWebFragment.this.dpD != null) {
                SpecialFrsWebFragment.this.dpD.stopLoading();
                SpecialFrsWebFragment.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SpecialFrsWebFragment.this.dpD != null) {
                if (SpecialFrsWebFragment.this.ddc) {
                    SpecialFrsWebFragment.this.isLoading = true;
                    SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.aqr);
                }
                SpecialFrsWebFragment.this.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (SpecialFrsWebFragment.this.ddc) {
                SpecialFrsWebFragment.this.ddc = false;
                return false;
            } else if (!SpecialFrsWebFragment.this.vr(str) || TbadkCoreApplication.isLogin() || SpecialFrsWebFragment.this.getPageContext() == null) {
                if (!SpecialFrsWebFragment.this.sf(str) && SpecialFrsWebFragment.this.getPageContext() != null && SpecialFrsWebFragment.this.dpD.isShown()) {
                    if (str.startsWith("tdoudiscount:")) {
                        SpecialFrsWebFragment.this.fpk = true;
                    }
                    if (!SpecialFrsWebFragment.this.kr(str)) {
                        if (SpecialFrsWebFragment.this.fpj) {
                            return ba.adD().b(SpecialFrsWebFragment.this.getPageContext(), new String[]{str}) == 0;
                        }
                        ba.adD().a((TbPageContext<?>) SpecialFrsWebFragment.this.getPageContext(), new String[]{str}, true);
                    } else {
                        int b = ba.adD().b(SpecialFrsWebFragment.this.getPageContext(), new String[]{str});
                        return b == 0 || b == 1;
                    }
                }
                return true;
            } else {
                bc.cY(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vr(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sf(String str) {
        return vs(str) || vu(str) || vv(str) || vt(str);
    }

    private boolean vs(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gamedemo?")) {
            return false;
        }
        int parseInt = Integer.parseInt(ae.bU(str, "fid="));
        int parseInt2 = Integer.parseInt(ae.bU(str, "gameid="));
        String bU = ae.bU(str, "gamename=");
        if (this.fpi != null) {
            this.fpi.a(getPageContext(), bU, parseInt2, parseInt);
        }
        return true;
    }

    private boolean vt(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://frsdetail?")) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), ae.bU(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    private boolean vu(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gameinvoke?")) {
            return false;
        }
        String bU = ae.bU(str, "packagename=");
        if (!StringUtils.isNull(bU)) {
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(bU));
        }
        return true;
    }

    private boolean vv(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://pb?")) {
            return false;
        }
        String bU = ae.bU(str, "tid=");
        if (!StringUtils.isNull(bU)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(bU, null, PbActivityConfig.KEY_FROM_NEWS)));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements DownloadListener {
        private b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!StringUtils.isNull(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    SpecialFrsWebFragment.this.startActivity(intent);
                }
            }
        }
    }

    public void initCookie() {
        com.baidu.tbadk.browser.a.cF(getBaseFragmentActivity().getApplicationContext());
    }

    public void onReceivedError(int i) {
        if (this.dpD != null) {
            this.mUrl = this.dpD.getUrl();
            this.dpD.stopLoading();
        }
        this.aqr.setVisibility(8);
        this.fph.setVisibility(0);
        if (getPageContext() != null) {
            showNetRefreshView(this.fph, getPageContext().getString(d.j.url_not_found), null, getPageContext().getString(d.j.refresh), false, this.mOnRefreshClickListener);
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
            g.abz().a(16, new com.baidu.tbadk.core.hybrid.j() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.5
                @Override // com.baidu.tbadk.core.hybrid.j
                public void Q(List<Long> list) {
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
                                com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.o.l.jC();
                                jC.c("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", jC);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDp() {
        if (this.fpf != null) {
            return this.fpf.aDp();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.mTabId == 102) {
            return "a055";
        }
        if (this.mTabId == 103) {
            return "a056";
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        return super.getCurrentPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        if (!this.isLoading && !TextUtils.isEmpty(this.mUrl) && j.kY()) {
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
                hashMap.put(LogBuilder.KEY_CHANNEL, str);
                m a2 = m.a("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && this.dpD != null) {
                    this.dpD.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }
}
