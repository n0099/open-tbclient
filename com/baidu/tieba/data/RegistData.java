package com.baidu.tieba.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RegistData implements Serializable {
    private static final long serialVersionUID = 3826031631760706500L;
    private String activationCode;
    private String name;
    private String phone;
    private String psw;
    private int smsCodeTime;
    private String vcode;
    private String vcodeMd5;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPsw() {
        return this.psw;
    }

    public void setPsw(String str) {
        if (str != null) {
            str = com.baidu.tieba.util.bb.b(str.getBytes());
        }
        this.psw = str;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setVcode(String str) {
        this.vcode = str;
    }

    public String getVcode() {
        return this.vcode;
    }

    public void setActivationCode(String str) {
        this.activationCode = str;
    }

    public String getActivationCode() {
        return this.activationCode;
    }

    public void setVcodeMd5(String str) {
        this.vcodeMd5 = str;
    }

    public String getVcodeMd5() {
        return this.vcodeMd5;
    }

    public void setSmsCodeTime(int i) {
        this.smsCodeTime = i;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
