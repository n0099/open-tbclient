package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.fq9;
import com.baidu.tieba.gq9;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
import com.baidu.tieba.tu4;
import com.baidu.tieba.xf6;
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
/* loaded from: classes4.dex */
public class SystemJsBridgePlugin_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tu4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(tu4 tu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = tu4Var;
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
    }

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(WebView webView, jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLLL;
        hq9 hq9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, jq9Var, hq9Var)) == null) {
            if (hq9Var == null) {
                hq9Var2 = new hq9();
            } else {
                hq9Var2 = hq9Var;
            }
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("system/saveImage")) {
                hq9Var2.s(true);
                hq9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    hq9Var2.y(u.f());
                    hq9Var2.u(u.b());
                    hq9Var2.o(u.a());
                    hq9Var2.x(u.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                hq9Var2.s(true);
                hq9 C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    hq9Var2.y(C.f());
                    hq9Var2.u(C.b());
                    hq9Var2.o(C.a());
                    hq9Var2.x(C.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                hq9Var2.s(true);
                hq9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    hq9Var2.y(t.f());
                    hq9Var2.u(t.b());
                    hq9Var2.o(t.a());
                    hq9Var2.x(t.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                hq9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                hq9 I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    hq9Var2.y(I.f());
                    hq9Var2.u(I.b());
                    hq9Var2.o(I.a());
                    hq9Var2.x(I.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("system/playSound")) {
                hq9Var2.s(true);
                hq9 E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    hq9Var2.y(E.f());
                    hq9Var2.u(E.b());
                    hq9Var2.o(E.a());
                    hq9Var2.x(E.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                hq9Var2.s(true);
                hq9 F = this.mJsBridge.F(webView);
                if (F != null) {
                    hq9Var2.y(F.f());
                    hq9Var2.u(F.b());
                    hq9Var2.o(F.a());
                    hq9Var2.x(F.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                hq9Var2.s(true);
                hq9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    hq9Var2.y(f.f());
                    hq9Var2.u(f.b());
                    hq9Var2.o(f.a());
                    hq9Var2.x(f.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                hq9Var2.s(true);
                hq9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    hq9Var2.y(d.f());
                    hq9Var2.u(d.b());
                    hq9Var2.o(d.a());
                    hq9Var2.x(d.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                hq9Var2.s(true);
                hq9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    hq9Var2.y(i.f());
                    hq9Var2.u(i.b());
                    hq9Var2.o(i.a());
                    hq9Var2.x(i.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                hq9Var2.s(true);
                hq9 K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    hq9Var2.y(K.f());
                    hq9Var2.u(K.b());
                    hq9Var2.o(K.a());
                    hq9Var2.x(K.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                hq9Var2.s(true);
                hq9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    hq9Var2.y(v.f());
                    hq9Var2.u(v.b());
                    hq9Var2.o(v.a());
                    hq9Var2.x(v.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                hq9Var2.s(true);
                hq9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    hq9Var2.y(s.f());
                    hq9Var2.u(s.b());
                    hq9Var2.o(s.a());
                    hq9Var2.x(s.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                hq9Var2.s(true);
                hq9 hq9Var3 = hq9Var2;
                hq9 L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    hq9Var3.y(L.f());
                    hq9Var3.u(L.b());
                    hq9Var3.o(L.a());
                    hq9Var3.x(L.e());
                }
                hq9Var3.z(0);
                return hq9Var3;
            } else {
                hq9 hq9Var4 = hq9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    hq9Var4.s(true);
                    hq9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        hq9Var4.y(e2.f());
                        hq9Var4.u(e2.b());
                        hq9Var4.o(e2.a());
                        hq9Var4.x(e2.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    hq9Var4.s(true);
                    hq9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        hq9Var4.y(l.f());
                        hq9Var4.u(l.b());
                        hq9Var4.o(l.a());
                        hq9Var4.x(l.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    hq9Var4.s(true);
                    hq9 G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        hq9Var4.y(G.f());
                        hq9Var4.u(G.b());
                        hq9Var4.o(G.a());
                        hq9Var4.x(G.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    hq9Var4.s(true);
                    hq9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        hq9Var4.y(o.f());
                        hq9Var4.u(o.b());
                        hq9Var4.o(o.a());
                        hq9Var4.x(o.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    hq9Var4.s(true);
                    hq9 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        hq9Var4.y(n.f());
                        hq9Var4.u(n.b());
                        hq9Var4.o(n.a());
                        hq9Var4.x(n.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    hq9Var4.s(true);
                    hq9 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        hq9Var4.y(m.f());
                        hq9Var4.u(m.b());
                        hq9Var4.o(m.a());
                        hq9Var4.x(m.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    hq9Var4.s(true);
                    hq9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        hq9Var4.y(k.f());
                        hq9Var4.u(k.b());
                        hq9Var4.o(k.a());
                        hq9Var4.x(k.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    hq9Var4.s(true);
                    hq9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        hq9Var4.y(j.f());
                        hq9Var4.u(j.b());
                        hq9Var4.o(j.a());
                        hq9Var4.x(j.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/installGameApk")) {
                    hq9Var4.s(true);
                    hq9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        hq9Var4.y(w.f());
                        hq9Var4.u(w.b());
                        hq9Var4.o(w.a());
                        hq9Var4.x(w.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/launchApk")) {
                    hq9Var4.s(true);
                    hq9 z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        hq9Var4.y(z.f());
                        hq9Var4.u(z.b());
                        hq9Var4.o(z.a());
                        hq9Var4.x(z.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    hq9Var4.s(true);
                    hq9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        hq9Var4.y(r.f());
                        hq9Var4.u(r.b());
                        hq9Var4.o(r.a());
                        hq9Var4.x(r.e());
                    }
                    hq9Var4.z(0);
                    return hq9Var4;
                } else {
                    return hq9Var4;
                }
            }
            return hq9Var2;
        }
        return (hq9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public xf6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xf6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            hq9 hq9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                hq9Var = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                hq9Var = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                hq9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                hq9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                hq9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                hq9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                hq9Var = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                hq9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                hq9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (hq9Var != null) {
                hq9Var.z(0);
            }
            List<gq9> list = this.mAsyncCallBackMethodList.get(str);
            if (hq9Var != null && list != null) {
                Iterator<gq9> it = list.iterator();
                if (!TextUtils.isEmpty(hq9Var.e())) {
                    while (it.hasNext()) {
                        gq9 next = it.next();
                        if (next.b().equals(hq9Var.e())) {
                            hq9 hq9Var2 = new hq9();
                            hq9Var2.w(next.a());
                            hq9Var2.y(hq9Var.f());
                            hq9Var2.u(hq9Var.b());
                            hq9Var2.o(hq9Var.a());
                            hq9Var2.A(hq9Var.l());
                            arrayList.add(hq9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        gq9 next2 = it.next();
                        hq9 hq9Var3 = new hq9();
                        hq9Var3.w(next2.a());
                        hq9Var3.y(hq9Var.f());
                        hq9Var3.u(hq9Var.b());
                        hq9Var3.o(hq9Var.a());
                        hq9Var3.A(hq9Var.l());
                        arrayList.add(hq9Var3);
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
