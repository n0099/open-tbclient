package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.qk6;
import com.baidu.tieba.sx4;
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
public class SystemJsBridgePlugin_Proxy extends ica {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sx4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(sx4 sx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = sx4Var;
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

    @Override // com.baidu.tieba.ica
    public kca dispatch(WebView webView, mca mcaVar, kca kcaVar) {
        InterceptResult invokeLLL;
        kca kcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, mcaVar, kcaVar)) == null) {
            if (kcaVar == null) {
                kcaVar2 = new kca();
            } else {
                kcaVar2 = kcaVar;
            }
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("system/saveImage")) {
                kcaVar2.s(true);
                kca u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    kcaVar2.y(u.f());
                    kcaVar2.u(u.b());
                    kcaVar2.o(u.a());
                    kcaVar2.x(u.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                kcaVar2.s(true);
                kca C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    kcaVar2.y(C.f());
                    kcaVar2.u(C.b());
                    kcaVar2.o(C.a());
                    kcaVar2.x(C.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                kcaVar2.s(true);
                kca t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    kcaVar2.y(t.f());
                    kcaVar2.u(t.b());
                    kcaVar2.o(t.a());
                    kcaVar2.x(t.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                kcaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                kca I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    kcaVar2.y(I.f());
                    kcaVar2.u(I.b());
                    kcaVar2.o(I.a());
                    kcaVar2.x(I.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                kcaVar2.s(true);
                kca E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    kcaVar2.y(E.f());
                    kcaVar2.u(E.b());
                    kcaVar2.o(E.a());
                    kcaVar2.x(E.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                kcaVar2.s(true);
                kca F = this.mJsBridge.F(webView);
                if (F != null) {
                    kcaVar2.y(F.f());
                    kcaVar2.u(F.b());
                    kcaVar2.o(F.a());
                    kcaVar2.x(F.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                kcaVar2.s(true);
                kca f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    kcaVar2.y(f.f());
                    kcaVar2.u(f.b());
                    kcaVar2.o(f.a());
                    kcaVar2.x(f.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                kcaVar2.s(true);
                kca d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    kcaVar2.y(d.f());
                    kcaVar2.u(d.b());
                    kcaVar2.o(d.a());
                    kcaVar2.x(d.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                kcaVar2.s(true);
                kca i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    kcaVar2.y(i.f());
                    kcaVar2.u(i.b());
                    kcaVar2.o(i.a());
                    kcaVar2.x(i.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                kcaVar2.s(true);
                kca K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    kcaVar2.y(K.f());
                    kcaVar2.u(K.b());
                    kcaVar2.o(K.a());
                    kcaVar2.x(K.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                kcaVar2.s(true);
                kca v = this.mJsBridge.v(webView);
                if (v != null) {
                    kcaVar2.y(v.f());
                    kcaVar2.u(v.b());
                    kcaVar2.o(v.a());
                    kcaVar2.x(v.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                kcaVar2.s(true);
                kca s = this.mJsBridge.s(webView);
                if (s != null) {
                    kcaVar2.y(s.f());
                    kcaVar2.u(s.b());
                    kcaVar2.o(s.a());
                    kcaVar2.x(s.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                kcaVar2.s(true);
                kca kcaVar3 = kcaVar2;
                kca L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    kcaVar3.y(L.f());
                    kcaVar3.u(L.b());
                    kcaVar3.o(L.a());
                    kcaVar3.x(L.e());
                }
                kcaVar3.z(0);
                return kcaVar3;
            } else {
                kca kcaVar4 = kcaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    kcaVar4.s(true);
                    kca e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        kcaVar4.y(e2.f());
                        kcaVar4.u(e2.b());
                        kcaVar4.o(e2.a());
                        kcaVar4.x(e2.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    kcaVar4.s(true);
                    kca l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        kcaVar4.y(l.f());
                        kcaVar4.u(l.b());
                        kcaVar4.o(l.a());
                        kcaVar4.x(l.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    kcaVar4.s(true);
                    kca G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        kcaVar4.y(G.f());
                        kcaVar4.u(G.b());
                        kcaVar4.o(G.a());
                        kcaVar4.x(G.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    kcaVar4.s(true);
                    kca o = this.mJsBridge.o(webView);
                    if (o != null) {
                        kcaVar4.y(o.f());
                        kcaVar4.u(o.b());
                        kcaVar4.o(o.a());
                        kcaVar4.x(o.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    kcaVar4.s(true);
                    kca n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        kcaVar4.y(n.f());
                        kcaVar4.u(n.b());
                        kcaVar4.o(n.a());
                        kcaVar4.x(n.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    kcaVar4.s(true);
                    kca m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        kcaVar4.y(m.f());
                        kcaVar4.u(m.b());
                        kcaVar4.o(m.a());
                        kcaVar4.x(m.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    kcaVar4.s(true);
                    kca k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        kcaVar4.y(k.f());
                        kcaVar4.u(k.b());
                        kcaVar4.o(k.a());
                        kcaVar4.x(k.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    kcaVar4.s(true);
                    kca j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        kcaVar4.y(j.f());
                        kcaVar4.u(j.b());
                        kcaVar4.o(j.a());
                        kcaVar4.x(j.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/installGameApk")) {
                    kcaVar4.s(true);
                    kca w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        kcaVar4.y(w.f());
                        kcaVar4.u(w.b());
                        kcaVar4.o(w.a());
                        kcaVar4.x(w.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/launchApk")) {
                    kcaVar4.s(true);
                    kca z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        kcaVar4.y(z.f());
                        kcaVar4.u(z.b());
                        kcaVar4.o(z.a());
                        kcaVar4.x(z.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    kcaVar4.s(true);
                    kca r = this.mJsBridge.r(webView);
                    if (r != null) {
                        kcaVar4.y(r.f());
                        kcaVar4.u(r.b());
                        kcaVar4.o(r.a());
                        kcaVar4.x(r.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    kcaVar4.s(true);
                    kca M = this.mJsBridge.M(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (M != null) {
                        kcaVar4.y(M.f());
                        kcaVar4.u(M.b());
                        kcaVar4.o(M.a());
                        kcaVar4.x(M.e());
                    }
                    kcaVar4.z(0);
                    return kcaVar4;
                } else {
                    return kcaVar4;
                }
            }
            return kcaVar2;
        }
        return (kca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ica
    public qk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (qk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            kca kcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                kcaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                kcaVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                kcaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                kcaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                kcaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                kcaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                kcaVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                kcaVar = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                kcaVar = this.mJsBridge.c(webView, hashMap);
            }
            if (kcaVar != null) {
                kcaVar.z(0);
            }
            List<jca> list = this.mAsyncCallBackMethodList.get(str);
            if (kcaVar != null && list != null) {
                Iterator<jca> it = list.iterator();
                if (!TextUtils.isEmpty(kcaVar.e())) {
                    while (it.hasNext()) {
                        jca next = it.next();
                        if (next.b().equals(kcaVar.e())) {
                            kca kcaVar2 = new kca();
                            kcaVar2.w(next.a());
                            kcaVar2.y(kcaVar.f());
                            kcaVar2.u(kcaVar.b());
                            kcaVar2.o(kcaVar.a());
                            kcaVar2.A(kcaVar.l());
                            arrayList.add(kcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jca next2 = it.next();
                        kca kcaVar3 = new kca();
                        kcaVar3.w(next2.a());
                        kcaVar3.y(kcaVar.f());
                        kcaVar3.u(kcaVar.b());
                        kcaVar3.o(kcaVar.a());
                        kcaVar3.A(kcaVar.l());
                        arrayList.add(kcaVar3);
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
