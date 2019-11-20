package com.baidu.tieba.discover;

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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private g dDz;
    private ShareFromPBMsgData dJR;
    private QuickWebView eWj;
    private boolean mLoadSuccess;
    TbPageContext<BaseFragmentActivity> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private String mUrl;

    public a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.discover.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, a.this.dJR);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.eWj != null) {
            this.eWj.destroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(R.layout.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void l(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eWj = (QuickWebView) this.mRootView.findViewById(R.id.webview);
        View findViewById = this.mRootView.findViewById(R.id.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        aLc();
    }

    public BaseWebView getWebView() {
        return this.eWj;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.eWj.loadUrl(str);
    }

    public void aLa() {
        if (this.mLoadSuccess) {
            this.eWj.loadUrl("javascript:window.reload_page()");
        } else {
            this.eWj.loadUrl(this.mUrl);
        }
    }

    public void bcC() {
        if (this.eWj != null) {
            this.eWj.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void bcD() {
        if (this.eWj != null) {
            this.eWj.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.dDz = new g(this.mPageContext.getPageActivity());
            this.dDz.attachView(this.mRootView, false);
            this.dDz.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this.mRootView);
            this.dDz = null;
        }
    }

    public void aLb() {
        aJm();
        this.eWj.setVisibility(0);
    }

    public void aJl() {
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aLa();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.eWj.setVisibility(8);
        this.mRefreshView.setSubText(string);
        this.mRefreshView.attachView(this.mRootView, false);
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void aLc() {
        if (this.eWj != null) {
            this.eWj.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.a.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    a.this.sZ(str);
                    if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                        return false;
                    }
                    if (a.this.ta(str)) {
                        return true;
                    }
                    ba.amO().b(a.this.mPageContext, new String[]{str});
                    return true;
                }
            });
            this.eWj.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.a.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    a.this.showLoadingView();
                }
            });
            this.eWj.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.a.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    a.this.hideLoadingView();
                    if (j.isNetWorkAvailable()) {
                        a.this.aLb();
                        a.this.mLoadSuccess = true;
                        a.this.bcC();
                    }
                }
            });
            this.eWj.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.a.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    a.this.aJl();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ(String str) {
        if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_SEARCH)) {
            TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).O("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ta(String str) {
        return tb(str) || tc(str) || td(str) || te(str) || tf(str) || tg(str) || th(str) || ti(str);
    }

    private boolean tb(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_install_fail);
                return true;
            }
            ba.amO().b(this.mPageContext, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean tc(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            ba.amO().a((TbPageContext<?>) this.mPageContext, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean td(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) || str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            String matchStringFromURL = ad.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = ad.getMatchStringFromURL(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(matchStringFromURL) || StringUtils.isNull(matchStringFromURL2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), matchStringFromURL2, str);
            return true;
        } else if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean te(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.mPageContext.getPageActivity(), ad.getMatchStringFromURL(str, "menuname="), ad.getMatchStringFromURL(str, "menutype="), ad.getMatchStringFromURL(str, "menuid="))));
            return true;
        }
        BdToast.b(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity().getString(R.string.discover_forum_square_tips), 0).akR();
        return true;
    }

    private boolean tf(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_install_fail);
            return true;
        }
        ba.amO().b(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean tg(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_install_fail);
            return true;
        }
        ba.amO().b(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean th(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_BEAUTY_PIC) && str.contains("data=")) {
            String substring = str.substring("data=".length() + str.indexOf("data="));
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(substring).optJSONArray("pic");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
                if (arrayList.size() > 0) {
                    TiebaStatic.log("c12183");
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean ti(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
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
                    if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                        this.dJR = new ShareFromPBMsgData();
                        this.dJR.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.dJR.setImageUrl(optString6);
                        }
                        this.dJR.setForumName(optString5);
                        this.dJR.setThreadId(optString4);
                        this.dJR.setTitle(optString);
                        String format = MessageFormat.format(this.mPageContext.getResources().getString(R.string.share_content_tpl), optString, optString2);
                        final e eVar = new e();
                        eVar.title = optString;
                        eVar.content = format;
                        eVar.linkUrl = optString3;
                        eVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            eVar.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mPageContext.getPageActivity(), eVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(a.this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.copyToClipboard(eVar.linkUrl);
                                l.showToast(a.this.mPageContext.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                            }
                        });
                        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
}
