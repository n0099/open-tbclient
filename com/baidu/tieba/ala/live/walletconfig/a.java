package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bz;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static HashMap<String, String> a(bz bzVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bzVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + bzVar.aRZ);
            hashMap.put("service", bzVar.service);
            hashMap.put(CashierData.ORDERID, bzVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + bzVar.aSa);
            hashMap.put(CashierData.DEVICE_TYPE, "" + bzVar.aSb);
            hashMap.put(CashierData.PAY_AMOUNT, "" + bzVar.aSc);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + bzVar.aSd);
            hashMap.put(CashierData.NOTIFY_URL, bzVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, bzVar.passuid);
            hashMap.put("title", bzVar.title);
            hashMap.put("mobile", bzVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, bzVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + bzVar.aSe);
            hashMap.put(CashierData.SDK_STYLE, "" + bzVar.aSf);
            hashMap.put("sign", bzVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + bzVar.aSg);
            if (!TextUtils.isEmpty(bzVar.tag)) {
                hashMap.put("tag", "" + bzVar.tag);
            }
            if (!TextUtils.isEmpty(bzVar.aSi)) {
                hashMap.put("channel", "" + bzVar.aSi);
            }
        }
        return hashMap;
    }
}
