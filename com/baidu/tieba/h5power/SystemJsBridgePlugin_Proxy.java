package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cj6;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
import com.baidu.tieba.xs4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SystemJsBridgePlugin_Proxy extends lsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xs4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(xs4 xs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = xs4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add("orderGameApkResult");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add("selectPhotoAlbum");
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add("keyboardHeightChange");
        this.mNotificationNameList.add("pushNotificationPermission");
    }

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(WebView webView, psa psaVar, nsa nsaVar) {
        InterceptResult invokeLLL;
        nsa nsaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, psaVar, nsaVar)) == null) {
            if (nsaVar == null) {
                nsaVar2 = new nsa();
            } else {
                nsaVar2 = nsaVar;
            }
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("system/saveImage")) {
                nsaVar2.s(true);
                nsa w = this.mJsBridge.w(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (w != null) {
                    nsaVar2.y(w.f());
                    nsaVar2.u(w.b());
                    nsaVar2.o(w.a());
                    nsaVar2.x(w.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                nsaVar2.s(true);
                nsa G = this.mJsBridge.G(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (G != null) {
                    nsaVar2.y(G.f());
                    nsaVar2.u(G.b());
                    nsaVar2.o(G.a());
                    nsaVar2.x(G.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                nsaVar2.s(true);
                nsa t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    nsaVar2.y(t.f());
                    nsaVar2.u(t.b());
                    nsaVar2.o(t.a());
                    nsaVar2.x(t.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                nsaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                nsa M = this.mJsBridge.M(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (M != null) {
                    nsaVar2.y(M.f());
                    nsaVar2.u(M.b());
                    nsaVar2.o(M.a());
                    nsaVar2.x(M.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                nsaVar2.s(true);
                nsa I = this.mJsBridge.I(webView, e.optString("soundUrl"));
                if (I != null) {
                    nsaVar2.y(I.f());
                    nsaVar2.u(I.b());
                    nsaVar2.o(I.a());
                    nsaVar2.x(I.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                nsaVar2.s(true);
                nsa J = this.mJsBridge.J(webView);
                if (J != null) {
                    nsaVar2.y(J.f());
                    nsaVar2.u(J.b());
                    nsaVar2.o(J.a());
                    nsaVar2.x(J.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                nsaVar2.s(true);
                nsa f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    nsaVar2.y(f.f());
                    nsaVar2.u(f.b());
                    nsaVar2.o(f.a());
                    nsaVar2.x(f.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                nsaVar2.s(true);
                nsa d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    nsaVar2.y(d.f());
                    nsaVar2.u(d.b());
                    nsaVar2.o(d.a());
                    nsaVar2.x(d.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                nsaVar2.s(true);
                nsa i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    nsaVar2.y(i.f());
                    nsaVar2.u(i.b());
                    nsaVar2.o(i.a());
                    nsaVar2.x(i.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                nsaVar2.s(true);
                nsa O = this.mJsBridge.O(webView, e.optString("pkgName"), e.optString("schema"));
                if (O != null) {
                    nsaVar2.y(O.f());
                    nsaVar2.u(O.b());
                    nsaVar2.o(O.a());
                    nsaVar2.x(O.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                nsaVar2.s(true);
                nsa x = this.mJsBridge.x(webView);
                if (x != null) {
                    nsaVar2.y(x.f());
                    nsaVar2.u(x.b());
                    nsaVar2.o(x.a());
                    nsaVar2.x(x.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                nsaVar2.s(true);
                nsa s = this.mJsBridge.s(webView);
                if (s != null) {
                    nsaVar2.y(s.f());
                    nsaVar2.u(s.b());
                    nsaVar2.o(s.a());
                    nsaVar2.x(s.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                nsaVar2.s(true);
                nsa nsaVar3 = nsaVar2;
                nsa P = this.mJsBridge.P(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (P != null) {
                    nsaVar3.y(P.f());
                    nsaVar3.u(P.b());
                    nsaVar3.o(P.a());
                    nsaVar3.x(P.e());
                }
                nsaVar3.z(0);
                return nsaVar3;
            } else {
                nsa nsaVar4 = nsaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    nsaVar4.s(true);
                    nsa e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        nsaVar4.y(e2.f());
                        nsaVar4.u(e2.b());
                        nsaVar4.o(e2.a());
                        nsaVar4.x(e2.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    nsaVar4.s(true);
                    nsa l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        nsaVar4.y(l.f());
                        nsaVar4.u(l.b());
                        nsaVar4.o(l.a());
                        nsaVar4.x(l.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    nsaVar4.s(true);
                    nsa K = this.mJsBridge.K(webView, e.optString("key"), e.optString("data"));
                    if (K != null) {
                        nsaVar4.y(K.f());
                        nsaVar4.u(K.b());
                        nsaVar4.o(K.a());
                        nsaVar4.x(K.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    nsaVar4.s(true);
                    nsa o = this.mJsBridge.o(webView);
                    if (o != null) {
                        nsaVar4.y(o.f());
                        nsaVar4.u(o.b());
                        nsaVar4.o(o.a());
                        nsaVar4.x(o.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    nsaVar4.s(true);
                    nsa n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        nsaVar4.y(n.f());
                        nsaVar4.u(n.b());
                        nsaVar4.o(n.a());
                        nsaVar4.x(n.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    nsaVar4.s(true);
                    nsa m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        nsaVar4.y(m.f());
                        nsaVar4.u(m.b());
                        nsaVar4.o(m.a());
                        nsaVar4.x(m.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    nsaVar4.s(true);
                    nsa k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        nsaVar4.y(k.f());
                        nsaVar4.u(k.b());
                        nsaVar4.o(k.a());
                        nsaVar4.x(k.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    nsaVar4.s(true);
                    nsa j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        nsaVar4.y(j.f());
                        nsaVar4.u(j.b());
                        nsaVar4.o(j.a());
                        nsaVar4.x(j.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/installGameApk")) {
                    nsaVar4.s(true);
                    nsa y = this.mJsBridge.y(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        nsaVar4.y(y.f());
                        nsaVar4.u(y.b());
                        nsaVar4.o(y.a());
                        nsaVar4.x(y.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/launchApk")) {
                    nsaVar4.s(true);
                    nsa C = this.mJsBridge.C(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (C != null) {
                        nsaVar4.y(C.f());
                        nsaVar4.u(C.b());
                        nsaVar4.o(C.a());
                        nsaVar4.x(C.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    nsaVar4.s(true);
                    nsa r = this.mJsBridge.r(webView);
                    if (r != null) {
                        nsaVar4.y(r.f());
                        nsaVar4.u(r.b());
                        nsaVar4.o(r.a());
                        nsaVar4.x(r.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    nsaVar4.s(true);
                    nsa Q = this.mJsBridge.Q(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (Q != null) {
                        nsaVar4.y(Q.f());
                        nsaVar4.u(Q.b());
                        nsaVar4.o(Q.a());
                        nsaVar4.x(Q.e());
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    nsaVar4.s(true);
                    nsa A = this.mJsBridge.A(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (A != null) {
                        nsaVar4.y(A.f());
                        nsaVar4.u(A.b());
                        nsaVar4.o(A.a());
                        nsaVar4.x(A.e());
                        if (!nsaVar4.h()) {
                            nsaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", nsaVar4, true);
                        }
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else if (b.equals("system/pushNotificationPermission")) {
                    nsaVar4.s(true);
                    nsa u = this.mJsBridge.u(webView, e.optString("switch_name"), e.optString("operate_type"), e.optString("set_status"));
                    this.mNotificationNameList.add("pushNotificationPermission");
                    if (u != null) {
                        nsaVar4.y(u.f());
                        nsaVar4.u(u.b());
                        nsaVar4.o(u.a());
                        nsaVar4.x(u.e());
                        if (!nsaVar4.h()) {
                            nsaVar4.n(false);
                            addObserver(webView, "pushNotificationPermission", nsaVar4, false);
                        }
                    }
                    nsaVar4.z(0);
                    return nsaVar4;
                } else {
                    return nsaVar4;
                }
            }
            return nsaVar2;
        }
        return (nsa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public cj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (cj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            nsa nsaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                nsaVar = this.mJsBridge.L(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                nsaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                nsaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                nsaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                nsaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                nsaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                nsaVar = this.mJsBridge.E(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                nsaVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                nsaVar = this.mJsBridge.c(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                nsaVar = this.mJsBridge.F(webView, hashMap);
            } else if (str.equals("pushNotificationPermission")) {
                nsaVar = this.mJsBridge.v(webView, hashMap);
            }
            if (nsaVar != null) {
                nsaVar.z(0);
            }
            List<msa> list = this.mAsyncCallBackMethodList.get(str);
            if (nsaVar != null && list != null) {
                Iterator<msa> it = list.iterator();
                if (!TextUtils.isEmpty(nsaVar.e())) {
                    while (it.hasNext()) {
                        msa next = it.next();
                        if (next.b().equals(nsaVar.e())) {
                            nsa nsaVar2 = new nsa();
                            nsaVar2.w(next.a());
                            nsaVar2.y(nsaVar.f());
                            nsaVar2.u(nsaVar.b());
                            nsaVar2.o(nsaVar.a());
                            nsaVar2.j = nsaVar.j;
                            nsaVar2.A(nsaVar.l());
                            arrayList.add(nsaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        msa next2 = it.next();
                        nsa nsaVar3 = new nsa();
                        nsaVar3.w(next2.a());
                        nsaVar3.y(nsaVar.f());
                        nsaVar3.u(nsaVar.b());
                        nsaVar3.o(nsaVar.a());
                        nsaVar3.j = nsaVar.j;
                        nsaVar3.A(nsaVar.l());
                        arrayList.add(nsaVar3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
