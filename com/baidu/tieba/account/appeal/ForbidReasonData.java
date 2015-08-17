package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidReasonData extends i implements Serializable {
    private static final long serialVersionUID = 3978400869191734600L;
    public a error;
    public String reason = null;

    /* loaded from: classes.dex */
    public static class a extends i {
        public int errno = 0;
        public String errMsg = "";
        public String userMsg = "";
    }

    public ForbidReasonData() {
        this.error = null;
        this.error = new a();
    }
}
