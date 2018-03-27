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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import com.baidu.tieba.quickWebView.QuickWebView;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private boolean amf;
    private f bXd;
    private ShareFromPBMsgData cln;
    private QuickWebView dml;
    TbPageContext<BaseFragmentActivity> mPageContext;
    private g mRefreshView;
    private View mRootView;
    private String mUrl;

    public b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921015, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.discover.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921015, b.this.cln);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void onDestroy() {
        if (this.dml != null) {
            this.dml.destroy();
        }
        MessageManager.getInstance().unRegisterTask(2921015);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(d.h.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void i(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dml = (QuickWebView) this.mRootView.findViewById(d.g.webview);
        View findViewById = this.mRootView.findViewById(d.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        YW();
    }

    public BaseWebView YT() {
        return this.dml;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.dml.loadUrl(str);
    }

    public void YU() {
        if (this.amf) {
            this.dml.loadUrl("javascript:window.reload_page()");
        } else {
            this.dml.loadUrl(this.mUrl);
        }
    }

    public void apt() {
        if (this.dml != null) {
            this.dml.loadUrl("javascript:__js_bridge_discovery_enter_action()");
        }
    }

    public void apu() {
        if (this.dml != null) {
            this.dml.loadUrl("javascript:__js_bridge_discovery_leave_action()");
        }
    }

    public void VU() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.bXd = new f(this.mPageContext.getPageActivity());
            this.bXd.j(this.mRootView, false);
            this.bXd.onChangeSkinType();
        }
    }

    public void VV() {
        if (this.bXd != null) {
            this.bXd.bk(this.mRootView);
            this.bXd = null;
        }
    }

    public void YV() {
        XN();
        this.dml.setVisibility(0);
    }

    public void XM() {
        String string = TbadkCoreApplication.getInst().getString(d.j.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.YU();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        this.dml.setVisibility(8);
        this.mRefreshView.gW(string);
        this.mRefreshView.j(this.mRootView, false);
        this.mRefreshView.MR();
        this.mRefreshView.ib(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds280));
    }

    public void XN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.bk(this.mRootView);
            this.mRefreshView = null;
        }
    }

    private void YW() {
        if (this.dml != null) {
            this.dml.setOnLoadUrlListener(new BaseWebView.b() { // from class: com.baidu.tieba.discover.b.3
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    b.this.iV(str);
                    if (StringUtils.isNull(str) || str.contains("jump_webview_type=2")) {
                        return false;
                    }
                    if (b.this.iW(str)) {
                        return true;
                    }
                    aw.Du().c(b.this.mPageContext, new String[]{str});
                    return true;
                }
            });
            this.dml.setOnPageStartedListener(new BaseWebView.d() { // from class: com.baidu.tieba.discover.b.4
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
                public void b(WebView webView, String str) {
                    b.this.VU();
                }
            });
            this.dml.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.discover.b.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str) {
                    b.this.VV();
                    if (j.oJ()) {
                        b.this.YV();
                        b.this.amf = true;
                        b.this.apt();
                    }
                }
            });
            this.dml.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.discover.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    b.this.XM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new ak("c10378").s("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iW(String str) {
        return iX(str) || iY(str) || iZ(str) || ja(str) || jb(str) || jc(str) || jd(str) || je(str);
    }

    private boolean iX(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_install_fail);
                return true;
            }
            aw.Du().c(this.mPageContext, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean iY(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            aw.Du().a(this.mPageContext, new String[]{"http://dushu.m.baidu.com/?from=tieba&jump=open_full_screen_web_page&nonavigationbar=1"}, true);
            return true;
        }
        return false;
    }

    private boolean iZ(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ar = z.ar(str, "topic_id=");
            String ar2 = z.ar(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(ar) || StringUtils.isNull(ar2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.mPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(ar, ar2, null)));
                return true;
            }
            com.baidu.tbadk.browser.b.g(this.mPageContext.getPageActivity(), ar2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith(TbConfig.URL_HOST_TOPIC_LIST)) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean ja(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(2902025) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.mPageContext.getPageActivity(), z.ar(str, "menuname="), z.ar(str, "menutype="), z.ar(str, "menuid="))));
            return true;
        }
        BdToast.a(this.mPageContext.getPageActivity(), this.mPageContext.getPageActivity().getString(d.j.discover_forum_square_tips), 0).Bd();
        return true;
    }

    private boolean jb(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_install_fail);
            return true;
        }
        aw.Du().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean jc(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_install_fail);
            return true;
        }
        aw.Du().c(this.mPageContext, new String[]{str});
        return true;
    }

    private boolean jd(String str) {
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

    private boolean je(String str) {
        if (str.contains("share:")) {
            String aW = k.aW(str);
            if (aW.contains("data=")) {
                try {
                    JSONObject jSONObject = new JSONObject(aW.substring("data=".length() + aW.indexOf("data=")));
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (ay.ba(this.mPageContext.getPageActivity())) {
                        this.cln = new ShareFromPBMsgData();
                        this.cln.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.cln.setImageUrl(optString6);
                        }
                        this.cln.setForumName(optString5);
                        this.cln.setThreadId(optString4);
                        this.cln.setTitle(optString);
                        String format = MessageFormat.format(this.mPageContext.getResources().getString(d.j.share_content_tpl), optString, optString2);
                        final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                        dVar.title = optString;
                        dVar.content = format;
                        dVar.linkUrl = optString3;
                        dVar.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            dVar.blr = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mPageContext.getPageActivity(), dVar, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(d.j.forum_friend, d.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.7
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(b.this.mPageContext.getPageActivity(), 23007, 1)));
                            }
                        });
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.discover.b.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aE(dVar.linkUrl);
                                l.showToast(b.this.mPageContext.getPageActivity(), view.getResources().getString(d.j.copy_pb_url_success));
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
