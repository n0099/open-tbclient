package com.baidu.tieba.h5power;

import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.tbadkCore.e.a.a;
import com.baidu.tieba.tbadkCore.e.a.b;
import com.baidu.tieba.tbadkCore.e.a.c;
import com.baidu.tieba.tbadkCore.e.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UegTbJsBridge_Proxy extends a {
    private UegTbJsBridge mJsBridge;

    public UegTbJsBridge_Proxy(UegTbJsBridge uegTbJsBridge) {
        this.mJsBridge = uegTbJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public c dispatch(e eVar, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        String dPT = eVar.dPT();
        JSONObject dPR = eVar.dPR();
        if (dPT.equals("host/callNativeSMS")) {
            cVar.ye(true);
            c callNativeSMS = this.mJsBridge.callNativeSMS(dPR.optString("phoneNumber"), dPR.optString("content"));
            if (callNativeSMS != null) {
                cVar.setStatus(callNativeSMS.getStatus());
                cVar.setMessage(callNativeSMS.getMessage());
                cVar.setData(callNativeSMS.getData());
            }
            cVar.Ld(0);
        } else if (dPT.equals("device/setBlockPopInfo")) {
            cVar.ye(true);
            c blockPopInfo = this.mJsBridge.setBlockPopInfo(dPR.optInt("canPost"), dPR.optString("blockInfo"), dPR.optString("aheadInfo"), dPR.optString("aheadUrl"), dPR.optString("okInfo"), dPR.optInt("aheadType"));
            if (blockPopInfo != null) {
                cVar.setStatus(blockPopInfo.getStatus());
                cVar.setMessage(blockPopInfo.getMessage());
                cVar.setData(blockPopInfo.getData());
            }
            cVar.Ld(0);
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public List<c> processNotification(String str, HashMap hashMap) {
        c cVar = null;
        if (au.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (0 != 0) {
            cVar.Ld(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (0 != 0 && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar2 = new c();
                cVar2.TI(next.getName());
                cVar2.setStatus(cVar.getStatus());
                cVar2.setMessage(cVar.getMessage());
                cVar2.setData(cVar.getData());
                arrayList.add(cVar2);
                if (!next.dPK()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
