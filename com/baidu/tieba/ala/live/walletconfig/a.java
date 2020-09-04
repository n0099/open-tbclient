package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bh;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    public static HashMap<String, String> a(bh bhVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bhVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bhVar.aJZ);
            hashMap.put("service", bhVar.service);
            hashMap.put(CashierData.ORDERID, bhVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bhVar.aKa);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bhVar.aKb);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bhVar.aKc);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bhVar.aKd);
            hashMap.put(CashierData.NOTIFY_URL, bhVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bhVar.passuid);
            hashMap.put("title", bhVar.title);
            hashMap.put("mobile", bhVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bhVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bhVar.aKe);
            hashMap.put(CashierData.SDK_STYLE, "" + bhVar.aKf);
            hashMap.put("sign", bhVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bhVar.signType);
            if (!TextUtils.isEmpty(bhVar.tag)) {
                hashMap.put("tag", "" + bhVar.tag);
            }
            if (!TextUtils.isEmpty(bhVar.aKh)) {
                hashMap.put("channel", "" + bhVar.aKh);
            }
        }
        return hashMap;
    }
}
