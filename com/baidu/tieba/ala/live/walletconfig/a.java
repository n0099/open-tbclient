package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.as;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static HashMap<String, String> a(as asVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (asVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + asVar.ads);
            hashMap.put("service", asVar.service);
            hashMap.put(CashierData.ORDERID, asVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + asVar.adt);
            hashMap.put(CashierData.DEVICE_TYPE, "" + asVar.adu);
            hashMap.put(CashierData.PAY_AMOUNT, "" + asVar.adv);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + asVar.adw);
            hashMap.put(CashierData.NOTIFY_URL, asVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, asVar.passuid);
            hashMap.put("title", asVar.title);
            hashMap.put("mobile", asVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, asVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + asVar.adx);
            hashMap.put(CashierData.SDK_STYLE, "" + asVar.ady);
            hashMap.put("sign", asVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + asVar.signType);
            if (!TextUtils.isEmpty(asVar.tag)) {
                hashMap.put("tag", "" + asVar.tag);
            }
            if (!TextUtils.isEmpty(asVar.adA)) {
                hashMap.put("channel", "" + asVar.adA);
            }
        }
        return hashMap;
    }
}
