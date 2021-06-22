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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.n0.r.s.a;
import d.a.o0.e3.w;
import d.a.o0.m0.u;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonEmotionCenterFragment extends BaseFragment {

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f14906f;

    /* renamed from: g  reason: collision with root package name */
    public NewFaceGroupDownloadModel f14907g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f14908h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.d0.g f14909i;
    public d.a.n0.d0.h j;
    public boolean k;
    public Handler l;

    /* renamed from: e  reason: collision with root package name */
    public String f14905e = null;
    public CustomMessageListener m = new i(2921054);
    public CustomMessageListener n = new j(2001266);
    public CustomMessageListener o = new k(2921062);
    public CustomMessageListener p = new l(2921040);

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f14910e;

        public a(JSONObject jSONObject) {
            this.f14910e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.f14910e.optString("id").split(",")));
            for (String str : arrayList) {
                d.a.o0.m0.g.k().h(str);
            }
            if (d.a.o0.z1.c.i().c(arrayList, true)) {
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_del_action(1)");
            } else {
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_del_action(0)");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f14912e;

        public b(ShareItem shareItem) {
            this.f14912e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f14912e.t);
            d.a.c.e.p.l.M(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.a.o0.z1.c.i().f();
            if (f2 == null || f2.isEmpty()) {
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_has_action()");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (MyEmotionGroupData myEmotionGroupData : f2) {
                if (myEmotionGroupData != null) {
                    sb.append(myEmotionGroupData.getGroupId());
                    sb.append(",");
                }
            }
            CommonEmotionCenterFragment commonEmotionCenterFragment = CommonEmotionCenterFragment.this;
            commonEmotionCenterFragment.X0("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_show_dialog(1)");
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f14918e;

        public g(JSONObject jSONObject) {
            this.f14918e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.z1.c.i().j(new ArrayList(Arrays.asList(this.f14918e.optString("id").split(","))), true);
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_sort_action()");
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.a.o0.z1.e.b {
        public h() {
        }

        @Override // d.a.o0.z1.e.b
        public void onFail(String str) {
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_save_action(0)");
        }

        @Override // d.a.o0.z1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.o0.z1.e.b
        public void onSuccess(String str) {
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_save_action(1)");
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_refresh_has_action()");
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && ((w) customResponsedMessage.getData()).l() == 1) {
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof EmotionPackageData)) {
                return;
            }
            EmotionPackageData emotionPackageData = (EmotionPackageData) customResponsedMessage.getData();
            if (emotionPackageData.has_vote != 0 || emotionPackageData.id <= 0) {
                return;
            }
            CommonEmotionCenterFragment commonEmotionCenterFragment = CommonEmotionCenterFragment.this;
            commonEmotionCenterFragment.X0("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            HashMap hashMap = (HashMap) customResponsedMessage.getData();
            String str = null;
            if (hashMap == null || hashMap.isEmpty()) {
                CommonEmotionCenterFragment.this.W0(0, null);
            } else if (!hashMap.containsKey("upload_result")) {
                CommonEmotionCenterFragment.this.W0(0, null);
            } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                CommonEmotionCenterFragment.this.W0(0, null);
            } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                BdToast.c(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), CommonEmotionCenterFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                CommonEmotionCenterFragment.this.W0(1, null);
            } else {
                if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                    str = (String) hashMap.get("upload_msg");
                }
                CommonEmotionCenterFragment.this.W0(0, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonEmotionCenterFragment.this.b1();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f14926e;

        public n(String str) {
            this.f14926e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonEmotionCenterFragment.this.f14906f != null) {
                CommonEmotionCenterFragment.this.f14906f.loadUrl(this.f14926e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.a.o0.z1.e.b {
        public o() {
        }

        @Override // d.a.o0.z1.e.b
        public void onFail(String str) {
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_down_process_action(-1)");
        }

        @Override // d.a.o0.z1.e.b
        public void onProgress(int i2) {
            if (i2 <= 0 || i2 >= 100) {
                return;
            }
            CommonEmotionCenterFragment commonEmotionCenterFragment = CommonEmotionCenterFragment.this;
            commonEmotionCenterFragment.X0("javascript:__js_bridge_emoticon_down_process_action(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }

        @Override // d.a.o0.z1.e.b
        public void onSuccess(String str) {
            CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_down_process_action(100)");
        }
    }

    /* loaded from: classes4.dex */
    public class p implements d.a.o0.m0.y.d.c {
        public p() {
        }

        @Override // d.a.o0.m0.y.d.c
        public void a() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), 25021)));
        }

        @Override // d.a.o0.m0.y.d.c
        public void b() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), true, 25021)));
        }
    }

    /* loaded from: classes4.dex */
    public class q extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f14930a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14931b;

        public q(LikeModel likeModel, String str) {
            this.f14930a = likeModel;
            this.f14931b = str;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (this.f14930a.getErrorCode() == 22) {
                CommonEmotionCenterFragment.this.showToast(R.string.unfollow_title);
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_attend_action(0)");
            } else if (AntiHelper.m(this.f14930a.getErrorCode(), this.f14930a.getErrorString())) {
                AntiHelper.u(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), this.f14930a.getErrorString());
            } else if (this.f14930a.getErrorCode() != 0) {
                CommonEmotionCenterFragment.this.showToast(this.f14930a.getErrorString());
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_attend_action(0)");
            } else {
                w wVar = (w) obj;
                if (wVar != null) {
                    CommonEmotionCenterFragment.this.showToast(R.string.attention_success);
                    TbadkApplication.getInst().addLikeForum(this.f14931b);
                    wVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                    CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_attend_action(1)");
                    return;
                }
                CommonEmotionCenterFragment commonEmotionCenterFragment = CommonEmotionCenterFragment.this;
                commonEmotionCenterFragment.showToast(commonEmotionCenterFragment.getPageContext().getString(R.string.neterror));
                CommonEmotionCenterFragment.this.X0("javascript:__js_bridge_emoticon_attend_action(0)");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends WebViewClient {
        public r() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (CommonEmotionCenterFragment.this.getPageContext() == null || CommonEmotionCenterFragment.this.getPageContext().getPageActivity() == null) {
                return;
            }
            CommonEmotionCenterFragment.this.o();
            if (d.a.c.e.p.j.z()) {
                CommonEmotionCenterFragment.this.h1();
                CommonEmotionCenterFragment.this.k = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (CommonEmotionCenterFragment.this.getPageContext() == null || CommonEmotionCenterFragment.this.getPageContext().getPageActivity() == null) {
                return;
            }
            CommonEmotionCenterFragment.this.f1();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (CommonEmotionCenterFragment.this.getPageContext() == null || CommonEmotionCenterFragment.this.getPageContext().getPageActivity() == null) {
                return;
            }
            CommonEmotionCenterFragment.this.g1();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int dealOneLinkWithOutJumpWebView;
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (!StringUtils.isNull(str) && CommonEmotionCenterFragment.this.getPageContext() != null && CommonEmotionCenterFragment.this.getPageContext().getPageActivity() != null) {
                if (CommonEmotionCenterFragment.this.Z0(str) || (dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(CommonEmotionCenterFragment.this.getPageContext(), new String[]{str})) == 1 || dealOneLinkWithOutJumpWebView == 0) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public /* synthetic */ r(CommonEmotionCenterFragment commonEmotionCenterFragment, i iVar) {
            this();
        }
    }

    public final void L0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return;
        }
        LikeModel likeModel = new LikeModel(getPageContext());
        likeModel.setFrom("emotion_center_follow");
        likeModel.setLoadDataCallBack(new q(likeModel, optString2));
        likeModel.L(optString2, String.valueOf(optString));
    }

    public final void M0() {
        if (d.a.o0.z1.g.e.l().r()) {
            V0(1, null);
        } else if (d.a.o0.z1.g.e.l().k() == null) {
            V0(0, null);
        } else {
            FaceGroupDraft k2 = d.a.o0.z1.g.e.l().k();
            if (!TextUtils.isEmpty(k2.getFailMsg())) {
                V0(2, k2.getFailMsg());
            } else {
                V0(2, null);
            }
        }
    }

    public final void N0(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        int optInt = jSONObject.optInt("pck_id");
        u s = u.s();
        String str = "";
        if (optInt != -1) {
            str = "" + optInt;
        }
        s.g(optString, str);
        X0("javascript:__js_bridge_emoticon_coll_action(2)");
    }

    public final void O0(JSONObject jSONObject) {
        if (d.a.o0.z1.d.m().o()) {
            X0("javascript:__js_bridge_emoticon_del_action(0)");
            d.a.c.e.p.l.L(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
        d.a.o0.z1.a.b().a(new a(jSONObject));
    }

    public final void P0(JSONObject jSONObject) {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (d.a.o0.z1.d.m().o()) {
                X0("javascript:__js_bridge_emoticon_down_process_action(-1)");
                d.a.c.e.p.l.L(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.f14907g == null) {
                this.f14907g = new NewFaceGroupDownloadModel();
            }
            this.f14907g.w(optString, Boolean.TRUE, new o());
        }
    }

    public final void Q0() {
        d.a.o0.z1.a.b().a(new c());
    }

    public final JSONObject R0(String str) {
        if (str.contains("data=")) {
            try {
                return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    public final void S0() {
        if (getArguments() == null || TextUtils.isEmpty(getArguments().getString("key_load_url"))) {
            return;
        }
        this.f14905e = getArguments().getString("key_load_url");
    }

    public final void T0(JSONObject jSONObject) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getPageContext().getPageActivity(), jSONObject.optInt("id"), 25024)));
    }

    public final void U0() {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(getPageContext().getPageActivity(), 25021)));
        }
    }

    public final void V0(int i2, String str) {
        if (!TextUtils.isEmpty(str)) {
            X0("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
            return;
        }
        X0("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
    }

    public final void W0(int i2, String str) {
        if (!TextUtils.isEmpty(str)) {
            X0("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
            return;
        }
        X0("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
    }

    public final void X0(String str) {
        if (this.f14906f != null) {
            this.l.post(new n(str));
        }
    }

    public final void Y0() {
        d.a.o0.m0.y.d.a aVar = new d.a.o0.m0.y.d.a(getPageContext().getPageActivity(), 1);
        aVar.d(new p());
        Rect rect = new Rect();
        getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        aVar.showAtLocation(this.f14908h, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
    }

    public final boolean Z0(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), str)));
                return true;
            }
            JSONObject R0 = R0(str);
            if (R0 == null) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                P0(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                O0(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                d1(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                Q0();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                e1(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                i1(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                a1(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                N0(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                c1(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                T0(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                U0();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                Y0();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                L0(R0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                M0();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void a1(JSONObject jSONObject) {
        if (d.a.o0.z1.d.m().o()) {
            X0("javascript:__js_bridge_emoticon_sort_action()");
            d.a.c.e.p.l.L(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
        d.a.o0.z1.a.b().a(new g(jSONObject));
    }

    public void b1() {
        if (this.f14906f == null) {
            return;
        }
        if (this.k) {
            X0("javascript:window.reload_page()");
        } else {
            X0(this.f14905e);
        }
    }

    public final void c1(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        d.a.o0.z1.c.i().d(optString, new h());
    }

    public final void d1(JSONObject jSONObject) {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        ShareItem shareItem = new ShareItem();
        shareItem.r = jSONObject.optString("title");
        shareItem.s = jSONObject.optString("content");
        shareItem.t = jSONObject.optString("linkUrl");
        shareItem.v = Uri.parse(jSONObject.optString("imageUri"));
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new b(shareItem));
        sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void e1(JSONObject jSONObject) {
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString(IAdRequestParam.POS);
        String optString3 = jSONObject.optString("neg");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            X0("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(optString);
        aVar.setPositiveButton(optString2, new d());
        aVar.setNegativeButton(optString3, new e());
        aVar.setOnCalcelListener(new f());
        aVar.create(getPageContext()).show();
    }

    public void f1() {
        d.a.n0.d0.g gVar = new d.a.n0.d0.g(getPageContext().getPageActivity());
        this.f14909i = gVar;
        gVar.attachView(this.f14908h, false);
        this.f14909i.onChangeSkinType();
    }

    public void g1() {
        if (getPageContext() == null || getPageContext().getPageActivity() == null) {
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.j == null) {
            d.a.n0.d0.h hVar = new d.a.n0.d0.h(getPageContext().getPageActivity(), new m());
            this.j = hVar;
            hVar.onChangeSkinType();
        }
        BaseWebView baseWebView = this.f14906f;
        if (baseWebView != null) {
            baseWebView.setVisibility(8);
        }
        this.j.l(string);
        this.j.attachView(this.f14908h, false);
        this.j.o();
        this.j.j(getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void h1() {
        d.a.n0.d0.h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this.f14908h);
            this.j = null;
        }
        BaseWebView baseWebView = this.f14906f;
        if (baseWebView != null) {
            baseWebView.setVisibility(0);
        }
    }

    public final void i1(JSONObject jSONObject) {
        String optString = jSONObject.optString("content");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        showToast(optString);
    }

    public void o() {
        d.a.n0.d0.g gVar = this.f14909i;
        if (gVar != null) {
            gVar.dettachView(this.f14908h);
            this.f14909i = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new Handler(Looper.getMainLooper());
        registerListener(this.m);
        registerListener(this.p);
        registerListener(this.n);
        registerListener(this.o);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14908h = new RelativeLayout(getPageContext().getPageActivity());
        this.f14906f = new BaseWebView(getPageContext().getPageActivity());
        this.f14906f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f14908h.addView(this.f14906f);
        this.f14906f.setWebViewClient(new r(this, null));
        d.a.n0.l.a.f(getPageContext().getPageActivity());
        S0();
        X0(this.f14905e);
        return this.f14908h;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M0();
    }
}
