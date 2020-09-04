package com.baidu.tbadk.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Error extends OrmObject implements Serializable {
    private static final long serialVersionUID = 8237735171200223481L;
    private int mCode;
    private String mMessage;

    public Error() {
    }

    public Error(int i) {
        this.mCode = i;
    }

    public Error(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }
}
