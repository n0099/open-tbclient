package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hca;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
import com.baidu.tieba.pk6;
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
public class SystemJsBridgePlugin_Proxy extends hca {
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

    @Override // com.baidu.tieba.hca
    public jca dispatch(WebView webView, lca lcaVar, jca jcaVar) {
        InterceptResult invokeLLL;
        jca jcaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, lcaVar, jcaVar)) == null) {
            if (jcaVar == null) {
                jcaVar2 = new jca();
            } else {
                jcaVar2 = jcaVar;
            }
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("system/saveImage")) {
                jcaVar2.s(true);
                jca u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    jcaVar2.y(u.f());
                    jcaVar2.u(u.b());
                    jcaVar2.o(u.a());
                    jcaVar2.x(u.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                jcaVar2.s(true);
                jca C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    jcaVar2.y(C.f());
                    jcaVar2.u(C.b());
                    jcaVar2.o(C.a());
                    jcaVar2.x(C.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                jcaVar2.s(true);
                jca t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    jcaVar2.y(t.f());
                    jcaVar2.u(t.b());
                    jcaVar2.o(t.a());
                    jcaVar2.x(t.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                jcaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                jca I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    jcaVar2.y(I.f());
                    jcaVar2.u(I.b());
                    jcaVar2.o(I.a());
                    jcaVar2.x(I.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                jcaVar2.s(true);
                jca E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    jcaVar2.y(E.f());
                    jcaVar2.u(E.b());
                    jcaVar2.o(E.a());
                    jcaVar2.x(E.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                jcaVar2.s(true);
                jca F = this.mJsBridge.F(webView);
                if (F != null) {
                    jcaVar2.y(F.f());
                    jcaVar2.u(F.b());
                    jcaVar2.o(F.a());
                    jcaVar2.x(F.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                jcaVar2.s(true);
                jca f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    jcaVar2.y(f.f());
                    jcaVar2.u(f.b());
                    jcaVar2.o(f.a());
                    jcaVar2.x(f.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                jcaVar2.s(true);
                jca d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    jcaVar2.y(d.f());
                    jcaVar2.u(d.b());
                    jcaVar2.o(d.a());
                    jcaVar2.x(d.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                jcaVar2.s(true);
                jca i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    jcaVar2.y(i.f());
                    jcaVar2.u(i.b());
                    jcaVar2.o(i.a());
                    jcaVar2.x(i.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                jcaVar2.s(true);
                jca K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    jcaVar2.y(K.f());
                    jcaVar2.u(K.b());
                    jcaVar2.o(K.a());
                    jcaVar2.x(K.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                jcaVar2.s(true);
                jca v = this.mJsBridge.v(webView);
                if (v != null) {
                    jcaVar2.y(v.f());
                    jcaVar2.u(v.b());
                    jcaVar2.o(v.a());
                    jcaVar2.x(v.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                jcaVar2.s(true);
                jca s = this.mJsBridge.s(webView);
                if (s != null) {
                    jcaVar2.y(s.f());
                    jcaVar2.u(s.b());
                    jcaVar2.o(s.a());
                    jcaVar2.x(s.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                jcaVar2.s(true);
                jca jcaVar3 = jcaVar2;
                jca L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    jcaVar3.y(L.f());
                    jcaVar3.u(L.b());
                    jcaVar3.o(L.a());
                    jcaVar3.x(L.e());
                }
                jcaVar3.z(0);
                return jcaVar3;
            } else {
                jca jcaVar4 = jcaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    jcaVar4.s(true);
                    jca e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        jcaVar4.y(e2.f());
                        jcaVar4.u(e2.b());
                        jcaVar4.o(e2.a());
                        jcaVar4.x(e2.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    jcaVar4.s(true);
                    jca l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        jcaVar4.y(l.f());
                        jcaVar4.u(l.b());
                        jcaVar4.o(l.a());
                        jcaVar4.x(l.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    jcaVar4.s(true);
                    jca G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        jcaVar4.y(G.f());
                        jcaVar4.u(G.b());
                        jcaVar4.o(G.a());
                        jcaVar4.x(G.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    jcaVar4.s(true);
                    jca o = this.mJsBridge.o(webView);
                    if (o != null) {
                        jcaVar4.y(o.f());
                        jcaVar4.u(o.b());
                        jcaVar4.o(o.a());
                        jcaVar4.x(o.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    jcaVar4.s(true);
                    jca n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        jcaVar4.y(n.f());
                        jcaVar4.u(n.b());
                        jcaVar4.o(n.a());
                        jcaVar4.x(n.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    jcaVar4.s(true);
                    jca m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        jcaVar4.y(m.f());
                        jcaVar4.u(m.b());
                        jcaVar4.o(m.a());
                        jcaVar4.x(m.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    jcaVar4.s(true);
                    jca k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        jcaVar4.y(k.f());
                        jcaVar4.u(k.b());
                        jcaVar4.o(k.a());
                        jcaVar4.x(k.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    jcaVar4.s(true);
                    jca j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        jcaVar4.y(j.f());
                        jcaVar4.u(j.b());
                        jcaVar4.o(j.a());
                        jcaVar4.x(j.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/installGameApk")) {
                    jcaVar4.s(true);
                    jca w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        jcaVar4.y(w.f());
                        jcaVar4.u(w.b());
                        jcaVar4.o(w.a());
                        jcaVar4.x(w.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/launchApk")) {
                    jcaVar4.s(true);
                    jca z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        jcaVar4.y(z.f());
                        jcaVar4.u(z.b());
                        jcaVar4.o(z.a());
                        jcaVar4.x(z.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    jcaVar4.s(true);
                    jca r = this.mJsBridge.r(webView);
                    if (r != null) {
                        jcaVar4.y(r.f());
                        jcaVar4.u(r.b());
                        jcaVar4.o(r.a());
                        jcaVar4.x(r.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    jcaVar4.s(true);
                    jca M = this.mJsBridge.M(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (M != null) {
                        jcaVar4.y(M.f());
                        jcaVar4.u(M.b());
                        jcaVar4.o(M.a());
                        jcaVar4.x(M.e());
                    }
                    jcaVar4.z(0);
                    return jcaVar4;
                } else {
                    return jcaVar4;
                }
            }
            return jcaVar2;
        }
        return (jca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.hca
    public pk6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (pk6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            jca jcaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                jcaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                jcaVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                jcaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                jcaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                jcaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                jcaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                jcaVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                jcaVar = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                jcaVar = this.mJsBridge.c(webView, hashMap);
            }
            if (jcaVar != null) {
                jcaVar.z(0);
            }
            List<ica> list = this.mAsyncCallBackMethodList.get(str);
            if (jcaVar != null && list != null) {
                Iterator<ica> it = list.iterator();
                if (!TextUtils.isEmpty(jcaVar.e())) {
                    while (it.hasNext()) {
                        ica next = it.next();
                        if (next.b().equals(jcaVar.e())) {
                            jca jcaVar2 = new jca();
                            jcaVar2.w(next.a());
                            jcaVar2.y(jcaVar.f());
                            jcaVar2.u(jcaVar.b());
                            jcaVar2.o(jcaVar.a());
                            jcaVar2.A(jcaVar.l());
                            arrayList.add(jcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ica next2 = it.next();
                        jca jcaVar3 = new jca();
                        jcaVar3.w(next2.a());
                        jcaVar3.y(jcaVar.f());
                        jcaVar3.u(jcaVar.b());
                        jcaVar3.o(jcaVar.a());
                        jcaVar3.A(jcaVar.l());
                        arrayList.add(jcaVar3);
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
