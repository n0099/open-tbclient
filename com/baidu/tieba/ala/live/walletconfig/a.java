package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bs;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, String> a(bs bsVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bsVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bsVar.aRw);
            hashMap.put("service", bsVar.service);
            hashMap.put(CashierData.ORDERID, bsVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bsVar.aRx);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bsVar.aRy);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bsVar.aRz);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bsVar.aRA);
            hashMap.put(CashierData.NOTIFY_URL, bsVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bsVar.passuid);
            hashMap.put("title", bsVar.title);
            hashMap.put("mobile", bsVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bsVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bsVar.aRB);
            hashMap.put(CashierData.SDK_STYLE, "" + bsVar.aRC);
            hashMap.put("sign", bsVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bsVar.aRD);
            if (!TextUtils.isEmpty(bsVar.tag)) {
                hashMap.put("tag", "" + bsVar.tag);
            }
            if (!TextUtils.isEmpty(bsVar.aRF)) {
                hashMap.put("channel", "" + bsVar.aRF);
            }
        }
        return hashMap;
    }
}
