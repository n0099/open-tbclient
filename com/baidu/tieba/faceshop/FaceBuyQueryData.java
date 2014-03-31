package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FaceBuyQueryData implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("buy_result")
    public BuyResult buyResult;
    @SerializedName("ctime")
    public int ctime;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName("error_code")
    public int errorCode;
    @SerializedName("error_msg")
    public String errorMsg;
    @SerializedName("logid")
    public long logid;
    @SerializedName("time")
    public int time;
    @SerializedName("usermsg")
    public String usermsg;

    /* loaded from: classes.dex */
    class BuyResult implements Serializable {
        private static final long serialVersionUID = -34451984893L;
        @SerializedName("pack_url")
        public String packUrl;
        @SerializedName("status")
        public int status;

        BuyResult() {
        }
    }
}
