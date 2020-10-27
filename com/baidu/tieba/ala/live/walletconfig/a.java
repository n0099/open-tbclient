package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bq;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, String> a(bq bqVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bqVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bqVar.aPk);
            hashMap.put("service", bqVar.service);
            hashMap.put(CashierData.ORDERID, bqVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bqVar.aPl);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bqVar.aPm);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bqVar.aPn);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bqVar.aPo);
            hashMap.put(CashierData.NOTIFY_URL, bqVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bqVar.passuid);
            hashMap.put("title", bqVar.title);
            hashMap.put("mobile", bqVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bqVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bqVar.aPp);
            hashMap.put(CashierData.SDK_STYLE, "" + bqVar.aPq);
            hashMap.put("sign", bqVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bqVar.signType);
            if (!TextUtils.isEmpty(bqVar.tag)) {
                hashMap.put("tag", "" + bqVar.tag);
            }
            if (!TextUtils.isEmpty(bqVar.aPs)) {
                hashMap.put("channel", "" + bqVar.aPs);
            }
        }
        return hashMap;
    }
}
