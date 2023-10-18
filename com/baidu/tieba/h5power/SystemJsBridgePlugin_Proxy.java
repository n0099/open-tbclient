package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.gfa;
import com.baidu.tieba.gh6;
import com.baidu.tieba.gs4;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
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
public class SystemJsBridgePlugin_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gs4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(gs4 gs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = gs4Var;
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
        this.mNotificationNameList.add("pushNotificationPermission");
    }

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(WebView webView, kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLLL;
        ifa ifaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, kfaVar, ifaVar)) == null) {
            if (ifaVar == null) {
                ifaVar2 = new ifa();
            } else {
                ifaVar2 = ifaVar;
            }
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("system/saveImage")) {
                ifaVar2.s(true);
                ifa w = this.mJsBridge.w(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (w != null) {
                    ifaVar2.y(w.f());
                    ifaVar2.u(w.b());
                    ifaVar2.o(w.a());
                    ifaVar2.x(w.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                ifaVar2.s(true);
                ifa G = this.mJsBridge.G(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (G != null) {
                    ifaVar2.y(G.f());
                    ifaVar2.u(G.b());
                    ifaVar2.o(G.a());
                    ifaVar2.x(G.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                ifaVar2.s(true);
                ifa t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    ifaVar2.y(t.f());
                    ifaVar2.u(t.b());
                    ifaVar2.o(t.a());
                    ifaVar2.x(t.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                ifaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                ifa M = this.mJsBridge.M(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (M != null) {
                    ifaVar2.y(M.f());
                    ifaVar2.u(M.b());
                    ifaVar2.o(M.a());
                    ifaVar2.x(M.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                ifaVar2.s(true);
                ifa I = this.mJsBridge.I(webView, e.optString("soundUrl"));
                if (I != null) {
                    ifaVar2.y(I.f());
                    ifaVar2.u(I.b());
                    ifaVar2.o(I.a());
                    ifaVar2.x(I.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                ifaVar2.s(true);
                ifa J = this.mJsBridge.J(webView);
                if (J != null) {
                    ifaVar2.y(J.f());
                    ifaVar2.u(J.b());
                    ifaVar2.o(J.a());
                    ifaVar2.x(J.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                ifaVar2.s(true);
                ifa f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    ifaVar2.y(f.f());
                    ifaVar2.u(f.b());
                    ifaVar2.o(f.a());
                    ifaVar2.x(f.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                ifaVar2.s(true);
                ifa d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    ifaVar2.y(d.f());
                    ifaVar2.u(d.b());
                    ifaVar2.o(d.a());
                    ifaVar2.x(d.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                ifaVar2.s(true);
                ifa i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    ifaVar2.y(i.f());
                    ifaVar2.u(i.b());
                    ifaVar2.o(i.a());
                    ifaVar2.x(i.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                ifaVar2.s(true);
                ifa O = this.mJsBridge.O(webView, e.optString("pkgName"), e.optString("schema"));
                if (O != null) {
                    ifaVar2.y(O.f());
                    ifaVar2.u(O.b());
                    ifaVar2.o(O.a());
                    ifaVar2.x(O.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                ifaVar2.s(true);
                ifa x = this.mJsBridge.x(webView);
                if (x != null) {
                    ifaVar2.y(x.f());
                    ifaVar2.u(x.b());
                    ifaVar2.o(x.a());
                    ifaVar2.x(x.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                ifaVar2.s(true);
                ifa s = this.mJsBridge.s(webView);
                if (s != null) {
                    ifaVar2.y(s.f());
                    ifaVar2.u(s.b());
                    ifaVar2.o(s.a());
                    ifaVar2.x(s.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                ifaVar2.s(true);
                ifa ifaVar3 = ifaVar2;
                ifa P = this.mJsBridge.P(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (P != null) {
                    ifaVar3.y(P.f());
                    ifaVar3.u(P.b());
                    ifaVar3.o(P.a());
                    ifaVar3.x(P.e());
                }
                ifaVar3.z(0);
                return ifaVar3;
            } else {
                ifa ifaVar4 = ifaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    ifaVar4.s(true);
                    ifa e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        ifaVar4.y(e2.f());
                        ifaVar4.u(e2.b());
                        ifaVar4.o(e2.a());
                        ifaVar4.x(e2.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    ifaVar4.s(true);
                    ifa l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        ifaVar4.y(l.f());
                        ifaVar4.u(l.b());
                        ifaVar4.o(l.a());
                        ifaVar4.x(l.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    ifaVar4.s(true);
                    ifa K = this.mJsBridge.K(webView, e.optString("key"), e.optString("data"));
                    if (K != null) {
                        ifaVar4.y(K.f());
                        ifaVar4.u(K.b());
                        ifaVar4.o(K.a());
                        ifaVar4.x(K.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    ifaVar4.s(true);
                    ifa o = this.mJsBridge.o(webView);
                    if (o != null) {
                        ifaVar4.y(o.f());
                        ifaVar4.u(o.b());
                        ifaVar4.o(o.a());
                        ifaVar4.x(o.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    ifaVar4.s(true);
                    ifa n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        ifaVar4.y(n.f());
                        ifaVar4.u(n.b());
                        ifaVar4.o(n.a());
                        ifaVar4.x(n.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    ifaVar4.s(true);
                    ifa m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        ifaVar4.y(m.f());
                        ifaVar4.u(m.b());
                        ifaVar4.o(m.a());
                        ifaVar4.x(m.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    ifaVar4.s(true);
                    ifa k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        ifaVar4.y(k.f());
                        ifaVar4.u(k.b());
                        ifaVar4.o(k.a());
                        ifaVar4.x(k.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    ifaVar4.s(true);
                    ifa j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        ifaVar4.y(j.f());
                        ifaVar4.u(j.b());
                        ifaVar4.o(j.a());
                        ifaVar4.x(j.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/installGameApk")) {
                    ifaVar4.s(true);
                    ifa y = this.mJsBridge.y(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        ifaVar4.y(y.f());
                        ifaVar4.u(y.b());
                        ifaVar4.o(y.a());
                        ifaVar4.x(y.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/launchApk")) {
                    ifaVar4.s(true);
                    ifa C = this.mJsBridge.C(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (C != null) {
                        ifaVar4.y(C.f());
                        ifaVar4.u(C.b());
                        ifaVar4.o(C.a());
                        ifaVar4.x(C.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    ifaVar4.s(true);
                    ifa r = this.mJsBridge.r(webView);
                    if (r != null) {
                        ifaVar4.y(r.f());
                        ifaVar4.u(r.b());
                        ifaVar4.o(r.a());
                        ifaVar4.x(r.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    ifaVar4.s(true);
                    ifa Q = this.mJsBridge.Q(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (Q != null) {
                        ifaVar4.y(Q.f());
                        ifaVar4.u(Q.b());
                        ifaVar4.o(Q.a());
                        ifaVar4.x(Q.e());
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    ifaVar4.s(true);
                    ifa A = this.mJsBridge.A(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (A != null) {
                        ifaVar4.y(A.f());
                        ifaVar4.u(A.b());
                        ifaVar4.o(A.a());
                        ifaVar4.x(A.e());
                        if (!ifaVar4.h()) {
                            ifaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", ifaVar4, true);
                        }
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else if (b.equals("system/pushNotificationPermission")) {
                    ifaVar4.s(true);
                    ifa u = this.mJsBridge.u(webView, e.optString("switch_name"), e.optString("operate_type"), e.optString("set_status"));
                    this.mNotificationNameList.add("pushNotificationPermission");
                    if (u != null) {
                        ifaVar4.y(u.f());
                        ifaVar4.u(u.b());
                        ifaVar4.o(u.a());
                        ifaVar4.x(u.e());
                        if (!ifaVar4.h()) {
                            ifaVar4.n(false);
                            addObserver(webView, "pushNotificationPermission", ifaVar4, false);
                        }
                    }
                    ifaVar4.z(0);
                    return ifaVar4;
                } else {
                    return ifaVar4;
                }
            }
            return ifaVar2;
        }
        return (ifa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public gh6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (gh6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                ifaVar = this.mJsBridge.L(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                ifaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                ifaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                ifaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                ifaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                ifaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                ifaVar = this.mJsBridge.E(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                ifaVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                ifaVar = this.mJsBridge.c(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                ifaVar = this.mJsBridge.F(webView, hashMap);
            } else if (str.equals("pushNotificationPermission")) {
                ifaVar = this.mJsBridge.v(webView, hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!TextUtils.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.j = ifaVar.j;
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.j = ifaVar.j;
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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
