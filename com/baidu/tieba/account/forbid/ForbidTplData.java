package com.baidu.tieba.account.forbid;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidTplData implements Serializable {
    private static final long serialVersionUID = -2159666579341742989L;
    @SerializedName("error")
    public k error;
    @SerializedName("reason")
    public String[] reason = new String[0];
    @SerializedName("type")
    public int type = 0;

    public ForbidTplData() {
        this.error = null;
        this.error = new k();
    }
}
