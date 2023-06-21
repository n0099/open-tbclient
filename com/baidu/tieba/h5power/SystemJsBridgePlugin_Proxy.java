package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.vy4;
import com.baidu.tieba.zl6;
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
public class SystemJsBridgePlugin_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(vy4 vy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = vy4Var;
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

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(WebView webView, v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLLL;
        t0a t0aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, v0aVar, t0aVar)) == null) {
            if (t0aVar == null) {
                t0aVar2 = new t0a();
            } else {
                t0aVar2 = t0aVar;
            }
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("system/saveImage")) {
                t0aVar2.s(true);
                t0a u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    t0aVar2.y(u.f());
                    t0aVar2.u(u.b());
                    t0aVar2.o(u.a());
                    t0aVar2.x(u.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver(webView, "saveImageSuccess", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                t0aVar2.s(true);
                t0a C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    t0aVar2.y(C.f());
                    t0aVar2.u(C.b());
                    t0aVar2.o(C.a());
                    t0aVar2.x(C.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver(webView, "orderGameApkResult", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                t0aVar2.s(true);
                t0a t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    t0aVar2.y(t.f());
                    t0aVar2.u(t.b());
                    t0aVar2.o(t.a());
                    t0aVar2.x(t.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                t0aVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                t0a I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    t0aVar2.y(I.f());
                    t0aVar2.u(I.b());
                    t0aVar2.o(I.a());
                    t0aVar2.x(I.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/playSound")) {
                t0aVar2.s(true);
                t0a E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    t0aVar2.y(E.f());
                    t0aVar2.u(E.b());
                    t0aVar2.o(E.a());
                    t0aVar2.x(E.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                t0aVar2.s(true);
                t0a F = this.mJsBridge.F(webView);
                if (F != null) {
                    t0aVar2.y(F.f());
                    t0aVar2.u(F.b());
                    t0aVar2.o(F.a());
                    t0aVar2.x(F.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                t0aVar2.s(true);
                t0a f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    t0aVar2.y(f.f());
                    t0aVar2.u(f.b());
                    t0aVar2.o(f.a());
                    t0aVar2.x(f.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                t0aVar2.s(true);
                t0a d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    t0aVar2.y(d.f());
                    t0aVar2.u(d.b());
                    t0aVar2.o(d.a());
                    t0aVar2.x(d.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                t0aVar2.s(true);
                t0a i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    t0aVar2.y(i.f());
                    t0aVar2.u(i.b());
                    t0aVar2.o(i.a());
                    t0aVar2.x(i.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/startApp")) {
                t0aVar2.s(true);
                t0a K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    t0aVar2.y(K.f());
                    t0aVar2.u(K.b());
                    t0aVar2.o(K.a());
                    t0aVar2.x(K.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                t0aVar2.s(true);
                t0a v = this.mJsBridge.v(webView);
                if (v != null) {
                    t0aVar2.y(v.f());
                    t0aVar2.u(v.b());
                    t0aVar2.o(v.a());
                    t0aVar2.x(v.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                t0aVar2.s(true);
                t0a s = this.mJsBridge.s(webView);
                if (s != null) {
                    t0aVar2.y(s.f());
                    t0aVar2.u(s.b());
                    t0aVar2.o(s.a());
                    t0aVar2.x(s.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                t0aVar2.s(true);
                t0a t0aVar3 = t0aVar2;
                t0a L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    t0aVar3.y(L.f());
                    t0aVar3.u(L.b());
                    t0aVar3.o(L.a());
                    t0aVar3.x(L.e());
                }
                t0aVar3.z(0);
                return t0aVar3;
            } else {
                t0a t0aVar4 = t0aVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    t0aVar4.s(true);
                    t0a e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        t0aVar4.y(e2.f());
                        t0aVar4.u(e2.b());
                        t0aVar4.o(e2.a());
                        t0aVar4.x(e2.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/getAppStorage")) {
                    t0aVar4.s(true);
                    t0a l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        t0aVar4.y(l.f());
                        t0aVar4.u(l.b());
                        t0aVar4.o(l.a());
                        t0aVar4.x(l.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/putAppStorage")) {
                    t0aVar4.s(true);
                    t0a G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        t0aVar4.y(G.f());
                        t0aVar4.u(G.b());
                        t0aVar4.o(G.a());
                        t0aVar4.x(G.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    t0aVar4.s(true);
                    t0a o = this.mJsBridge.o(webView);
                    if (o != null) {
                        t0aVar4.y(o.f());
                        t0aVar4.u(o.b());
                        t0aVar4.o(o.a());
                        t0aVar4.x(o.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    t0aVar4.s(true);
                    t0a n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        t0aVar4.y(n.f());
                        t0aVar4.u(n.b());
                        t0aVar4.o(n.a());
                        t0aVar4.x(n.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    t0aVar4.s(true);
                    t0a m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        t0aVar4.y(m.f());
                        t0aVar4.u(m.b());
                        t0aVar4.o(m.a());
                        t0aVar4.x(m.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    t0aVar4.s(true);
                    t0a k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        t0aVar4.y(k.f());
                        t0aVar4.u(k.b());
                        t0aVar4.o(k.a());
                        t0aVar4.x(k.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    t0aVar4.s(true);
                    t0a j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        t0aVar4.y(j.f());
                        t0aVar4.u(j.b());
                        t0aVar4.o(j.a());
                        t0aVar4.x(j.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/installGameApk")) {
                    t0aVar4.s(true);
                    t0a w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        t0aVar4.y(w.f());
                        t0aVar4.u(w.b());
                        t0aVar4.o(w.a());
                        t0aVar4.x(w.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/launchApk")) {
                    t0aVar4.s(true);
                    t0a z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        t0aVar4.y(z.f());
                        t0aVar4.u(z.b());
                        t0aVar4.o(z.a());
                        t0aVar4.x(z.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    t0aVar4.s(true);
                    t0a r = this.mJsBridge.r(webView);
                    if (r != null) {
                        t0aVar4.y(r.f());
                        t0aVar4.u(r.b());
                        t0aVar4.o(r.a());
                        t0aVar4.x(r.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    t0aVar4.s(true);
                    t0a M = this.mJsBridge.M(webView);
                    if (M != null) {
                        t0aVar4.y(M.f());
                        t0aVar4.u(M.b());
                        t0aVar4.o(M.a());
                        t0aVar4.x(M.e());
                    }
                    t0aVar4.z(0);
                    return t0aVar4;
                } else {
                    return t0aVar4;
                }
            }
            return t0aVar2;
        }
        return (t0a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public zl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (zl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                t0aVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                t0aVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                t0aVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                t0aVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                t0aVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                t0aVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                t0aVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                t0aVar = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                t0aVar = this.mJsBridge.c(webView, hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!TextUtils.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
