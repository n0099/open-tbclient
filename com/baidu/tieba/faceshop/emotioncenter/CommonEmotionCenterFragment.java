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
import d.b.h0.r.s.a;
import d.b.i0.c3.w;
import d.b.i0.l0.u;
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
    public BaseWebView f15726f;

    /* renamed from: g  reason: collision with root package name */
    public NewFaceGroupDownloadModel f15727g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f15728h;
    public d.b.h0.d0.g i;
    public d.b.h0.d0.h j;
    public boolean k;
    public Handler l;

    /* renamed from: e  reason: collision with root package name */
    public String f15725e = null;
    public CustomMessageListener m = new i(2921054);
    public CustomMessageListener n = new j(2001266);
    public CustomMessageListener o = new k(2921062);
    public CustomMessageListener p = new l(2921040);

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f15729e;

        public a(JSONObject jSONObject) {
            this.f15729e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.f15729e.optString("id").split(",")));
            for (String str : arrayList) {
                d.b.i0.l0.g.k().h(str);
            }
            if (d.b.i0.x1.c.i().c(arrayList, true)) {
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_del_action(1)");
            } else {
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_del_action(0)");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f15731e;

        public b(ShareItem shareItem) {
            this.f15731e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f15731e.t);
            d.b.b.e.p.l.L(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.b.i0.x1.c.i().f();
            if (f2 == null || f2.isEmpty()) {
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_has_action()");
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
            commonEmotionCenterFragment.V0("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_show_dialog(1)");
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f15737e;

        public g(JSONObject jSONObject) {
            this.f15737e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.x1.c.i().j(new ArrayList(Arrays.asList(this.f15737e.optString("id").split(","))), true);
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_sort_action()");
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.b.i0.x1.e.b {
        public h() {
        }

        @Override // d.b.i0.x1.e.b
        public void onFail(String str) {
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_save_action(0)");
        }

        @Override // d.b.i0.x1.e.b
        public void onProgress(int i) {
        }

        @Override // d.b.i0.x1.e.b
        public void onSuccess(String str) {
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_save_action(1)");
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_refresh_has_action()");
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && ((w) customResponsedMessage.getData()).l() == 1) {
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i) {
            super(i);
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
            commonEmotionCenterFragment.V0("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
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
                CommonEmotionCenterFragment.this.U0(0, null);
            } else if (!hashMap.containsKey("upload_result")) {
                CommonEmotionCenterFragment.this.U0(0, null);
            } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                CommonEmotionCenterFragment.this.U0(0, null);
            } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                BdToast.c(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), CommonEmotionCenterFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                CommonEmotionCenterFragment.this.U0(1, null);
            } else {
                if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                    str = (String) hashMap.get("upload_msg");
                }
                CommonEmotionCenterFragment.this.U0(0, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonEmotionCenterFragment.this.Z0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15745e;

        public n(String str) {
            this.f15745e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonEmotionCenterFragment.this.f15726f != null) {
                CommonEmotionCenterFragment.this.f15726f.loadUrl(this.f15745e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements d.b.i0.x1.e.b {
        public o() {
        }

        @Override // d.b.i0.x1.e.b
        public void onFail(String str) {
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_down_process_action(-1)");
        }

        @Override // d.b.i0.x1.e.b
        public void onProgress(int i) {
            if (i <= 0 || i >= 100) {
                return;
            }
            CommonEmotionCenterFragment commonEmotionCenterFragment = CommonEmotionCenterFragment.this;
            commonEmotionCenterFragment.V0("javascript:__js_bridge_emoticon_down_process_action(" + i + SmallTailInfo.EMOTION_SUFFIX);
        }

        @Override // d.b.i0.x1.e.b
        public void onSuccess(String str) {
            CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_down_process_action(100)");
        }
    }

    /* loaded from: classes4.dex */
    public class p implements d.b.i0.l0.y.d.c {
        public p() {
        }

        @Override // d.b.i0.l0.y.d.c
        public void a() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), 25021)));
        }

        @Override // d.b.i0.l0.y.d.c
        public void b() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), true, 25021)));
        }
    }

    /* loaded from: classes4.dex */
    public class q extends d.b.b.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f15749a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f15750b;

        public q(LikeModel likeModel, String str) {
            this.f15749a = likeModel;
            this.f15750b = str;
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (this.f15749a.getErrorCode() == 22) {
                CommonEmotionCenterFragment.this.showToast(R.string.unfollow_title);
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_attend_action(0)");
            } else if (AntiHelper.m(this.f15749a.getErrorCode(), this.f15749a.getErrorString())) {
                AntiHelper.u(CommonEmotionCenterFragment.this.getPageContext().getPageActivity(), this.f15749a.getErrorString());
            } else if (this.f15749a.getErrorCode() != 0) {
                CommonEmotionCenterFragment.this.showToast(this.f15749a.getErrorString());
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_attend_action(0)");
            } else {
                w wVar = (w) obj;
                if (wVar != null) {
                    CommonEmotionCenterFragment.this.showToast(R.string.attention_success);
                    TbadkApplication.getInst().addLikeForum(this.f15750b);
                    wVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                    CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_attend_action(1)");
                    return;
                }
                CommonEmotionCenterFragment commonEmotionCenterFragment = CommonEmotionCenterFragment.this;
                commonEmotionCenterFragment.showToast(commonEmotionCenterFragment.getPageContext().getString(R.string.neterror));
                CommonEmotionCenterFragment.this.V0("javascript:__js_bridge_emoticon_attend_action(0)");
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
            CommonEmotionCenterFragment.this.n();
            if (d.b.b.e.p.j.z()) {
                CommonEmotionCenterFragment.this.f1();
                CommonEmotionCenterFragment.this.k = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (CommonEmotionCenterFragment.this.getPageContext() == null || CommonEmotionCenterFragment.this.getPageContext().getPageActivity() == null) {
                return;
            }
            CommonEmotionCenterFragment.this.d1();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (CommonEmotionCenterFragment.this.getPageContext() == null || CommonEmotionCenterFragment.this.getPageContext().getPageActivity() == null) {
                return;
            }
            CommonEmotionCenterFragment.this.e1();
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
                if (CommonEmotionCenterFragment.this.X0(str) || (dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(CommonEmotionCenterFragment.this.getPageContext(), new String[]{str})) == 1 || dealOneLinkWithOutJumpWebView == 0) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public /* synthetic */ r(CommonEmotionCenterFragment commonEmotionCenterFragment, i iVar) {
            this();
        }
    }

    public final void J0(JSONObject jSONObject) {
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
        likeModel.H(optString2, String.valueOf(optString));
    }

    public final void K0() {
        if (d.b.i0.x1.g.e.l().r()) {
            T0(1, null);
        } else if (d.b.i0.x1.g.e.l().k() == null) {
            T0(0, null);
        } else {
            FaceGroupDraft k2 = d.b.i0.x1.g.e.l().k();
            if (!TextUtils.isEmpty(k2.getFailMsg())) {
                T0(2, k2.getFailMsg());
            } else {
                T0(2, null);
            }
        }
    }

    public final void L0(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        int optInt = jSONObject.optInt("pck_id");
        u s = u.s();
        String str = "";
        if (optInt != -1) {
            str = "" + optInt;
        }
        s.g(optString, str);
        V0("javascript:__js_bridge_emoticon_coll_action(2)");
    }

    public final void M0(JSONObject jSONObject) {
        if (d.b.i0.x1.d.m().o()) {
            V0("javascript:__js_bridge_emoticon_del_action(0)");
            d.b.b.e.p.l.K(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
        d.b.i0.x1.a.b().a(new a(jSONObject));
    }

    public final void N0(JSONObject jSONObject) {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (d.b.i0.x1.d.m().o()) {
                V0("javascript:__js_bridge_emoticon_down_process_action(-1)");
                d.b.b.e.p.l.K(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.f15727g == null) {
                this.f15727g = new NewFaceGroupDownloadModel();
            }
            this.f15727g.s(optString, Boolean.TRUE, new o());
        }
    }

    public final void O0() {
        d.b.i0.x1.a.b().a(new c());
    }

    public final JSONObject P0(String str) {
        if (str.contains("data=")) {
            try {
                return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    public final void Q0() {
        if (getArguments() == null || TextUtils.isEmpty(getArguments().getString("key_load_url"))) {
            return;
        }
        this.f15725e = getArguments().getString("key_load_url");
    }

    public final void R0(JSONObject jSONObject) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getPageContext().getPageActivity(), jSONObject.optInt("id"), 25024)));
    }

    public final void S0() {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(getPageContext().getPageActivity(), 25021)));
        }
    }

    public final void T0(int i2, String str) {
        if (!TextUtils.isEmpty(str)) {
            V0("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
            return;
        }
        V0("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
    }

    public final void U0(int i2, String str) {
        if (!TextUtils.isEmpty(str)) {
            V0("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
            return;
        }
        V0("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
    }

    public final void V0(String str) {
        if (this.f15726f != null) {
            this.l.post(new n(str));
        }
    }

    public final void W0() {
        d.b.i0.l0.y.d.a aVar = new d.b.i0.l0.y.d.a(getPageContext().getPageActivity(), 1);
        aVar.d(new p());
        Rect rect = new Rect();
        getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        aVar.showAtLocation(this.f15728h, 81, 0, getPageContext().getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
    }

    public final boolean X0(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TBOWNEREMOJI)) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), str)));
                return true;
            }
            JSONObject P0 = P0(str);
            if (P0 == null) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                N0(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                M0(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                b1(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                O0();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                c1(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                g1(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                Y0(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                L0(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                a1(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                R0(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                S0();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                W0();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                J0(P0);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                K0();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public final void Y0(JSONObject jSONObject) {
        if (d.b.i0.x1.d.m().o()) {
            V0("javascript:__js_bridge_emoticon_sort_action()");
            d.b.b.e.p.l.K(getPageContext().getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
        d.b.i0.x1.a.b().a(new g(jSONObject));
    }

    public void Z0() {
        if (this.f15726f == null) {
            return;
        }
        if (this.k) {
            V0("javascript:window.reload_page()");
        } else {
            V0(this.f15725e);
        }
    }

    public final void a1(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        d.b.i0.x1.c.i().d(optString, new h());
    }

    public final void b1(JSONObject jSONObject) {
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

    public final void c1(JSONObject jSONObject) {
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("pos");
        String optString3 = jSONObject.optString("neg");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            V0("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(optString);
        aVar.setPositiveButton(optString2, new d());
        aVar.setNegativeButton(optString3, new e());
        aVar.setOnCalcelListener(new f());
        aVar.create(getPageContext()).show();
    }

    public void d1() {
        d.b.h0.d0.g gVar = new d.b.h0.d0.g(getPageContext().getPageActivity());
        this.i = gVar;
        gVar.attachView(this.f15728h, false);
        this.i.onChangeSkinType();
    }

    public void e1() {
        if (getPageContext() == null || getPageContext().getPageActivity() == null) {
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.j == null) {
            d.b.h0.d0.h hVar = new d.b.h0.d0.h(getPageContext().getPageActivity(), new m());
            this.j = hVar;
            hVar.onChangeSkinType();
        }
        BaseWebView baseWebView = this.f15726f;
        if (baseWebView != null) {
            baseWebView.setVisibility(8);
        }
        this.j.l(string);
        this.j.attachView(this.f15728h, false);
        this.j.o();
        this.j.j(getPageContext().getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void f1() {
        d.b.h0.d0.h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this.f15728h);
            this.j = null;
        }
        BaseWebView baseWebView = this.f15726f;
        if (baseWebView != null) {
            baseWebView.setVisibility(0);
        }
    }

    public final void g1(JSONObject jSONObject) {
        String optString = jSONObject.optString("content");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        showToast(optString);
    }

    public void n() {
        d.b.h0.d0.g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this.f15728h);
            this.i = null;
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
        this.f15728h = new RelativeLayout(getPageContext().getPageActivity());
        this.f15726f = new BaseWebView(getPageContext().getPageActivity());
        this.f15726f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f15728h.addView(this.f15726f);
        this.f15726f.setWebViewClient(new r(this, null));
        d.b.h0.l.a.f(getPageContext().getPageActivity());
        Q0();
        V0(this.f15725e);
        return this.f15728h;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        K0();
    }
}
