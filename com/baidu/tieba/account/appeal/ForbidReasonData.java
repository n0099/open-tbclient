package com.baidu.tieba.account.appeal;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidReasonData implements Serializable {
    private static final long serialVersionUID = 3978400869191734600L;
    @SerializedName("error")
    public i error;
    @SerializedName("reason")
    public String reason = null;

    public ForbidReasonData() {
        this.error = null;
        this.error = new i();
    }
}
