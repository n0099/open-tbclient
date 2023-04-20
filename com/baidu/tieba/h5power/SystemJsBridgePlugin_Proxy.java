package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hu4;
import com.baidu.tieba.qm9;
import com.baidu.tieba.rm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
public class SystemJsBridgePlugin_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hu4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(hu4 hu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = hu4Var;
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

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(WebView webView, um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLLL;
        sm9 sm9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, um9Var, sm9Var)) == null) {
            if (sm9Var == null) {
                sm9Var2 = new sm9();
            } else {
                sm9Var2 = sm9Var;
            }
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("system/saveImage")) {
                sm9Var2.r(true);
                sm9 u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    sm9Var2.x(u.f());
                    sm9Var2.t(u.b());
                    sm9Var2.o(u.a());
                    sm9Var2.w(u.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver(webView, "saveImageSuccess", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                sm9Var2.r(true);
                sm9 B = this.mJsBridge.B(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (B != null) {
                    sm9Var2.x(B.f());
                    sm9Var2.t(B.b());
                    sm9Var2.o(B.a());
                    sm9Var2.w(B.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver(webView, "orderGameApkResult", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                sm9Var2.r(true);
                sm9 t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    sm9Var2.x(t.f());
                    sm9Var2.t(t.b());
                    sm9Var2.o(t.a());
                    sm9Var2.w(t.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver(webView, "GetPhotoAlbum", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                sm9Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                sm9 H = this.mJsBridge.H(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (H != null) {
                    sm9Var2.x(H.f());
                    sm9Var2.t(H.b());
                    sm9Var2.o(H.a());
                    sm9Var2.w(H.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver(webView, "selectPhotoAlbum", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("system/playSound")) {
                sm9Var2.r(true);
                sm9 D = this.mJsBridge.D(webView, e.optString("soundUrl"));
                if (D != null) {
                    sm9Var2.x(D.f());
                    sm9Var2.t(D.b());
                    sm9Var2.o(D.a());
                    sm9Var2.w(D.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                sm9Var2.r(true);
                sm9 E = this.mJsBridge.E(webView);
                if (E != null) {
                    sm9Var2.x(E.f());
                    sm9Var2.t(E.b());
                    sm9Var2.o(E.a());
                    sm9Var2.w(E.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                sm9Var2.r(true);
                sm9 f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    sm9Var2.x(f.f());
                    sm9Var2.t(f.b());
                    sm9Var2.o(f.a());
                    sm9Var2.w(f.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                sm9Var2.r(true);
                sm9 d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    sm9Var2.x(d.f());
                    sm9Var2.t(d.b());
                    sm9Var2.o(d.a());
                    sm9Var2.w(d.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                sm9Var2.r(true);
                sm9 i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    sm9Var2.x(i.f());
                    sm9Var2.t(i.b());
                    sm9Var2.o(i.a());
                    sm9Var2.w(i.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/startApp")) {
                sm9Var2.r(true);
                sm9 J = this.mJsBridge.J(webView, e.optString("pkgName"), e.optString("schema"));
                if (J != null) {
                    sm9Var2.x(J.f());
                    sm9Var2.t(J.b());
                    sm9Var2.o(J.a());
                    sm9Var2.w(J.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                sm9Var2.r(true);
                sm9 v = this.mJsBridge.v(webView);
                if (v != null) {
                    sm9Var2.x(v.f());
                    sm9Var2.t(v.b());
                    sm9Var2.o(v.a());
                    sm9Var2.w(v.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                sm9Var2.r(true);
                sm9 s = this.mJsBridge.s(webView);
                if (s != null) {
                    sm9Var2.x(s.f());
                    sm9Var2.t(s.b());
                    sm9Var2.o(s.a());
                    sm9Var2.w(s.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                sm9Var2.r(true);
                sm9 sm9Var3 = sm9Var2;
                sm9 K = this.mJsBridge.K(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (K != null) {
                    sm9Var3.x(K.f());
                    sm9Var3.t(K.b());
                    sm9Var3.o(K.a());
                    sm9Var3.w(K.e());
                }
                sm9Var3.y(0);
                return sm9Var3;
            } else {
                sm9 sm9Var4 = sm9Var2;
                if (b.equals("system/checkInstallGameApk")) {
                    sm9Var4.r(true);
                    sm9 e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        sm9Var4.x(e2.f());
                        sm9Var4.t(e2.b());
                        sm9Var4.o(e2.a());
                        sm9Var4.w(e2.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/getAppStorage")) {
                    sm9Var4.r(true);
                    sm9 l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        sm9Var4.x(l.f());
                        sm9Var4.t(l.b());
                        sm9Var4.o(l.a());
                        sm9Var4.w(l.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/putAppStorage")) {
                    sm9Var4.r(true);
                    sm9 F = this.mJsBridge.F(webView, e.optString("key"), e.optString("data"));
                    if (F != null) {
                        sm9Var4.x(F.f());
                        sm9Var4.t(F.b());
                        sm9Var4.o(F.a());
                        sm9Var4.w(F.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/getHistoryForumData")) {
                    sm9Var4.r(true);
                    sm9 o = this.mJsBridge.o(webView);
                    if (o != null) {
                        sm9Var4.x(o.f());
                        sm9Var4.t(o.b());
                        sm9Var4.o(o.a());
                        sm9Var4.w(o.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    sm9Var4.r(true);
                    sm9 n = this.mJsBridge.n(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        sm9Var4.x(n.f());
                        sm9Var4.t(n.b());
                        sm9Var4.o(n.a());
                        sm9Var4.w(n.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    sm9Var4.r(true);
                    sm9 m = this.mJsBridge.m(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        sm9Var4.x(m.f());
                        sm9Var4.t(m.b());
                        sm9Var4.o(m.a());
                        sm9Var4.w(m.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/fileDownloadPause")) {
                    sm9Var4.r(true);
                    sm9 k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        sm9Var4.x(k.f());
                        sm9Var4.t(k.b());
                        sm9Var4.o(k.a());
                        sm9Var4.w(k.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    sm9Var4.r(true);
                    sm9 j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        sm9Var4.x(j.f());
                        sm9Var4.t(j.b());
                        sm9Var4.o(j.a());
                        sm9Var4.w(j.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/installGameApk")) {
                    sm9Var4.r(true);
                    sm9 w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        sm9Var4.x(w.f());
                        sm9Var4.t(w.b());
                        sm9Var4.o(w.a());
                        sm9Var4.w(w.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/launchApk")) {
                    sm9Var4.r(true);
                    sm9 y = this.mJsBridge.y(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        sm9Var4.x(y.f());
                        sm9Var4.t(y.b());
                        sm9Var4.o(y.a());
                        sm9Var4.w(y.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    sm9Var4.r(true);
                    sm9 r = this.mJsBridge.r(webView);
                    if (r != null) {
                        sm9Var4.x(r.f());
                        sm9Var4.t(r.b());
                        sm9Var4.o(r.a());
                        sm9Var4.w(r.e());
                    }
                    sm9Var4.y(0);
                    return sm9Var4;
                } else {
                    return sm9Var4;
                }
            }
            return sm9Var2;
        }
        return (sm9) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            sm9 sm9Var = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                sm9Var = this.mJsBridge.G(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                sm9Var = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                sm9Var = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                sm9Var = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                sm9Var = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                sm9Var = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                sm9Var = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                sm9Var = this.mJsBridge.z(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                sm9Var = this.mJsBridge.c(webView, hashMap);
            }
            if (sm9Var != null) {
                sm9Var.y(0);
            }
            List<rm9> list = this.mAsyncCallBackMethodList.get(str);
            if (sm9Var != null && list != null) {
                Iterator<rm9> it = list.iterator();
                if (!TextUtils.isEmpty(sm9Var.e())) {
                    while (it.hasNext()) {
                        rm9 next = it.next();
                        if (next.b().equals(sm9Var.e())) {
                            sm9 sm9Var2 = new sm9();
                            sm9Var2.v(next.a());
                            sm9Var2.x(sm9Var.f());
                            sm9Var2.t(sm9Var.b());
                            sm9Var2.o(sm9Var.a());
                            sm9Var2.z(sm9Var.l());
                            arrayList.add(sm9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rm9 next2 = it.next();
                        sm9 sm9Var3 = new sm9();
                        sm9Var3.v(next2.a());
                        sm9Var3.x(sm9Var.f());
                        sm9Var3.t(sm9Var.b());
                        sm9Var3.o(sm9Var.a());
                        sm9Var3.z(sm9Var.l());
                        arrayList.add(sm9Var3);
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
