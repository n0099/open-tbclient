package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FacePackageDownloadData implements Serializable {
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
    @SerializedName("pack_url")
    public String packUrl;
    @SerializedName("time")
    public int time;
    @SerializedName("usermsg")
    public String usermsg;
}
