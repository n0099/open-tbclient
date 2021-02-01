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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.al;
import com.baidu.tieba.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private g gJn;
    private boolean gVo;
    private BaseFragment gWX;
    private ScrollBridgeWebview gWY;
    private int gWZ = 0;
    private ShareFromPBMsgData gXa;
    private boolean isLoading;
    private boolean mLoadSuccess;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private String mUrl;

    public b(boolean z) {
        this.gVo = false;
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null) {
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, b.this.gXa);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.gVo = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
    }

    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(R.layout.ala_frs_live_video_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void b(BaseFragment baseFragment) {
        this.gWX = baseFragment;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setVisibility(this.gVo ? 0 : 8);
        if (this.gVo) {
            this.mNavigationBar.onChangeSkinType(this.gWX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar.showBottomLine(true);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, b.this.gWX.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        this.gWY = (ScrollBridgeWebview) this.mRootView.findViewById(R.id.webview);
        this.gWY.setOnScrollChangeListener(new ScrollBridgeWebview.a() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.4
            @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
            public void t(int i, int i2, int i3, int i4) {
            }

            @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
            public void u(int i, int i2, int i3, int i4) {
            }

            @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (Math.abs(i2 - b.this.gWZ) > 50) {
                    b.this.gWZ = i2;
                    if (i2 > i4) {
                        b.this.L(false, true);
                    } else {
                        b.this.L(true, true);
                    }
                }
            }
        });
        bVp();
    }

    public BaseWebView getWebView() {
        return this.gWY;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.gWY.loadUrl(str);
    }

    public void bVo() {
        if (this.mLoadSuccess) {
            this.gWY.loadUrl("javascript:window.reload_page()");
        } else {
            this.gWY.loadUrl(this.mUrl);
        }
    }

    public void showLoadingView() {
        if (this.gWX != null && this.mRootView != null && this.gWX.isAdded()) {
            this.isLoading = true;
            this.gJn = new g(this.gWX.getActivity(), this.gWX.getResources().getDimensionPixelSize(R.dimen.ds270));
            this.gJn.attachView(this.mRootView, false);
            this.gJn.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        this.isLoading = false;
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
            this.gJn = null;
        }
    }

    public void bTS() {
        WZ();
        this.gWY.setVisibility(0);
    }

    public void bRu() {
        if (this.gWX != null && this.gWX.isAdded()) {
            String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.gWX.getActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.bVo();
                    }
                });
                this.mRefreshView.onChangeSkinType();
            }
            this.gWY.setVisibility(8);
            this.mRefreshView.setSubText(string);
            this.mRefreshView.attachView(this.mRootView, false);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void bVp() {
        if (this.gWY != null) {
            this.gWY.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    b.this.GF(str);
                    if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                        return false;
                    }
                    if (b.this.GG(str)) {
                        return true;
                    }
                    bf.bsV().b(b.this.gWX.getPageContext(), new String[]{str});
                    return true;
                }
            });
            this.gWY.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.7
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void onPageStarted(WebView webView, String str) {
                    b.this.showLoadingView();
                }
            });
            this.gWY.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.8
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    b.this.hideLoadingView();
                    if (j.isNetWorkAvailable()) {
                        b.this.bTS();
                        b.this.mLoadSuccess = true;
                    }
                }
            });
            this.gWY.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.9
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    b.this.bRu();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GF(String str) {
        if (StringUtils.isNull(str)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GG(String str) {
        return GH(str) || GI(str) || GJ(str) || GK(str) || GL(str) || GM(str) || GN(str) || GO(str);
    }

    private boolean GH(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                l.showToast(this.gWX.getActivity(), R.string.plugin_install_fail);
                return true;
            }
            bf.bsV().b(this.gWX.getPageContext(), new String[]{str});
            return true;
        }
        return false;
    }

    private boolean GI(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                l.showToast(this.gWX.getActivity(), R.string.plugin_install_fail);
            } else {
                bf.bsV().b(this.gWX.getPageContext(), new String[]{str});
            }
            return true;
        }
        return false;
    }

    private boolean GJ(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = al.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = al.getMatchStringFromURL(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(matchStringFromURL) || StringUtils.isNull(matchStringFromURL2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.gWX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.gWX.getActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(this.gWX.getActivity(), matchStringFromURL2, str);
            return true;
        } else if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.gWX.getActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean GK(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.gWX.getActivity(), al.getMatchStringFromURL(str, "menuname="), al.getMatchStringFromURL(str, "menutype="), al.getMatchStringFromURL(str, "menuid="))));
            return true;
        }
        return true;
    }

    private boolean GL(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.gWX.getActivity(), R.string.plugin_install_fail);
            return true;
        }
        bf.bsV().b(this.gWX.getPageContext(), new String[]{str});
        return true;
    }

    private boolean GM(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.gWX.getActivity(), R.string.plugin_install_fail);
            return true;
        }
        bf.bsV().b(this.gWX.getPageContext(), new String[]{str});
        return true;
    }

    private boolean GN(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_BEAUTY_PIC) && str.contains("data=")) {
            String substring = str.substring("data=".length() + str.indexOf("data="));
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(substring).optJSONArray("pic");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
                if (arrayList.size() > 0) {
                    ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                    aVar.s(arrayList).jg(true).zM(arrayList.get(0)).jh(true);
                    ImageViewerConfig eP = aVar.eP(this.gWX.getActivity());
                    eP.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.gWX.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean GO(String str) {
        if (this.gWX.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
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
                    if (bh.checkUpIsLogin(this.gWX.getActivity())) {
                        this.gXa = new ShareFromPBMsgData();
                        this.gXa.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.gXa.setImageUrl(optString6);
                        }
                        this.gXa.setForumName(optString5);
                        this.gXa.setThreadId(optString4);
                        this.gXa.setTitle(optString);
                        String format = MessageFormat.format(this.gWX.getResources().getString(R.string.share_content_tpl), optString, optString2);
                        final ShareItem shareItem = new ShareItem();
                        shareItem.title = optString;
                        shareItem.content = format;
                        shareItem.linkUrl = optString3;
                        shareItem.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            shareItem.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.gWX.getActivity(), shareItem, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.10
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.gWX.getActivity(), RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamefrslivetab.video.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                                l.showToast(b.this.gWX.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                            }
                        });
                        this.gWX.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
    public void L(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB);
            customMessage.setTag(this.gWX.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB);
        customMessage2.setTag(this.gWX.getBaseFragmentActivity().getUniqueId());
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public void bSq() {
        if (!this.isLoading && j.isNetWorkAvailable()) {
            this.gWY.loadUrl(this.mUrl);
        }
    }

    public NavigationBar bVd() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gWX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
    }
}
