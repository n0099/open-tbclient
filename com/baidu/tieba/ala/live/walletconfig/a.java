package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.aq;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static HashMap<String, String> a(aq aqVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aqVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + aqVar.abm);
            hashMap.put("service", aqVar.service);
            hashMap.put(CashierData.ORDERID, aqVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + aqVar.abn);
            hashMap.put(CashierData.DEVICE_TYPE, "" + aqVar.abo);
            hashMap.put(CashierData.PAY_AMOUNT, "" + aqVar.abp);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + aqVar.abq);
            hashMap.put(CashierData.NOTIFY_URL, aqVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, aqVar.passuid);
            hashMap.put("title", aqVar.title);
            hashMap.put("mobile", aqVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, aqVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + aqVar.abr);
            hashMap.put(CashierData.SDK_STYLE, "" + aqVar.abt);
            hashMap.put("sign", aqVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + aqVar.signType);
            if (!TextUtils.isEmpty(aqVar.tag)) {
                hashMap.put("tag", "" + aqVar.tag);
            }
            if (!TextUtils.isEmpty(aqVar.abv)) {
                hashMap.put("channel", "" + aqVar.abv);
            }
        }
        return hashMap;
    }
}
