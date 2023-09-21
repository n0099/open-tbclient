package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.qka;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
import com.baidu.tieba.xm6;
import com.baidu.tieba.yx4;
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
public class SystemJsBridgePlugin_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yx4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(yx4 yx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yx4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = yx4Var;
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

    @Override // com.baidu.tieba.qka
    public ska dispatch(WebView webView, uka ukaVar, ska skaVar) {
        InterceptResult invokeLLL;
        ska skaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, ukaVar, skaVar)) == null) {
            if (skaVar == null) {
                skaVar2 = new ska();
            } else {
                skaVar2 = skaVar;
            }
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("system/saveImage")) {
                skaVar2.s(true);
                ska u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    skaVar2.y(u.f());
                    skaVar2.u(u.b());
                    skaVar2.o(u.a());
                    skaVar2.x(u.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                skaVar2.s(true);
                ska E = this.mJsBridge.E(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (E != null) {
                    skaVar2.y(E.f());
                    skaVar2.u(E.b());
                    skaVar2.o(E.a());
                    skaVar2.x(E.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                skaVar2.s(true);
                ska t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    skaVar2.y(t.f());
                    skaVar2.u(t.b());
                    skaVar2.o(t.a());
                    skaVar2.x(t.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                skaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                ska K = this.mJsBridge.K(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (K != null) {
                    skaVar2.y(K.f());
                    skaVar2.u(K.b());
                    skaVar2.o(K.a());
                    skaVar2.x(K.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                skaVar2.s(true);
                ska G = this.mJsBridge.G(webView, e.optString("soundUrl"));
                if (G != null) {
                    skaVar2.y(G.f());
                    skaVar2.u(G.b());
                    skaVar2.o(G.a());
                    skaVar2.x(G.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                skaVar2.s(true);
                ska H = this.mJsBridge.H(webView);
                if (H != null) {
                    skaVar2.y(H.f());
                    skaVar2.u(H.b());
                    skaVar2.o(H.a());
                    skaVar2.x(H.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                skaVar2.s(true);
                ska f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    skaVar2.y(f.f());
                    skaVar2.u(f.b());
                    skaVar2.o(f.a());
                    skaVar2.x(f.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                skaVar2.s(true);
                ska d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    skaVar2.y(d.f());
                    skaVar2.u(d.b());
                    skaVar2.o(d.a());
                    skaVar2.x(d.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                skaVar2.s(true);
                ska i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    skaVar2.y(i.f());
                    skaVar2.u(i.b());
                    skaVar2.o(i.a());
                    skaVar2.x(i.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                skaVar2.s(true);
                ska M = this.mJsBridge.M(webView, e.optString("pkgName"), e.optString("schema"));
                if (M != null) {
                    skaVar2.y(M.f());
                    skaVar2.u(M.b());
                    skaVar2.o(M.a());
                    skaVar2.x(M.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                skaVar2.s(true);
                ska v = this.mJsBridge.v(webView);
                if (v != null) {
                    skaVar2.y(v.f());
                    skaVar2.u(v.b());
                    skaVar2.o(v.a());
                    skaVar2.x(v.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                skaVar2.s(true);
                ska s = this.mJsBridge.s(webView);
                if (s != null) {
                    skaVar2.y(s.f());
                    skaVar2.u(s.b());
                    skaVar2.o(s.a());
                    skaVar2.x(s.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                skaVar2.s(true);
                ska skaVar3 = skaVar2;
                ska N = this.mJsBridge.N(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (N != null) {
                    skaVar3.y(N.f());
                    skaVar3.u(N.b());
                    skaVar3.o(N.a());
                    skaVar3.x(N.e());
                }
                skaVar3.z(0);
                return skaVar3;
            } else {
                ska skaVar4 = skaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    skaVar4.s(true);
                    ska e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        skaVar4.y(e2.f());
                        skaVar4.u(e2.b());
                        skaVar4.o(e2.a());
                        skaVar4.x(e2.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    skaVar4.s(true);
                    ska l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        skaVar4.y(l.f());
                        skaVar4.u(l.b());
                        skaVar4.o(l.a());
                        skaVar4.x(l.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    skaVar4.s(true);
                    ska I = this.mJsBridge.I(webView, e.optString("key"), e.optString("data"));
                    if (I != null) {
                        skaVar4.y(I.f());
                        skaVar4.u(I.b());
                        skaVar4.o(I.a());
                        skaVar4.x(I.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    skaVar4.s(true);
                    ska o = this.mJsBridge.o(webView);
                    if (o != null) {
                        skaVar4.y(o.f());
                        skaVar4.u(o.b());
                        skaVar4.o(o.a());
                        skaVar4.x(o.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    skaVar4.s(true);
                    ska n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        skaVar4.y(n.f());
                        skaVar4.u(n.b());
                        skaVar4.o(n.a());
                        skaVar4.x(n.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    skaVar4.s(true);
                    ska m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        skaVar4.y(m.f());
                        skaVar4.u(m.b());
                        skaVar4.o(m.a());
                        skaVar4.x(m.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    skaVar4.s(true);
                    ska k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        skaVar4.y(k.f());
                        skaVar4.u(k.b());
                        skaVar4.o(k.a());
                        skaVar4.x(k.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    skaVar4.s(true);
                    ska j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        skaVar4.y(j.f());
                        skaVar4.u(j.b());
                        skaVar4.o(j.a());
                        skaVar4.x(j.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/installGameApk")) {
                    skaVar4.s(true);
                    ska w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        skaVar4.y(w.f());
                        skaVar4.u(w.b());
                        skaVar4.o(w.a());
                        skaVar4.x(w.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/launchApk")) {
                    skaVar4.s(true);
                    ska A = this.mJsBridge.A(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (A != null) {
                        skaVar4.y(A.f());
                        skaVar4.u(A.b());
                        skaVar4.o(A.a());
                        skaVar4.x(A.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    skaVar4.s(true);
                    ska r = this.mJsBridge.r(webView);
                    if (r != null) {
                        skaVar4.y(r.f());
                        skaVar4.u(r.b());
                        skaVar4.o(r.a());
                        skaVar4.x(r.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    skaVar4.s(true);
                    ska O = this.mJsBridge.O(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (O != null) {
                        skaVar4.y(O.f());
                        skaVar4.u(O.b());
                        skaVar4.o(O.a());
                        skaVar4.x(O.e());
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    skaVar4.s(true);
                    ska y = this.mJsBridge.y(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (y != null) {
                        skaVar4.y(y.f());
                        skaVar4.u(y.b());
                        skaVar4.o(y.a());
                        skaVar4.x(y.e());
                        if (!skaVar4.h()) {
                            skaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", skaVar4, true);
                        }
                    }
                    skaVar4.z(0);
                    return skaVar4;
                } else {
                    return skaVar4;
                }
            }
            return skaVar2;
        }
        return (ska) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.qka
    public xm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (xm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                skaVar = this.mJsBridge.J(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                skaVar = this.mJsBridge.F(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                skaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                skaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                skaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                skaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                skaVar = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                skaVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                skaVar = this.mJsBridge.c(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                skaVar = this.mJsBridge.D(webView, hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!TextUtils.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.j = skaVar.j;
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.j = skaVar.j;
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
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
