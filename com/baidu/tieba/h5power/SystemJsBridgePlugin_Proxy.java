package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cw4;
import com.baidu.tieba.hs9;
import com.baidu.tieba.is9;
import com.baidu.tieba.jh6;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
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
/* loaded from: classes5.dex */
public class SystemJsBridgePlugin_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cw4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(cw4 cw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cw4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = cw4Var;
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

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(WebView webView, ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLLL;
        js9 js9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ls9Var, js9Var)) == null) {
            if (js9Var == null) {
                js9Var2 = new js9();
            } else {
                js9Var2 = js9Var;
            }
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("system/saveImage")) {
                js9Var2.s(true);
                js9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    js9Var2.y(u.f());
                    js9Var2.u(u.b());
                    js9Var2.o(u.a());
                    js9Var2.x(u.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                js9Var2.s(true);
                js9 C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    js9Var2.y(C.f());
                    js9Var2.u(C.b());
                    js9Var2.o(C.a());
                    js9Var2.x(C.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                js9Var2.s(true);
                js9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    js9Var2.y(t.f());
                    js9Var2.u(t.b());
                    js9Var2.o(t.a());
                    js9Var2.x(t.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                js9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                js9 I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    js9Var2.y(I.f());
                    js9Var2.u(I.b());
                    js9Var2.o(I.a());
                    js9Var2.x(I.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("system/playSound")) {
                js9Var2.s(true);
                js9 E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    js9Var2.y(E.f());
                    js9Var2.u(E.b());
                    js9Var2.o(E.a());
                    js9Var2.x(E.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                js9Var2.s(true);
                js9 F = this.mJsBridge.F(webView);
                if (F != null) {
                    js9Var2.y(F.f());
                    js9Var2.u(F.b());
                    js9Var2.o(F.a());
                    js9Var2.x(F.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                js9Var2.s(true);
                js9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    js9Var2.y(f.f());
                    js9Var2.u(f.b());
                    js9Var2.o(f.a());
                    js9Var2.x(f.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                js9Var2.s(true);
                js9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    js9Var2.y(d.f());
                    js9Var2.u(d.b());
                    js9Var2.o(d.a());
                    js9Var2.x(d.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                js9Var2.s(true);
                js9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    js9Var2.y(i.f());
                    js9Var2.u(i.b());
                    js9Var2.o(i.a());
                    js9Var2.x(i.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                js9Var2.s(true);
                js9 K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    js9Var2.y(K.f());
                    js9Var2.u(K.b());
                    js9Var2.o(K.a());
                    js9Var2.x(K.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                js9Var2.s(true);
                js9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    js9Var2.y(v.f());
                    js9Var2.u(v.b());
                    js9Var2.o(v.a());
                    js9Var2.x(v.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                js9Var2.s(true);
                js9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    js9Var2.y(s.f());
                    js9Var2.u(s.b());
                    js9Var2.o(s.a());
                    js9Var2.x(s.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                js9Var2.s(true);
                js9 js9Var3 = js9Var2;
                js9 L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    js9Var3.y(L.f());
                    js9Var3.u(L.b());
                    js9Var3.o(L.a());
                    js9Var3.x(L.e());
                }
                js9Var3.z(0);
                return js9Var3;
            } else {
                js9 js9Var4 = js9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    js9Var4.s(true);
                    js9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        js9Var4.y(e2.f());
                        js9Var4.u(e2.b());
                        js9Var4.o(e2.a());
                        js9Var4.x(e2.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    js9Var4.s(true);
                    js9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        js9Var4.y(l.f());
                        js9Var4.u(l.b());
                        js9Var4.o(l.a());
                        js9Var4.x(l.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    js9Var4.s(true);
                    js9 G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        js9Var4.y(G.f());
                        js9Var4.u(G.b());
                        js9Var4.o(G.a());
                        js9Var4.x(G.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    js9Var4.s(true);
                    js9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        js9Var4.y(o.f());
                        js9Var4.u(o.b());
                        js9Var4.o(o.a());
                        js9Var4.x(o.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    js9Var4.s(true);
                    js9 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        js9Var4.y(n.f());
                        js9Var4.u(n.b());
                        js9Var4.o(n.a());
                        js9Var4.x(n.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    js9Var4.s(true);
                    js9 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        js9Var4.y(m.f());
                        js9Var4.u(m.b());
                        js9Var4.o(m.a());
                        js9Var4.x(m.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    js9Var4.s(true);
                    js9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        js9Var4.y(k.f());
                        js9Var4.u(k.b());
                        js9Var4.o(k.a());
                        js9Var4.x(k.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    js9Var4.s(true);
                    js9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        js9Var4.y(j.f());
                        js9Var4.u(j.b());
                        js9Var4.o(j.a());
                        js9Var4.x(j.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/installGameApk")) {
                    js9Var4.s(true);
                    js9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        js9Var4.y(w.f());
                        js9Var4.u(w.b());
                        js9Var4.o(w.a());
                        js9Var4.x(w.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/launchApk")) {
                    js9Var4.s(true);
                    js9 z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        js9Var4.y(z.f());
                        js9Var4.u(z.b());
                        js9Var4.o(z.a());
                        js9Var4.x(z.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    js9Var4.s(true);
                    js9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        js9Var4.y(r.f());
                        js9Var4.u(r.b());
                        js9Var4.o(r.a());
                        js9Var4.x(r.e());
                    }
                    js9Var4.z(0);
                    return js9Var4;
                } else {
                    return js9Var4;
                }
            }
            return js9Var2;
        }
        return (js9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public jh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (jh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            js9 js9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                js9Var = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                js9Var = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                js9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                js9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                js9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                js9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                js9Var = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                js9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                js9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (js9Var != null) {
                js9Var.z(0);
            }
            List<is9> list = this.mAsyncCallBackMethodList.get(str);
            if (js9Var != null && list != null) {
                Iterator<is9> it = list.iterator();
                if (!TextUtils.isEmpty(js9Var.e())) {
                    while (it.hasNext()) {
                        is9 next = it.next();
                        if (next.b().equals(js9Var.e())) {
                            js9 js9Var2 = new js9();
                            js9Var2.w(next.a());
                            js9Var2.y(js9Var.f());
                            js9Var2.u(js9Var.b());
                            js9Var2.o(js9Var.a());
                            js9Var2.A(js9Var.l());
                            arrayList.add(js9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        is9 next2 = it.next();
                        js9 js9Var3 = new js9();
                        js9Var3.w(next2.a());
                        js9Var3.y(js9Var.f());
                        js9Var3.u(js9Var.b());
                        js9Var3.o(js9Var.a());
                        js9Var3.A(js9Var.l());
                        arrayList.add(js9Var3);
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
