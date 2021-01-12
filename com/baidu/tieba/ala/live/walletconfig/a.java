package com.baidu.tieba.ala.live.walletconfig;

import android.text.TextUtils;
import com.baidu.live.data.bu;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static HashMap<String, String> a(bu buVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (buVar != null) {
            hashMap.put(CashierData.CUSTOMER_ID, "" + buVar.aNy);
            hashMap.put("service", buVar.service);
            hashMap.put(CashierData.ORDERID, buVar.orderId);
            hashMap.put(CashierData.ORDER_CREATE_TIME, "" + buVar.aNz);
            hashMap.put(CashierData.DEVICE_TYPE, "" + buVar.aNA);
            hashMap.put(CashierData.PAY_AMOUNT, "" + buVar.aNB);
            hashMap.put(CashierData.ORIGINALAMOUNT_AMOUNT, "" + buVar.aNC);
            hashMap.put(CashierData.NOTIFY_URL, buVar.notifyUrl);
            hashMap.put(CashierData.PASS_UID, buVar.passuid);
            hashMap.put("title", buVar.title);
            hashMap.put("mobile", buVar.mobile);
            hashMap.put(CashierData.ITEM_INFO, buVar.itemInfo);
            hashMap.put(CashierData.SDK, "" + buVar.aND);
            hashMap.put(CashierData.SDK_STYLE, "" + buVar.aNE);
            hashMap.put("sign", buVar.sign);
            hashMap.put(CashierData.SIGN_TYPE, "" + buVar.aNF);
            if (!TextUtils.isEmpty(buVar.tag)) {
                hashMap.put("tag", "" + buVar.tag);
            }
            if (!TextUtils.isEmpty(buVar.aNH)) {
                hashMap.put("channel", "" + buVar.aNH);
            }
        }
        return hashMap;
    }
}
