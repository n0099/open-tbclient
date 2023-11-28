package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
import com.baidu.tieba.mj6;
import com.baidu.tieba.zs4;
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
public class SystemJsBridgePlugin_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zs4 mJsBridge;

    @Override // com.baidu.tieba.exa
    public gxa dispatch(WebView webView, ixa ixaVar, gxa gxaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ixaVar, gxaVar)) == null) {
            gxa gxaVar2 = gxaVar == null ? new gxa() : gxaVar;
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("system/saveImage")) {
                gxaVar2.s(true);
                gxa z = this.mJsBridge.z(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (z != null) {
                    gxaVar2.y(z.f());
                    gxaVar2.u(z.b());
                    gxaVar2.o(z.a());
                    gxaVar2.x(z.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                gxaVar2.s(true);
                gxa K = this.mJsBridge.K(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (K != null) {
                    gxaVar2.y(K.f());
                    gxaVar2.u(K.b());
                    gxaVar2.o(K.a());
                    gxaVar2.x(K.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                gxaVar2.s(true);
                gxa w = this.mJsBridge.w(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (w != null) {
                    gxaVar2.y(w.f());
                    gxaVar2.u(w.b());
                    gxaVar2.o(w.a());
                    gxaVar2.x(w.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                gxaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                gxa R = this.mJsBridge.R(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (R != null) {
                    gxaVar2.y(R.f());
                    gxaVar2.u(R.b());
                    gxaVar2.o(R.a());
                    gxaVar2.x(R.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                gxaVar2.s(true);
                gxa N = this.mJsBridge.N(webView, e.optString("soundUrl"));
                if (N != null) {
                    gxaVar2.y(N.f());
                    gxaVar2.u(N.b());
                    gxaVar2.o(N.a());
                    gxaVar2.x(N.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                gxaVar2.s(true);
                gxa O = this.mJsBridge.O(webView);
                if (O != null) {
                    gxaVar2.y(O.f());
                    gxaVar2.u(O.b());
                    gxaVar2.o(O.a());
                    gxaVar2.x(O.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                gxaVar2.s(true);
                gxa g = this.mJsBridge.g(webView, e.optInt("result"));
                if (g != null) {
                    gxaVar2.y(g.f());
                    gxaVar2.u(g.b());
                    gxaVar2.o(g.a());
                    gxaVar2.x(g.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                gxaVar2.s(true);
                gxa e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                if (e2 != null) {
                    gxaVar2.y(e2.f());
                    gxaVar2.u(e2.b());
                    gxaVar2.o(e2.a());
                    gxaVar2.x(e2.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                gxaVar2.s(true);
                gxa j = this.mJsBridge.j(webView, e.optInt(PackageTable.DISABLE));
                if (j != null) {
                    gxaVar2.y(j.f());
                    gxaVar2.u(j.b());
                    gxaVar2.o(j.a());
                    gxaVar2.x(j.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                gxaVar2.s(true);
                gxa T2 = this.mJsBridge.T(webView, e.optString("pkgName"), e.optString("schema"));
                if (T2 != null) {
                    gxaVar2.y(T2.f());
                    gxaVar2.u(T2.b());
                    gxaVar2.o(T2.a());
                    gxaVar2.x(T2.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                gxaVar2.s(true);
                gxa A = this.mJsBridge.A(webView);
                if (A != null) {
                    gxaVar2.y(A.f());
                    gxaVar2.u(A.b());
                    gxaVar2.o(A.a());
                    gxaVar2.x(A.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                gxaVar2.s(true);
                gxa v = this.mJsBridge.v(webView, e.optString("type"));
                if (v != null) {
                    gxaVar2.y(v.f());
                    gxaVar2.u(v.b());
                    gxaVar2.o(v.a());
                    gxaVar2.x(v.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                gxaVar2.s(true);
                gxa gxaVar3 = gxaVar2;
                gxa U = this.mJsBridge.U(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (U != null) {
                    gxaVar3.y(U.f());
                    gxaVar3.u(U.b());
                    gxaVar3.o(U.a());
                    gxaVar3.x(U.e());
                }
                gxaVar3.z(0);
                return gxaVar3;
            } else {
                gxa gxaVar4 = gxaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    gxaVar4.s(true);
                    gxa f = this.mJsBridge.f(webView, e.optString("pkgName"));
                    if (f != null) {
                        gxaVar4.y(f.f());
                        gxaVar4.u(f.b());
                        gxaVar4.o(f.a());
                        gxaVar4.x(f.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    gxaVar4.s(true);
                    gxa m = this.mJsBridge.m(webView, e.optString("key"), e.optString("storageType"));
                    this.mNotificationNameList.add("getAppStorageResult");
                    if (m != null) {
                        gxaVar4.y(m.f());
                        gxaVar4.u(m.b());
                        gxaVar4.o(m.a());
                        gxaVar4.x(m.e());
                        if (!gxaVar4.h()) {
                            gxaVar4.n(false);
                            addObserver(webView, "getAppStorageResult", gxaVar4, false);
                        }
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    gxaVar4.s(true);
                    gxa P = this.mJsBridge.P(webView, e.optString("key"), e.optString("data"), e.optString("storageType"));
                    if (P != null) {
                        gxaVar4.y(P.f());
                        gxaVar4.u(P.b());
                        gxaVar4.o(P.a());
                        gxaVar4.x(P.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    gxaVar4.s(true);
                    gxa q = this.mJsBridge.q(webView);
                    if (q != null) {
                        gxaVar4.y(q.f());
                        gxaVar4.u(q.b());
                        gxaVar4.o(q.a());
                        gxaVar4.x(q.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    gxaVar4.s(true);
                    gxa p = this.mJsBridge.p(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                    if (p != null) {
                        gxaVar4.y(p.f());
                        gxaVar4.u(p.b());
                        gxaVar4.o(p.a());
                        gxaVar4.x(p.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    gxaVar4.s(true);
                    gxa o = this.mJsBridge.o(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                    if (o != null) {
                        gxaVar4.y(o.f());
                        gxaVar4.u(o.b());
                        gxaVar4.o(o.a());
                        gxaVar4.x(o.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    gxaVar4.s(true);
                    gxa l = this.mJsBridge.l(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                    if (l != null) {
                        gxaVar4.y(l.f());
                        gxaVar4.u(l.b());
                        gxaVar4.o(l.a());
                        gxaVar4.x(l.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    gxaVar4.s(true);
                    gxa k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                    if (k != null) {
                        gxaVar4.y(k.f());
                        gxaVar4.u(k.b());
                        gxaVar4.o(k.a());
                        gxaVar4.x(k.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/installGameApk")) {
                    gxaVar4.s(true);
                    gxa B = this.mJsBridge.B(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (B != null) {
                        gxaVar4.y(B.f());
                        gxaVar4.u(B.b());
                        gxaVar4.o(B.a());
                        gxaVar4.x(B.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/launchApk")) {
                    gxaVar4.s(true);
                    gxa F = this.mJsBridge.F(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (F != null) {
                        gxaVar4.y(F.f());
                        gxaVar4.u(F.b());
                        gxaVar4.o(F.a());
                        gxaVar4.x(F.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    gxaVar4.s(true);
                    gxa t = this.mJsBridge.t(webView);
                    if (t != null) {
                        gxaVar4.y(t.f());
                        gxaVar4.u(t.b());
                        gxaVar4.o(t.a());
                        gxaVar4.x(t.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    gxaVar4.s(true);
                    gxa V = this.mJsBridge.V(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (V != null) {
                        gxaVar4.y(V.f());
                        gxaVar4.u(V.b());
                        gxaVar4.o(V.a());
                        gxaVar4.x(V.e());
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    gxaVar4.s(true);
                    gxa D = this.mJsBridge.D(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (D != null) {
                        gxaVar4.y(D.f());
                        gxaVar4.u(D.b());
                        gxaVar4.o(D.a());
                        gxaVar4.x(D.e());
                        if (!gxaVar4.h()) {
                            gxaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", gxaVar4, true);
                        }
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else if (b.equals("system/pushNotificationPermission")) {
                    gxaVar4.s(true);
                    gxa x = this.mJsBridge.x(webView, e.optString("switch_name"), e.optString("operate_type"), e.optString("set_status"));
                    this.mNotificationNameList.add("pushNotificationPermission");
                    if (x != null) {
                        gxaVar4.y(x.f());
                        gxaVar4.u(x.b());
                        gxaVar4.o(x.a());
                        gxaVar4.x(x.e());
                        if (!gxaVar4.h()) {
                            gxaVar4.n(false);
                            addObserver(webView, "pushNotificationPermission", gxaVar4, false);
                        }
                    }
                    gxaVar4.z(0);
                    return gxaVar4;
                } else {
                    return gxaVar4;
                }
            }
            return gxaVar2;
        }
        return (gxa) invokeLLL.objValue;
    }

    public SystemJsBridgePlugin_Proxy(zs4 zs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = zs4Var;
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

    @Override // com.baidu.tieba.exa
    public mj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (mj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                gxaVar = this.mJsBridge.Q(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                gxaVar = this.mJsBridge.L(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                gxaVar = this.mJsBridge.r(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                gxaVar = this.mJsBridge.s(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                gxaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                gxaVar = this.mJsBridge.i(webView, hashMap);
            } else if (str.equals("getAppStorageResult")) {
                gxaVar = this.mJsBridge.n(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                gxaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                gxaVar = this.mJsBridge.G(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                gxaVar = this.mJsBridge.d(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                gxaVar = this.mJsBridge.J(webView, hashMap);
            } else if (str.equals("pushNotificationPermission")) {
                gxaVar = this.mJsBridge.y(webView, hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!TextUtils.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.j = gxaVar.j;
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.j = gxaVar.j;
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
