package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ct4;
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.qj6;
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
public class SystemJsBridgePlugin_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ct4 mJsBridge;

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(WebView webView, hxa hxaVar, fxa fxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, hxaVar, fxaVar)) == null) {
            fxa fxaVar2 = fxaVar == null ? new fxa() : fxaVar;
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("system/saveImage")) {
                fxaVar2.s(true);
                fxa z = this.mJsBridge.z(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (z != null) {
                    fxaVar2.y(z.f());
                    fxaVar2.u(z.b());
                    fxaVar2.o(z.a());
                    fxaVar2.x(z.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                fxaVar2.s(true);
                fxa K = this.mJsBridge.K(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (K != null) {
                    fxaVar2.y(K.f());
                    fxaVar2.u(K.b());
                    fxaVar2.o(K.a());
                    fxaVar2.x(K.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                fxaVar2.s(true);
                fxa w = this.mJsBridge.w(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (w != null) {
                    fxaVar2.y(w.f());
                    fxaVar2.u(w.b());
                    fxaVar2.o(w.a());
                    fxaVar2.x(w.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                fxaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                fxa R = this.mJsBridge.R(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (R != null) {
                    fxaVar2.y(R.f());
                    fxaVar2.u(R.b());
                    fxaVar2.o(R.a());
                    fxaVar2.x(R.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                fxaVar2.s(true);
                fxa N = this.mJsBridge.N(webView, e.optString("soundUrl"));
                if (N != null) {
                    fxaVar2.y(N.f());
                    fxaVar2.u(N.b());
                    fxaVar2.o(N.a());
                    fxaVar2.x(N.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                fxaVar2.s(true);
                fxa O = this.mJsBridge.O(webView);
                if (O != null) {
                    fxaVar2.y(O.f());
                    fxaVar2.u(O.b());
                    fxaVar2.o(O.a());
                    fxaVar2.x(O.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                fxaVar2.s(true);
                fxa g = this.mJsBridge.g(webView, e.optInt("result"));
                if (g != null) {
                    fxaVar2.y(g.f());
                    fxaVar2.u(g.b());
                    fxaVar2.o(g.a());
                    fxaVar2.x(g.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                fxaVar2.s(true);
                fxa e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                if (e2 != null) {
                    fxaVar2.y(e2.f());
                    fxaVar2.u(e2.b());
                    fxaVar2.o(e2.a());
                    fxaVar2.x(e2.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                fxaVar2.s(true);
                fxa j = this.mJsBridge.j(webView, e.optInt(PackageTable.DISABLE));
                if (j != null) {
                    fxaVar2.y(j.f());
                    fxaVar2.u(j.b());
                    fxaVar2.o(j.a());
                    fxaVar2.x(j.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                fxaVar2.s(true);
                fxa T2 = this.mJsBridge.T(webView, e.optString("pkgName"), e.optString("schema"));
                if (T2 != null) {
                    fxaVar2.y(T2.f());
                    fxaVar2.u(T2.b());
                    fxaVar2.o(T2.a());
                    fxaVar2.x(T2.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                fxaVar2.s(true);
                fxa A = this.mJsBridge.A(webView);
                if (A != null) {
                    fxaVar2.y(A.f());
                    fxaVar2.u(A.b());
                    fxaVar2.o(A.a());
                    fxaVar2.x(A.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                fxaVar2.s(true);
                fxa v = this.mJsBridge.v(webView, e.optString("type"));
                if (v != null) {
                    fxaVar2.y(v.f());
                    fxaVar2.u(v.b());
                    fxaVar2.o(v.a());
                    fxaVar2.x(v.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                fxaVar2.s(true);
                fxa fxaVar3 = fxaVar2;
                fxa U = this.mJsBridge.U(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (U != null) {
                    fxaVar3.y(U.f());
                    fxaVar3.u(U.b());
                    fxaVar3.o(U.a());
                    fxaVar3.x(U.e());
                }
                fxaVar3.z(0);
                return fxaVar3;
            } else {
                fxa fxaVar4 = fxaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    fxaVar4.s(true);
                    fxa f = this.mJsBridge.f(webView, e.optString("pkgName"));
                    if (f != null) {
                        fxaVar4.y(f.f());
                        fxaVar4.u(f.b());
                        fxaVar4.o(f.a());
                        fxaVar4.x(f.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    fxaVar4.s(true);
                    fxa m = this.mJsBridge.m(webView, e.optString("key"), e.optString("storageType"));
                    this.mNotificationNameList.add("getAppStorageResult");
                    if (m != null) {
                        fxaVar4.y(m.f());
                        fxaVar4.u(m.b());
                        fxaVar4.o(m.a());
                        fxaVar4.x(m.e());
                        if (!fxaVar4.h()) {
                            fxaVar4.n(false);
                            addObserver(webView, "getAppStorageResult", fxaVar4, false);
                        }
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    fxaVar4.s(true);
                    fxa P = this.mJsBridge.P(webView, e.optString("key"), e.optString("data"), e.optString("storageType"));
                    if (P != null) {
                        fxaVar4.y(P.f());
                        fxaVar4.u(P.b());
                        fxaVar4.o(P.a());
                        fxaVar4.x(P.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    fxaVar4.s(true);
                    fxa q = this.mJsBridge.q(webView);
                    if (q != null) {
                        fxaVar4.y(q.f());
                        fxaVar4.u(q.b());
                        fxaVar4.o(q.a());
                        fxaVar4.x(q.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    fxaVar4.s(true);
                    fxa p = this.mJsBridge.p(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                    if (p != null) {
                        fxaVar4.y(p.f());
                        fxaVar4.u(p.b());
                        fxaVar4.o(p.a());
                        fxaVar4.x(p.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    fxaVar4.s(true);
                    fxa o = this.mJsBridge.o(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                    if (o != null) {
                        fxaVar4.y(o.f());
                        fxaVar4.u(o.b());
                        fxaVar4.o(o.a());
                        fxaVar4.x(o.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    fxaVar4.s(true);
                    fxa l = this.mJsBridge.l(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                    if (l != null) {
                        fxaVar4.y(l.f());
                        fxaVar4.u(l.b());
                        fxaVar4.o(l.a());
                        fxaVar4.x(l.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    fxaVar4.s(true);
                    fxa k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                    if (k != null) {
                        fxaVar4.y(k.f());
                        fxaVar4.u(k.b());
                        fxaVar4.o(k.a());
                        fxaVar4.x(k.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/installGameApk")) {
                    fxaVar4.s(true);
                    fxa B = this.mJsBridge.B(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (B != null) {
                        fxaVar4.y(B.f());
                        fxaVar4.u(B.b());
                        fxaVar4.o(B.a());
                        fxaVar4.x(B.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/launchApk")) {
                    fxaVar4.s(true);
                    fxa F = this.mJsBridge.F(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (F != null) {
                        fxaVar4.y(F.f());
                        fxaVar4.u(F.b());
                        fxaVar4.o(F.a());
                        fxaVar4.x(F.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    fxaVar4.s(true);
                    fxa t = this.mJsBridge.t(webView);
                    if (t != null) {
                        fxaVar4.y(t.f());
                        fxaVar4.u(t.b());
                        fxaVar4.o(t.a());
                        fxaVar4.x(t.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    fxaVar4.s(true);
                    fxa V = this.mJsBridge.V(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (V != null) {
                        fxaVar4.y(V.f());
                        fxaVar4.u(V.b());
                        fxaVar4.o(V.a());
                        fxaVar4.x(V.e());
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    fxaVar4.s(true);
                    fxa D = this.mJsBridge.D(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (D != null) {
                        fxaVar4.y(D.f());
                        fxaVar4.u(D.b());
                        fxaVar4.o(D.a());
                        fxaVar4.x(D.e());
                        if (!fxaVar4.h()) {
                            fxaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", fxaVar4, true);
                        }
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else if (b.equals("system/pushNotificationPermission")) {
                    fxaVar4.s(true);
                    fxa x = this.mJsBridge.x(webView, e.optString("switch_name"), e.optString("operate_type"), e.optString("set_status"));
                    this.mNotificationNameList.add("pushNotificationPermission");
                    if (x != null) {
                        fxaVar4.y(x.f());
                        fxaVar4.u(x.b());
                        fxaVar4.o(x.a());
                        fxaVar4.x(x.e());
                        if (!fxaVar4.h()) {
                            fxaVar4.n(false);
                            addObserver(webView, "pushNotificationPermission", fxaVar4, false);
                        }
                    }
                    fxaVar4.z(0);
                    return fxaVar4;
                } else {
                    return fxaVar4;
                }
            }
            return fxaVar2;
        }
        return (fxa) invokeLLL.objValue;
    }

    public SystemJsBridgePlugin_Proxy(ct4 ct4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ct4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ct4Var;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add("orderGameApkResult");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add("selectPhotoAlbum");
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add("getAppStorageResult");
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add("keyboardHeightChange");
        this.mNotificationNameList.add("pushNotificationPermission");
    }

    @Override // com.baidu.tieba.dxa
    public qj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                fxaVar = this.mJsBridge.Q(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                fxaVar = this.mJsBridge.L(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                fxaVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                fxaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                fxaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                fxaVar = this.mJsBridge.i(webView, hashMap);
            } else if (str.equals("getAppStorageResult")) {
                fxaVar = this.mJsBridge.n(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                fxaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                fxaVar = this.mJsBridge.G(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                fxaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                fxaVar = this.mJsBridge.J(webView, hashMap);
            } else if (str.equals("pushNotificationPermission")) {
                fxaVar = this.mJsBridge.y(webView, hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!TextUtils.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.j = fxaVar.j;
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.j = fxaVar.j;
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
