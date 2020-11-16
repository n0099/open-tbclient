package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.br;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, String> a(br brVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (brVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + brVar.aOw);
            hashMap.put("service", brVar.service);
            hashMap.put(CashierData.ORDERID, brVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + brVar.aOx);
            hashMap.put(CashierData.DEVICE_TYPE, "" + brVar.aOy);
            hashMap.put(CashierData.PAY_AMOUNT, "" + brVar.aOz);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + brVar.aOA);
            hashMap.put(CashierData.NOTIFY_URL, brVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, brVar.passuid);
            hashMap.put("title", brVar.title);
            hashMap.put("mobile", brVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, brVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + brVar.aOB);
            hashMap.put(CashierData.SDK_STYLE, "" + brVar.aOC);
            hashMap.put("sign", brVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + brVar.signType);
            if (!TextUtils.isEmpty(brVar.tag)) {
                hashMap.put("tag", "" + brVar.tag);
            }
            if (!TextUtils.isEmpty(brVar.aOE)) {
                hashMap.put("channel", "" + brVar.aOE);
            }
        }
        return hashMap;
    }
}
