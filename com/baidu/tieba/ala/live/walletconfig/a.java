package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.br;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, String> a(br brVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (brVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + brVar.aQh);
            hashMap.put("service", brVar.service);
            hashMap.put(CashierData.ORDERID, brVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + brVar.aQi);
            hashMap.put(CashierData.DEVICE_TYPE, "" + brVar.aQj);
            hashMap.put(CashierData.PAY_AMOUNT, "" + brVar.aQk);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + brVar.aQl);
            hashMap.put(CashierData.NOTIFY_URL, brVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, brVar.passuid);
            hashMap.put("title", brVar.title);
            hashMap.put("mobile", brVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, brVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + brVar.aQm);
            hashMap.put(CashierData.SDK_STYLE, "" + brVar.aQn);
            hashMap.put("sign", brVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + brVar.signType);
            if (!TextUtils.isEmpty(brVar.tag)) {
                hashMap.put("tag", "" + brVar.tag);
            }
            if (!TextUtils.isEmpty(brVar.aQp)) {
                hashMap.put("channel", "" + brVar.aQp);
            }
        }
        return hashMap;
    }
}
