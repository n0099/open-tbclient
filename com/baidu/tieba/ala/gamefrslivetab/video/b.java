package com.baidu.tieba.ala.gamefrslivetab.video;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private g epL;
    private boolean exC;
    private BaseFragment ezp;
    private ScrollBridgeWebview ezq;
    private int ezr = 0;
    private ShareFromPBMsgData ezs;
    private boolean isLoading;
    private boolean mLoadSuccess;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private String mUrl;

    public b(boolean z) {
        this.exC = false;
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null) {
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, b.this.ezs);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.exC = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(R.layout.ala_frs_live_video_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void c(BaseFragment baseFragment) {
        this.ezp = baseFragment;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setVisibility(this.exC ? 0 : 8);
        if (this.exC) {
            this.mNavigationBar.onChangeSkinType(this.ezp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar.showBottomLine(true);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, b.this.ezp.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        this.ezq = (ScrollBridgeWebview) this.mRootView.findViewById(R.id.webview);
        this.ezq.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.4
            @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
            public void q(int i, int i2, int i3, int i4) {
            }

            @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
            public void r(int i, int i2, int i3, int i4) {
            }

            @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (Math.abs(i2 - b.this.ezr) > 50) {
                    b.this.ezr = i2;
                    if (i2 > i4) {
                        b.this.x(false, true);
                    } else {
                        b.this.x(true, true);
                    }
                }
            }
        });
        bcI();
    }

    public BaseWebView getWebView() {
        return this.ezq;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.ezq.loadUrl(str);
    }

    public void bcH() {
        if (this.mLoadSuccess) {
            this.ezq.loadUrl("javascript:window.reload_page()");
        } else {
            this.ezq.loadUrl(this.mUrl);
        }
    }

    public void showLoadingView() {
        if (this.ezp != null && this.mRootView != null && this.ezp.isAdded()) {
            this.isLoading = true;
            this.epL = new g(this.ezp.getActivity(), this.ezp.getResources().getDimensionPixelSize(R.dimen.ds270));
            this.epL.attachView(this.mRootView, false);
            this.epL.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        this.isLoading = false;
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
            this.epL = null;
        }
    }

    public void bbL() {
        baf();
        this.ezq.setVisibility(0);
    }

    public void bae() {
        if (this.ezp != null && this.ezp.isAdded()) {
            String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.ezp.getActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.bcH();
                    }
                });
                this.mRefreshView.onChangeSkinType();
            }
            this.ezq.setVisibility(8);
            this.mRefreshView.setSubText(string);
            this.mRefreshView.attachView(this.mRootView, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void bcI() {
        if (this.ezq != null) {
            this.ezq.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    b.this.xP(str);
                    if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                        return false;
                    }
                    if (b.this.xQ(str)) {
                        return true;
                    }
                    ba.aEt().b(b.this.ezp.getPageContext(), new String[]{str});
                    return true;
                }
            });
            this.ezq.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.7
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    b.this.showLoadingView();
                }
            });
            this.ezq.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.8
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    b.this.hideLoadingView();
                    if (j.isNetWorkAvailable()) {
                        b.this.bbL();
                        b.this.mLoadSuccess = true;
                    }
                }
            });
            this.ezq.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.9
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    b.this.bae();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP(String str) {
        if (StringUtils.isNull(str)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xQ(String str) {
        return xR(str) || xS(str) || xT(str) || xU(str) || xV(str) || xW(str) || xX(str) || xY(str);
    }

    private boolean xR(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                l.showToast(this.ezp.getActivity(), (int) R.string.plugin_install_fail);
                return true;
            }
            ba.aEt().b(this.ezp.getPageContext(), new String[]{str});
            return true;
        }
        return false;
    }

    private boolean xS(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                l.showToast(this.ezp.getActivity(), (int) R.string.plugin_install_fail);
            } else {
                ba.aEt().b(this.ezp.getPageContext(), new String[]{str});
            }
            return true;
        }
        return false;
    }

    private boolean xT(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ag.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ag.getMatchStringFromURL(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(matchStringFromURL) || StringUtils.isNull(matchStringFromURL2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.ezp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.ezp.getActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(this.ezp.getActivity(), matchStringFromURL2, str);
            return true;
        } else if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.ezp.getActivity()).createNormalConfig("discover", SchemeCollecter.CLASSIFY_ALL).start();
            return true;
        } else {
            return false;
        }
    }

    private boolean xU(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.ezp.getActivity(), ag.getMatchStringFromURL(str, "menuname="), ag.getMatchStringFromURL(str, "menutype="), ag.getMatchStringFromURL(str, "menuid="))));
            return true;
        }
        return true;
    }

    private boolean xV(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.ezp.getActivity(), (int) R.string.plugin_install_fail);
            return true;
        }
        ba.aEt().b(this.ezp.getPageContext(), new String[]{str});
        return true;
    }

    private boolean xW(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.ezp.getActivity(), (int) R.string.plugin_install_fail);
            return true;
        }
        ba.aEt().b(this.ezp.getPageContext(), new String[]{str});
        return true;
    }

    private boolean xX(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_BEAUTY_PIC) && str.contains("data=")) {
            String substring = str.substring("data=".length() + str.indexOf("data="));
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(substring).optJSONArray("pic");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
                if (arrayList.size() > 0) {
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.ezp.getActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.ezp.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean xY(String str) {
        if (this.ezp.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
            String urlDecode = k.getUrlDecode(str);
            if (urlDecode.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(urlDecode.substring("data=".length() + urlDecode.indexOf("data=")));
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (bc.checkUpIsLogin(this.ezp.getActivity())) {
                        this.ezs = new ShareFromPBMsgData();
                        this.ezs.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.ezs.setImageUrl(optString6);
                        }
                        this.ezs.setForumName(optString5);
                        this.ezs.setThreadId(optString4);
                        this.ezs.setTitle(optString);
                        String format = MessageFormat.format(this.ezp.getResources().getString(R.string.share_content_tpl), optString, optString2);
                        final ShareItem shareItem = new ShareItem();
                        shareItem.title = optString;
                        shareItem.content = format;
                        shareItem.linkUrl = optString3;
                        shareItem.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            shareItem.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.ezp.getActivity(), shareItem, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.10
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.ezp.getActivity(), RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                                l.showToast(b.this.ezp.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                            }
                        });
                        this.ezp.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
                    }
                    return true;
                } catch (JSONException e) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
            customMessage.setTag(this.ezp.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
        customMessage2.setTag(this.ezp.getBaseFragmentActivity().getUniqueId());
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public void baZ() {
        if (!this.isLoading && j.isNetWorkAvailable()) {
            this.ezq.loadUrl(this.mUrl);
        }
    }

    public NavigationBar bcw() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ezp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
    }
}
