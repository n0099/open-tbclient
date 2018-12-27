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
    private String daG;
    private d eaU;
    private NoNetworkView eaV;
    private com.baidu.tieba.frs.b.a eaW;
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
    private Pair<Integer, Integer> dKV = null;
    private ScrollBridgeWebview bZT = null;
    private boolean bRW = true;
    private boolean eaX = false;
    private boolean eaY = false;
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
    private CustomMessageListener bQx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                        SpecialFrsWebFragment.this.aaY();
                    }
                }
            }
        }
    };
    private CustomMessageListener bQy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.7
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
    private CustomMessageListener eaZ = new CustomMessageListener(2001227) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && SpecialFrsWebFragment.this.eaY) {
                if (SpecialFrsWebFragment.this.bZT != null) {
                    SpecialFrsWebFragment.this.bZT.reload();
                }
                SpecialFrsWebFragment.this.eaY = false;
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kV()) {
                SpecialFrsWebFragment.this.showToast(e.j.neterror);
                return;
            }
            SpecialFrsWebFragment.this.hideNoDataView();
            SpecialFrsWebFragment.this.bRW = true;
            SpecialFrsWebFragment.this.aaY();
        }
    };

    static {
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    public Pair<Integer, Integer> aGp() {
        return this.dKV;
    }

    public com.baidu.tbadk.coreExtra.c.d m(String str, String str2, String str3, String str4) {
        return createShareContent(str, str2, str3, str4);
    }

    public String getForumId() {
        return this.daG;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void nh(int i) {
        this.mTabId = i;
    }

    public boolean aGq() {
        return this.mTabId == 102 || this.mTabId == 103;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dKV = pair;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.daG = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.mForumName = bundle.getString(ImageViewerConfig.FORUM_NAME);
        } else if (getArguments() != null) {
            this.daG = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.mForumName = getArguments().getString(ImageViewerConfig.FORUM_NAME);
        }
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new com.baidu.tbadk.browser.b(getPageContext().getPageActivity()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        initCookie();
        registerListener(2001446, this.bQx, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.bQy);
        MessageManager.getInstance().registerListener(this.eaZ);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.special_frs_web_index, (ViewGroup) null);
        this.eaV = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        this.mWebViewContainer = (FrameLayout) this.mRootView.findViewById(e.g.webview_container_layout);
        if (this.eaU == null) {
            this.eaU = new d(getPageContext());
        }
        this.eaU.a((NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar), this);
        createWebView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.mWebViewContainer.setLayoutParams(layoutParams);
        if (this.bZT != null && (parent = this.bZT.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.bZT);
        }
        this.mWebViewContainer.addView(this.bZT);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eaU != null) {
            this.eaU.onChangeSkinType(i);
        }
        if (this.eaV != null) {
            this.eaV.onChangeSkinType(getPageContext(), i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eaU != null) {
            this.eaU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eaU == null) {
            this.eaU = new d(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.FORUM_ID, this.daG);
            bundle.putString(ImageViewerConfig.FORUM_NAME, this.mForumName);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.bZT != null) {
                if (this.bRW) {
                    initData();
                }
                try {
                    this.bZT.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callHiddenWebViewMethod("onResume");
            } else {
                return;
            }
        } else if (this.bZT != null) {
            try {
                this.bZT.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod(AudioStatusCallback.ON_PAUSE);
        } else {
            return;
        }
        this.eaY = false;
    }

    private void initData() {
        if (this.mUrl != null && this.mUrl.contains("redirect=1")) {
            this.eaX = true;
        }
        loadUrl(this.mUrl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921047, com.baidu.tieba.frs.b.a.class);
        if (runTask != null) {
            this.eaW = (com.baidu.tieba.frs.b.a) runTask.getData();
            if (this.eaW != null) {
                this.eaW.init();
            }
        }
    }

    protected void callHiddenWebViewMethod(String str) {
        if (this.bZT != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.bZT, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public View createWebView() {
        if (this.bZT == null) {
            this.bZT = new ScrollBridgeWebview(getPageContext().getPageActivity());
            this.bZT.setNeedDisAllowParentInterceptTouchEvent(true);
            this.bZT.getSettings().setJavaScriptEnabled(true);
            this.bZT.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.bZT.getSettings().setAllowFileAccess(true);
            this.bZT.getSettings().setDatabaseEnabled(true);
            this.bZT.getSettings().setDomStorageEnabled(true);
            this.bZT.getSettings().setSupportZoom(true);
            this.bZT.getSettings().setBuiltInZoomControls(true);
            this.bZT.getSettings().setUseWideViewPort(true);
            this.bZT.getSettings().setLoadWithOverviewMode(true);
            this.bZT.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.bZT.setHorizontalScrollBarEnabled(false);
            this.bZT.setHorizontalScrollbarOverlay(false);
            this.bZT.setInitialScale(100);
            this.bZT.setScrollBarStyle(33554432);
            this.bZT.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.bZT.setWebViewClient(new a());
            this.bZT.setDownloadListener(new b());
            com.baidu.tieba.frs.gametabs.b bVar = new com.baidu.tieba.frs.gametabs.b(getPageContext());
            bVar.setOnJsPromptCallback(this.jsCallback);
            this.bZT.setWebChromeClient(bVar);
            this.bZT.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.9
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
            CompatibleUtile.getInstance().removeJavascriptInterface(this.bZT);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.bZT, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(Cm = false, value = "trackFPS")
                    private void trackFPS() {
                        SpecialFrsWebFragment.this.trackFPS();
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.a.c
                    @o(Cm = false, value = "scanBigImages")
                    public void sanBigImages(JSONObject jSONObject) throws JSONException {
                        super.sanBigImages(jSONObject);
                        TiebaStatic.log(new am("c12338").x(ImageViewerConfig.FORUM_ID, jSONObject.optInt(ImageViewerConfig.FORUM_ID)));
                    }
                });
                a2.a(new com.baidu.tbadk.browser.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.d(a2));
                a2.a(new e(a2));
                a2.a(new com.baidu.tieba.frs.gametabs.a(a2, this.daG));
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_SKIN_TO_LOGIN";
                    }

                    @o(Cm = false, value = "skinToLogin")
                    private void skinToLogin() {
                        if (!TbadkCoreApplication.isLogin()) {
                            ba.bI(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.13
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(Cm = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && ba.bJ(SpecialFrsWebFragment.this.getPageContext().getPageActivity())) {
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
                    public String wQ() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(Cm = false, value = "share")
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
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.2.1
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
        return this.bZT;
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) getPageContext().getPageActivity(), dVar, true, xb())));
        }
    }

    private SparseArray<String> xb() {
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
        if (this.bZT != null) {
            CompatibleUtile.getInstance().loadUrl(this.bZT, str);
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
        MessageManager.getInstance().unRegisterListener(this.bQy);
        MessageManager.getInstance().unRegisterListener(this.eaZ);
        if (this.eaW != null) {
            this.eaW.release();
            this.eaW = null;
        }
        if (this.eaU != null) {
            this.eaU.onDestroy();
        }
        if (this.jsBridge != null) {
            this.jsBridge.bEK();
        }
        if (this.bZT != null) {
            this.bZT.getSettings().setBuiltInZoomControls(true);
            this.bZT.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SpecialFrsWebFragment.this.bZT != null) {
                            SpecialFrsWebFragment.this.bZT.destroy();
                            SpecialFrsWebFragment.this.bZT = null;
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
            if (SpecialFrsWebFragment.this.bZT != null) {
                SpecialFrsWebFragment.this.isLoading = false;
                SpecialFrsWebFragment.this.hideLoadingView(SpecialFrsWebFragment.this.mWebViewContainer);
                SpecialFrsWebFragment.this.mUrl = str;
                SpecialFrsWebFragment.this.bZT.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (SpecialFrsWebFragment.this.bRW) {
                    SpecialFrsWebFragment.this.bRW = false;
                }
                String title = SpecialFrsWebFragment.this.bZT.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    SpecialFrsWebFragment.this.dF(title);
                }
                SpecialFrsWebFragment.this.eaU.setNavBarVisibility(SpecialFrsWebFragment.this.isNeedShowNavigationBar());
                SpecialFrsWebFragment.this.eaU.aR(SpecialFrsWebFragment.this.isNeedShowShareItem());
                SpecialFrsWebFragment.this.eaU.hk(SpecialFrsWebFragment.this.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (SpecialFrsWebFragment.this.bZT != null) {
                SpecialFrsWebFragment.this.bZT.stopLoading();
                SpecialFrsWebFragment.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SpecialFrsWebFragment.this.bZT != null) {
                if (SpecialFrsWebFragment.this.bRW) {
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
            if (SpecialFrsWebFragment.this.bRW) {
                SpecialFrsWebFragment.this.bRW = false;
                return false;
            } else if (!SpecialFrsWebFragment.this.aGq() || SpecialFrsWebFragment.this.getPageContext() == null) {
                if (!SpecialFrsWebFragment.this.oy(str) || TbadkCoreApplication.isLogin() || SpecialFrsWebFragment.this.getPageContext() == null) {
                    if (!SpecialFrsWebFragment.this.lh(str) && SpecialFrsWebFragment.this.getPageContext() != null && SpecialFrsWebFragment.this.bZT.isShown()) {
                        if (str.startsWith("tdoudiscount:")) {
                            SpecialFrsWebFragment.this.eaY = true;
                        }
                        if (!SpecialFrsWebFragment.this.dG(str)) {
                            if (SpecialFrsWebFragment.this.eaX) {
                                return ay.Ef().b(SpecialFrsWebFragment.this.getPageContext(), new String[]{str}) == 0;
                            }
                            ay.Ef().a((TbPageContext<?>) SpecialFrsWebFragment.this.getPageContext(), new String[]{str}, true);
                        } else {
                            int b = ay.Ef().b(SpecialFrsWebFragment.this.getPageContext(), new String[]{str});
                            return b == 0 || b == 1;
                        }
                    }
                    return true;
                }
                ba.bI(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                return false;
            } else {
                com.baidu.tbadk.browser.a.ae(SpecialFrsWebFragment.this.getPageContext().getPageActivity(), str);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oy(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lh(String str) {
        return oz(str) || oB(str) || oC(str) || oA(str);
    }

    private boolean oz(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gamedemo?")) {
            return false;
        }
        int parseInt = Integer.parseInt(ab.aO(str, "fid="));
        int parseInt2 = Integer.parseInt(ab.aO(str, "gameid="));
        String aO = ab.aO(str, "gamename=");
        if (this.eaW != null) {
            this.eaW.a(getPageContext(), aO, parseInt2, parseInt);
        }
        return true;
    }

    private boolean oA(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://frsdetail?")) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(getFragmentActivity(), ab.aO(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    private boolean oB(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://gameinvoke?")) {
            return false;
        }
        String aO = ab.aO(str, "packagename=");
        if (!StringUtils.isNull(aO)) {
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(aO));
        }
        return true;
    }

    private boolean oC(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("tieba://pb?")) {
            return false;
        }
        String aO = ab.aO(str, "tid=");
        if (!StringUtils.isNull(aO)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getFragmentActivity()).createNormalCfg(aO, null, PbActivityConfig.KEY_FROM_NEWS)));
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
        com.baidu.tbadk.browser.a.br(getBaseFragmentActivity().getApplicationContext());
    }

    public void onReceivedError(int i) {
        if (this.bZT != null) {
            this.mUrl = this.bZT.getUrl();
            this.bZT.stopLoading();
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
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aD(null, getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getPageContext().getResources().getString(e.j.refresh), this.mOnRefreshClickListener)));
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
            g.Cc().a(16, new com.baidu.tbadk.core.hybrid.j() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.5
                @Override // com.baidu.tbadk.core.hybrid.j
                public void F(List<Long> list) {
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
                                com.baidu.adp.lib.stats.a jB = com.baidu.tbadk.l.l.jB();
                                jB.c("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", jB);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar abW() {
        if (this.eaU != null) {
            return this.eaU.abW();
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
    public void aaY() {
        if (!this.isLoading && !TextUtils.isEmpty(this.mUrl) && j.kV()) {
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
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && this.bZT != null) {
                    this.bZT.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (aGq() && z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
        }
    }
}
