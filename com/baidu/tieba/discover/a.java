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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.e;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private boolean Fg;
    private ShareFromPBMsgData bMK;
    private f bxm;
    private QuickWebView cUE;
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
                return new CustomResponsedMessage<>(2921015, a.this.bMK);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.cUE != null) {
            this.cUE.destroy();
        }
        MessageManager.getInstance().unRegisterTask(2921015);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(e.h.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void j(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cUE = (QuickWebView) this.mRootView.findViewById(e.g.webview);
        View findViewById = this.mRootView.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        Xj();
    }

    public BaseWebView getWebView() {
        return this.cUE;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.cUE.loadUrl(str);
    }

    public void Xh() {
        if (this.Fg) {
            this.cUE.loadUrl("javascript:window.reload_page()");
        } else {
            this.cUE.loadUrl(this.mUrl);
        }
    }

    public void apf() {
        if (this.cUE != null) {
            this.cUE.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void apg() {
        if (this.cUE != null) {
            this.cUE.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.bxm = new f(this.mPageContext.getPageActivity());
            this.bxm.c(this.mRootView, false);
            this.bxm.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.bxm != null) {
            this.bxm.ad(this.mRootView);
            this.bxm = null;
        }
    }

    public void Xi() {
        Wa();
        this.cUE.setVisibility(0);
    }

    public void VZ() {
        String string = TbadkCoreApplication.getInst().getString(e.j.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Xh();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.cUE.setVisibility(8);
        this.mRefreshView.hG(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.KA();
        this.mRefreshView.fs(this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds280));
    }

    public void Wa() {
        if (this.mRefreshView != null) {
            this.mRefreshView.ad(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void Xj() {
        if (this.cUE != null) {
            this.cUE.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.a.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    a.this.kf(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (a.this.kg(str)) {
                        return true;
                    }
                    ay.AN().c(a.this.mPageContext, new String[]{str});
                    return true;
                }
            });
            this.cUE.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.a.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    a.this.showLoadingView();
                }
            });
            this.cUE.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.a.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    a.this.hideLoadingView();
                    if (j.kK()) {
                        a.this.Xi();
                        a.this.Fg = true;
                        a.this.apf();
                    }
                }
            });
            this.cUE.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.a.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    a.this.VZ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new am("c10378").w("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kg(String str) {
        return kh(str) || ki(str) || kj(str) || kk(str) || kl(str) || km(str) || kn(str) || ko(str);
    }

    private boolean kh(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_install_fail);
                return true;
            }
            ay.AN().c(this.mPageContext, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean ki(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            ay.AN().a((TbPageContext<?>) this.mPageContext, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean kj(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String aA = ab.aA(str, "topic_id=");
            String aA2 = ab.aA(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(aA) || StringUtils.isNull(aA2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(aA, aA2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.h(this.mPageContext.getPageActivity(), aA2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean kk(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(2902025) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.mPageContext.getPageActivity(), ab.aA(str, "menuname="), ab.aA(str, "menutype="), ab.aA(str, "menuid="))));
            return true;
        }
        BdToast.a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity().getString(e.j.discover_forum_square_tips), 0).yt();
        return true;
    }

    private boolean kl(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_install_fail);
            return true;
        }
        ay.AN().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean km(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_install_fail);
            return true;
        }
        ay.AN().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean kn(String str) {
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

    private boolean ko(String str) {
        if (str.contains("share:")) {
            String bz = k.bz(str);
            if (bz.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(bz.substring("data=".length() + bz.indexOf("data=")));
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (ba.bA(this.mPageContext.getPageActivity())) {
                        this.bMK = new ShareFromPBMsgData();
                        this.bMK.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bMK.setImageUrl(optString6);
                        }
                        this.bMK.setForumName(optString5);
                        this.bMK.setThreadId(optString4);
                        this.bMK.setTitle(optString);
                        String format = MessageFormat.format(this.mPageContext.getResources().getString(e.j.share_content_tpl), optString, optString2);
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
                        shareDialogConfig.addOutsideTextView(e.j.forum_friend, e.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(a.this.mPageContext.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.a.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                                l.showToast(a.this.mPageContext.getPageActivity(), view.getResources().getString(e.j.copy_pb_url_success));
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
