package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FacePurchaseRecordsData implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("ctime")
    public int ctime;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName("error_code")
    public int errorCode;
    @SerializedName("logid")
    public long logid;
    @SerializedName("buy_his")
    public ArrayList<FacePurchasePackageData> packList;
    @SerializedName("time")
    public int time;
    @SerializedName("usermsg")
    public String usermsg;
}
