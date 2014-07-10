package com.baidu.tieba.account.forbid;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidResultData implements Serializable {
    private static final long serialVersionUID = 2253122288401584111L;
    @SerializedName("error_code")
    public int errNo = 0;
    @SerializedName("error_msg")
    public String errMsg = "";
}
