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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private boolean CO;
    private ShareFromPBMsgData bGg;
    private f bqL;
    private QuickWebView cMh;
    TbPageContext<BaseFragmentActivity> mPageContext;
    private g mRefreshView;
    private View mRootView;
    private String mUrl;

    public a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921015, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.discover.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921015, a.this.bGg);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.cMh != null) {
            this.cMh.destroy();
        }
        MessageManager.getInstance().unRegisterTask(2921015);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(d.i.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void j(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cMh = (QuickWebView) this.mRootView.findViewById(d.g.webview);
        View findViewById = this.mRootView.findViewById(d.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        Vk();
    }

    public BaseWebView getWebView() {
        return this.cMh;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.cMh.loadUrl(str);
    }

    public void Vi() {
        if (this.CO) {
            this.cMh.loadUrl("javascript:window.reload_page()");
        } else {
            this.cMh.loadUrl(this.mUrl);
        }
    }

    public void amS() {
        if (this.cMh != null) {
            this.cMh.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void amT() {
        if (this.cMh != null) {
            this.cMh.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.bqL = new f(this.mPageContext.getPageActivity());
            this.bqL.d(this.mRootView, false);
            this.bqL.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.bqL != null) {
            this.bqL.Q(this.mRootView);
            this.bqL = null;
        }
    }

    public void Vj() {
        Uc();
        this.cMh.setVisibility(0);
    }

    public void Ub() {
        String string = TbadkCoreApplication.getInst().getString(d.k.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Vi();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.cMh.setVisibility(8);
        this.mRefreshView.setSubText(string);
        this.mRefreshView.d(this.mRootView, false);
        this.mRefreshView.Jp();
        this.mRefreshView.fg(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds280));
    }

    public void Uc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void Vk() {
        if (this.cMh != null) {
            this.cMh.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.a.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    a.this.jF(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (a.this.jG(str)) {
                        return true;
                    }
                    az.zV().c(a.this.mPageContext, new String[]{str});
                    return true;
                }
            });
            this.cMh.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.a.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    a.this.showLoadingView();
                }
            });
            this.cMh.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.a.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    a.this.hideLoadingView();
                    if (j.jD()) {
                        a.this.Vj();
                        a.this.CO = true;
                        a.this.amS();
                    }
                }
            });
            this.cMh.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.a.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    a.this.Ub();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new an("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jG(String str) {
        return jH(str) || jI(str) || jJ(str) || jK(str) || jL(str) || jM(str) || jN(str) || jO(str);
    }

    private boolean jH(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_install_fail);
                return true;
            }
            az.zV().c(this.mPageContext, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean jI(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            az.zV().a((TbPageContext<?>) this.mPageContext, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean jJ(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ax = aa.ax(str, "topic_id=");
            String ax2 = aa.ax(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(ax) || StringUtils.isNull(ax2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(ax, ax2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.g(this.mPageContext.getPageActivity(), ax2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean jK(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(2902025) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.mPageContext.getPageActivity(), aa.ax(str, "menuname="), aa.ax(str, "menutype="), aa.ax(str, "menuid="))));
            return true;
        }
        BdToast.a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity().getString(d.k.discover_forum_square_tips), 0).xv();
        return true;
    }

    private boolean jL(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_install_fail);
            return true;
        }
        az.zV().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean jM(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_install_fail);
            return true;
        }
        az.zV().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean jN(String str) {
        if (str.contains("beautypic:") && str.contains("data=")) {
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
                    this.mPageContext.sendMessage(new CustomMessage(2010000, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean jO(String str) {
        if (str.contains("share:")) {
            String bh = k.bh(str);
            if (bh.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(bh.substring("data=".length() + bh.indexOf("data=")));
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (bb.aU(this.mPageContext.getPageActivity())) {
                        this.bGg = new ShareFromPBMsgData();
                        this.bGg.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bGg.setImageUrl(optString6);
                        }
                        this.bGg.setForumName(optString5);
                        this.bGg.setThreadId(optString4);
                        this.bGg.setTitle(optString);
                        String format = MessageFormat.format(this.mPageContext.getResources().getString(d.k.share_content_tpl), optString, optString2);
                        final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                        dVar.title = optString;
                        dVar.content = format;
                        dVar.linkUrl = optString3;
                        dVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            dVar.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mPageContext.getPageActivity(), dVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(d.k.forum_friend, d.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(a.this.mPageContext.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aP(dVar.linkUrl);
                                l.showToast(a.this.mPageContext.getPageActivity(), view.getResources().getString(d.k.copy_pb_url_success));
                            }
                        });
                        this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
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
