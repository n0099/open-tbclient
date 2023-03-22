package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.eu4;
import com.baidu.tieba.rc9;
import com.baidu.tieba.sc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
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
public class SystemJsBridgePlugin_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eu4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(eu4 eu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = eu4Var;
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

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(WebView webView, vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLLL;
        tc9 tc9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, vc9Var, tc9Var)) == null) {
            if (tc9Var == null) {
                tc9Var2 = new tc9();
            } else {
                tc9Var2 = tc9Var;
            }
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("system/saveImage")) {
                tc9Var2.r(true);
                tc9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    tc9Var2.x(u.f());
                    tc9Var2.t(u.b());
                    tc9Var2.o(u.a());
                    tc9Var2.w(u.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                tc9Var2.r(true);
                tc9 B = this.mJsBridge.B(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (B != null) {
                    tc9Var2.x(B.f());
                    tc9Var2.t(B.b());
                    tc9Var2.o(B.a());
                    tc9Var2.w(B.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                tc9Var2.r(true);
                tc9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    tc9Var2.x(t.f());
                    tc9Var2.t(t.b());
                    tc9Var2.o(t.a());
                    tc9Var2.w(t.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                tc9Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                tc9 H = this.mJsBridge.H(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (H != null) {
                    tc9Var2.x(H.f());
                    tc9Var2.t(H.b());
                    tc9Var2.o(H.a());
                    tc9Var2.w(H.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("system/playSound")) {
                tc9Var2.r(true);
                tc9 D = this.mJsBridge.D(webView, e.optString("soundUrl"));
                if (D != null) {
                    tc9Var2.x(D.f());
                    tc9Var2.t(D.b());
                    tc9Var2.o(D.a());
                    tc9Var2.w(D.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                tc9Var2.r(true);
                tc9 E = this.mJsBridge.E(webView);
                if (E != null) {
                    tc9Var2.x(E.f());
                    tc9Var2.t(E.b());
                    tc9Var2.o(E.a());
                    tc9Var2.w(E.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                tc9Var2.r(true);
                tc9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    tc9Var2.x(f.f());
                    tc9Var2.t(f.b());
                    tc9Var2.o(f.a());
                    tc9Var2.w(f.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                tc9Var2.r(true);
                tc9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    tc9Var2.x(d.f());
                    tc9Var2.t(d.b());
                    tc9Var2.o(d.a());
                    tc9Var2.w(d.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                tc9Var2.r(true);
                tc9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    tc9Var2.x(i.f());
                    tc9Var2.t(i.b());
                    tc9Var2.o(i.a());
                    tc9Var2.w(i.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/startApp")) {
                tc9Var2.r(true);
                tc9 J = this.mJsBridge.J(webView, e.optString("pkgName"), e.optString("schema"));
                if (J != null) {
                    tc9Var2.x(J.f());
                    tc9Var2.t(J.b());
                    tc9Var2.o(J.a());
                    tc9Var2.w(J.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                tc9Var2.r(true);
                tc9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    tc9Var2.x(v.f());
                    tc9Var2.t(v.b());
                    tc9Var2.o(v.a());
                    tc9Var2.w(v.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                tc9Var2.r(true);
                tc9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    tc9Var2.x(s.f());
                    tc9Var2.t(s.b());
                    tc9Var2.o(s.a());
                    tc9Var2.w(s.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                tc9Var2.r(true);
                tc9 tc9Var3 = tc9Var2;
                tc9 K = this.mJsBridge.K(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (K != null) {
                    tc9Var3.x(K.f());
                    tc9Var3.t(K.b());
                    tc9Var3.o(K.a());
                    tc9Var3.w(K.e());
                }
                tc9Var3.y(0);
                return tc9Var3;
            } else {
                tc9 tc9Var4 = tc9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    tc9Var4.r(true);
                    tc9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        tc9Var4.x(e2.f());
                        tc9Var4.t(e2.b());
                        tc9Var4.o(e2.a());
                        tc9Var4.w(e2.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    tc9Var4.r(true);
                    tc9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        tc9Var4.x(l.f());
                        tc9Var4.t(l.b());
                        tc9Var4.o(l.a());
                        tc9Var4.w(l.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    tc9Var4.r(true);
                    tc9 F = this.mJsBridge.F(webView, e.optString("key"), e.optString("data"));
                    if (F != null) {
                        tc9Var4.x(F.f());
                        tc9Var4.t(F.b());
                        tc9Var4.o(F.a());
                        tc9Var4.w(F.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    tc9Var4.r(true);
                    tc9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        tc9Var4.x(o.f());
                        tc9Var4.t(o.b());
                        tc9Var4.o(o.a());
                        tc9Var4.w(o.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    tc9Var4.r(true);
                    tc9 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        tc9Var4.x(n.f());
                        tc9Var4.t(n.b());
                        tc9Var4.o(n.a());
                        tc9Var4.w(n.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    tc9Var4.r(true);
                    tc9 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        tc9Var4.x(m.f());
                        tc9Var4.t(m.b());
                        tc9Var4.o(m.a());
                        tc9Var4.w(m.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    tc9Var4.r(true);
                    tc9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        tc9Var4.x(k.f());
                        tc9Var4.t(k.b());
                        tc9Var4.o(k.a());
                        tc9Var4.w(k.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    tc9Var4.r(true);
                    tc9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        tc9Var4.x(j.f());
                        tc9Var4.t(j.b());
                        tc9Var4.o(j.a());
                        tc9Var4.w(j.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/installGameApk")) {
                    tc9Var4.r(true);
                    tc9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        tc9Var4.x(w.f());
                        tc9Var4.t(w.b());
                        tc9Var4.o(w.a());
                        tc9Var4.w(w.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/launchApk")) {
                    tc9Var4.r(true);
                    tc9 y = this.mJsBridge.y(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        tc9Var4.x(y.f());
                        tc9Var4.t(y.b());
                        tc9Var4.o(y.a());
                        tc9Var4.w(y.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    tc9Var4.r(true);
                    tc9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        tc9Var4.x(r.f());
                        tc9Var4.t(r.b());
                        tc9Var4.o(r.a());
                        tc9Var4.w(r.e());
                    }
                    tc9Var4.y(0);
                    return tc9Var4;
                } else {
                    return tc9Var4;
                }
            }
            return tc9Var2;
        }
        return (tc9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            tc9 tc9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                tc9Var = this.mJsBridge.G(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                tc9Var = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                tc9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                tc9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                tc9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                tc9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                tc9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                tc9Var = this.mJsBridge.z(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                tc9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (tc9Var != null) {
                tc9Var.y(0);
            }
            List<sc9> list = this.mAsyncCallBackMethodList.get(str);
            if (tc9Var != null && list != null) {
                Iterator<sc9> it = list.iterator();
                if (!TextUtils.isEmpty(tc9Var.e())) {
                    while (it.hasNext()) {
                        sc9 next = it.next();
                        if (next.b().equals(tc9Var.e())) {
                            tc9 tc9Var2 = new tc9();
                            tc9Var2.v(next.a());
                            tc9Var2.x(tc9Var.f());
                            tc9Var2.t(tc9Var.b());
                            tc9Var2.o(tc9Var.a());
                            tc9Var2.z(tc9Var.l());
                            arrayList.add(tc9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        sc9 next2 = it.next();
                        tc9 tc9Var3 = new tc9();
                        tc9Var3.v(next2.a());
                        tc9Var3.x(tc9Var.f());
                        tc9Var3.t(tc9Var.b());
                        tc9Var3.o(tc9Var.a());
                        tc9Var3.z(tc9Var.l());
                        arrayList.add(tc9Var3);
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
