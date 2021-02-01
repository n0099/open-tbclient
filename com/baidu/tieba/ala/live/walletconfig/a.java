package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bz;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static HashMap<String, String> a(bz bzVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bzVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bzVar.aQz);
            hashMap.put("service", bzVar.service);
            hashMap.put(CashierData.ORDERID, bzVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bzVar.aQA);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bzVar.aQB);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bzVar.aQC);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bzVar.aQD);
            hashMap.put(CashierData.NOTIFY_URL, bzVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bzVar.passuid);
            hashMap.put("title", bzVar.title);
            hashMap.put("mobile", bzVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bzVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bzVar.aQE);
            hashMap.put(CashierData.SDK_STYLE, "" + bzVar.aQF);
            hashMap.put("sign", bzVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bzVar.aQG);
            if (!TextUtils.isEmpty(bzVar.tag)) {
                hashMap.put("tag", "" + bzVar.tag);
            }
            if (!TextUtils.isEmpty(bzVar.aQI)) {
                hashMap.put("channel", "" + bzVar.aQI);
            }
        }
        return hashMap;
    }
}
