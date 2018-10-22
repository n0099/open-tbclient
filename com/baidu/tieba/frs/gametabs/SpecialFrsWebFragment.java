package com.baidu.tieba.frs.gametabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
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
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements NavigationBar.a, ak {
    private String cQb;
    private com.baidu.tieba.frs.b.a dQA;
    private d dQy;
    private NoNetworkView dQz;
    private boolean isLoading;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private String mForumName;
    private l mHybridBridge;
    private NoDataView mNoDataView;
    private View mRootView;
    private int mTabId;
    private FrameLayout mWebViewContainer;
    private static boolean sFrameLostTracked = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    private Pair<Integer, Integer> dAr = null;
    private ScrollBridgeWebview bVk = null;
    private boolean bNr = true;
    private boolean dQB = false;
    private boolean dQC = false;
    protected boolean mShareResultToFe = false;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (SpecialFrsWebFragment.this.jsBridge != null) {
                return SpecialFrsWebFragment.this.jsBridge.b(str, jsPromptResult);
            }
            return false;
        }
    };
    private CustomMessageListener bLT = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                        SpecialFrsWebFragment.this.ZG();
                    }
                }
            }
        }
    };
    private CustomMessageListener bLU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(SpecialFrsWebFragment.this.mUrl)) {
                SpecialFrsWebFragment.this.isLoading = true;
                SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.mWebViewContainer);
                SpecialFrsWebFragment.this.loadUrl(SpecialFrsWebFragment.this.mUrl);
            }
        }
    };
    private CustomMessageListener dQD = new CustomMessageListener(2001227) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && SpecialFrsWebFragment.this.dQC) {
                if (SpecialFrsWebFragment.this.bVk != null) {
                    SpecialFrsWebFragment.this.bVk.reload();
                }
                SpecialFrsWebFragment.this.dQC = false;
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kX()) {
                SpecialFrsWebFragment.this.showToast(e.j.neterror);
                return;
            }
            SpecialFrsWebFragment.this.hideNoDataView();
            SpecialFrsWebFragment.this.bNr = true;
            SpecialFrsWebFragment.this.ZG();
        }
    };

    static {
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    public Pair<Integer, Integer> aEt() {
        return this.dAr;
    }

    public com.baidu.tbadk.coreExtra.c.d m(String str, String str2, String str3, String str4) {
        return createShareContent(str, str2, str3, str4);
    }

    public String getForumId() {
        return this.cQb;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void mn(int i) {
        this.mTabId = i;
    }

    public boolean aEu() {
        return this.mTabId == 102 || this.mTabId == 103;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dAr = pair;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cQb = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME);
        } else if (getArguments() != null) {
            this.cQb = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.mForumName = getArguments().getString(ImageViewerConfig.FORUM_NAME);
        }
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new com.baidu.tbadk.browser.b(getPageContext().getPageActivity()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        initCookie();
        registerListener(2001446, this.bLT, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.bLU);
        MessageManager.getInstance().registerListener(this.dQD);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.special_frs_web_index, (ViewGroup) null);
        this.dQz = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        this.mWebViewContainer = (FrameLayout) this.mRootView.findViewById(e.g.webview_container_layout);
        if (this.dQy == null) {
            this.dQy = new d(getPageContext());
        }
        this.dQy.a((NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar), this);
        createWebView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.mWebViewContainer.setLayoutParams(layoutParams);
        if (this.bVk != null && (parent = this.bVk.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.bVk);
        }
        this.mWebViewContainer.addView(this.bVk);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dQy != null) {
            this.dQy.onChangeSkinType(i);
        }
        if (this.dQz != null) {
            this.dQz.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dQy != null) {
            this.dQy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.dQy == null) {
            this.dQy = new d(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.FORUM_ID, this.cQb);
            bundle.putString(ImageViewerConfig.FORUM_NAME, this.mForumName);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.bVk != null) {
                if (this.bNr) {
                    initData();
                }
                try {
                    this.bVk.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callHiddenWebViewMethod("onResume");
            } else {
                return;
            }
        } else if (this.bVk != null) {
            try {
                this.bVk.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod(AudioStatusCallback.ON_PAUSE);
        } else {
            return;
        }
        this.dQC = false;
    }

    private void initData() {
        if (this.mUrl != null && this.mUrl.contains("redirect=1")) {
            this.dQB = true;
        }
        loadUrl(this.mUrl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, com.baidu.tieba.frs.b.a.class);
        if (runTask != null) {
            this.dQA = (com.baidu.tieba.frs.b.a) runTask.getData();
            if (this.dQA != null) {
                this.dQA.init();
            }
        }
    }

    protected void callHiddenWebViewMethod(String str) {
        if (this.bVk != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.bVk, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public View createWebView() {
        if (this.bVk == null) {
            this.bVk = new ScrollBridgeWebview(getPageContext().getPageActivity());
            this.bVk.setNeedDisAllowParentInterceptTouchEvent(true);
            this.bVk.getSettings().setJavaScriptEnabled(true);
            this.bVk.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.bVk.getSettings().setAllowFileAccess(true);
            this.bVk.getSettings().setDatabaseEnabled(true);
            this.bVk.getSettings().setDomStorageEnabled(true);
            this.bVk.getSettings().setSupportZoom(true);
            this.bVk.getSettings().setBuiltInZoomControls(true);
            this.bVk.getSettings().setUseWideViewPort(true);
            this.bVk.getSettings().setLoadWithOverviewMode(true);
            this.bVk.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.bVk.setHorizontalScrollBarEnabled(false);
            this.bVk.setHorizontalScrollbarOverlay(false);
            this.bVk.setInitialScale(100);
            this.bVk.setScrollBarStyle(33554432);
            this.bVk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.bVk.setWebViewClient(new a());
            this.bVk.setDownloadListener(new b());
            com.baidu.tieba.frs.gametabs.b bVar = new com.baidu.tieba.frs.gametabs.b(getPageContext());
            bVar.setOnJsPromptCallback(this.jsCallback);
            this.bVk.setWebChromeClient(bVar);
            this.bVk.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.9
                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void e(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void f(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void onScrollChanged(int i, int i2, int i3, int i4) {
                }
            });
            CompatibleUtile.getInstance().removeJavascriptInterface(this.bVk);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.bVk, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String vC() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(Bb = false, value = "trackFPS")
                    private void trackFPS() {
                        SpecialFrsWebFragment.this.trackFPS();
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.a.c
                    @o(Bb = false, value = "scanBigImages")
                    public void sanBigImages(JSONObject jSONObject) throws JSONException {
                        super.sanBigImages(jSONObject);
                        TiebaStatic.log(new am("c12338").x(ImageViewerConfig.FORUM_ID, jSONObject.optInt(ImageViewerConfig.FORUM_ID)));
                    }
                });
                a2.a(new com.baidu.tbadk.browser.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.d(a2));
                a2.a(new e(a2));
                a2.a(new com.baidu.tieba.frs.gametabs.a(a2, this.cQb));
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String vC() {
                        return "TBHY_COMMON_SKIN_TO_LOGIN";
                    }

                    @o(Bb = false, value = "skinToLogin")
                    private void skinToLogin() {
                        if (!TbadkCoreApplication.isLogin()) {
                            ba.bH(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.13
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String vC() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(Bb = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && ba.bI(SpecialFrsWebFragment.this.getPageContext().getPageActivity())) {
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
                    public String vC() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(Bb = false, value = "share")
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
                            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.2.1
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
        return this.bVk;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, vP())));
        }
    }

    private SparseArray<String> vP() {
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
        if (this.bVk != null) {
            CompatibleUtile.getInstance().loadUrl(this.bVk, str);
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
        MessageManager.getInstance().unRegisterListener(this.bLU);
        MessageManager.getInstance().unRegisterListener(this.dQD);
        if (this.dQA != null) {
            this.dQA.release();
            this.dQA = null;
        }
        if (this.dQy != null) {
            this.dQy.onDestroy();
        }
        if (this.jsBridge != null) {
            this.jsBridge.bCC();
        }
        if (this.bVk != null) {
            this.bVk.getSettings().setBuiltInZoomControls(true);
            this.bVk.setVisibility(8);
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SpecialFrsWebFragment.this.bVk != null) {
                            SpecialFrsWebFragment.this.bVk.destroy();
                            SpecialFrsWebFragment.this.bVk = null;
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
            if (SpecialFrsWebFragment.this.bVk != null) {
                SpecialFrsWebFragment.this.isLoading = false;
                SpecialFrsWebFragment.this.hideLoadingView(SpecialFrsWebFragment.this.mWebViewContainer);
                SpecialFrsWebFragment.this.mUrl = str;
                SpecialFrsWebFragment.this.bVk.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (SpecialFrsWebFragment.this.bNr) {
                    SpecialFrsWebFragment.this.bNr = false;
                }
                SpecialFrsWebFragment.this.dQy.setNavBarVisibility(SpecialFrsWebFragment.this.isNeedShowNavigationBar());
                SpecialFrsWebFragment.this.dQy.aA(SpecialFrsWebFragment.this.isNeedShowShareItem());
                SpecialFrsWebFragment.this.dQy.gW(SpecialFrsWebFragment.this.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (SpecialFrsWebFragment.this.bVk != null) {
                SpecialFrsWebFragment.this.bVk.stopLoading();
                SpecialFrsWebFragment.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SpecialFrsWebFragment.this.bVk != null) {
                if (SpecialFrsWebFragment.this.bNr) {
                    SpecialFrsWebFragment.this.isLoading = true;
                    SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.mWebViewContainer);
                }
                SpecialFrsWebFragment.this.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (SpecialFrsWebFragment.this.bNr) {
                SpecialFrsWebFragment.this.bNr = false;
                return false;
            } else if (!SpecialFrsWebFragment.this.aEu() || SpecialFrsWebFragment.this.getPageContext() == null) {
                if (!SpecialFrsWebFragment.this.nT(str) || TbadkCoreApplication.isLogin() || SpecialFrsWebFragment.this.getPageContext() == null) {
                    if (!SpecialFrsWebFragment.this.kK(str) && SpecialFrsWebFragment.this.getPageContext() != null && SpecialFrsWebFragment.this.bVk.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            SpecialFrsWebFragment.this.dQC = true;
                        }
                        if (!SpecialFrsWebFragment.this.dq(str)) {
                            if (SpecialFrsWebFragment.this.dQB) {
                                return ay.CU().b(SpecialFrsWebFragment.this.getPageContext(), new String[]{str}) == 0;
                            }
                            ay.CU().a((TbPageContext<?>) SpecialFrsWebFragment.this.getPageContext(), new String[]{str}, true);
                        } else {
                            int b = ay.CU().b(SpecialFrsWebFragment.this.getPageContext(), new String[]{str});
                            return b == 0 || b == 1;
                        }
                    }
                    return true;
                }
                ba.bH(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                return false;
            } else {
                com.baidu.tbadk.browser.a.af(SpecialFrsWebFragment.this.getPageContext().getPageActivity(), str);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nT(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kK(String str) {
        return nU(str) || nW(str) || nX(str) || nV(str);
    }

    private boolean nU(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gamedemo?")) {
            return false;
        }
        int parseInt = Integer.parseInt(ab.aL(str, "fid="));
        int parseInt2 = Integer.parseInt(ab.aL(str, "gameid="));
        String aL = ab.aL(str, "gamename=");
        if (this.dQA != null) {
            this.dQA.a(getPageContext(), aL, parseInt2, parseInt);
        }
        return true;
    }

    private boolean nV(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://frsdetail?")) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), ab.aL(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    private boolean nW(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gameinvoke?")) {
            return false;
        }
        String aL = ab.aL(str, "packagename=");
        if (!StringUtils.isNull(aL)) {
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(aL));
        }
        return true;
    }

    private boolean nX(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://pb?")) {
            return false;
        }
        String aL = ab.aL(str, "tid=");
        if (!StringUtils.isNull(aL)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(aL, null, PbActivityConfig.KEY_FROM_NEWS)));
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
                    SpecialFrsWebFragment.this.startActivity(intent);
                }
            }
        }
    }

    public void initCookie() {
        com.baidu.tbadk.browser.a.bq(getBaseFragmentActivity().getApplicationContext());
    }

    public void onReceivedError(int i) {
        if (this.bVk != null) {
            this.mUrl = this.bVk.getUrl();
            this.bVk.stopLoading();
        }
        showNoDataView();
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mWebViewContainer.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (getPageContext() != null) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aA(null, getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getResources().getString(e.j.refresh), this.mOnRefreshClickListener)));
            }
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mWebViewContainer.setVisibility(8);
            this.mNoDataView.setVisibility(0);
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
            g.AR().a(16, new com.baidu.tbadk.core.hybrid.j() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.5
                @Override // com.baidu.tbadk.core.hybrid.j
                public void G(List<Long> list) {
                    if (list != null && list.size() != 0) {
                        String str = "";
                        StringBuilder sb = new StringBuilder();
                        Iterator<Long> it = list.iterator();
                        while (true) {
                            String str2 = str;
                            if (it.hasNext()) {
                                sb.append(str2);
                                sb.append(it.next());
                                str = BaseRequestAction.SPLITE;
                            } else {
                                com.baidu.adp.lib.stats.a jD = com.baidu.tbadk.l.l.jD();
                                jD.c("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", jD);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaE() {
        if (this.dQy != null) {
            return this.dQy.aaE();
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
    public void ZG() {
        if (!this.isLoading && !TextUtils.isEmpty(this.mUrl) && j.kX()) {
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
                m a2 = m.a("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && this.bVk != null) {
                    this.bVk.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (aEu() && z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
        }
    }
}
