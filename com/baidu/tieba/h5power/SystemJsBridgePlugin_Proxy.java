package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.qga;
import com.baidu.tieba.rga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
import com.baidu.tieba.ux4;
import com.baidu.tieba.vl6;
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
public class SystemJsBridgePlugin_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ux4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(ux4 ux4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ux4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = ux4Var;
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
        this.mNotificationNameList.add("keyboardHeightChange");
    }

    @Override // com.baidu.tieba.qga
    public sga dispatch(WebView webView, uga ugaVar, sga sgaVar) {
        InterceptResult invokeLLL;
        sga sgaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ugaVar, sgaVar)) == null) {
            if (sgaVar == null) {
                sgaVar2 = new sga();
            } else {
                sgaVar2 = sgaVar;
            }
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("system/saveImage")) {
                sgaVar2.s(true);
                sga u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    sgaVar2.y(u.f());
                    sgaVar2.u(u.b());
                    sgaVar2.o(u.a());
                    sgaVar2.x(u.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                sgaVar2.s(true);
                sga E = this.mJsBridge.E(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (E != null) {
                    sgaVar2.y(E.f());
                    sgaVar2.u(E.b());
                    sgaVar2.o(E.a());
                    sgaVar2.x(E.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                sgaVar2.s(true);
                sga t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    sgaVar2.y(t.f());
                    sgaVar2.u(t.b());
                    sgaVar2.o(t.a());
                    sgaVar2.x(t.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                sgaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                sga K = this.mJsBridge.K(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (K != null) {
                    sgaVar2.y(K.f());
                    sgaVar2.u(K.b());
                    sgaVar2.o(K.a());
                    sgaVar2.x(K.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                sgaVar2.s(true);
                sga G = this.mJsBridge.G(webView, e.optString("soundUrl"));
                if (G != null) {
                    sgaVar2.y(G.f());
                    sgaVar2.u(G.b());
                    sgaVar2.o(G.a());
                    sgaVar2.x(G.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                sgaVar2.s(true);
                sga H = this.mJsBridge.H(webView);
                if (H != null) {
                    sgaVar2.y(H.f());
                    sgaVar2.u(H.b());
                    sgaVar2.o(H.a());
                    sgaVar2.x(H.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                sgaVar2.s(true);
                sga f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    sgaVar2.y(f.f());
                    sgaVar2.u(f.b());
                    sgaVar2.o(f.a());
                    sgaVar2.x(f.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                sgaVar2.s(true);
                sga d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    sgaVar2.y(d.f());
                    sgaVar2.u(d.b());
                    sgaVar2.o(d.a());
                    sgaVar2.x(d.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                sgaVar2.s(true);
                sga i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    sgaVar2.y(i.f());
                    sgaVar2.u(i.b());
                    sgaVar2.o(i.a());
                    sgaVar2.x(i.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                sgaVar2.s(true);
                sga M = this.mJsBridge.M(webView, e.optString("pkgName"), e.optString("schema"));
                if (M != null) {
                    sgaVar2.y(M.f());
                    sgaVar2.u(M.b());
                    sgaVar2.o(M.a());
                    sgaVar2.x(M.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                sgaVar2.s(true);
                sga v = this.mJsBridge.v(webView);
                if (v != null) {
                    sgaVar2.y(v.f());
                    sgaVar2.u(v.b());
                    sgaVar2.o(v.a());
                    sgaVar2.x(v.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                sgaVar2.s(true);
                sga s = this.mJsBridge.s(webView);
                if (s != null) {
                    sgaVar2.y(s.f());
                    sgaVar2.u(s.b());
                    sgaVar2.o(s.a());
                    sgaVar2.x(s.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                sgaVar2.s(true);
                sga sgaVar3 = sgaVar2;
                sga N = this.mJsBridge.N(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (N != null) {
                    sgaVar3.y(N.f());
                    sgaVar3.u(N.b());
                    sgaVar3.o(N.a());
                    sgaVar3.x(N.e());
                }
                sgaVar3.z(0);
                return sgaVar3;
            } else {
                sga sgaVar4 = sgaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    sgaVar4.s(true);
                    sga e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        sgaVar4.y(e2.f());
                        sgaVar4.u(e2.b());
                        sgaVar4.o(e2.a());
                        sgaVar4.x(e2.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    sgaVar4.s(true);
                    sga l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        sgaVar4.y(l.f());
                        sgaVar4.u(l.b());
                        sgaVar4.o(l.a());
                        sgaVar4.x(l.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    sgaVar4.s(true);
                    sga I = this.mJsBridge.I(webView, e.optString("key"), e.optString("data"));
                    if (I != null) {
                        sgaVar4.y(I.f());
                        sgaVar4.u(I.b());
                        sgaVar4.o(I.a());
                        sgaVar4.x(I.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    sgaVar4.s(true);
                    sga o = this.mJsBridge.o(webView);
                    if (o != null) {
                        sgaVar4.y(o.f());
                        sgaVar4.u(o.b());
                        sgaVar4.o(o.a());
                        sgaVar4.x(o.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    sgaVar4.s(true);
                    sga n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        sgaVar4.y(n.f());
                        sgaVar4.u(n.b());
                        sgaVar4.o(n.a());
                        sgaVar4.x(n.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    sgaVar4.s(true);
                    sga m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        sgaVar4.y(m.f());
                        sgaVar4.u(m.b());
                        sgaVar4.o(m.a());
                        sgaVar4.x(m.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    sgaVar4.s(true);
                    sga k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        sgaVar4.y(k.f());
                        sgaVar4.u(k.b());
                        sgaVar4.o(k.a());
                        sgaVar4.x(k.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    sgaVar4.s(true);
                    sga j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        sgaVar4.y(j.f());
                        sgaVar4.u(j.b());
                        sgaVar4.o(j.a());
                        sgaVar4.x(j.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/installGameApk")) {
                    sgaVar4.s(true);
                    sga w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        sgaVar4.y(w.f());
                        sgaVar4.u(w.b());
                        sgaVar4.o(w.a());
                        sgaVar4.x(w.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/launchApk")) {
                    sgaVar4.s(true);
                    sga A = this.mJsBridge.A(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (A != null) {
                        sgaVar4.y(A.f());
                        sgaVar4.u(A.b());
                        sgaVar4.o(A.a());
                        sgaVar4.x(A.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    sgaVar4.s(true);
                    sga r = this.mJsBridge.r(webView);
                    if (r != null) {
                        sgaVar4.y(r.f());
                        sgaVar4.u(r.b());
                        sgaVar4.o(r.a());
                        sgaVar4.x(r.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    sgaVar4.s(true);
                    sga O = this.mJsBridge.O(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (O != null) {
                        sgaVar4.y(O.f());
                        sgaVar4.u(O.b());
                        sgaVar4.o(O.a());
                        sgaVar4.x(O.e());
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    sgaVar4.s(true);
                    sga y = this.mJsBridge.y(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (y != null) {
                        sgaVar4.y(y.f());
                        sgaVar4.u(y.b());
                        sgaVar4.o(y.a());
                        sgaVar4.x(y.e());
                        if (!sgaVar4.h()) {
                            sgaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", sgaVar4, true);
                        }
                    }
                    sgaVar4.z(0);
                    return sgaVar4;
                } else {
                    return sgaVar4;
                }
            }
            return sgaVar2;
        }
        return (sga) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qga
    public vl6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (vl6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            sga sgaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                sgaVar = this.mJsBridge.J(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                sgaVar = this.mJsBridge.F(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                sgaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                sgaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                sgaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                sgaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                sgaVar = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                sgaVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                sgaVar = this.mJsBridge.c(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                sgaVar = this.mJsBridge.D(webView, hashMap);
            }
            if (sgaVar != null) {
                sgaVar.z(0);
            }
            List<rga> list = this.mAsyncCallBackMethodList.get(str);
            if (sgaVar != null && list != null) {
                Iterator<rga> it = list.iterator();
                if (!TextUtils.isEmpty(sgaVar.e())) {
                    while (it.hasNext()) {
                        rga next = it.next();
                        if (next.b().equals(sgaVar.e())) {
                            sga sgaVar2 = new sga();
                            sgaVar2.w(next.a());
                            sgaVar2.y(sgaVar.f());
                            sgaVar2.u(sgaVar.b());
                            sgaVar2.o(sgaVar.a());
                            sgaVar2.A(sgaVar.l());
                            arrayList.add(sgaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rga next2 = it.next();
                        sga sgaVar3 = new sga();
                        sgaVar3.w(next2.a());
                        sgaVar3.y(sgaVar.f());
                        sgaVar3.u(sgaVar.b());
                        sgaVar3.o(sgaVar.a());
                        sgaVar3.A(sgaVar.l());
                        arrayList.add(sgaVar3);
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
