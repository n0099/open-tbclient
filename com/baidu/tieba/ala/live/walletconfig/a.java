package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bf;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, String> a(bf bfVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bfVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bfVar.aEN);
            hashMap.put("service", bfVar.service);
            hashMap.put(CashierData.ORDERID, bfVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bfVar.aEO);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bfVar.aEP);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bfVar.aEQ);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bfVar.aER);
            hashMap.put(CashierData.NOTIFY_URL, bfVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bfVar.passuid);
            hashMap.put("title", bfVar.title);
            hashMap.put("mobile", bfVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bfVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bfVar.aES);
            hashMap.put(CashierData.SDK_STYLE, "" + bfVar.aET);
            hashMap.put("sign", bfVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bfVar.signType);
            if (!TextUtils.isEmpty(bfVar.tag)) {
                hashMap.put("tag", "" + bfVar.tag);
            }
            if (!TextUtils.isEmpty(bfVar.aEV)) {
                hashMap.put("channel", "" + bfVar.aEV);
            }
        }
        return hashMap;
    }
}
