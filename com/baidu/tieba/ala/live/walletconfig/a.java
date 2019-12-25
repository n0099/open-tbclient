package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.am;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static HashMap<String, String> a(am amVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (amVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + amVar.aaY);
            hashMap.put("service", amVar.service);
            hashMap.put(CashierData.ORDERID, amVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + amVar.aaZ);
            hashMap.put(CashierData.DEVICE_TYPE, "" + amVar.aba);
            hashMap.put(CashierData.PAY_AMOUNT, "" + amVar.abb);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + amVar.abd);
            hashMap.put(CashierData.NOTIFY_URL, amVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, amVar.passuid);
            hashMap.put("title", amVar.title);
            hashMap.put("mobile", amVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, amVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + amVar.abe);
            hashMap.put(CashierData.SDK_STYLE, "" + amVar.abf);
            hashMap.put("sign", amVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + amVar.abg);
            if (!TextUtils.isEmpty(amVar.tag)) {
                hashMap.put("tag", "" + amVar.tag);
            }
            if (!TextUtils.isEmpty(amVar.abi)) {
                hashMap.put("channel", "" + amVar.abi);
            }
        }
        return hashMap;
    }
}
