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
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.f;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private boolean CK;
    private ShareFromPBMsgData bGV;
    private f brv;
    private QuickWebView cON;
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
                return new CustomResponsedMessage<>(2921015, a.this.bGV);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.cON != null) {
            this.cON.destroy();
        }
        MessageManager.getInstance().unRegisterTask(2921015);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(f.h.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void j(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cON = (QuickWebView) this.mRootView.findViewById(f.g.webview);
        View findViewById = this.mRootView.findViewById(f.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        Vw();
    }

    public BaseWebView getWebView() {
        return this.cON;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.cON.loadUrl(str);
    }

    public void Vu() {
        if (this.CK) {
            this.cON.loadUrl("javascript:window.reload_page()");
        } else {
            this.cON.loadUrl(this.mUrl);
        }
    }

    public void ant() {
        if (this.cON != null) {
            this.cON.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void anu() {
        if (this.cON != null) {
            this.cON.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.brv = new com.baidu.tbadk.k.f(this.mPageContext.getPageActivity());
            this.brv.c(this.mRootView, false);
            this.brv.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.brv != null) {
            this.brv.Q(this.mRootView);
            this.brv = null;
        }
    }

    public void Vv() {
        Un();
        this.cON.setVisibility(0);
    }

    public void Um() {
        String string = TbadkCoreApplication.getInst().getString(f.j.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Vu();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.cON.setVisibility(8);
        this.mRefreshView.hk(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.Jk();
        this.mRefreshView.fg(this.mPageContext.getResources().getDimensionPixelSize(f.e.ds280));
    }

    public void Un() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void Vw() {
        if (this.cON != null) {
            this.cON.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.a.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    a.this.jD(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (a.this.jE(str)) {
                        return true;
                    }
                    az.zI().c(a.this.mPageContext, new String[]{str});
                    return true;
                }
            });
            this.cON.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.a.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    a.this.showLoadingView();
                }
            });
            this.cON.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.a.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    a.this.hideLoadingView();
                    if (j.jE()) {
                        a.this.Vv();
                        a.this.CK = true;
                        a.this.ant();
                    }
                }
            });
            this.cON.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.a.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    a.this.Um();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new an("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jE(String str) {
        return jF(str) || jG(str) || jH(str) || jI(str) || jJ(str) || jK(str) || jL(str) || jM(str);
    }

    private boolean jF(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_install_fail);
                return true;
            }
            az.zI().c(this.mPageContext, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean jG(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            az.zI().a((TbPageContext<?>) this.mPageContext, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean jH(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String as = z.as(str, "topic_id=");
            String as2 = z.as(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(as) || StringUtils.isNull(as2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(as, as2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.g(this.mPageContext.getPageActivity(), as2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean jI(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(2902025) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.mPageContext.getPageActivity(), z.as(str, "menuname="), z.as(str, "menutype="), z.as(str, "menuid="))));
            return true;
        }
        BdToast.a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity().getString(f.j.discover_forum_square_tips), 0).xm();
        return true;
    }

    private boolean jJ(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_install_fail);
            return true;
        }
        az.zI().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean jK(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_install_fail);
            return true;
        }
        az.zI().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean jL(String str) {
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

    private boolean jM(String str) {
        if (str.contains("share:")) {
            String bi = k.bi(str);
            if (bi.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(bi.substring("data=".length() + bi.indexOf("data=")));
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
                        this.bGV = new ShareFromPBMsgData();
                        this.bGV.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bGV.setImageUrl(optString6);
                        }
                        this.bGV.setForumName(optString5);
                        this.bGV.setThreadId(optString4);
                        this.bGV.setTitle(optString);
                        String format = MessageFormat.format(this.mPageContext.getResources().getString(f.j.share_content_tpl), optString, optString2);
                        final d dVar = new d();
                        dVar.title = optString;
                        dVar.content = format;
                        dVar.linkUrl = optString3;
                        dVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            dVar.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mPageContext.getPageActivity(), dVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(f.j.forum_friend, f.C0146f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(a.this.mPageContext.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aQ(dVar.linkUrl);
                                l.showToast(a.this.mPageContext.getPageActivity(), view.getResources().getString(f.j.copy_pb_url_success));
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
