package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class ao {
    final AntiData alm;
    final int errorCode;
    private String errorString;

    public ao(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.alm = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean Ao() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public AntiData Ap() {
        return this.alm;
    }
}
