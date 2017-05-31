package com.baidu.tieba.discover;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.w;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    TbPageContext<BaseFragmentActivity> ajh;
    private ShareFromPBMsgData bJo;
    private com.baidu.tbadk.i.f baZ;
    private com.baidu.tbadk.i.h mRefreshView;
    private View mRootView;
    private String mUrl;
    private BaseWebView mWebView;
    private boolean yB;

    public d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new e(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(w.j.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void m(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.ajh = tbPageContext;
        this.mWebView = (BaseWebView) this.mRootView.findViewById(w.h.webview);
        View findViewById = this.mRootView.findViewById(w.h.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.mWebView.setWebViewClient(new a(this, null));
    }

    public BaseWebView Tj() {
        return this.mWebView;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.mWebView.loadUrl(str);
    }

    public void Wf() {
        if (this.yB) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    public void Mt() {
        if (this.ajh != null && this.mRootView != null) {
            this.baZ = new com.baidu.tbadk.i.f(this.ajh.getPageActivity());
            this.baZ.c(this.mRootView, false);
            this.baZ.onChangeSkinType();
        }
    }

    public void Mu() {
        if (this.baZ != null) {
            this.baZ.H(this.mRootView);
            this.baZ = null;
        }
    }

    public void Tk() {
        Mx();
        this.mWebView.setVisibility(0);
    }

    public void Wg() {
        String string = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.i.h(this.ajh.getPageActivity(), new f(this));
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.fP(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.DY();
        this.mRefreshView.eS(this.ajh.getResources().getDimensionPixelSize(w.f.ds280));
    }

    public void Mx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.H(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(d dVar, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.this.in(str);
            if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (d.this.io(str)) {
                return true;
            }
            bb.vy().c(d.this.ajh, new String[]{str});
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            d.this.Mt();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.Mu();
            if (i.hk()) {
                d.this.Tk();
                d.this.yB = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            d.this.Wg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new as("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean io(String str) {
        return ip(str) || iq(str) || ir(str) || is(str) || it(str) || iu(str) || iv(str) || iw(str);
    }

    private boolean ip(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                k.showToast(this.ajh.getPageActivity(), w.l.plugin_install_fail);
                return true;
            }
            bb.vy().c(this.ajh, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean iq(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                k.showToast(this.ajh.getPageActivity(), w.l.plugin_install_fail);
            } else {
                bb.vy().c(this.ajh, new String[]{str});
            }
            return true;
        }
        return false;
    }

    private boolean ir(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String aq = aa.aq(str, "topic_id=");
            String aq2 = aa.aq(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(aq) || StringUtils.isNull(aq2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.ajh.getPageActivity()).createNormalConfig(aq, aq2, null)));
                return true;
            }
            com.baidu.tbadk.browser.f.e(this.ajh.getPageActivity(), aq2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.ajh.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean is(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.ajh.getPageActivity(), aa.aq(str, "menuname="), aa.aq(str, "menutype="), aa.aq(str, "menuid="))));
            return true;
        }
        BdToast.a(this.ajh.getPageActivity(), this.ajh.getPageActivity().getString(w.l.discover_forum_square_tips), 0).tk();
        return true;
    }

    private boolean it(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            k.showToast(this.ajh.getPageActivity(), w.l.plugin_install_fail);
            return true;
        }
        bb.vy().c(this.ajh, new String[]{str});
        return true;
    }

    private boolean iu(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            k.showToast(this.ajh.getPageActivity(), w.l.plugin_install_fail);
            return true;
        }
        bb.vy().c(this.ajh, new String[]{str});
        return true;
    }

    private boolean iv(String str) {
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
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.ajh.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean iw(String str) {
        if (str.contains("share:")) {
            String aE = j.aE(str);
            if (aE.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(aE.substring("data=".length() + aE.indexOf("data=")));
                    String optString = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (bh.aN(this.ajh.getPageActivity())) {
                        this.bJo = new ShareFromPBMsgData();
                        this.bJo.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bJo.setImageUrl(optString6);
                        }
                        this.bJo.setForumName(optString5);
                        this.bJo.setThreadId(optString4);
                        this.bJo.setTitle(optString);
                        String format = MessageFormat.format(this.ajh.getResources().getString(w.l.share_content_tpl), optString, optString5, optString2);
                        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
                        hVar.title = optString;
                        hVar.content = format;
                        hVar.linkUrl = optString3;
                        hVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            hVar.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.ajh.getPageActivity(), hVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new g(this));
                        shareDialogConfig.setCopyLinkListener(new h(this, hVar));
                        this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
