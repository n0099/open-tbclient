package com.baidu.tieba.faceshop;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FacePackageDetailData implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("ctime")
    public int ctime;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName(SocialConstants.PARAM_ERROR_CODE)
    public int errorCode;
    @SerializedName("faces_list")
    public FacePackageData facePackage;
    @SerializedName("logid")
    public long logid;
    @SerializedName("time")
    public int time;
    @SerializedName("usermsg")
    public String usermsg;
}
