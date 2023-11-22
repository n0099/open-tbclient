package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.dj6;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qsa;
import com.baidu.tieba.xs4;
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
public class SystemJsBridgePlugin_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xs4 mJsBridge;

    public SystemJsBridgePlugin_Proxy(xs4 xs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xs4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = xs4Var;
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

    @Override // com.baidu.tieba.msa
    public osa dispatch(WebView webView, qsa qsaVar, osa osaVar) {
        InterceptResult invokeLLL;
        osa osaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, qsaVar, osaVar)) == null) {
            if (osaVar == null) {
                osaVar2 = new osa();
            } else {
                osaVar2 = osaVar;
            }
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("system/saveImage")) {
                osaVar2.s(true);
                osa w = this.mJsBridge.w(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (w != null) {
                    osaVar2.y(w.f());
                    osaVar2.u(w.b());
                    osaVar2.o(w.a());
                    osaVar2.x(w.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                osaVar2.s(true);
                osa G = this.mJsBridge.G(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (G != null) {
                    osaVar2.y(G.f());
                    osaVar2.u(G.b());
                    osaVar2.o(G.a());
                    osaVar2.x(G.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                osaVar2.s(true);
                osa t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    osaVar2.y(t.f());
                    osaVar2.u(t.b());
                    osaVar2.o(t.a());
                    osaVar2.x(t.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                osaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                osa M = this.mJsBridge.M(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (M != null) {
                    osaVar2.y(M.f());
                    osaVar2.u(M.b());
                    osaVar2.o(M.a());
                    osaVar2.x(M.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                osaVar2.s(true);
                osa I = this.mJsBridge.I(webView, e.optString("soundUrl"));
                if (I != null) {
                    osaVar2.y(I.f());
                    osaVar2.u(I.b());
                    osaVar2.o(I.a());
                    osaVar2.x(I.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                osaVar2.s(true);
                osa J = this.mJsBridge.J(webView);
                if (J != null) {
                    osaVar2.y(J.f());
                    osaVar2.u(J.b());
                    osaVar2.o(J.a());
                    osaVar2.x(J.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                osaVar2.s(true);
                osa f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    osaVar2.y(f.f());
                    osaVar2.u(f.b());
                    osaVar2.o(f.a());
                    osaVar2.x(f.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                osaVar2.s(true);
                osa d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    osaVar2.y(d.f());
                    osaVar2.u(d.b());
                    osaVar2.o(d.a());
                    osaVar2.x(d.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                osaVar2.s(true);
                osa i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    osaVar2.y(i.f());
                    osaVar2.u(i.b());
                    osaVar2.o(i.a());
                    osaVar2.x(i.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                osaVar2.s(true);
                osa O = this.mJsBridge.O(webView, e.optString("pkgName"), e.optString("schema"));
                if (O != null) {
                    osaVar2.y(O.f());
                    osaVar2.u(O.b());
                    osaVar2.o(O.a());
                    osaVar2.x(O.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                osaVar2.s(true);
                osa x = this.mJsBridge.x(webView);
                if (x != null) {
                    osaVar2.y(x.f());
                    osaVar2.u(x.b());
                    osaVar2.o(x.a());
                    osaVar2.x(x.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                osaVar2.s(true);
                osa s = this.mJsBridge.s(webView);
                if (s != null) {
                    osaVar2.y(s.f());
                    osaVar2.u(s.b());
                    osaVar2.o(s.a());
                    osaVar2.x(s.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                osaVar2.s(true);
                osa osaVar3 = osaVar2;
                osa P = this.mJsBridge.P(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (P != null) {
                    osaVar3.y(P.f());
                    osaVar3.u(P.b());
                    osaVar3.o(P.a());
                    osaVar3.x(P.e());
                }
                osaVar3.z(0);
                return osaVar3;
            } else {
                osa osaVar4 = osaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    osaVar4.s(true);
                    osa e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        osaVar4.y(e2.f());
                        osaVar4.u(e2.b());
                        osaVar4.o(e2.a());
                        osaVar4.x(e2.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    osaVar4.s(true);
                    osa l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        osaVar4.y(l.f());
                        osaVar4.u(l.b());
                        osaVar4.o(l.a());
                        osaVar4.x(l.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    osaVar4.s(true);
                    osa K = this.mJsBridge.K(webView, e.optString("key"), e.optString("data"));
                    if (K != null) {
                        osaVar4.y(K.f());
                        osaVar4.u(K.b());
                        osaVar4.o(K.a());
                        osaVar4.x(K.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    osaVar4.s(true);
                    osa o = this.mJsBridge.o(webView);
                    if (o != null) {
                        osaVar4.y(o.f());
                        osaVar4.u(o.b());
                        osaVar4.o(o.a());
                        osaVar4.x(o.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    osaVar4.s(true);
                    osa n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        osaVar4.y(n.f());
                        osaVar4.u(n.b());
                        osaVar4.o(n.a());
                        osaVar4.x(n.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    osaVar4.s(true);
                    osa m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        osaVar4.y(m.f());
                        osaVar4.u(m.b());
                        osaVar4.o(m.a());
                        osaVar4.x(m.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    osaVar4.s(true);
                    osa k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        osaVar4.y(k.f());
                        osaVar4.u(k.b());
                        osaVar4.o(k.a());
                        osaVar4.x(k.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    osaVar4.s(true);
                    osa j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        osaVar4.y(j.f());
                        osaVar4.u(j.b());
                        osaVar4.o(j.a());
                        osaVar4.x(j.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/installGameApk")) {
                    osaVar4.s(true);
                    osa y = this.mJsBridge.y(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (y != null) {
                        osaVar4.y(y.f());
                        osaVar4.u(y.b());
                        osaVar4.o(y.a());
                        osaVar4.x(y.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/launchApk")) {
                    osaVar4.s(true);
                    osa C = this.mJsBridge.C(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (C != null) {
                        osaVar4.y(C.f());
                        osaVar4.u(C.b());
                        osaVar4.o(C.a());
                        osaVar4.x(C.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    osaVar4.s(true);
                    osa r = this.mJsBridge.r(webView);
                    if (r != null) {
                        osaVar4.y(r.f());
                        osaVar4.u(r.b());
                        osaVar4.o(r.a());
                        osaVar4.x(r.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    osaVar4.s(true);
                    osa Q = this.mJsBridge.Q(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (Q != null) {
                        osaVar4.y(Q.f());
                        osaVar4.u(Q.b());
                        osaVar4.o(Q.a());
                        osaVar4.x(Q.e());
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    osaVar4.s(true);
                    osa A = this.mJsBridge.A(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (A != null) {
                        osaVar4.y(A.f());
                        osaVar4.u(A.b());
                        osaVar4.o(A.a());
                        osaVar4.x(A.e());
                        if (!osaVar4.h()) {
                            osaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", osaVar4, true);
                        }
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else if (b.equals("system/pushNotificationPermission")) {
                    osaVar4.s(true);
                    osa u = this.mJsBridge.u(webView, e.optString("switch_name"), e.optString("operate_type"), e.optString("set_status"));
                    this.mNotificationNameList.add("pushNotificationPermission");
                    if (u != null) {
                        osaVar4.y(u.f());
                        osaVar4.u(u.b());
                        osaVar4.o(u.a());
                        osaVar4.x(u.e());
                        if (!osaVar4.h()) {
                            osaVar4.n(false);
                            addObserver(webView, "pushNotificationPermission", osaVar4, false);
                        }
                    }
                    osaVar4.z(0);
                    return osaVar4;
                } else {
                    return osaVar4;
                }
            }
            return osaVar2;
        }
        return (osa) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.msa
    public dj6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (dj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                osaVar = this.mJsBridge.L(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                osaVar = this.mJsBridge.H(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                osaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                osaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                osaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                osaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                osaVar = this.mJsBridge.E(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                osaVar = this.mJsBridge.D(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                osaVar = this.mJsBridge.c(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                osaVar = this.mJsBridge.F(webView, hashMap);
            } else if (str.equals("pushNotificationPermission")) {
                osaVar = this.mJsBridge.v(webView, hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!TextUtils.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.j = osaVar.j;
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.j = osaVar.j;
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
