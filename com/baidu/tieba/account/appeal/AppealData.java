package com.baidu.tieba.account.appeal;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AppealData implements Serializable {
    private static final long serialVersionUID = 8636034753470244254L;
    @SerializedName(SocialConstants.PARAM_ERROR_CODE)
    public int errNo = 0;
    @SerializedName("error_msg")
    public String errMsg = "";
    @SerializedName("task_id")
    public int task_id = 0;
}
