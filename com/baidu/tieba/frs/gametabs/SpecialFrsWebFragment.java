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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.hybrid.g;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SpecialFrsWebFragment extends BaseWebViewFragment implements ap {
    private static boolean gjo = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    private FrameLayout cUF;
    private String fPy;
    private boolean isLoading;
    private d jBX;
    private NoNetworkView jBY;
    private FrameLayout jBZ;
    private com.baidu.tieba.frs.a.a jCa;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private String mForumName;
    private l mHybridBridge;
    private View mRootView;
    private int mTabId;
    private ScrollBridgeWebview gYU = null;
    private boolean gEY = true;
    private boolean jCb = false;
    private boolean mIsPaying = false;
    protected boolean mShareResultToFe = false;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (SpecialFrsWebFragment.this.jsBridge != null) {
                return SpecialFrsWebFragment.this.jsBridge.a(SpecialFrsWebFragment.this.gYU, str, jsPromptResult);
            }
            return false;
        }
    };
    private CustomMessageListener gIn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsInfoTab".equals(split[0]) || "FrsRankList".equals(split[0])) {
                        SpecialFrsWebFragment.this.bVE();
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
                SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.cUF);
                SpecialFrsWebFragment.this.loadUrl(SpecialFrsWebFragment.this.mUrl);
            }
        }
    };
    private CustomMessageListener jCc = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001227 && SpecialFrsWebFragment.this.mIsPaying) {
                if (SpecialFrsWebFragment.this.gYU != null) {
                    SpecialFrsWebFragment.this.gYU.reload();
                }
                SpecialFrsWebFragment.this.mIsPaying = false;
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                SpecialFrsWebFragment.this.hideNetRefreshView(SpecialFrsWebFragment.this.jBZ);
                SpecialFrsWebFragment.this.cUF.setVisibility(0);
                SpecialFrsWebFragment.this.jBZ.setVisibility(8);
                SpecialFrsWebFragment.this.gEY = true;
                SpecialFrsWebFragment.this.bVE();
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

    public ShareItem D(String str, String str2, String str3, String str4) {
        return createShareContent(str, str2, str3, str4);
    }

    public String getForumId() {
        return this.fPy;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setTabId(int i) {
        this.mTabId = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fPy = bundle.getString("fid");
            this.mForumName = bundle.getString("fname");
        } else if (getArguments() != null) {
            this.fPy = getArguments().getString("fid");
            this.mForumName = getArguments().getString("fname");
        }
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new CommonTbJsBridge(getPageContext().getPageActivity()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        initCookie();
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIn, getBaseFragmentActivity().getUniqueId());
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
        MessageManager.getInstance().registerListener(this.jCc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent parent;
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.special_frs_web_index, (ViewGroup) null);
        this.jBY = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        this.cUF = (FrameLayout) this.mRootView.findViewById(R.id.webview_container_layout);
        this.jBZ = (FrameLayout) this.mRootView.findViewById(R.id.no_data_container);
        if (this.jBX == null) {
            this.jBX = new d(getPageContext());
        }
        this.jBX.a((NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar), this);
        createWebView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cUF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cUF.setLayoutParams(layoutParams);
        if (this.gYU != null && (parent = this.gYU.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.gYU);
        }
        this.cUF.addView(this.gYU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.jBX != null) {
            this.jBX.onChangeSkinType(i);
        }
        if (this.jBY != null) {
            this.jBY.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jBX != null) {
            this.jBX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.jBX == null) {
            this.jBX = new d(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("fid", this.fPy);
            bundle.putString("fname", this.mForumName);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gYU != null) {
                if (this.gEY) {
                    initData();
                }
                try {
                    this.gYU.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
            } else {
                return;
            }
        } else if (this.gYU != null) {
            try {
                this.gYU.onPause();
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
            this.jCb = true;
        }
        loadUrl(this.mUrl);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_GAME_TRIAL_INSTANCE, com.baidu.tieba.frs.a.a.class);
        if (runTask != null) {
            this.jCa = (com.baidu.tieba.frs.a.a) runTask.getData();
            if (this.jCa != null) {
                this.jCa.init();
            }
        }
    }

    protected void callHiddenWebViewMethod(String str) {
        if (this.gYU != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.gYU, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public View createWebView() {
        if (this.gYU == null) {
            this.gYU = new ScrollBridgeWebview(getPageContext().getPageActivity());
            this.gYU.setNeedDisAllowParentInterceptTouchEvent(true);
            this.gYU.getSettings().setJavaScriptEnabled(true);
            this.gYU.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.gYU.getSettings().setAllowFileAccess(true);
            this.gYU.getSettings().setDatabaseEnabled(true);
            this.gYU.getSettings().setDomStorageEnabled(true);
            this.gYU.getSettings().setSupportZoom(true);
            this.gYU.getSettings().setBuiltInZoomControls(true);
            this.gYU.getSettings().setUseWideViewPort(true);
            this.gYU.getSettings().setLoadWithOverviewMode(true);
            this.gYU.getSettings().setDatabasePath(getBaseFragmentActivity().getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.gYU.setHorizontalScrollBarEnabled(false);
            this.gYU.setHorizontalScrollbarOverlay(false);
            this.gYU.setInitialScale(100);
            this.gYU.setScrollBarStyle(33554432);
            this.gYU.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.gYU.setWebViewClient(new a());
            this.gYU.setDownloadListener(new b());
            com.baidu.tieba.frs.gametabs.b bVar = new com.baidu.tieba.frs.gametabs.b(getPageContext());
            bVar.setOnJsPromptCallback(this.jsCallback);
            this.gYU.setWebChromeClient(bVar);
            this.gYU.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.9
                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void t(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void u(int i, int i2, int i3, int i4) {
                }

                @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
                public void onScrollChanged(int i, int i2, int i3, int i4) {
                }
            });
            CompatibleUtile.getInstance().removeJavascriptInterface(this.gYU);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.gYU, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bnV() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(bvb = false, value = "trackFPS")
                    private void trackFPS() {
                        SpecialFrsWebFragment.this.trackFPS();
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.a.c
                    @o(bvb = false, value = "scanBigImages")
                    public void sanBigImages(JSONObject jSONObject) throws JSONException {
                        super.sanBigImages(jSONObject);
                        TiebaStatic.log(new aq("c12338").an("fid", jSONObject.optInt("fid")));
                    }
                });
                a2.a(new com.baidu.tbadk.browser.b(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.d(a2));
                a2.a(new e(a2));
                a2.a(new com.baidu.tieba.frs.gametabs.a(a2, this.fPy));
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bnV() {
                        return "TBHY_COMMON_SKIN_TO_LOGIN";
                    }

                    @o(bvb = false, value = "skinToLogin")
                    private void skinToLogin() {
                        if (!TbadkCoreApplication.isLogin()) {
                            bg.skipToLoginActivity(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.13
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bnV() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(bvb = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && bg.checkUpIsLogin(SpecialFrsWebFragment.this.getPageContext().getPageActivity())) {
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
                    public String bnV() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(bvb = false, value = TbConfig.TMP_SHARE_DIR_NAME)
                    private void share(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_BID);
                            if (!StringUtils.isNULL(optString5)) {
                                SpecialFrsWebFragment.this.mShareResultToFe = true;
                                SpecialFrsWebFragment.this.mBid = optString5;
                            }
                            final ShareItem createShareContent = SpecialFrsWebFragment.this.createShareContent(optString, optString4, optString2, optString3);
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SpecialFrsWebFragment.this.showShareDialog(createShareContent);
                                }
                            });
                        }
                    }
                });
            }
        }
        return this.gYU;
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) getPageContext().getPageActivity(), shareItem, true, bog())));
        }
    }

    private SparseArray<String> bog() {
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
        if (this.gYU != null) {
            CompatibleUtile.getInstance().loadUrl(this.gYU, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
        MessageManager.getInstance().unRegisterListener(this.jCc);
        if (this.jCa != null) {
            this.jCa.release();
            this.jCa = null;
        }
        if (this.jBX != null) {
            this.jBX.onDestroy();
        }
        if (this.jsBridge != null) {
            this.jsBridge.dPF();
        }
        if (this.gYU != null) {
            this.gYU.getSettings().setBuiltInZoomControls(true);
            this.gYU.setVisibility(8);
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SpecialFrsWebFragment.this.gYU != null) {
                            SpecialFrsWebFragment.this.gYU.destroy();
                            SpecialFrsWebFragment.this.gYU = null;
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (SpecialFrsWebFragment.this.gYU != null) {
                SpecialFrsWebFragment.this.isLoading = false;
                SpecialFrsWebFragment.this.hideLoadingView(SpecialFrsWebFragment.this.cUF);
                SpecialFrsWebFragment.this.mUrl = str;
                SpecialFrsWebFragment.this.gYU.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                if (SpecialFrsWebFragment.this.gEY) {
                    SpecialFrsWebFragment.this.gEY = false;
                }
                String title = SpecialFrsWebFragment.this.gYU.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    SpecialFrsWebFragment.this.Ap(title);
                }
                SpecialFrsWebFragment.this.jBX.setNavBarVisibility(SpecialFrsWebFragment.this.isNeedShowNavigationBar());
                SpecialFrsWebFragment.this.jBX.je(SpecialFrsWebFragment.this.isNeedShowShareItem());
                SpecialFrsWebFragment.this.jBX.rj(SpecialFrsWebFragment.this.isNeedShowMenuItem());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (SpecialFrsWebFragment.this.gYU != null) {
                SpecialFrsWebFragment.this.gYU.stopLoading();
                SpecialFrsWebFragment.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SpecialFrsWebFragment.this.gYU != null) {
                if (SpecialFrsWebFragment.this.gEY) {
                    SpecialFrsWebFragment.this.isLoading = true;
                    SpecialFrsWebFragment.this.showLoadingView(SpecialFrsWebFragment.this.cUF);
                }
                SpecialFrsWebFragment.this.mUrl = str;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (SpecialFrsWebFragment.this.gEY) {
                SpecialFrsWebFragment.this.gEY = false;
                return false;
            } else if (!SpecialFrsWebFragment.this.Lq(str) || TbadkCoreApplication.isLogin() || SpecialFrsWebFragment.this.getPageContext() == null) {
                if (!SpecialFrsWebFragment.this.Ht(str) && SpecialFrsWebFragment.this.getPageContext() != null && SpecialFrsWebFragment.this.gYU.isShown()) {
                    if (str.startsWith("tdoudiscount:")) {
                        SpecialFrsWebFragment.this.mIsPaying = true;
                    }
                    if (!SpecialFrsWebFragment.this.Aq(str)) {
                        if (SpecialFrsWebFragment.this.jCb) {
                            return be.bwu().a(SpecialFrsWebFragment.this.getPageContext(), new String[]{str}) == 0;
                        }
                        be.bwu().a((TbPageContext<?>) SpecialFrsWebFragment.this.getPageContext(), new String[]{str}, true);
                    } else {
                        int a2 = be.bwu().a(SpecialFrsWebFragment.this.getPageContext(), new String[]{str});
                        return a2 == 0 || a2 == 1;
                    }
                }
                return true;
            } else {
                bg.skipToLoginActivity(SpecialFrsWebFragment.this.getPageContext().getPageActivity());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lq(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("tieba_check_login=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ht(String str) {
        return Lr(str) || Lt(str) || Lu(str) || Ls(str);
    }

    private boolean Lr(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_SDK)) {
            return false;
        }
        int parseInt = Integer.parseInt(ai.getMatchStringFromURL(str, "fid="));
        int parseInt2 = Integer.parseInt(ai.getMatchStringFromURL(str, "gameid="));
        String matchStringFromURL = ai.getMatchStringFromURL(str, "gamename=");
        if (this.jCa != null) {
            this.jCa.a(getPageContext(), matchStringFromURL, parseInt2, parseInt);
        }
        return true;
    }

    private boolean Ls(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS_DETAIL)) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(getFragmentActivity(), ai.getMatchStringFromURL(str, "fid="), ForumDetailActivityConfig.FromType.FRS_GAME_INFO)));
        return true;
    }

    private boolean Lt(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_START_GAME)) {
            return false;
        }
        String matchStringFromURL = ai.getMatchStringFromURL(str, "packagename=");
        if (!StringUtils.isNull(matchStringFromURL)) {
            getFragmentActivity().startActivity(getFragmentActivity().getPackageManager().getLaunchIntentForPackage(matchStringFromURL));
        }
        return true;
    }

    private boolean Lu(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_PB)) {
            return false;
        }
        String matchStringFromURL = ai.getMatchStringFromURL(str, "tid=");
        if (!StringUtils.isNull(matchStringFromURL)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getFragmentActivity()).createNormalCfg(matchStringFromURL, null, PbActivityConfig.KEY_FROM_NEWS)));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
        if (this.gYU != null) {
            this.mUrl = this.gYU.getUrl();
            this.gYU.stopLoading();
        }
        this.cUF.setVisibility(8);
        this.jBZ.setVisibility(0);
        if (getPageContext() != null) {
            showNetRefreshView(this.jBZ, getPageContext().getString(R.string.url_not_found), null, getPageContext().getString(R.string.refresh), false, this.mOnRefreshClickListener);
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
        if (!gjo) {
            gjo = true;
            g.buS().a(16, new com.baidu.tbadk.core.hybrid.j() { // from class: com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment.5
                @Override // com.baidu.tbadk.core.hybrid.j
                public void bD(List<Long> list) {
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
                                com.baidu.adp.lib.stats.a pi = com.baidu.tbadk.n.j.pi();
                                pi.addValue("frame_delta", sb.toString());
                                BdStatisticsManager.getInstance().performance("webview", pi);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bYq() {
        if (this.jBX != null) {
            return this.jBX.bYq();
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
    public void bVE() {
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
                hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, this.mBid);
                hashMap.put("result", Boolean.valueOf(z));
                hashMap.put("channel", str);
                m a2 = m.a("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1 && this.gYU != null) {
                    this.gYU.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
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
