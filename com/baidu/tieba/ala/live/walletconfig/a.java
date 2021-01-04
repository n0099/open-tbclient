package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bu;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static HashMap<String, String> a(bu buVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (buVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + buVar.aSl);
            hashMap.put("service", buVar.service);
            hashMap.put(CashierData.ORDERID, buVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + buVar.aSm);
            hashMap.put(CashierData.DEVICE_TYPE, "" + buVar.aSn);
            hashMap.put(CashierData.PAY_AMOUNT, "" + buVar.aSo);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + buVar.aSp);
            hashMap.put(CashierData.NOTIFY_URL, buVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, buVar.passuid);
            hashMap.put("title", buVar.title);
            hashMap.put("mobile", buVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, buVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + buVar.aSq);
            hashMap.put(CashierData.SDK_STYLE, "" + buVar.aSr);
            hashMap.put("sign", buVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + buVar.aSs);
            if (!TextUtils.isEmpty(buVar.tag)) {
                hashMap.put("tag", "" + buVar.tag);
            }
            if (!TextUtils.isEmpty(buVar.aSu)) {
                hashMap.put("channel", "" + buVar.aSu);
            }
        }
        return hashMap;
    }
}
