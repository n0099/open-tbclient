package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.in6;
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.tieba.qda;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sda;
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
public class SystemJsBridgePlugin_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ry4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(ry4 ry4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ry4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ry4Var;
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

    @Override // com.baidu.tieba.oda
    public qda dispatch(WebView webView, sda sdaVar, qda qdaVar) {
        InterceptResult invokeLLL;
        qda qdaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, sdaVar, qdaVar)) == null) {
            if (qdaVar == null) {
                qdaVar2 = new qda();
            } else {
                qdaVar2 = qdaVar;
            }
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("system/saveImage")) {
                qdaVar2.s(true);
                qda u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    qdaVar2.y(u.f());
                    qdaVar2.u(u.b());
                    qdaVar2.o(u.a());
                    qdaVar2.x(u.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                qdaVar2.s(true);
                qda C = this.mJsBridge.C(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (C != null) {
                    qdaVar2.y(C.f());
                    qdaVar2.u(C.b());
                    qdaVar2.o(C.a());
                    qdaVar2.x(C.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                qdaVar2.s(true);
                qda t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    qdaVar2.y(t.f());
                    qdaVar2.u(t.b());
                    qdaVar2.o(t.a());
                    qdaVar2.x(t.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                qdaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                qda I = this.mJsBridge.I(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (I != null) {
                    qdaVar2.y(I.f());
                    qdaVar2.u(I.b());
                    qdaVar2.o(I.a());
                    qdaVar2.x(I.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                qdaVar2.s(true);
                qda E = this.mJsBridge.E(webView, e.optString("soundUrl"));
                if (E != null) {
                    qdaVar2.y(E.f());
                    qdaVar2.u(E.b());
                    qdaVar2.o(E.a());
                    qdaVar2.x(E.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                qdaVar2.s(true);
                qda F = this.mJsBridge.F(webView);
                if (F != null) {
                    qdaVar2.y(F.f());
                    qdaVar2.u(F.b());
                    qdaVar2.o(F.a());
                    qdaVar2.x(F.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                qdaVar2.s(true);
                qda f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    qdaVar2.y(f.f());
                    qdaVar2.u(f.b());
                    qdaVar2.o(f.a());
                    qdaVar2.x(f.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                qdaVar2.s(true);
                qda d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    qdaVar2.y(d.f());
                    qdaVar2.u(d.b());
                    qdaVar2.o(d.a());
                    qdaVar2.x(d.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                qdaVar2.s(true);
                qda i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    qdaVar2.y(i.f());
                    qdaVar2.u(i.b());
                    qdaVar2.o(i.a());
                    qdaVar2.x(i.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                qdaVar2.s(true);
                qda K = this.mJsBridge.K(webView, e.optString("pkgName"), e.optString("schema"));
                if (K != null) {
                    qdaVar2.y(K.f());
                    qdaVar2.u(K.b());
                    qdaVar2.o(K.a());
                    qdaVar2.x(K.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                qdaVar2.s(true);
                qda v = this.mJsBridge.v(webView);
                if (v != null) {
                    qdaVar2.y(v.f());
                    qdaVar2.u(v.b());
                    qdaVar2.o(v.a());
                    qdaVar2.x(v.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                qdaVar2.s(true);
                qda s = this.mJsBridge.s(webView);
                if (s != null) {
                    qdaVar2.y(s.f());
                    qdaVar2.u(s.b());
                    qdaVar2.o(s.a());
                    qdaVar2.x(s.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                qdaVar2.s(true);
                qda qdaVar3 = qdaVar2;
                qda L = this.mJsBridge.L(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (L != null) {
                    qdaVar3.y(L.f());
                    qdaVar3.u(L.b());
                    qdaVar3.o(L.a());
                    qdaVar3.x(L.e());
                }
                qdaVar3.z(0);
                return qdaVar3;
            } else {
                qda qdaVar4 = qdaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    qdaVar4.s(true);
                    qda e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        qdaVar4.y(e2.f());
                        qdaVar4.u(e2.b());
                        qdaVar4.o(e2.a());
                        qdaVar4.x(e2.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    qdaVar4.s(true);
                    qda l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        qdaVar4.y(l.f());
                        qdaVar4.u(l.b());
                        qdaVar4.o(l.a());
                        qdaVar4.x(l.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    qdaVar4.s(true);
                    qda G = this.mJsBridge.G(webView, e.optString("key"), e.optString("data"));
                    if (G != null) {
                        qdaVar4.y(G.f());
                        qdaVar4.u(G.b());
                        qdaVar4.o(G.a());
                        qdaVar4.x(G.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    qdaVar4.s(true);
                    qda o = this.mJsBridge.o(webView);
                    if (o != null) {
                        qdaVar4.y(o.f());
                        qdaVar4.u(o.b());
                        qdaVar4.o(o.a());
                        qdaVar4.x(o.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    qdaVar4.s(true);
                    qda n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        qdaVar4.y(n.f());
                        qdaVar4.u(n.b());
                        qdaVar4.o(n.a());
                        qdaVar4.x(n.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    qdaVar4.s(true);
                    qda m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        qdaVar4.y(m.f());
                        qdaVar4.u(m.b());
                        qdaVar4.o(m.a());
                        qdaVar4.x(m.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    qdaVar4.s(true);
                    qda k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        qdaVar4.y(k.f());
                        qdaVar4.u(k.b());
                        qdaVar4.o(k.a());
                        qdaVar4.x(k.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    qdaVar4.s(true);
                    qda j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        qdaVar4.y(j.f());
                        qdaVar4.u(j.b());
                        qdaVar4.o(j.a());
                        qdaVar4.x(j.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/installGameApk")) {
                    qdaVar4.s(true);
                    qda w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        qdaVar4.y(w.f());
                        qdaVar4.u(w.b());
                        qdaVar4.o(w.a());
                        qdaVar4.x(w.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/launchApk")) {
                    qdaVar4.s(true);
                    qda z = this.mJsBridge.z(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (z != null) {
                        qdaVar4.y(z.f());
                        qdaVar4.u(z.b());
                        qdaVar4.o(z.a());
                        qdaVar4.x(z.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    qdaVar4.s(true);
                    qda r = this.mJsBridge.r(webView);
                    if (r != null) {
                        qdaVar4.y(r.f());
                        qdaVar4.u(r.b());
                        qdaVar4.o(r.a());
                        qdaVar4.x(r.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    qdaVar4.s(true);
                    qda M = this.mJsBridge.M(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (M != null) {
                        qdaVar4.y(M.f());
                        qdaVar4.u(M.b());
                        qdaVar4.o(M.a());
                        qdaVar4.x(M.e());
                    }
                    qdaVar4.z(0);
                    return qdaVar4;
                } else {
                    return qdaVar4;
                }
            }
            return qdaVar2;
        }
        return (qda) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.oda
    public in6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (in6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            qda qdaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                qdaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                qdaVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                qdaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                qdaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                qdaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                qdaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                qdaVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                qdaVar = this.mJsBridge.A(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                qdaVar = this.mJsBridge.c(webView, hashMap);
            }
            if (qdaVar != null) {
                qdaVar.z(0);
            }
            List<pda> list = this.mAsyncCallBackMethodList.get(str);
            if (qdaVar != null && list != null) {
                Iterator<pda> it = list.iterator();
                if (!TextUtils.isEmpty(qdaVar.e())) {
                    while (it.hasNext()) {
                        pda next = it.next();
                        if (next.b().equals(qdaVar.e())) {
                            qda qdaVar2 = new qda();
                            qdaVar2.w(next.a());
                            qdaVar2.y(qdaVar.f());
                            qdaVar2.u(qdaVar.b());
                            qdaVar2.o(qdaVar.a());
                            qdaVar2.A(qdaVar.l());
                            arrayList.add(qdaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        pda next2 = it.next();
                        qda qdaVar3 = new qda();
                        qdaVar3.w(next2.a());
                        qdaVar3.y(qdaVar.f());
                        qdaVar3.u(qdaVar.b());
                        qdaVar3.o(qdaVar.a());
                        qdaVar3.A(qdaVar.l());
                        arrayList.add(qdaVar3);
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
