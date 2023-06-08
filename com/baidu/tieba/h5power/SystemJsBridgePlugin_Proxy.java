package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ul6;
import com.baidu.tieba.uy4;
import com.baidu.tieba.zy9;
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
public class SystemJsBridgePlugin_Proxy extends zy9 {
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

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(WebView webView, dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLLL;
        bz9 bz9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, dz9Var, bz9Var)) == null) {
            if (bz9Var == null) {
                bz9Var2 = new bz9();
            } else {
                bz9Var2 = bz9Var;
            }
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("system/saveImage")) {
                bz9Var2.s(true);
                bz9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    bz9Var2.y(u.f());
                    bz9Var2.u(u.b());
                    bz9Var2.o(u.a());
                    bz9Var2.x(u.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                bz9Var2.s(true);
                bz9 C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    bz9Var2.y(C.f());
                    bz9Var2.u(C.b());
                    bz9Var2.o(C.a());
                    bz9Var2.x(C.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                bz9Var2.s(true);
                bz9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    bz9Var2.y(t.f());
                    bz9Var2.u(t.b());
                    bz9Var2.o(t.a());
                    bz9Var2.x(t.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                bz9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                bz9 I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    bz9Var2.y(I.f());
                    bz9Var2.u(I.b());
                    bz9Var2.o(I.a());
                    bz9Var2.x(I.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/playSound")) {
                bz9Var2.s(true);
                bz9 E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    bz9Var2.y(E.f());
                    bz9Var2.u(E.b());
                    bz9Var2.o(E.a());
                    bz9Var2.x(E.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                bz9Var2.s(true);
                bz9 F = this.mJsBridge.F(webView);
                if (F != null) {
                    bz9Var2.y(F.f());
                    bz9Var2.u(F.b());
                    bz9Var2.o(F.a());
                    bz9Var2.x(F.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                bz9Var2.s(true);
                bz9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    bz9Var2.y(f.f());
                    bz9Var2.u(f.b());
                    bz9Var2.o(f.a());
                    bz9Var2.x(f.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                bz9Var2.s(true);
                bz9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    bz9Var2.y(d.f());
                    bz9Var2.u(d.b());
                    bz9Var2.o(d.a());
                    bz9Var2.x(d.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                bz9Var2.s(true);
                bz9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    bz9Var2.y(i.f());
                    bz9Var2.u(i.b());
                    bz9Var2.o(i.a());
                    bz9Var2.x(i.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                bz9Var2.s(true);
                bz9 K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    bz9Var2.y(K.f());
                    bz9Var2.u(K.b());
                    bz9Var2.o(K.a());
                    bz9Var2.x(K.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                bz9Var2.s(true);
                bz9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    bz9Var2.y(v.f());
                    bz9Var2.u(v.b());
                    bz9Var2.o(v.a());
                    bz9Var2.x(v.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                bz9Var2.s(true);
                bz9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    bz9Var2.y(s.f());
                    bz9Var2.u(s.b());
                    bz9Var2.o(s.a());
                    bz9Var2.x(s.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                bz9Var2.s(true);
                bz9 bz9Var3 = bz9Var2;
                bz9 L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    bz9Var3.y(L.f());
                    bz9Var3.u(L.b());
                    bz9Var3.o(L.a());
                    bz9Var3.x(L.e());
                }
                bz9Var3.z(0);
                return bz9Var3;
            } else {
                bz9 bz9Var4 = bz9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    bz9Var4.s(true);
                    bz9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        bz9Var4.y(e2.f());
                        bz9Var4.u(e2.b());
                        bz9Var4.o(e2.a());
                        bz9Var4.x(e2.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    bz9Var4.s(true);
                    bz9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        bz9Var4.y(l.f());
                        bz9Var4.u(l.b());
                        bz9Var4.o(l.a());
                        bz9Var4.x(l.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    bz9Var4.s(true);
                    bz9 G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        bz9Var4.y(G.f());
                        bz9Var4.u(G.b());
                        bz9Var4.o(G.a());
                        bz9Var4.x(G.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    bz9Var4.s(true);
                    bz9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        bz9Var4.y(o.f());
                        bz9Var4.u(o.b());
                        bz9Var4.o(o.a());
                        bz9Var4.x(o.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    bz9Var4.s(true);
                    bz9 n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        bz9Var4.y(n.f());
                        bz9Var4.u(n.b());
                        bz9Var4.o(n.a());
                        bz9Var4.x(n.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    bz9Var4.s(true);
                    bz9 m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        bz9Var4.y(m.f());
                        bz9Var4.u(m.b());
                        bz9Var4.o(m.a());
                        bz9Var4.x(m.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    bz9Var4.s(true);
                    bz9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        bz9Var4.y(k.f());
                        bz9Var4.u(k.b());
                        bz9Var4.o(k.a());
                        bz9Var4.x(k.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    bz9Var4.s(true);
                    bz9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        bz9Var4.y(j.f());
                        bz9Var4.u(j.b());
                        bz9Var4.o(j.a());
                        bz9Var4.x(j.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/installGameApk")) {
                    bz9Var4.s(true);
                    bz9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        bz9Var4.y(w.f());
                        bz9Var4.u(w.b());
                        bz9Var4.o(w.a());
                        bz9Var4.x(w.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/launchApk")) {
                    bz9Var4.s(true);
                    bz9 z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        bz9Var4.y(z.f());
                        bz9Var4.u(z.b());
                        bz9Var4.o(z.a());
                        bz9Var4.x(z.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    bz9Var4.s(true);
                    bz9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        bz9Var4.y(r.f());
                        bz9Var4.u(r.b());
                        bz9Var4.o(r.a());
                        bz9Var4.x(r.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else if (b.equals("system/wakeKeyboard")) {
                    bz9Var4.s(true);
                    bz9 M = this.mJsBridge.M(webView);
                    if (M != null) {
                        bz9Var4.y(M.f());
                        bz9Var4.u(M.b());
                        bz9Var4.o(M.a());
                        bz9Var4.x(M.e());
                    }
                    bz9Var4.z(0);
                    return bz9Var4;
                } else {
                    return bz9Var4;
                }
            }
            return bz9Var2;
        }
        return (bz9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public ul6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (ul6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                bz9Var = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                bz9Var = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                bz9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                bz9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                bz9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                bz9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                bz9Var = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                bz9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                bz9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!TextUtils.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
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
