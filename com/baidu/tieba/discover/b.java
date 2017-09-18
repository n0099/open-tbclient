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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private QuickWebView bZC;
    private f bfY;
    private ShareFromPBMsgData bjX;
    TbPageContext<BaseFragmentActivity> mF;
    private g mRefreshView;
    private View mRootView;
    private String mUrl;
    private boolean xX;

    public b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.discover.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, b.this.bjX);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.bZC != null) {
            this.bZC.destroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(d.j.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void m(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mF = tbPageContext;
        this.bZC = (QuickWebView) this.mRootView.findViewById(d.h.webview);
        View findViewById = this.mRootView.findViewById(d.h.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        OL();
    }

    public BaseWebView OH() {
        return this.bZC;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.bZC.loadUrl(str);
    }

    public void OI() {
        if (this.xX) {
            this.bZC.loadUrl("javascript:window.reload_page()");
        } else {
            this.bZC.loadUrl(this.mUrl);
        }
    }

    public void abV() {
        if (this.bZC != null) {
            this.bZC.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void abW() {
        if (this.bZC != null) {
            this.bZC.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void ND() {
        if (this.mF != null && this.mRootView != null) {
            this.bfY = new f(this.mF.getPageActivity());
            this.bfY.c(this.mRootView, false);
            this.bfY.onChangeSkinType();
        }
    }

    public void NE() {
        if (this.bfY != null) {
            this.bfY.N(this.mRootView);
            this.bfY = null;
        }
    }

    public void OJ() {
        NH();
        this.bZC.setVisibility(0);
    }

    public void OK() {
        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mF.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.OI();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.bZC.setVisibility(8);
        this.mRefreshView.gv(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.ER();
        this.mRefreshView.eZ(this.mF.getResources().getDimensionPixelSize(d.f.ds280));
    }

    public void NH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.N(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void OL() {
        if (this.bZC != null) {
            this.bZC.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.b.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    b.this.im(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (b.this.in(str)) {
                        return true;
                    }
                    au.wd().c(b.this.mF, new String[]{str});
                    return true;
                }
            });
            this.bZC.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.b.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    b.this.ND();
                }
            });
            this.bZC.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.b.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    b.this.NE();
                    if (i.hi()) {
                        b.this.OJ();
                        b.this.xX = true;
                        b.this.abV();
                    }
                }
            });
            this.bZC.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    b.this.OK();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new ak("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean in(String str) {
        return io(str) || ip(str) || iq(str) || ir(str) || is(str) || it(str) || iu(str) || iv(str);
    }

    private boolean io(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                k.showToast(this.mF.getPageActivity(), d.l.plugin_install_fail);
                return true;
            }
            au.wd().c(this.mF, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean ip(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            au.wd().a(this.mF, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean iq(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String at = y.at(str, "topic_id=");
            String at2 = y.at(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(at) || StringUtils.isNull(at2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mF.getPageActivity()).createNormalConfig(at, at2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.f(this.mF.getPageActivity(), at2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mF.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean ir(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.mF.getPageActivity(), y.at(str, "menuname="), y.at(str, "menutype="), y.at(str, "menuid="))));
            return true;
        }
        BdToast.a(this.mF.getPageActivity(), this.mF.getPageActivity().getString(d.l.discover_forum_square_tips), 0).tw();
        return true;
    }

    private boolean is(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            k.showToast(this.mF.getPageActivity(), d.l.plugin_install_fail);
            return true;
        }
        au.wd().c(this.mF, new String[]{str});
        return true;
    }

    private boolean it(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            k.showToast(this.mF.getPageActivity(), d.l.plugin_install_fail);
            return true;
        }
        au.wd().c(this.mF, new String[]{str});
        return true;
    }

    private boolean iu(String str) {
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
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean iv(String str) {
        if (str.contains("share:")) {
            String aO = j.aO(str);
            if (aO.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(aO.substring("data=".length() + aO.indexOf("data=")));
                    String optString = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (ax.aU(this.mF.getPageActivity())) {
                        this.bjX = new ShareFromPBMsgData();
                        this.bjX.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bjX.setImageUrl(optString6);
                        }
                        this.bjX.setForumName(optString5);
                        this.bjX.setThreadId(optString4);
                        this.bjX.setTitle(optString);
                        String format = MessageFormat.format(this.mF.getResources().getString(d.l.share_content_tpl), optString, optString2);
                        final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                        dVar.title = optString;
                        dVar.content = format;
                        dVar.linkUrl = optString3;
                        dVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            dVar.auz = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mF.getPageActivity(), dVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.mF.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                                k.showToast(b.this.mF.getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            }
                        });
                        this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
