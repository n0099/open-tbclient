package com.baidu.tieba.ala.live.walletconfig;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes10.dex */
public class CashierData implements Serializable {
    public static final String CHANNEL = "channel";
    public static final String CUSTOMER_ID = "customerId";
    public static final String DEFAULT_RES_PAGE = "defaultResPage";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String EXT_DATA = "extData";
    public static final String IMIE = "imei";
    public static final String ITEM_INFO = "itemInfo";
    public static final String MOBILE = "mobile";
    public static final String NOTIFY_URL = "notifyUrl";
    public static final String ORDERID = "orderId";
    public static final String ORDER_CREATE_TIME = "orderCreateTime";
    public static final String ORIGINALAMOUNT_AMOUNT = "originalAmount";
    public static final String PASS_UID = "passuid";
    public static final String PAY_AMOUNT = "payAmount";
    public static final String RETURN_URL = "returnUrl";
    public static final String SDK = "sdk";
    public static final String SDK_STYLE = "sdkStyle";
    public static final String SERVICE = "service";
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "signType";
    public static final String TAG = "tag";
    public static final String TITLE = "title";
    public static final String TN = "tn";
    public static final String URL = "url";
    private static final long serialVersionUID = 1;
    private Map<String, String> mData;
    private Map<String, String[]> mExtraData;
    public static String DELIVERY_CASHIER_DATA = "delivery_cashier_data";
    public static String DELIVERY_CASHIER_CONTENT = "delivery_cashier_content";

    public void setData(Map<String, String> map) {
        this.mData = map;
    }

    public Map<String, String> getData() {
        return this.mData;
    }
}
