package com.baidu.tieba.faceshop;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FaceBuyData implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("buy_info")
    public BuyInfo buyInfo;
    @SerializedName("ctime")
    public int ctime;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName(SocialConstants.PARAM_ERROR_CODE)
    public int errorCode;
    @SerializedName("logid")
    public long logid;
    @SerializedName("time")
    public int time;
    @SerializedName("usermsg")
    public String usermsg;

    /* loaded from: classes.dex */
    class BuyInfo implements Serializable {
        private static final long serialVersionUID = -634843997435L;
        @SerializedName("buy_status")
        public int buyStatus;
        @SerializedName("buy_url")
        public String buyUrl;
        @SerializedName("order_id")
        public String orderId;
        @SerializedName("return_url")
        public String returnUrl;

        BuyInfo() {
        }
    }
}
