package com.baidu.tieba.h5power;

import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.tbadkCore.e.a.a;
import com.baidu.tieba.tbadkCore.e.a.b;
import com.baidu.tieba.tbadkCore.e.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UegTbJsBridge_Proxy extends a {
    private UegTbJsBridge mJsBridge;

    public UegTbJsBridge_Proxy(UegTbJsBridge uegTbJsBridge) {
        this.mJsBridge = uegTbJsBridge;
        this.mAsyncCallBackNameList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public b dispatch(d dVar, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        String dKA = dVar.dKA();
        JSONObject dKy = dVar.dKy();
        if (dKA.equals("host/callNativeSMS")) {
            bVar.xz(true);
            b callNativeSMS = this.mJsBridge.callNativeSMS(dKy.optString("phoneNumber"), dKy.optString("content"));
            if (callNativeSMS != null) {
                bVar.setStatus(callNativeSMS.getStatus());
                bVar.setMessage(callNativeSMS.getMessage());
                bVar.setData(callNativeSMS.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("device/setBlockPopInfo")) {
            bVar.xz(true);
            b blockPopInfo = this.mJsBridge.setBlockPopInfo(dKy.optInt("canPost"), dKy.optString("blockInfo"), dKy.optString("aheadInfo"), dKy.optString("aheadUrl"), dKy.optString("okInfo"), dKy.optInt("aheadType"));
            if (blockPopInfo != null) {
                bVar.setStatus(blockPopInfo.getStatus());
                bVar.setMessage(blockPopInfo.getMessage());
                bVar.setData(blockPopInfo.getData());
            }
            bVar.Kn(0);
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public List<b> processNotification(String str, HashMap hashMap) {
        b bVar = null;
        if (au.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (0 != 0) {
            bVar.Kn(0);
        }
        List<String> list = this.mAsyncCallBackNameList.get(str);
        if (0 != 0 && list != null) {
            for (String str2 : list) {
                b bVar2 = new b();
                bVar2.Su(str2);
                bVar2.setStatus(bVar.getStatus());
                bVar2.setMessage(bVar.getMessage());
                bVar2.setData(bVar.getData());
                arrayList.add(bVar2);
            }
        }
        return arrayList;
    }
}
