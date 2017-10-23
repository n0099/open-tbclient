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
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private QuickWebView bZn;
    private f bhx;
    private ShareFromPBMsgData blu;
    TbPageContext<BaseFragmentActivity> mH;
    private g mRefreshView;
    private View mRootView;
    private String mUrl;
    private boolean ya;

    public b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.discover.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, b.this.blu);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.bZn != null) {
            this.bZn.destroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(d.j.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void j(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mH = tbPageContext;
        this.bZn = (QuickWebView) this.mRootView.findViewById(d.h.webview);
        View findViewById = this.mRootView.findViewById(d.h.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        Pa();
    }

    public BaseWebView OW() {
        return this.bZn;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.bZn.loadUrl(str);
    }

    public void OX() {
        if (this.ya) {
            this.bZn.loadUrl("javascript:window.reload_page()");
        } else {
            this.bZn.loadUrl(this.mUrl);
        }
    }

    public void abE() {
        if (this.bZn != null) {
            this.bZn.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void abF() {
        if (this.bZn != null) {
            this.bZn.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void NS() {
        if (this.mH != null && this.mRootView != null) {
            this.bhx = new f(this.mH.getPageActivity());
            this.bhx.c(this.mRootView, false);
            this.bhx.onChangeSkinType();
        }
    }

    public void NT() {
        if (this.bhx != null) {
            this.bhx.O(this.mRootView);
            this.bhx = null;
        }
    }

    public void OY() {
        NW();
        this.bZn.setVisibility(0);
    }

    public void OZ() {
        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mH.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.OX();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.bZn.setVisibility(8);
        this.mRefreshView.gq(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.Eq();
        this.mRefreshView.fj(this.mH.getResources().getDimensionPixelSize(d.f.ds280));
    }

    public void NW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.O(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void Pa() {
        if (this.bZn != null) {
            this.bZn.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.b.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    b.this.ig(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (b.this.ih(str)) {
                        return true;
                    }
                    av.vA().c(b.this.mH, new String[]{str});
                    return true;
                }
            });
            this.bZn.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.b.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    b.this.NS();
                }
            });
            this.bZn.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.b.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    b.this.NT();
                    if (j.hh()) {
                        b.this.OY();
                        b.this.ya = true;
                        b.this.abE();
                    }
                }
            });
            this.bZn.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    b.this.OZ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new ak("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ih(String str) {
        return ii(str) || ij(str) || ik(str) || il(str) || im(str) || in(str) || io(str) || ip(str);
    }

    private boolean ii(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                l.showToast(this.mH.getPageActivity(), d.l.plugin_install_fail);
                return true;
            }
            av.vA().c(this.mH, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean ij(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            av.vA().a(this.mH, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean ik(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String as = x.as(str, "topic_id=");
            String as2 = x.as(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(as) || StringUtils.isNull(as2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.mH.getPageActivity()).createNormalConfig(as, as2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.f(this.mH.getPageActivity(), as2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mH.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean il(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.mH.getPageActivity(), x.as(str, "menuname="), x.as(str, "menutype="), x.as(str, "menuid="))));
            return true;
        }
        BdToast.a(this.mH.getPageActivity(), this.mH.getPageActivity().getString(d.l.discover_forum_square_tips), 0).tj();
        return true;
    }

    private boolean im(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.mH.getPageActivity(), d.l.plugin_install_fail);
            return true;
        }
        av.vA().c(this.mH, new String[]{str});
        return true;
    }

    private boolean in(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.mH.getPageActivity(), d.l.plugin_install_fail);
            return true;
        }
        av.vA().c(this.mH, new String[]{str});
        return true;
    }

    private boolean io(String str) {
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
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.mH.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean ip(String str) {
        if (str.contains("share:")) {
            String aO = k.aO(str);
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
                    if (ax.aT(this.mH.getPageActivity())) {
                        this.blu = new ShareFromPBMsgData();
                        this.blu.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.blu.setImageUrl(optString6);
                        }
                        this.blu.setForumName(optString5);
                        this.blu.setThreadId(optString4);
                        this.blu.setTitle(optString);
                        String format = MessageFormat.format(this.mH.getResources().getString(d.l.share_content_tpl), optString, optString2);
                        final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
                        dVar.title = optString;
                        dVar.content = format;
                        dVar.linkUrl = optString3;
                        dVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            dVar.atv = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mH.getPageActivity(), dVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.mH.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                                l.showToast(b.this.mH.getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            }
                        });
                        this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
