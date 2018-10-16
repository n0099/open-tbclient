package com.baidu.tbadk.pay;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class PayInfoResultData extends OrmObject implements Serializable {
    private static final long serialVersionUID = -3890790632004634138L;
    private String errmsg;
    private int errno;
    private int pay_status;
    private String usermsg;

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public String getUsermsg() {
        return this.usermsg;
    }

    public void setUsermsg(String str) {
        this.usermsg = str;
    }

    public int getPay_status() {
        return this.pay_status;
    }

    public void setPay_status(int i) {
        this.pay_status = i;
    }
}
