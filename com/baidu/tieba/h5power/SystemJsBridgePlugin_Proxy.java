package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cw4;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.kh6;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class SystemJsBridgePlugin_Proxy extends is9 {
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

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(WebView webView, ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLLL;
        ks9 ks9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ms9Var, ks9Var)) == null) {
            if (ks9Var == null) {
                ks9Var2 = new ks9();
            } else {
                ks9Var2 = ks9Var;
            }
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("system/saveImage")) {
                ks9Var2.s(true);
                ks9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    ks9Var2.y(u.f());
                    ks9Var2.u(u.b());
                    ks9Var2.o(u.a());
                    ks9Var2.x(u.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                ks9Var2.s(true);
                ks9 C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    ks9Var2.y(C.f());
                    ks9Var2.u(C.b());
                    ks9Var2.o(C.a());
                    ks9Var2.x(C.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                ks9Var2.s(true);
                ks9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    ks9Var2.y(t.f());
                    ks9Var2.u(t.b());
                    ks9Var2.o(t.a());
                    ks9Var2.x(t.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                ks9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                ks9 I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    ks9Var2.y(I.f());
                    ks9Var2.u(I.b());
                    ks9Var2.o(I.a());
                    ks9Var2.x(I.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("system/playSound")) {
                ks9Var2.s(true);
                ks9 E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    ks9Var2.y(E.f());
                    ks9Var2.u(E.b());
                    ks9Var2.o(E.a());
                    ks9Var2.x(E.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                ks9Var2.s(true);
                ks9 F = this.mJsBridge.F(webView);
                if (F != null) {
                    ks9Var2.y(F.f());
                    ks9Var2.u(F.b());
                    ks9Var2.o(F.a());
                    ks9Var2.x(F.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                ks9Var2.s(true);
                ks9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    ks9Var2.y(f.f());
                    ks9Var2.u(f.b());
                    ks9Var2.o(f.a());
                    ks9Var2.x(f.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                ks9Var2.s(true);
                ks9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    ks9Var2.y(d.f());
                    ks9Var2.u(d.b());
                    ks9Var2.o(d.a());
                    ks9Var2.x(d.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                ks9Var2.s(true);
                ks9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    ks9Var2.y(i.f());
                    ks9Var2.u(i.b());
                    ks9Var2.o(i.a());
                    ks9Var2.x(i.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                ks9Var2.s(true);
                ks9 K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    ks9Var2.y(K.f());
                    ks9Var2.u(K.b());
                    ks9Var2.o(K.a());
                    ks9Var2.x(K.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                ks9Var2.s(true);
                ks9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    ks9Var2.y(v.f());
                    ks9Var2.u(v.b());
                    ks9Var2.o(v.a());
                    ks9Var2.x(v.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                ks9Var2.s(true);
                ks9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    ks9Var2.y(s.f());
                    ks9Var2.u(s.b());
                    ks9Var2.o(s.a());
                    ks9Var2.x(s.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                ks9Var2.s(true);
                ks9 ks9Var3 = ks9Var2;
                ks9 L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    ks9Var3.y(L.f());
                    ks9Var3.u(L.b());
                    ks9Var3.o(L.a());
                    ks9Var3.x(L.e());
                }
                ks9Var3.z(0);
                return ks9Var3;
            } else {
                ks9 ks9Var4 = ks9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    ks9Var4.s(true);
                    ks9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        ks9Var4.y(e2.f());
                        ks9Var4.u(e2.b());
                        ks9Var4.o(e2.a());
                        ks9Var4.x(e2.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    ks9Var4.s(true);
                    ks9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        ks9Var4.y(l.f());
                        ks9Var4.u(l.b());
                        ks9Var4.o(l.a());
                        ks9Var4.x(l.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    ks9Var4.s(true);
                    ks9 G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        ks9Var4.y(G.f());
                        ks9Var4.u(G.b());
                        ks9Var4.o(G.a());
                        ks9Var4.x(G.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    ks9Var4.s(true);
                    ks9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        ks9Var4.y(o.f());
                        ks9Var4.u(o.b());
                        ks9Var4.o(o.a());
                        ks9Var4.x(o.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    ks9Var4.s(true);
                    ks9 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        ks9Var4.y(n.f());
                        ks9Var4.u(n.b());
                        ks9Var4.o(n.a());
                        ks9Var4.x(n.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    ks9Var4.s(true);
                    ks9 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        ks9Var4.y(m.f());
                        ks9Var4.u(m.b());
                        ks9Var4.o(m.a());
                        ks9Var4.x(m.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    ks9Var4.s(true);
                    ks9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        ks9Var4.y(k.f());
                        ks9Var4.u(k.b());
                        ks9Var4.o(k.a());
                        ks9Var4.x(k.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    ks9Var4.s(true);
                    ks9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        ks9Var4.y(j.f());
                        ks9Var4.u(j.b());
                        ks9Var4.o(j.a());
                        ks9Var4.x(j.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/installGameApk")) {
                    ks9Var4.s(true);
                    ks9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        ks9Var4.y(w.f());
                        ks9Var4.u(w.b());
                        ks9Var4.o(w.a());
                        ks9Var4.x(w.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/launchApk")) {
                    ks9Var4.s(true);
                    ks9 z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        ks9Var4.y(z.f());
                        ks9Var4.u(z.b());
                        ks9Var4.o(z.a());
                        ks9Var4.x(z.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    ks9Var4.s(true);
                    ks9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        ks9Var4.y(r.f());
                        ks9Var4.u(r.b());
                        ks9Var4.o(r.a());
                        ks9Var4.x(r.e());
                    }
                    ks9Var4.z(0);
                    return ks9Var4;
                } else {
                    return ks9Var4;
                }
            }
            return ks9Var2;
        }
        return (ks9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.is9
    public kh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (kh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ks9 ks9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                ks9Var = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                ks9Var = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                ks9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                ks9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                ks9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                ks9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                ks9Var = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                ks9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                ks9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (ks9Var != null) {
                ks9Var.z(0);
            }
            List<js9> list = this.mAsyncCallBackMethodList.get(str);
            if (ks9Var != null && list != null) {
                Iterator<js9> it = list.iterator();
                if (!TextUtils.isEmpty(ks9Var.e())) {
                    while (it.hasNext()) {
                        js9 next = it.next();
                        if (next.b().equals(ks9Var.e())) {
                            ks9 ks9Var2 = new ks9();
                            ks9Var2.w(next.a());
                            ks9Var2.y(ks9Var.f());
                            ks9Var2.u(ks9Var.b());
                            ks9Var2.o(ks9Var.a());
                            ks9Var2.A(ks9Var.l());
                            arrayList.add(ks9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        js9 next2 = it.next();
                        ks9 ks9Var3 = new ks9();
                        ks9Var3.w(next2.a());
                        ks9Var3.y(ks9Var.f());
                        ks9Var3.u(ks9Var.b());
                        ks9Var3.o(ks9Var.a());
                        ks9Var3.A(ks9Var.l());
                        arrayList.add(ks9Var3);
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
