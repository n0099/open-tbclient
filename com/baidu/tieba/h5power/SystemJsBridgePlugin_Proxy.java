package com.baidu.tieba.h5power;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.tieba.tm6;
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
public class SystemJsBridgePlugin_Proxy extends kia {
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

    @Override // com.baidu.tieba.kia
    public mia dispatch(WebView webView, oia oiaVar, mia miaVar) {
        InterceptResult invokeLLL;
        mia miaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, webView, oiaVar, miaVar)) == null) {
            if (miaVar == null) {
                miaVar2 = new mia();
            } else {
                miaVar2 = miaVar;
            }
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("system/saveImage")) {
                miaVar2.s(true);
                mia u = this.mJsBridge.u(webView, e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (u != null) {
                    miaVar2.y(u.f());
                    miaVar2.u(u.b());
                    miaVar2.o(u.a());
                    miaVar2.x(u.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "saveImageSuccess", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                miaVar2.s(true);
                mia E = this.mJsBridge.E(webView, e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (E != null) {
                    miaVar2.y(E.f());
                    miaVar2.u(E.b());
                    miaVar2.o(E.a());
                    miaVar2.x(E.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "orderGameApkResult", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                miaVar2.s(true);
                mia t = this.mJsBridge.t(webView);
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (t != null) {
                    miaVar2.y(t.f());
                    miaVar2.u(t.b());
                    miaVar2.o(t.a());
                    miaVar2.x(t.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "GetPhotoAlbum", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                miaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                mia K = this.mJsBridge.K(webView, optInt, arrayList);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (K != null) {
                    miaVar2.y(K.f());
                    miaVar2.u(K.b());
                    miaVar2.o(K.a());
                    miaVar2.x(K.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver(webView, "selectPhotoAlbum", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                miaVar2.s(true);
                mia G = this.mJsBridge.G(webView, e.optString("soundUrl"));
                if (G != null) {
                    miaVar2.y(G.f());
                    miaVar2.u(G.b());
                    miaVar2.o(G.a());
                    miaVar2.x(G.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                miaVar2.s(true);
                mia H = this.mJsBridge.H(webView);
                if (H != null) {
                    miaVar2.y(H.f());
                    miaVar2.u(H.b());
                    miaVar2.o(H.a());
                    miaVar2.x(H.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                miaVar2.s(true);
                mia f = this.mJsBridge.f(webView, e.optInt("result"));
                if (f != null) {
                    miaVar2.y(f.f());
                    miaVar2.u(f.b());
                    miaVar2.o(f.a());
                    miaVar2.x(f.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                miaVar2.s(true);
                mia d = this.mJsBridge.d(webView, e.optString("pkgName"));
                if (d != null) {
                    miaVar2.y(d.f());
                    miaVar2.u(d.b());
                    miaVar2.o(d.a());
                    miaVar2.x(d.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                miaVar2.s(true);
                mia i = this.mJsBridge.i(webView, e.optInt(PackageTable.DISABLE));
                if (i != null) {
                    miaVar2.y(i.f());
                    miaVar2.u(i.b());
                    miaVar2.o(i.a());
                    miaVar2.x(i.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                miaVar2.s(true);
                mia M = this.mJsBridge.M(webView, e.optString("pkgName"), e.optString("schema"));
                if (M != null) {
                    miaVar2.y(M.f());
                    miaVar2.u(M.b());
                    miaVar2.o(M.a());
                    miaVar2.x(M.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                miaVar2.s(true);
                mia v = this.mJsBridge.v(webView);
                if (v != null) {
                    miaVar2.y(v.f());
                    miaVar2.u(v.b());
                    miaVar2.o(v.a());
                    miaVar2.x(v.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                miaVar2.s(true);
                mia s = this.mJsBridge.s(webView);
                if (s != null) {
                    miaVar2.y(s.f());
                    miaVar2.u(s.b());
                    miaVar2.o(s.a());
                    miaVar2.x(s.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                miaVar2.s(true);
                mia miaVar3 = miaVar2;
                mia N = this.mJsBridge.N(webView, e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (N != null) {
                    miaVar3.y(N.f());
                    miaVar3.u(N.b());
                    miaVar3.o(N.a());
                    miaVar3.x(N.e());
                }
                miaVar3.z(0);
                return miaVar3;
            } else {
                mia miaVar4 = miaVar2;
                if (b.equals("system/checkInstallGameApk")) {
                    miaVar4.s(true);
                    mia e2 = this.mJsBridge.e(webView, e.optString("pkgName"));
                    if (e2 != null) {
                        miaVar4.y(e2.f());
                        miaVar4.u(e2.b());
                        miaVar4.o(e2.a());
                        miaVar4.x(e2.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/getAppStorage")) {
                    miaVar4.s(true);
                    mia l = this.mJsBridge.l(webView, e.optString("key"));
                    if (l != null) {
                        miaVar4.y(l.f());
                        miaVar4.u(l.b());
                        miaVar4.o(l.a());
                        miaVar4.x(l.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/putAppStorage")) {
                    miaVar4.s(true);
                    mia I = this.mJsBridge.I(webView, e.optString("key"), e.optString("data"));
                    if (I != null) {
                        miaVar4.y(I.f());
                        miaVar4.u(I.b());
                        miaVar4.o(I.a());
                        miaVar4.x(I.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/getHistoryForumData")) {
                    miaVar4.s(true);
                    mia o = this.mJsBridge.o(webView);
                    if (o != null) {
                        miaVar4.y(o.f());
                        miaVar4.u(o.b());
                        miaVar4.o(o.a());
                        miaVar4.x(o.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/getFileDownloadStatus")) {
                    miaVar4.s(true);
                    mia n = this.mJsBridge.n(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (n != null) {
                        miaVar4.y(n.f());
                        miaVar4.u(n.b());
                        miaVar4.o(n.a());
                        miaVar4.x(n.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/getFileDownloadProgress")) {
                    miaVar4.s(true);
                    mia m = this.mJsBridge.m(webView, e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                    if (m != null) {
                        miaVar4.y(m.f());
                        miaVar4.u(m.b());
                        miaVar4.o(m.a());
                        miaVar4.x(m.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/fileDownloadPause")) {
                    miaVar4.s(true);
                    mia k = this.mJsBridge.k(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (k != null) {
                        miaVar4.y(k.f());
                        miaVar4.u(k.b());
                        miaVar4.o(k.a());
                        miaVar4.x(k.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/fileDownloadDelete")) {
                    miaVar4.s(true);
                    mia j = this.mJsBridge.j(webView, e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (j != null) {
                        miaVar4.y(j.f());
                        miaVar4.u(j.b());
                        miaVar4.o(j.a());
                        miaVar4.x(j.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/installGameApk")) {
                    miaVar4.s(true);
                    mia w = this.mJsBridge.w(webView, e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                    if (w != null) {
                        miaVar4.y(w.f());
                        miaVar4.u(w.b());
                        miaVar4.o(w.a());
                        miaVar4.x(w.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/launchApk")) {
                    miaVar4.s(true);
                    mia A = this.mJsBridge.A(webView, e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                    if (A != null) {
                        miaVar4.y(A.f());
                        miaVar4.u(A.b());
                        miaVar4.o(A.a());
                        miaVar4.x(A.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/startLoadTimeInterval")) {
                    miaVar4.s(true);
                    mia r = this.mJsBridge.r(webView);
                    if (r != null) {
                        miaVar4.y(r.f());
                        miaVar4.u(r.b());
                        miaVar4.o(r.a());
                        miaVar4.x(r.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/wakeKeyboard")) {
                    miaVar4.s(true);
                    mia O = this.mJsBridge.O(webView, e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                    if (O != null) {
                        miaVar4.y(O.f());
                        miaVar4.u(O.b());
                        miaVar4.o(O.a());
                        miaVar4.x(O.e());
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else if (b.equals("system/keyboardHeightChange")) {
                    miaVar4.s(true);
                    mia y = this.mJsBridge.y(webView);
                    this.mNotificationNameList.add("keyboardHeightChange");
                    if (y != null) {
                        miaVar4.y(y.f());
                        miaVar4.u(y.b());
                        miaVar4.o(y.a());
                        miaVar4.x(y.e());
                        if (!miaVar4.h()) {
                            miaVar4.n(false);
                            addObserver(webView, "keyboardHeightChange", miaVar4, true);
                        }
                    }
                    miaVar4.z(0);
                    return miaVar4;
                } else {
                    return miaVar4;
                }
            }
            return miaVar2;
        }
        return (mia) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.kia
    public tm6 getJsBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mJsBridge;
        }
        return (tm6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, hashMap)) == null) {
            mia miaVar = null;
            if (TextUtils.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                miaVar = this.mJsBridge.J(webView, hashMap);
            } else if (str.equals("orderGameApkResult")) {
                miaVar = this.mJsBridge.F(webView, hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                miaVar = this.mJsBridge.p(webView, hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                miaVar = this.mJsBridge.q(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                miaVar = this.mJsBridge.g(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                miaVar = this.mJsBridge.h(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                miaVar = this.mJsBridge.C(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                miaVar = this.mJsBridge.B(webView, hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                miaVar = this.mJsBridge.c(webView, hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                miaVar = this.mJsBridge.D(webView, hashMap);
            }
            if (miaVar != null) {
                miaVar.z(0);
            }
            List<lia> list = this.mAsyncCallBackMethodList.get(str);
            if (miaVar != null && list != null) {
                Iterator<lia> it = list.iterator();
                if (!TextUtils.isEmpty(miaVar.e())) {
                    while (it.hasNext()) {
                        lia next = it.next();
                        if (next.b().equals(miaVar.e())) {
                            mia miaVar2 = new mia();
                            miaVar2.w(next.a());
                            miaVar2.y(miaVar.f());
                            miaVar2.u(miaVar.b());
                            miaVar2.o(miaVar.a());
                            miaVar2.j = miaVar.j;
                            miaVar2.A(miaVar.l());
                            arrayList.add(miaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        lia next2 = it.next();
                        mia miaVar3 = new mia();
                        miaVar3.w(next2.a());
                        miaVar3.y(miaVar.f());
                        miaVar3.u(miaVar.b());
                        miaVar3.o(miaVar.a());
                        miaVar3.j = miaVar.j;
                        miaVar3.A(miaVar.l());
                        arrayList.add(miaVar3);
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
