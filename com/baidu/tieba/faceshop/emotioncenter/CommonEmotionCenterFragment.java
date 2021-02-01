package com.baidu.tieba.faceshop.emotioncenter;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.ab;
import com.baidu.tieba.faceshop.emotioncenter.a.c;
import com.baidu.tieba.faceshop.i;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.a.b;
import com.baidu.tieba.newfaceshop.d;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.newfaceshop.facemake.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CommonEmotionCenterFragment extends BaseFragment {
    private g gJn;
    private NewFaceGroupDownloadModel iUd;
    private boolean mLoadSuccess;
    private h mRefreshView;
    private RelativeLayout mRootView;
    private Handler mUIHandler;
    private BaseWebView mWebView;
    private String mUrl = null;
    private CustomMessageListener iXC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
        }
    };
    private CustomMessageListener iXD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && ((w) customResponsedMessage.getData()).isLike() == 1) {
                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    };
    private CustomMessageListener iXE = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS) { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof EmotionPackageData)) {
                EmotionPackageData emotionPackageData = (EmotionPackageData) customResponsedMessage.getData();
                if (emotionPackageData.has_vote == 0 && emotionPackageData.id > 0) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + ")");
                }
            }
        }
    };
    CustomMessageListener iXF = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    CommonEmotionCenterFragment.this.by(0, null);
                } else if (!hashMap.containsKey("upload_result")) {
                    CommonEmotionCenterFragment.this.by(0, null);
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    CommonEmotionCenterFragment.this.by(0, null);
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    CommonEmotionCenterFragment.this.by(0, (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) ? (String) hashMap.get("upload_msg") : null);
                } else {
                    BdToast.b(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), CommonEmotionCenterFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).bqD();
                    CommonEmotionCenterFragment.this.by(1, null);
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        registerListener(this.iXC);
        registerListener(this.iXF);
        registerListener(this.iXD);
        registerListener(this.iXE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.mWebView = new BaseWebView(getPageContext().getPageActivity());
        this.mWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.mWebView);
        this.mWebView.setWebViewClient(new a());
        com.baidu.tbadk.browser.a.initCookie(getPageContext().getPageActivity());
        czL();
        loadUrl(this.mUrl);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        czM();
    }

    public void showLoadingView() {
        this.gJn = new g(getPageContext().getPageActivity());
        this.gJn.attachView(this.mRootView, false);
        this.gJn.onChangeSkinType();
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
            this.gJn = null;
        }
    }

    public void bTS() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        if (this.mWebView != null) {
            this.mWebView.setVisibility(0);
        }
    }

    public void bRu() {
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CommonEmotionCenterFragment.this.bVo();
                    }
                });
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mWebView != null) {
                this.mWebView.setVisibility(8);
            }
            this.mRefreshView.setSubText(string);
            this.mRefreshView.attachView(this.mRootView, false);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.setLayoutMargin(getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds280));
        }
    }

    private void czL() {
        if (getArguments() != null && !TextUtils.isEmpty(getArguments().getString("key_load_url"))) {
            this.mUrl = getArguments().getString("key_load_url");
        }
    }

    public void bVo() {
        if (this.mWebView != null) {
            if (this.mLoadSuccess) {
                loadUrl("javascript:window.reload_page()");
            } else {
                loadUrl(this.mUrl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl(final String str) {
        if (this.mWebView != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.14
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonEmotionCenterFragment.this.mWebView != null) {
                        CommonEmotionCenterFragment.this.mWebView.loadUrl(str);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }

    /* loaded from: classes9.dex */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int a2;
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (!StringUtils.isNull(str) && CommonEmotionCenterFragment.this.getPageContext() != null && CommonEmotionCenterFragment.this.getPageContext().getPageActivity() != null) {
                if (CommonEmotionCenterFragment.this.JR(str) || (a2 = bf.bsV().a(CommonEmotionCenterFragment.this.getPageContext(), new String[]{str})) == 1 || a2 == 0) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (CommonEmotionCenterFragment.this.getPageContext() != null && CommonEmotionCenterFragment.this.getPageContext().getPageActivity() != null) {
                CommonEmotionCenterFragment.this.showLoadingView();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (CommonEmotionCenterFragment.this.getPageContext() != null && CommonEmotionCenterFragment.this.getPageContext().getPageActivity() != null) {
                CommonEmotionCenterFragment.this.hideLoadingView();
                if (j.isNetWorkAvailable()) {
                    CommonEmotionCenterFragment.this.bTS();
                    CommonEmotionCenterFragment.this.mLoadSuccess = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (CommonEmotionCenterFragment.this.getPageContext() != null && CommonEmotionCenterFragment.this.getPageContext().getPageActivity() != null) {
                CommonEmotionCenterFragment.this.bRu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i + "','" + str + "')");
        } else {
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i + "')");
        }
    }

    private void bz(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i + "','" + str + "')");
        } else {
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i + "')");
        }
    }

    private void czM() {
        if (e.diD().diF()) {
            bz(1, null);
        } else if (e.diD().diE() == null) {
            bz(0, null);
        } else {
            FaceGroupDraft diE = e.diD().diE();
            if (!TextUtils.isEmpty(diE.getFailMsg())) {
                bz(2, diE.getFailMsg());
            } else {
                bz(2, null);
            }
        }
    }

    private void ej(JSONObject jSONObject) {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (d.dip().dis()) {
                loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                l.showToast(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.iUd == null) {
                this.iUd = new NewFaceGroupDownloadModel();
            }
            this.iUd.a(optString, true, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.15
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(100)");
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                    if (i > 0 && i < 100) {
                        CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(" + i + ")");
                    }
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JR(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), str)));
                return true;
            }
            JSONObject JS = JS(str);
            if (JS != null) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                    ej(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                    el(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                    em(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                    czO();
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                    en(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                    showToast(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                    eo(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                    ep(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                    eq(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                    er(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                    czP();
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                    czN();
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                    ek(JS);
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                    czM();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void czN() {
        com.baidu.tieba.faceshop.emotioncenter.a.a aVar = new com.baidu.tieba.faceshop.emotioncenter.a.a(getPageContext().getPageActivity(), 1);
        aVar.a(new c() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.16
            @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
            public void czQ() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
            }

            @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
            public void czR() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
            }
        });
        Rect rect = new Rect();
        getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        aVar.showAtLocation(this.mRootView, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
    }

    private void ek(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("forum_id");
            final String optString2 = jSONObject.optString("forum_name");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                final LikeModel likeModel = new LikeModel(getPageContext());
                likeModel.setFrom("emotion_center_follow");
                likeModel.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.17
                    @Override // com.baidu.adp.base.e
                    public void callback(Object obj) {
                        if (likeModel.getErrorCode() == 22) {
                            CommonEmotionCenterFragment.this.showToast(R.string.unfollow_title);
                            CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                        } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                            AntiHelper.br(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), likeModel.getErrorString());
                        } else if (likeModel.getErrorCode() != 0) {
                            CommonEmotionCenterFragment.this.showToast(likeModel.getErrorString());
                            CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                        } else {
                            w wVar = (w) obj;
                            if (wVar != null) {
                                CommonEmotionCenterFragment.this.showToast(R.string.attention_success);
                                TbadkApplication.getInst().addLikeForum(optString2);
                                wVar.setLike(1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
                                return;
                            }
                            CommonEmotionCenterFragment.this.showToast(CommonEmotionCenterFragment.this.getPageContext().getString(R.string.neterror));
                            CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                        }
                    }
                });
                likeModel.gw(optString2, String.valueOf(optString));
            }
        }
    }

    private JSONObject JS(String str) {
        if (str.contains("data=")) {
            try {
                return new JSONObject(str.substring("data=".length() + str.indexOf("data=")).replaceAll("\\\\", ""));
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    private void el(final JSONObject jSONObject) {
        if (d.dip().dis()) {
            loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
            l.showToast(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<String> arrayList = new ArrayList(Arrays.asList(jSONObject.optString("id").split(",")));
                for (String str : arrayList) {
                    i.cyE().JD(str);
                }
                if (com.baidu.tieba.newfaceshop.c.dil().v(arrayList, true)) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        });
    }

    private void em(JSONObject jSONObject) {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        final ShareItem shareItem = new ShareItem();
        shareItem.title = jSONObject.optString("title");
        shareItem.content = jSONObject.optString("content");
        shareItem.linkUrl = jSONObject.optString("linkUrl");
        shareItem.imageUri = Uri.parse(jSONObject.optString("imageUri"));
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                l.showToast(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        });
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
    }

    private void czO() {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.4
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dim = com.baidu.tieba.newfaceshop.c.dil().dim();
                if (dim == null || dim.isEmpty()) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_has_action()");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (MyEmotionGroupData myEmotionGroupData : dim) {
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        sb.append(",");
                    }
                }
                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        });
    }

    private void en(JSONObject jSONObject) {
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("pos");
        String optString3 = jSONObject.optString("neg");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Au(optString);
        aVar.a(optString2, new a.b() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        });
        aVar.b(optString3, new a.b() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        });
        aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        });
        aVar.b(getPageContext()).bqx();
    }

    private void showToast(JSONObject jSONObject) {
        String optString = jSONObject.optString("content");
        if (!TextUtils.isEmpty(optString)) {
            showToast(optString);
        }
    }

    private void eo(final JSONObject jSONObject) {
        if (d.dip().dis()) {
            loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            l.showToast(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tieba.newfaceshop.c.dil().w(new ArrayList(Arrays.asList(jSONObject.optString("id").split(","))), true);
                CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            }
        });
    }

    private void ep(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        int optInt = jSONObject.optInt("pck_id");
        ab.czG().eU(optString, optInt == -1 ? "" : "" + optInt);
        loadUrl("javascript:__js_bridge_emoticon_coll_action(2)");
    }

    private void eq(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (!TextUtils.isEmpty(optString)) {
            com.baidu.tieba.newfaceshop.c.dil().a(optString, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.CommonEmotionCenterFragment.9
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_save_action(1)");
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    CommonEmotionCenterFragment.this.loadUrl("javascript:__js_bridge_emoticon_save_action(0)");
                }
            });
        }
    }

    private void er(JSONObject jSONObject) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(getPageContext().getPageActivity(), jSONObject.optInt("id"), RequestResponseCode.REQUEST_EMOTION_DETAIL)));
    }

    private void czP() {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }
}
