package com.baidu.tbadk.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class Error extends OrmObject implements Serializable {
    public static final long serialVersionUID = 8237735171200223481L;
    public int mCode;
    public String mMessage;

    public Error() {
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public Error(int i) {
        this.mCode = i;
    }

    public Error(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }
}
