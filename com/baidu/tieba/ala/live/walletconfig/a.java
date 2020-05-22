package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.ba;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static HashMap<String, String> a(ba baVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (baVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + baVar.aBi);
            hashMap.put("service", baVar.service);
            hashMap.put(CashierData.ORDERID, baVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + baVar.aBj);
            hashMap.put(CashierData.DEVICE_TYPE, "" + baVar.aBk);
            hashMap.put(CashierData.PAY_AMOUNT, "" + baVar.aBl);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + baVar.aBm);
            hashMap.put(CashierData.NOTIFY_URL, baVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, baVar.passuid);
            hashMap.put("title", baVar.title);
            hashMap.put("mobile", baVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, baVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + baVar.aBn);
            hashMap.put(CashierData.SDK_STYLE, "" + baVar.aBo);
            hashMap.put("sign", baVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + baVar.signType);
            if (!TextUtils.isEmpty(baVar.tag)) {
                hashMap.put("tag", "" + baVar.tag);
            }
            if (!TextUtils.isEmpty(baVar.aBq)) {
                hashMap.put("channel", "" + baVar.aBq);
            }
        }
        return hashMap;
    }
}
