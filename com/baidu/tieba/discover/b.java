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
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean Ae;
    private f bfY;
    private ShareFromPBMsgData bjH;
    private g mRefreshView;
    private View mRootView;
    private String mUrl;
    private BaseWebView mWebView;
    TbPageContext<BaseFragmentActivity> oV;

    public b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.discover.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage != null) {
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, b.this.bjH);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(d.j.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void m(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.oV = tbPageContext;
        this.mWebView = (BaseWebView) this.mRootView.findViewById(d.h.webview);
        this.mWebView.initCommonJsBridge(tbPageContext);
        View findViewById = this.mRootView.findViewById(d.h.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        Ot();
    }

    public BaseWebView Op() {
        return this.mWebView;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.mWebView.loadUrl(str);
    }

    public void Oq() {
        if (this.Ae) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    public void aaK() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void aaL() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void Nm() {
        if (this.oV != null && this.mRootView != null) {
            this.bfY = new f(this.oV.getPageActivity());
            this.bfY.c(this.mRootView, false);
            this.bfY.onChangeSkinType();
        }
    }

    public void Nn() {
        if (this.bfY != null) {
            this.bfY.I(this.mRootView);
            this.bfY = null;
        }
    }

    public void Or() {
        Nq();
        this.mWebView.setVisibility(0);
    }

    public void Os() {
        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.oV.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.Oq();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.gv(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.ET();
        this.mRefreshView.eZ(this.oV.getResources().getDimensionPixelSize(d.f.ds280));
    }

    public void Nq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.I(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void Ot() {
        if (this.mWebView != null) {
            this.mWebView.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.b.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    b.this.ih(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (b.this.ii(str)) {
                        return true;
                    }
                    at.wf().c(b.this.oV, new String[]{str});
                    return true;
                }
            });
            this.mWebView.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.b.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void a(WebView webView, String str) {
                    b.this.Nm();
                }
            });
            this.mWebView.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.b.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    b.this.Nn();
                    if (i.hr()) {
                        b.this.Or();
                        b.this.Ae = true;
                        b.this.aaK();
                    }
                }
            });
            this.mWebView.setOnReceivedErrorListener(new BaseWebView.e() { // from class: com.baidu.tieba.discover.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    b.this.Os();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new aj("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ii(String str) {
        return ij(str) || ik(str) || il(str) || im(str) || in(str) || io(str) || ip(str) || iq(str);
    }

    private boolean ij(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                k.showToast(this.oV.getPageActivity(), d.l.plugin_install_fail);
                return true;
            }
            at.wf().c(this.oV, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean ik(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                k.showToast(this.oV.getPageActivity(), d.l.plugin_install_fail);
            } else {
                at.wf().c(this.oV, new String[]{str});
            }
            return true;
        }
        return false;
    }

    private boolean il(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String aq = y.aq(str, "topic_id=");
            String aq2 = y.aq(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(aq) || StringUtils.isNull(aq2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.oV.getPageActivity()).createNormalConfig(aq, aq2, null)));
                return true;
            }
            com.baidu.tbadk.browser.a.e(this.oV.getPageActivity(), aq2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.oV.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean im(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.oV.getPageActivity(), y.aq(str, "menuname="), y.aq(str, "menutype="), y.aq(str, "menuid="))));
            return true;
        }
        BdToast.a(this.oV.getPageActivity(), this.oV.getPageActivity().getString(d.l.discover_forum_square_tips), 0).tz();
        return true;
    }

    private boolean in(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            k.showToast(this.oV.getPageActivity(), d.l.plugin_install_fail);
            return true;
        }
        at.wf().c(this.oV, new String[]{str});
        return true;
    }

    private boolean io(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            k.showToast(this.oV.getPageActivity(), d.l.plugin_install_fail);
            return true;
        }
        at.wf().c(this.oV, new String[]{str});
        return true;
    }

    private boolean ip(String str) {
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
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.oV.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean iq(String str) {
        if (str.contains("share:")) {
            String aR = j.aR(str);
            if (aR.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(aR.substring("data=".length() + aR.indexOf("data=")));
                    String optString = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (aw.aO(this.oV.getPageActivity())) {
                        this.bjH = new ShareFromPBMsgData();
                        this.bjH.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bjH.setImageUrl(optString6);
                        }
                        this.bjH.setForumName(optString5);
                        this.bjH.setThreadId(optString4);
                        this.bjH.setTitle(optString);
                        String format = MessageFormat.format(this.oV.getResources().getString(d.l.share_content_tpl), optString, optString5, optString2);
                        final e eVar = new e();
                        eVar.title = optString;
                        eVar.content = format;
                        eVar.linkUrl = optString3;
                        eVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            eVar.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.oV.getPageActivity(), eVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.oV.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aB(eVar.linkUrl);
                                k.showToast(b.this.oV.getPageActivity(), view.getResources().getString(d.l.copy_pb_url_success));
                            }
                        });
                        this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
