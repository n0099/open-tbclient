package com.baidu.tbadk.pay;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class PayInfoResultData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -3890790632004634138L;
    public String errmsg;
    public int errno;
    public int pay_status;
    public long time;
    public String usermsg;

    public long getCreateTime() {
        return this.time;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public int getErrno() {
        return this.errno;
    }

    public int getPay_status() {
        return this.pay_status;
    }

    public String getUsermsg() {
        return this.usermsg;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public void setErrno(int i2) {
        this.errno = i2;
    }

    public void setPay_status(int i2) {
        this.pay_status = i2;
    }

    public void setUsermsg(String str) {
        this.usermsg = str;
    }
}
