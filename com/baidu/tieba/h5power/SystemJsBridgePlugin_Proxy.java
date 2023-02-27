package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.l69;
import com.baidu.tieba.m69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
import com.baidu.tieba.xv4;
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
public class SystemJsBridgePlugin_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xv4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(xv4 xv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xv4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = xv4Var;
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

    @Override // com.baidu.tieba.l69
    public n69 dispatch(WebView webView, p69 p69Var, n69 n69Var) {
        InterceptResult invokeLLL;
        n69 n69Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, p69Var, n69Var)) == null) {
            if (n69Var == null) {
                n69Var2 = new n69();
            } else {
                n69Var2 = n69Var;
            }
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("system/saveImage")) {
                n69Var2.r(true);
                n69 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    n69Var2.x(u.f());
                    n69Var2.t(u.b());
                    n69Var2.o(u.a());
                    n69Var2.w(u.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver(webView, "saveImageSuccess", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                n69Var2.r(true);
                n69 B = this.mJsBridge.B(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (B != null) {
                    n69Var2.x(B.f());
                    n69Var2.t(B.b());
                    n69Var2.o(B.a());
                    n69Var2.w(B.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver(webView, "orderGameApkResult", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                n69Var2.r(true);
                n69 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    n69Var2.x(t.f());
                    n69Var2.t(t.b());
                    n69Var2.o(t.a());
                    n69Var2.w(t.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                n69Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                n69 H = this.mJsBridge.H(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (H != null) {
                    n69Var2.x(H.f());
                    n69Var2.t(H.b());
                    n69Var2.o(H.a());
                    n69Var2.w(H.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("system/playSound")) {
                n69Var2.r(true);
                n69 D = this.mJsBridge.D(webView, e.optString("soundUrl"));
                if (D != null) {
                    n69Var2.x(D.f());
                    n69Var2.t(D.b());
                    n69Var2.o(D.a());
                    n69Var2.w(D.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                n69Var2.r(true);
                n69 E = this.mJsBridge.E(webView);
                if (E != null) {
                    n69Var2.x(E.f());
                    n69Var2.t(E.b());
                    n69Var2.o(E.a());
                    n69Var2.w(E.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                n69Var2.r(true);
                n69 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    n69Var2.x(f.f());
                    n69Var2.t(f.b());
                    n69Var2.o(f.a());
                    n69Var2.w(f.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                n69Var2.r(true);
                n69 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    n69Var2.x(d.f());
                    n69Var2.t(d.b());
                    n69Var2.o(d.a());
                    n69Var2.w(d.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                n69Var2.r(true);
                n69 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    n69Var2.x(i.f());
                    n69Var2.t(i.b());
                    n69Var2.o(i.a());
                    n69Var2.w(i.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/startApp")) {
                n69Var2.r(true);
                n69 J = this.mJsBridge.J(webView, e.optString("pkgName"), e.optString("schema"));
                if (J != null) {
                    n69Var2.x(J.f());
                    n69Var2.t(J.b());
                    n69Var2.o(J.a());
                    n69Var2.w(J.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                n69Var2.r(true);
                n69 v = this.mJsBridge.v(webView);
                if (v != null) {
                    n69Var2.x(v.f());
                    n69Var2.t(v.b());
                    n69Var2.o(v.a());
                    n69Var2.w(v.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                n69Var2.r(true);
                n69 s = this.mJsBridge.s(webView);
                if (s != null) {
                    n69Var2.x(s.f());
                    n69Var2.t(s.b());
                    n69Var2.o(s.a());
                    n69Var2.w(s.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                n69Var2.r(true);
                n69 n69Var3 = n69Var2;
                n69 K = this.mJsBridge.K(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (K != null) {
                    n69Var3.x(K.f());
                    n69Var3.t(K.b());
                    n69Var3.o(K.a());
                    n69Var3.w(K.e());
                }
                n69Var3.y(0);
                return n69Var3;
            } else {
                n69 n69Var4 = n69Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    n69Var4.r(true);
                    n69 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        n69Var4.x(e2.f());
                        n69Var4.t(e2.b());
                        n69Var4.o(e2.a());
                        n69Var4.w(e2.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/getAppStorage")) {
                    n69Var4.r(true);
                    n69 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        n69Var4.x(l.f());
                        n69Var4.t(l.b());
                        n69Var4.o(l.a());
                        n69Var4.w(l.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/putAppStorage")) {
                    n69Var4.r(true);
                    n69 F = this.mJsBridge.F(webView, e.optString("key"), e.optString("data"));
                    if (F != null) {
                        n69Var4.x(F.f());
                        n69Var4.t(F.b());
                        n69Var4.o(F.a());
                        n69Var4.w(F.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    n69Var4.r(true);
                    n69 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        n69Var4.x(o.f());
                        n69Var4.t(o.b());
                        n69Var4.o(o.a());
                        n69Var4.w(o.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    n69Var4.r(true);
                    n69 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        n69Var4.x(n.f());
                        n69Var4.t(n.b());
                        n69Var4.o(n.a());
                        n69Var4.w(n.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    n69Var4.r(true);
                    n69 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        n69Var4.x(m.f());
                        n69Var4.t(m.b());
                        n69Var4.o(m.a());
                        n69Var4.w(m.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    n69Var4.r(true);
                    n69 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        n69Var4.x(k.f());
                        n69Var4.t(k.b());
                        n69Var4.o(k.a());
                        n69Var4.w(k.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    n69Var4.r(true);
                    n69 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        n69Var4.x(j.f());
                        n69Var4.t(j.b());
                        n69Var4.o(j.a());
                        n69Var4.w(j.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/installGameApk")) {
                    n69Var4.r(true);
                    n69 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        n69Var4.x(w.f());
                        n69Var4.t(w.b());
                        n69Var4.o(w.a());
                        n69Var4.w(w.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/launchApk")) {
                    n69Var4.r(true);
                    n69 y = this.mJsBridge.y(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        n69Var4.x(y.f());
                        n69Var4.t(y.b());
                        n69Var4.o(y.a());
                        n69Var4.w(y.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    n69Var4.r(true);
                    n69 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        n69Var4.x(r.f());
                        n69Var4.t(r.b());
                        n69Var4.o(r.a());
                        n69Var4.w(r.e());
                    }
                    n69Var4.y(0);
                    return n69Var4;
                } else {
                    return n69Var4;
                }
            }
            return n69Var2;
        }
        return (n69) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            n69 n69Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                n69Var = this.mJsBridge.G(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                n69Var = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                n69Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                n69Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                n69Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                n69Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                n69Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                n69Var = this.mJsBridge.z(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                n69Var = this.mJsBridge.c(webView, hashMap);
            }
            if (n69Var != null) {
                n69Var.y(0);
            }
            List<m69> list = this.mAsyncCallBackMethodList.get(str);
            if (n69Var != null && list != null) {
                Iterator<m69> it = list.iterator();
                if (!TextUtils.isEmpty(n69Var.e())) {
                    while (it.hasNext()) {
                        m69 next = it.next();
                        if (next.b().equals(n69Var.e())) {
                            n69 n69Var2 = new n69();
                            n69Var2.v(next.a());
                            n69Var2.x(n69Var.f());
                            n69Var2.t(n69Var.b());
                            n69Var2.o(n69Var.a());
                            n69Var2.z(n69Var.l());
                            arrayList.add(n69Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        m69 next2 = it.next();
                        n69 n69Var3 = new n69();
                        n69Var3.v(next2.a());
                        n69Var3.x(n69Var.f());
                        n69Var3.t(n69Var.b());
                        n69Var3.o(n69Var.a());
                        n69Var3.z(n69Var.l());
                        arrayList.add(n69Var3);
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
