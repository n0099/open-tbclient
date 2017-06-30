package com.baidu.tieba.discover;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.w;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    TbPageContext<BaseFragmentActivity> ajP;
    private ShareFromPBMsgData bPM;
    private com.baidu.tbadk.i.f bdc;
    private com.baidu.tbadk.i.h mRefreshView;
    private View mRootView;
    private String mUrl;
    private BaseWebView mWebView;
    private boolean yB;

    public e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, new f(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(w.j.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void m(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.ajP = tbPageContext;
        this.mWebView = (BaseWebView) this.mRootView.findViewById(w.h.webview);
        View findViewById = this.mRootView.findViewById(w.h.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ZC();
    }

    public BaseWebView UL() {
        return this.mWebView;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.mWebView.loadUrl(str);
    }

    public void UZ() {
        if (this.yB) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    public void Nl() {
        if (this.ajP != null && this.mRootView != null) {
            this.bdc = new com.baidu.tbadk.i.f(this.ajP.getPageActivity());
            this.bdc.c(this.mRootView, false);
            this.bdc.onChangeSkinType();
        }
    }

    public void Nm() {
        if (this.bdc != null) {
            this.bdc.I(this.mRootView);
            this.bdc = null;
        }
    }

    public void UM() {
        Np();
        this.mWebView.setVisibility(0);
    }

    public void Va() {
        String string = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.i.h(this.ajP.getPageActivity(), new g(this));
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.gk(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.Ev();
        this.mRefreshView.eU(this.ajP.getResources().getDimensionPixelSize(w.f.ds280));
    }

    public void Np() {
        if (this.mRefreshView != null) {
            this.mRefreshView.I(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void ZC() {
        if (this.mWebView != null) {
            this.mWebView.setOnLoadUrlListener(new h(this));
            this.mWebView.setOnPageStartedListener(new i(this));
            this.mWebView.setOnPageFinishedListener(new j(this));
            this.mWebView.setOnReceivedErrorListener(new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new au("c10378").r("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ja(String str) {
        return jb(str) || jc(str) || jd(str) || je(str) || jf(str) || jg(str) || jh(str) || ji(str);
    }

    private boolean jb(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_install_fail);
                return true;
            }
            be.vP().c(this.ajP, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean jc(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_install_fail);
            } else {
                be.vP().c(this.ajP, new String[]{str});
            }
            return true;
        }
        return false;
    }

    private boolean jd(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String aq = ab.aq(str, "topic_id=");
            String aq2 = ab.aq(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(aq) || StringUtils.isNull(aq2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.ajP.getPageActivity()).createNormalConfig(aq, aq2, null)));
                return true;
            }
            com.baidu.tbadk.browser.g.e(this.ajP.getPageActivity(), aq2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.ajP.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean je(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.ajP.getPageActivity(), ab.aq(str, "menuname="), ab.aq(str, "menutype="), ab.aq(str, "menuid="))));
            return true;
        }
        BdToast.a(this.ajP.getPageActivity(), this.ajP.getPageActivity().getString(w.l.discover_forum_square_tips), 0).ti();
        return true;
    }

    private boolean jf(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_install_fail);
            return true;
        }
        be.vP().c(this.ajP, new String[]{str});
        return true;
    }

    private boolean jg(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_install_fail);
            return true;
        }
        be.vP().c(this.ajP, new String[]{str});
        return true;
    }

    private boolean jh(String str) {
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
                    ImageViewerConfig createConfig = new ImageViewerConfig(this.ajP.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, arrayList.get(0), true);
                    createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                    this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    return true;
                }
                return false;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private boolean ji(String str) {
        if (str.contains("share:")) {
            String aJ = com.baidu.adp.lib.util.j.aJ(str);
            if (aJ.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(aJ.substring("data=".length() + aJ.indexOf("data=")));
                    String optString = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (bl.aN(this.ajP.getPageActivity())) {
                        this.bPM = new ShareFromPBMsgData();
                        this.bPM.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.bPM.setImageUrl(optString6);
                        }
                        this.bPM.setForumName(optString5);
                        this.bPM.setThreadId(optString4);
                        this.bPM.setTitle(optString);
                        String format = MessageFormat.format(this.ajP.getResources().getString(w.l.share_content_tpl), optString, optString5, optString2);
                        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
                        hVar.title = optString;
                        hVar.content = format;
                        hVar.linkUrl = optString3;
                        hVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            hVar.imageUri = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.ajP.getPageActivity(), hVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new l(this));
                        shareDialogConfig.setCopyLinkListener(new m(this, hVar));
                        this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
