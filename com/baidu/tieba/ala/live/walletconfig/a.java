package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bn;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, String> a(bn bnVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bnVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bnVar.aLA);
            hashMap.put("service", bnVar.service);
            hashMap.put(CashierData.ORDERID, bnVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bnVar.aLB);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bnVar.aLC);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bnVar.aLD);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bnVar.aLE);
            hashMap.put(CashierData.NOTIFY_URL, bnVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bnVar.passuid);
            hashMap.put("title", bnVar.title);
            hashMap.put("mobile", bnVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bnVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bnVar.aLF);
            hashMap.put(CashierData.SDK_STYLE, "" + bnVar.aLG);
            hashMap.put("sign", bnVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bnVar.signType);
            if (!TextUtils.isEmpty(bnVar.tag)) {
                hashMap.put("tag", "" + bnVar.tag);
            }
            if (!TextUtils.isEmpty(bnVar.aLI)) {
                hashMap.put("channel", "" + bnVar.aLI);
            }
        }
        return hashMap;
    }
}
