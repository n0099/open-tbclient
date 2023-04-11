package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.gu4;
import com.baidu.tieba.im9;
import com.baidu.tieba.jm9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
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
public class SystemJsBridgePlugin_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gu4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(gu4 gu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = gu4Var;
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

    @Override // com.baidu.tieba.im9
    public km9 dispatch(WebView webView, mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLLL;
        km9 km9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mm9Var, km9Var)) == null) {
            if (km9Var == null) {
                km9Var2 = new km9();
            } else {
                km9Var2 = km9Var;
            }
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("system/saveImage")) {
                km9Var2.r(true);
                km9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    km9Var2.x(u.f());
                    km9Var2.t(u.b());
                    km9Var2.o(u.a());
                    km9Var2.w(u.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                km9Var2.r(true);
                km9 B = this.mJsBridge.B(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (B != null) {
                    km9Var2.x(B.f());
                    km9Var2.t(B.b());
                    km9Var2.o(B.a());
                    km9Var2.w(B.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                km9Var2.r(true);
                km9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    km9Var2.x(t.f());
                    km9Var2.t(t.b());
                    km9Var2.o(t.a());
                    km9Var2.w(t.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                km9Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                km9 H = this.mJsBridge.H(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (H != null) {
                    km9Var2.x(H.f());
                    km9Var2.t(H.b());
                    km9Var2.o(H.a());
                    km9Var2.w(H.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("system/playSound")) {
                km9Var2.r(true);
                km9 D = this.mJsBridge.D(webView, e.optString("soundUrl"));
                if (D != null) {
                    km9Var2.x(D.f());
                    km9Var2.t(D.b());
                    km9Var2.o(D.a());
                    km9Var2.w(D.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                km9Var2.r(true);
                km9 E = this.mJsBridge.E(webView);
                if (E != null) {
                    km9Var2.x(E.f());
                    km9Var2.t(E.b());
                    km9Var2.o(E.a());
                    km9Var2.w(E.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                km9Var2.r(true);
                km9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    km9Var2.x(f.f());
                    km9Var2.t(f.b());
                    km9Var2.o(f.a());
                    km9Var2.w(f.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                km9Var2.r(true);
                km9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    km9Var2.x(d.f());
                    km9Var2.t(d.b());
                    km9Var2.o(d.a());
                    km9Var2.w(d.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                km9Var2.r(true);
                km9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    km9Var2.x(i.f());
                    km9Var2.t(i.b());
                    km9Var2.o(i.a());
                    km9Var2.w(i.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/startApp")) {
                km9Var2.r(true);
                km9 J = this.mJsBridge.J(webView, e.optString("pkgName"), e.optString("schema"));
                if (J != null) {
                    km9Var2.x(J.f());
                    km9Var2.t(J.b());
                    km9Var2.o(J.a());
                    km9Var2.w(J.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                km9Var2.r(true);
                km9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    km9Var2.x(v.f());
                    km9Var2.t(v.b());
                    km9Var2.o(v.a());
                    km9Var2.w(v.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                km9Var2.r(true);
                km9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    km9Var2.x(s.f());
                    km9Var2.t(s.b());
                    km9Var2.o(s.a());
                    km9Var2.w(s.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                km9Var2.r(true);
                km9 km9Var3 = km9Var2;
                km9 K = this.mJsBridge.K(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (K != null) {
                    km9Var3.x(K.f());
                    km9Var3.t(K.b());
                    km9Var3.o(K.a());
                    km9Var3.w(K.e());
                }
                km9Var3.y(0);
                return km9Var3;
            } else {
                km9 km9Var4 = km9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    km9Var4.r(true);
                    km9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        km9Var4.x(e2.f());
                        km9Var4.t(e2.b());
                        km9Var4.o(e2.a());
                        km9Var4.w(e2.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    km9Var4.r(true);
                    km9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        km9Var4.x(l.f());
                        km9Var4.t(l.b());
                        km9Var4.o(l.a());
                        km9Var4.w(l.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    km9Var4.r(true);
                    km9 F = this.mJsBridge.F(webView, e.optString("key"), e.optString("data"));
                    if (F != null) {
                        km9Var4.x(F.f());
                        km9Var4.t(F.b());
                        km9Var4.o(F.a());
                        km9Var4.w(F.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    km9Var4.r(true);
                    km9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        km9Var4.x(o.f());
                        km9Var4.t(o.b());
                        km9Var4.o(o.a());
                        km9Var4.w(o.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    km9Var4.r(true);
                    km9 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        km9Var4.x(n.f());
                        km9Var4.t(n.b());
                        km9Var4.o(n.a());
                        km9Var4.w(n.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    km9Var4.r(true);
                    km9 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        km9Var4.x(m.f());
                        km9Var4.t(m.b());
                        km9Var4.o(m.a());
                        km9Var4.w(m.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    km9Var4.r(true);
                    km9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        km9Var4.x(k.f());
                        km9Var4.t(k.b());
                        km9Var4.o(k.a());
                        km9Var4.w(k.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    km9Var4.r(true);
                    km9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        km9Var4.x(j.f());
                        km9Var4.t(j.b());
                        km9Var4.o(j.a());
                        km9Var4.w(j.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/installGameApk")) {
                    km9Var4.r(true);
                    km9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        km9Var4.x(w.f());
                        km9Var4.t(w.b());
                        km9Var4.o(w.a());
                        km9Var4.w(w.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/launchApk")) {
                    km9Var4.r(true);
                    km9 y = this.mJsBridge.y(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        km9Var4.x(y.f());
                        km9Var4.t(y.b());
                        km9Var4.o(y.a());
                        km9Var4.w(y.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    km9Var4.r(true);
                    km9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        km9Var4.x(r.f());
                        km9Var4.t(r.b());
                        km9Var4.o(r.a());
                        km9Var4.w(r.e());
                    }
                    km9Var4.y(0);
                    return km9Var4;
                } else {
                    return km9Var4;
                }
            }
            return km9Var2;
        }
        return (km9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            km9 km9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                km9Var = this.mJsBridge.G(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                km9Var = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                km9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                km9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                km9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                km9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                km9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                km9Var = this.mJsBridge.z(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                km9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (km9Var != null) {
                km9Var.y(0);
            }
            List<jm9> list = this.mAsyncCallBackMethodList.get(str);
            if (km9Var != null && list != null) {
                Iterator<jm9> it = list.iterator();
                if (!TextUtils.isEmpty(km9Var.e())) {
                    while (it.hasNext()) {
                        jm9 next = it.next();
                        if (next.b().equals(km9Var.e())) {
                            km9 km9Var2 = new km9();
                            km9Var2.v(next.a());
                            km9Var2.x(km9Var.f());
                            km9Var2.t(km9Var.b());
                            km9Var2.o(km9Var.a());
                            km9Var2.z(km9Var.l());
                            arrayList.add(km9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jm9 next2 = it.next();
                        km9 km9Var3 = new km9();
                        km9Var3.v(next2.a());
                        km9Var3.x(km9Var.f());
                        km9Var3.t(km9Var.b());
                        km9Var3.o(km9Var.a());
                        km9Var3.z(km9Var.l());
                        arrayList.add(km9Var3);
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
