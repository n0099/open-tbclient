package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.d5a;
import com.baidu.tieba.e5a;
import com.baidu.tieba.em6;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.yy4;
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
public class SystemJsBridgePlugin_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yy4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(yy4 yy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yy4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = yy4Var;
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

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(WebView webView, h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLLL;
        f5a f5aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, h5aVar, f5aVar)) == null) {
            if (f5aVar == null) {
                f5aVar2 = new f5a();
            } else {
                f5aVar2 = f5aVar;
            }
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("system/saveImage")) {
                f5aVar2.s(true);
                f5a u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    f5aVar2.y(u.f());
                    f5aVar2.u(u.b());
                    f5aVar2.o(u.a());
                    f5aVar2.x(u.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver(webView, "saveImageSuccess", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                f5aVar2.s(true);
                f5a C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    f5aVar2.y(C.f());
                    f5aVar2.u(C.b());
                    f5aVar2.o(C.a());
                    f5aVar2.x(C.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver(webView, "orderGameApkResult", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                f5aVar2.s(true);
                f5a t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    f5aVar2.y(t.f());
                    f5aVar2.u(t.b());
                    f5aVar2.o(t.a());
                    f5aVar2.x(t.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                f5aVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                f5a I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    f5aVar2.y(I.f());
                    f5aVar2.u(I.b());
                    f5aVar2.o(I.a());
                    f5aVar2.x(I.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/playSound")) {
                f5aVar2.s(true);
                f5a E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    f5aVar2.y(E.f());
                    f5aVar2.u(E.b());
                    f5aVar2.o(E.a());
                    f5aVar2.x(E.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                f5aVar2.s(true);
                f5a F = this.mJsBridge.F(webView);
                if (F != null) {
                    f5aVar2.y(F.f());
                    f5aVar2.u(F.b());
                    f5aVar2.o(F.a());
                    f5aVar2.x(F.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                f5aVar2.s(true);
                f5a f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    f5aVar2.y(f.f());
                    f5aVar2.u(f.b());
                    f5aVar2.o(f.a());
                    f5aVar2.x(f.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                f5aVar2.s(true);
                f5a d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    f5aVar2.y(d.f());
                    f5aVar2.u(d.b());
                    f5aVar2.o(d.a());
                    f5aVar2.x(d.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                f5aVar2.s(true);
                f5a i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    f5aVar2.y(i.f());
                    f5aVar2.u(i.b());
                    f5aVar2.o(i.a());
                    f5aVar2.x(i.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/startApp")) {
                f5aVar2.s(true);
                f5a K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    f5aVar2.y(K.f());
                    f5aVar2.u(K.b());
                    f5aVar2.o(K.a());
                    f5aVar2.x(K.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                f5aVar2.s(true);
                f5a v = this.mJsBridge.v(webView);
                if (v != null) {
                    f5aVar2.y(v.f());
                    f5aVar2.u(v.b());
                    f5aVar2.o(v.a());
                    f5aVar2.x(v.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                f5aVar2.s(true);
                f5a s = this.mJsBridge.s(webView);
                if (s != null) {
                    f5aVar2.y(s.f());
                    f5aVar2.u(s.b());
                    f5aVar2.o(s.a());
                    f5aVar2.x(s.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                f5aVar2.s(true);
                f5a f5aVar3 = f5aVar2;
                f5a L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    f5aVar3.y(L.f());
                    f5aVar3.u(L.b());
                    f5aVar3.o(L.a());
                    f5aVar3.x(L.e());
                }
                f5aVar3.z(0);
                return f5aVar3;
            } else {
                f5a f5aVar4 = f5aVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    f5aVar4.s(true);
                    f5a e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        f5aVar4.y(e2.f());
                        f5aVar4.u(e2.b());
                        f5aVar4.o(e2.a());
                        f5aVar4.x(e2.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/getAppStorage")) {
                    f5aVar4.s(true);
                    f5a l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        f5aVar4.y(l.f());
                        f5aVar4.u(l.b());
                        f5aVar4.o(l.a());
                        f5aVar4.x(l.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/putAppStorage")) {
                    f5aVar4.s(true);
                    f5a G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        f5aVar4.y(G.f());
                        f5aVar4.u(G.b());
                        f5aVar4.o(G.a());
                        f5aVar4.x(G.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    f5aVar4.s(true);
                    f5a o = this.mJsBridge.o(webView);
                    if (o != null) {
                        f5aVar4.y(o.f());
                        f5aVar4.u(o.b());
                        f5aVar4.o(o.a());
                        f5aVar4.x(o.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    f5aVar4.s(true);
                    f5a n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        f5aVar4.y(n.f());
                        f5aVar4.u(n.b());
                        f5aVar4.o(n.a());
                        f5aVar4.x(n.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    f5aVar4.s(true);
                    f5a m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        f5aVar4.y(m.f());
                        f5aVar4.u(m.b());
                        f5aVar4.o(m.a());
                        f5aVar4.x(m.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    f5aVar4.s(true);
                    f5a k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        f5aVar4.y(k.f());
                        f5aVar4.u(k.b());
                        f5aVar4.o(k.a());
                        f5aVar4.x(k.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    f5aVar4.s(true);
                    f5a j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        f5aVar4.y(j.f());
                        f5aVar4.u(j.b());
                        f5aVar4.o(j.a());
                        f5aVar4.x(j.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/installGameApk")) {
                    f5aVar4.s(true);
                    f5a w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        f5aVar4.y(w.f());
                        f5aVar4.u(w.b());
                        f5aVar4.o(w.a());
                        f5aVar4.x(w.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/launchApk")) {
                    f5aVar4.s(true);
                    f5a z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        f5aVar4.y(z.f());
                        f5aVar4.u(z.b());
                        f5aVar4.o(z.a());
                        f5aVar4.x(z.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    f5aVar4.s(true);
                    f5a r = this.mJsBridge.r(webView);
                    if (r != null) {
                        f5aVar4.y(r.f());
                        f5aVar4.u(r.b());
                        f5aVar4.o(r.a());
                        f5aVar4.x(r.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    f5aVar4.s(true);
                    f5a M = this.mJsBridge.M(webView);
                    if (M != null) {
                        f5aVar4.y(M.f());
                        f5aVar4.u(M.b());
                        f5aVar4.o(M.a());
                        f5aVar4.x(M.e());
                    }
                    f5aVar4.z(0);
                    return f5aVar4;
                } else {
                    return f5aVar4;
                }
            }
            return f5aVar2;
        }
        return (f5a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public em6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (em6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            f5a f5aVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                f5aVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                f5aVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                f5aVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                f5aVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                f5aVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                f5aVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                f5aVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                f5aVar = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                f5aVar = this.mJsBridge.c(webView, hashMap);
            }
            if (f5aVar != null) {
                f5aVar.z(0);
            }
            List<e5a> list = this.mAsyncCallBackMethodList.get(str);
            if (f5aVar != null && list != null) {
                Iterator<e5a> it = list.iterator();
                if (!TextUtils.isEmpty(f5aVar.e())) {
                    while (it.hasNext()) {
                        e5a next = it.next();
                        if (next.b().equals(f5aVar.e())) {
                            f5a f5aVar2 = new f5a();
                            f5aVar2.w(next.a());
                            f5aVar2.y(f5aVar.f());
                            f5aVar2.u(f5aVar.b());
                            f5aVar2.o(f5aVar.a());
                            f5aVar2.A(f5aVar.l());
                            arrayList.add(f5aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        e5a next2 = it.next();
                        f5a f5aVar3 = new f5a();
                        f5aVar3.w(next2.a());
                        f5aVar3.y(f5aVar.f());
                        f5aVar3.u(f5aVar.b());
                        f5aVar3.o(f5aVar.a());
                        f5aVar3.A(f5aVar.l());
                        arrayList.add(f5aVar3);
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
