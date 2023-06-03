package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.sl6;
import com.baidu.tieba.uy4;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
public class SystemJsBridgePlugin_Proxy extends uy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uy4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(uy4 uy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = uy4Var;
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

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(WebView webView, yy9 yy9Var, wy9 wy9Var) {
        InterceptResult invokeLLL;
        wy9 wy9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, yy9Var, wy9Var)) == null) {
            if (wy9Var == null) {
                wy9Var2 = new wy9();
            } else {
                wy9Var2 = wy9Var;
            }
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("system/saveImage")) {
                wy9Var2.s(true);
                wy9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    wy9Var2.y(u.f());
                    wy9Var2.u(u.b());
                    wy9Var2.o(u.a());
                    wy9Var2.x(u.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                wy9Var2.s(true);
                wy9 C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    wy9Var2.y(C.f());
                    wy9Var2.u(C.b());
                    wy9Var2.o(C.a());
                    wy9Var2.x(C.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                wy9Var2.s(true);
                wy9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    wy9Var2.y(t.f());
                    wy9Var2.u(t.b());
                    wy9Var2.o(t.a());
                    wy9Var2.x(t.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                wy9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                wy9 I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    wy9Var2.y(I.f());
                    wy9Var2.u(I.b());
                    wy9Var2.o(I.a());
                    wy9Var2.x(I.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("system/playSound")) {
                wy9Var2.s(true);
                wy9 E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    wy9Var2.y(E.f());
                    wy9Var2.u(E.b());
                    wy9Var2.o(E.a());
                    wy9Var2.x(E.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                wy9Var2.s(true);
                wy9 F = this.mJsBridge.F(webView);
                if (F != null) {
                    wy9Var2.y(F.f());
                    wy9Var2.u(F.b());
                    wy9Var2.o(F.a());
                    wy9Var2.x(F.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                wy9Var2.s(true);
                wy9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    wy9Var2.y(f.f());
                    wy9Var2.u(f.b());
                    wy9Var2.o(f.a());
                    wy9Var2.x(f.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                wy9Var2.s(true);
                wy9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    wy9Var2.y(d.f());
                    wy9Var2.u(d.b());
                    wy9Var2.o(d.a());
                    wy9Var2.x(d.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                wy9Var2.s(true);
                wy9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    wy9Var2.y(i.f());
                    wy9Var2.u(i.b());
                    wy9Var2.o(i.a());
                    wy9Var2.x(i.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                wy9Var2.s(true);
                wy9 K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    wy9Var2.y(K.f());
                    wy9Var2.u(K.b());
                    wy9Var2.o(K.a());
                    wy9Var2.x(K.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                wy9Var2.s(true);
                wy9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    wy9Var2.y(v.f());
                    wy9Var2.u(v.b());
                    wy9Var2.o(v.a());
                    wy9Var2.x(v.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                wy9Var2.s(true);
                wy9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    wy9Var2.y(s.f());
                    wy9Var2.u(s.b());
                    wy9Var2.o(s.a());
                    wy9Var2.x(s.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                wy9Var2.s(true);
                wy9 wy9Var3 = wy9Var2;
                wy9 L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    wy9Var3.y(L.f());
                    wy9Var3.u(L.b());
                    wy9Var3.o(L.a());
                    wy9Var3.x(L.e());
                }
                wy9Var3.z(0);
                return wy9Var3;
            } else {
                wy9 wy9Var4 = wy9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    wy9Var4.s(true);
                    wy9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        wy9Var4.y(e2.f());
                        wy9Var4.u(e2.b());
                        wy9Var4.o(e2.a());
                        wy9Var4.x(e2.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    wy9Var4.s(true);
                    wy9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        wy9Var4.y(l.f());
                        wy9Var4.u(l.b());
                        wy9Var4.o(l.a());
                        wy9Var4.x(l.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    wy9Var4.s(true);
                    wy9 G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        wy9Var4.y(G.f());
                        wy9Var4.u(G.b());
                        wy9Var4.o(G.a());
                        wy9Var4.x(G.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    wy9Var4.s(true);
                    wy9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        wy9Var4.y(o.f());
                        wy9Var4.u(o.b());
                        wy9Var4.o(o.a());
                        wy9Var4.x(o.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    wy9Var4.s(true);
                    wy9 n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        wy9Var4.y(n.f());
                        wy9Var4.u(n.b());
                        wy9Var4.o(n.a());
                        wy9Var4.x(n.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    wy9Var4.s(true);
                    wy9 m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        wy9Var4.y(m.f());
                        wy9Var4.u(m.b());
                        wy9Var4.o(m.a());
                        wy9Var4.x(m.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    wy9Var4.s(true);
                    wy9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        wy9Var4.y(k.f());
                        wy9Var4.u(k.b());
                        wy9Var4.o(k.a());
                        wy9Var4.x(k.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    wy9Var4.s(true);
                    wy9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        wy9Var4.y(j.f());
                        wy9Var4.u(j.b());
                        wy9Var4.o(j.a());
                        wy9Var4.x(j.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/installGameApk")) {
                    wy9Var4.s(true);
                    wy9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        wy9Var4.y(w.f());
                        wy9Var4.u(w.b());
                        wy9Var4.o(w.a());
                        wy9Var4.x(w.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/launchApk")) {
                    wy9Var4.s(true);
                    wy9 z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        wy9Var4.y(z.f());
                        wy9Var4.u(z.b());
                        wy9Var4.o(z.a());
                        wy9Var4.x(z.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    wy9Var4.s(true);
                    wy9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        wy9Var4.y(r.f());
                        wy9Var4.u(r.b());
                        wy9Var4.o(r.a());
                        wy9Var4.x(r.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else if (b.equals("system/wakeKeyboard")) {
                    wy9Var4.s(true);
                    wy9 M = this.mJsBridge.M(webView);
                    if (M != null) {
                        wy9Var4.y(M.f());
                        wy9Var4.u(M.b());
                        wy9Var4.o(M.a());
                        wy9Var4.x(M.e());
                    }
                    wy9Var4.z(0);
                    return wy9Var4;
                } else {
                    return wy9Var4;
                }
            }
            return wy9Var2;
        }
        return (wy9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public sl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (sl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            wy9 wy9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                wy9Var = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                wy9Var = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                wy9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                wy9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                wy9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                wy9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                wy9Var = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                wy9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                wy9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (wy9Var != null) {
                wy9Var.z(0);
            }
            List<vy9> list = this.mAsyncCallBackMethodList.get(str);
            if (wy9Var != null && list != null) {
                Iterator<vy9> it = list.iterator();
                if (!TextUtils.isEmpty(wy9Var.e())) {
                    while (it.hasNext()) {
                        vy9 next = it.next();
                        if (next.b().equals(wy9Var.e())) {
                            wy9 wy9Var2 = new wy9();
                            wy9Var2.w(next.a());
                            wy9Var2.y(wy9Var.f());
                            wy9Var2.u(wy9Var.b());
                            wy9Var2.o(wy9Var.a());
                            wy9Var2.A(wy9Var.l());
                            arrayList.add(wy9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        vy9 next2 = it.next();
                        wy9 wy9Var3 = new wy9();
                        wy9Var3.w(next2.a());
                        wy9Var3.y(wy9Var.f());
                        wy9Var3.u(wy9Var.b());
                        wy9Var3.o(wy9Var.a());
                        wy9Var3.A(wy9Var.l());
                        arrayList.add(wy9Var3);
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
