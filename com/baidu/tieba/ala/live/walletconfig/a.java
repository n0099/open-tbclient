package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.be;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static HashMap<String, String> a(be beVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (beVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + beVar.aDt);
            hashMap.put("service", beVar.service);
            hashMap.put(CashierData.ORDERID, beVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + beVar.aDu);
            hashMap.put(CashierData.DEVICE_TYPE, "" + beVar.aDv);
            hashMap.put(CashierData.PAY_AMOUNT, "" + beVar.aDw);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + beVar.aDx);
            hashMap.put(CashierData.NOTIFY_URL, beVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, beVar.passuid);
            hashMap.put("title", beVar.title);
            hashMap.put("mobile", beVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, beVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + beVar.aDy);
            hashMap.put(CashierData.SDK_STYLE, "" + beVar.aDz);
            hashMap.put("sign", beVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + beVar.signType);
            if (!TextUtils.isEmpty(beVar.tag)) {
                hashMap.put("tag", "" + beVar.tag);
            }
            if (!TextUtils.isEmpty(beVar.aDB)) {
                hashMap.put("channel", "" + beVar.aDB);
            }
        }
        return hashMap;
    }
}
