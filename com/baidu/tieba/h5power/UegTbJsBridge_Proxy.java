package com.baidu.tieba.h5power;

import com.baidu.tbadk.browser.UegTbJsBridge;
import d.b.c.e.p.k;
import d.b.i0.d3.l0.d.a;
import d.b.i0.d3.l0.d.c;
import d.b.i0.d3.l0.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UegTbJsBridge_Proxy extends a {
    public UegTbJsBridge mJsBridge;

    public UegTbJsBridge_Proxy(UegTbJsBridge uegTbJsBridge) {
        this.mJsBridge = uegTbJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // d.b.i0.d3.l0.d.a
    public c dispatch(e eVar, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        String b2 = eVar.b();
        JSONObject e2 = eVar.e();
        if (b2.equals("host/callNativeSMS")) {
            cVar.o(true);
            c callNativeSMS = this.mJsBridge.callNativeSMS(e2.optString("phoneNumber"), e2.optString("content"));
            if (callNativeSMS != null) {
                cVar.t(callNativeSMS.e());
                cVar.q(callNativeSMS.b());
                cVar.l(callNativeSMS.a());
            }
            cVar.u(0);
        } else if (b2.equals("device/setBlockPopInfo")) {
            cVar.o(true);
            c blockPopInfo = this.mJsBridge.setBlockPopInfo(e2.optInt("canPost"), e2.optString("blockInfo"), e2.optString("aheadInfo"), e2.optString("aheadUrl"), e2.optString("okInfo"), e2.optInt("aheadType"));
            if (blockPopInfo != null) {
                cVar.t(blockPopInfo.e());
                cVar.q(blockPopInfo.b());
                cVar.l(blockPopInfo.a());
            }
            cVar.u(0);
        }
        return cVar;
    }

    @Override // d.b.i0.d3.l0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        if (k.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.mAsyncCallBackMethodList.get(str);
        return arrayList;
    }
}
