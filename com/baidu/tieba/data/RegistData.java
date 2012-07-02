package com.baidu.tieba.data;

import com.baidu.tieba.util.StringHelper;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return this.psw;
    }

    public void setPsw(String psw) {
        if (psw != null) {
            psw = StringHelper.base64Encode(psw.getBytes());
        }
        this.psw = psw;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getVcode() {
        return this.vcode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getActivationCode() {
        return this.activationCode;
    }

    public void setVcodeMd5(String vcodeMd5) {
        this.vcodeMd5 = vcodeMd5;
    }

    public String getVcodeMd5() {
        return this.vcodeMd5;
    }

    public void setSmsCodeTime(int smsCodeTime) {
        this.smsCodeTime = smsCodeTime;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
