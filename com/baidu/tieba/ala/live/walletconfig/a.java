package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.av;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static HashMap<String, String> a(av avVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (avVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + avVar.avT);
            hashMap.put("service", avVar.service);
            hashMap.put(CashierData.ORDERID, avVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + avVar.avU);
            hashMap.put(CashierData.DEVICE_TYPE, "" + avVar.avV);
            hashMap.put(CashierData.PAY_AMOUNT, "" + avVar.avW);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + avVar.avX);
            hashMap.put(CashierData.NOTIFY_URL, avVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, avVar.passuid);
            hashMap.put("title", avVar.title);
            hashMap.put("mobile", avVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, avVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + avVar.avY);
            hashMap.put(CashierData.SDK_STYLE, "" + avVar.avZ);
            hashMap.put("sign", avVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + avVar.signType);
            if (!TextUtils.isEmpty(avVar.tag)) {
                hashMap.put("tag", "" + avVar.tag);
            }
            if (!TextUtils.isEmpty(avVar.awb)) {
                hashMap.put("channel", "" + avVar.awb);
            }
        }
        return hashMap;
    }
}
