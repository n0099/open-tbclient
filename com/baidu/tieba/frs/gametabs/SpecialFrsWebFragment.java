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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewFragment;
import com.baidu.tbadk.browser.XiubaTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements ai {
    private static boolean dUF = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    private FrameLayout bjC;
    private String fKa;
    private d gCT;
    private NoNetworkView gCU;
    private FrameLayout gCV;
    private com.baidu.tieba.frs.b.a gCW;
    private boolean isLoading;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private String mForumName;
    private l mHybridBridge;
    private View mRootView;
    private int mTabId;
    private ScrollBridgeWebview ezq = null;
    private boolean ejJ = true;
    private boolean gCX = false;
    private boolean mIsPaying = false;
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
    private CustomMessageListener emK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                        SpecialFrsWebFragment.this.baZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && !StringUtils.isNull(SpecialFrsWebFragment.this.mUrl)) {
                SpecialFrsWebFragment.this.isLoading = true;
                SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.bjC);
                SpecialFrsWebFragment.this.loadUrl(SpecialFrsWebFragment.this.mUrl);
            }
        }
    };
    private CustomMessageListener gCY = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && SpecialFrsWebFragment.this.mIsPaying) {
                if (SpecialFrsWebFragment.this.ezq != null) {
                    SpecialFrsWebFragment.this.ezq.reload();
                }
                SpecialFrsWebFragment.this.mIsPaying = false;
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                SpecialFrsWebFragment.this.hideNetRefreshView(SpecialFrsWebFragment.this.gCV);
                SpecialFrsWebFragment.this.bjC.setVisibility(0);
                SpecialFrsWebFragment.this.gCV.setVisibility(8);
                SpecialFrsWebFragment.this.ejJ = true;
                SpecialFrsWebFragment.this.baZ();
                return;
            }
            SpecialFrsWebFragment.this.showToast(R.string.neterror);
        }
    };

    static {
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIXIN_TIMELINE, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE);
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIXIN_FRIEND, LogConfig.LIVE_SHARE_WEIXIN_FRIEND);
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIBO, "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    public ShareItem v(String str, String str2, String str3, String str4) {
        return createShareContent(str, str2, str3, str4);
    }

    public String getForumId() {
        return this.fKa;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void tB(int i) {
        this.mTabId = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fKa = bundle.getString("fid");
            this.mForumName = bundle.getString("fname");
        } else if (getArguments() != null) {
            this.fKa = getArguments().getString("fid");
            this.mForumName = getArguments().getString("fname");
        }
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new com.baidu.tbadk.browser.b(getPageContext().getPageActivity()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        initCookie();
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.emK, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
        MessageManager.getInstance().registerListener(this.gCY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.special_frs_web_index, (ViewGroup) null);
        this.gCU = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.bjC = (FrameLayout) this.mRootView.findViewById(R.id.webview_container_layout);
        this.gCV = (FrameLayout) this.mRootView.findViewById(R.id.no_data_container);
        if (this.gCT == null) {
            this.gCT = new d(getPageContext());
        }
        this.gCT.a((NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar), this);
        createWebView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bjC.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bjC.setLayoutParams(layoutParams);
        if (this.ezq != null && (parent = this.ezq.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.ezq);
        }
        this.bjC.addView(this.ezq);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gCT != null) {
            this.gCT.onChangeSkinType(i);
        }
        if (this.gCU != null) {
            this.gCU.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gCT != null) {
            this.gCT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gCT == null) {
            this.gCT = new d(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("fid", this.fKa);
            bundle.putString("fname", this.mForumName);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ezq != null) {
                if (this.ejJ) {
                    initData();
                }
                try {
                    this.ezq.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
            } else {
                return;
            }
        } else if (this.ezq != null) {
            try {
                this.ezq.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
        } else {
            return;
        }
        this.mIsPaying = false;
    }

    private void initData() {
        if (this.mUrl != null && this.mUrl.contains("redirect=1")) {
            this.gCX = true;
        }
        loadUrl(this.mUrl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_GAME_TRIAL_INSTANCE, com.baidu.tieba.frs.b.a.class);
        if (runTask != null) {
            this.gCW = (com.baidu.tieba.frs.b.a) runTask.getData();
            if (this.gCW != null) {
                this.gCW.init();
            }
        }
    }

    protected void callHiddenWebViewMethod(String str) {
        if (this.ezq != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.ezq, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public View createWebView() {
        if (this.ezq == null) {
            this.ezq = new ScrollBridgeWebview(getPageContext().getPageActivity());
            this.ezq.setNeedDisAllowParentInterceptTouchEvent(true);
            this.ezq.getSettings().setJavaScriptEnabled(true);
            this.ezq.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.ezq.getSettings().setAllowFileAccess(true);
            this.ezq.getSettings().setDatabaseEnabled(true);
            this.ezq.getSettings().setDomStorageEnabled(true);
            this.ezq.getSettings().setSupportZoom(true);
            this.ezq.getSettings().setBuiltInZoomControls(true);
            this.ezq.getSettings().setUseWideViewPort(true);
            this.ezq.getSettings().setLoadWithOverviewMode(true);
            this.ezq.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.ezq.setHorizontalScrollBarEnabled(false);
            this.ezq.setHorizontalScrollbarOverlay(false);
            this.ezq.setInitialScale(100);
            this.ezq.setScrollBarStyle(33554432);
            this.ezq.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.ezq.setWebViewClient(new a());
            this.ezq.setDownloadListener(new b());
            com.baidu.tieba.frs.gametabs.b bVar = new com.baidu.tieba.frs.gametabs.b(getPageContext());
            bVar.setOnJsPromptCallback(this.jsCallback);
            this.ezq.setWebChromeClient(bVar);
            this.ezq.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.9
                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void q(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void r(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void onScrollChanged(int i, int i2, int i3, int i4) {
                }
            });
            CompatibleUtile.getInstance().removeJavascriptInterface(this.ezq);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.ezq, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String axf() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(aDd = false, value = "trackFPS")
                    private void trackFPS() {
                        SpecialFrsWebFragment.this.trackFPS();
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.a.c
                    @o(aDd = false, value = "scanBigImages")
                    public void sanBigImages(JSONObject jSONObject) throws JSONException {
                        super.sanBigImages(jSONObject);
                        TiebaStatic.log(new an("c12338").Z("fid", jSONObject.optInt("fid")));
                    }
                });
                a2.a(new com.baidu.tbadk.browser.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.d(a2));
                a2.a(new e(a2));
                a2.a(new com.baidu.tieba.frs.gametabs.a(a2, this.fKa));
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String axf() {
                        return "TBHY_COMMON_SKIN_TO_LOGIN";
                    }

                    @o(aDd = false, value = "skinToLogin")
                    private void skinToLogin() {
                        if (!TbadkCoreApplication.isLogin()) {
                            bc.skipToLoginActivity(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.13
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String axf() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(aDd = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && bc.checkUpIsLogin(SpecialFrsWebFragment.this.getPageContext().getPageActivity())) {
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
                    public String axf() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(aDd = false, value = TbConfig.TMP_SHARE_DIR_NAME)
                    private void share(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString("bid");
                            if (!StringUtils.isNULL(optString5)) {
                                SpecialFrsWebFragment.this.mShareResultToFe = true;
                                SpecialFrsWebFragment.this.mBid = optString5;
                            }
                            final ShareItem createShareContent = SpecialFrsWebFragment.this.createShareContent(optString, optString4, optString2, optString3);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.2.1
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
        return this.ezq;
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, axq())));
        }
    }

    private SparseArray<String> axq() {
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
        if (this.ezq != null) {
            CompatibleUtile.getInstance().loadUrl(this.ezq, str);
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
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        MessageManager.getInstance().unRegisterListener(this.gCY);
        if (this.gCW != null) {
            this.gCW.release();
            this.gCW = null;
        }
        if (this.gCT != null) {
            this.gCT.onDestroy();
        }
        if (this.jsBridge != null) {
            this.jsBridge.cKd();
        }
        if (this.ezq != null) {
            this.ezq.getSettings().setBuiltInZoomControls(true);
            this.ezq.setVisibility(8);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SpecialFrsWebFragment.this.ezq != null) {
                            SpecialFrsWebFragment.this.ezq.destroy();
                            SpecialFrsWebFragment.this.ezq = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (SpecialFrsWebFragment.this.ezq != null) {
                SpecialFrsWebFragment.this.isLoading = false;
                SpecialFrsWebFragment.this.hideLoadingView(SpecialFrsWebFragment.this.bjC);
                SpecialFrsWebFragment.this.mUrl = str;
                SpecialFrsWebFragment.this.ezq.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (SpecialFrsWebFragment.this.ejJ) {
                    SpecialFrsWebFragment.this.ejJ = false;
                }
                String title = SpecialFrsWebFragment.this.ezq.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    SpecialFrsWebFragment.this.ru(title);
                }
                SpecialFrsWebFragment.this.gCT.setNavBarVisibility(SpecialFrsWebFragment.this.isNeedShowNavigationBar());
                SpecialFrsWebFragment.this.gCT.fi(SpecialFrsWebFragment.this.isNeedShowShareItem());
                SpecialFrsWebFragment.this.gCT.lR(SpecialFrsWebFragment.this.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (SpecialFrsWebFragment.this.ezq != null) {
                SpecialFrsWebFragment.this.ezq.stopLoading();
                SpecialFrsWebFragment.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SpecialFrsWebFragment.this.ezq != null) {
                if (SpecialFrsWebFragment.this.ejJ) {
                    SpecialFrsWebFragment.this.isLoading = true;
                    SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.bjC);
                }
                SpecialFrsWebFragment.this.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (SpecialFrsWebFragment.this.ejJ) {
                SpecialFrsWebFragment.this.ejJ = false;
                return false;
            } else if (!SpecialFrsWebFragment.this.Be(str) || TbadkCoreApplication.isLogin() || SpecialFrsWebFragment.this.getPageContext() == null) {
                if (!SpecialFrsWebFragment.this.xQ(str) && SpecialFrsWebFragment.this.getPageContext() != null && SpecialFrsWebFragment.this.ezq.isShown()) {
                    if (str.startsWith("tdoudiscount:")) {
                        SpecialFrsWebFragment.this.mIsPaying = true;
                    }
                    if (!SpecialFrsWebFragment.this.rv(str)) {
                        if (SpecialFrsWebFragment.this.gCX) {
                            return ba.aEt().a(SpecialFrsWebFragment.this.getPageContext(), new String[]{str}) == 0;
                        }
                        ba.aEt().a((TbPageContext<?>) SpecialFrsWebFragment.this.getPageContext(), new String[]{str}, true);
                    } else {
                        int a = ba.aEt().a(SpecialFrsWebFragment.this.getPageContext(), new String[]{str});
                        return a == 0 || a == 1;
                    }
                }
                return true;
            } else {
                bc.skipToLoginActivity(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Be(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xQ(String str) {
        return Bf(str) || Bh(str) || Bi(str) || Bg(str);
    }

    private boolean Bf(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
            return false;
        }
        int parseInt = Integer.parseInt(ag.getMatchStringFromURL(str, "fid="));
        int parseInt2 = Integer.parseInt(ag.getMatchStringFromURL(str, "gameid="));
        String matchStringFromURL = ag.getMatchStringFromURL(str, "gamename=");
        if (this.gCW != null) {
            this.gCW.a(getPageContext(), matchStringFromURL, parseInt2, parseInt);
        }
        return true;
    }

    private boolean Bg(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getFragmentActivity(), ag.getMatchStringFromURL(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    private boolean Bh(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
            return false;
        }
        String matchStringFromURL = ag.getMatchStringFromURL(str, "packagename=");
        if (!StringUtils.isNull(matchStringFromURL)) {
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(matchStringFromURL));
        }
        return true;
    }

    private boolean Bi(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
            return false;
        }
        String matchStringFromURL = ag.getMatchStringFromURL(str, "tid=");
        if (!StringUtils.isNull(matchStringFromURL)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getFragmentActivity()).createNormalCfg(matchStringFromURL, null, PbActivityConfig.KEY_FROM_NEWS)));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
        com.baidu.tbadk.browser.a.initCookie(getBaseFragmentActivity().getApplicationContext());
    }

    public void onReceivedError(int i) {
        if (this.ezq != null) {
            this.mUrl = this.ezq.getUrl();
            this.ezq.stopLoading();
        }
        this.bjC.setVisibility(8);
        this.gCV.setVisibility(0);
        if (getPageContext() != null) {
            showNetRefreshView(this.gCV, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.refresh), false, this.mOnRefreshClickListener);
        }
    }

    private com.baidu.tieba.tbadkCore.e.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GAME_JS_HANDLER_REGISTER, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        if (!dUF) {
            dUF = true;
            g.aCU().a(16, new com.baidu.tbadk.core.hybrid.j() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.5
                @Override // com.baidu.tbadk.core.hybrid.j
                public void aA(List<Long> list) {
                    if (list != null && list.size() != 0) {
                        String str = "";
                        StringBuilder sb = new StringBuilder();
                        Iterator<Long> it = list.iterator();
                        while (true) {
                            String str2 = str;
                            if (it.hasNext()) {
                                sb.append(str2);
                                sb.append(it.next());
                                str = PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
                            } else {
                                com.baidu.adp.lib.stats.a gs = com.baidu.tbadk.n.l.gs();
                                gs.addValue("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", gs);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar bcw() {
        if (this.gCT != null) {
            return this.gCT.bcw();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.mTabId == 102) {
            return "a055";
        }
        if (this.mTabId == 103) {
            return "a056";
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        return super.getCurrentPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baZ() {
        if (!this.isLoading && !TextUtils.isEmpty(this.mUrl) && j.isNetWorkAvailable()) {
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
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && this.ezq != null) {
                    this.ezq.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
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
