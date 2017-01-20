package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForbidReasonData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 3978400869191734600L;
    public ErrorInfo error;
    public String reason = null;

    /* loaded from: classes.dex */
    public static class ErrorInfo extends OrmObject {
        public int errno = 0;
        public String errMsg = "";
        public String userMsg = "";
    }

    public ForbidReasonData() {
        this.error = null;
        this.error = new ErrorInfo();
    }
}
