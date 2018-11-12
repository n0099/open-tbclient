package com.baidu.tbadk.coreExtra.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AuthVerifyData implements Serializable {
    public static final int TYPE_AUTH_WIDGET = 0;
    public static final int TYPE_BIND_MOBILE = 2;
    public static final int TYPE_DOUBLE_CHECK = 4;
    public static final int TYPE_FACE_ID = 3;
    public static final int TYPE_MODIFY_PWD = 1;
    private String authToken;
    private String from;
    private c result;
    private int type;

    public static AuthVerifyData createDataForAuthWidget(String str, String str2) {
        return new AuthVerifyData(0, str, str2);
    }

    public static AuthVerifyData createDataForModifyPwd(String str) {
        return new AuthVerifyData(1, null, str);
    }

    public static AuthVerifyData createDataForBindMobile(String str) {
        return new AuthVerifyData(2, null, str);
    }

    public static AuthVerifyData createDataForFaceId(String str) {
        return new AuthVerifyData(3, null, str);
    }

    public AuthVerifyData(int i, String str, String str2) {
        this.type = i;
        this.authToken = str;
        this.from = str2;
    }

    public int getType() {
        return this.type;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public c getResult() {
        return this.result;
    }

    public void setResult(c cVar) {
        this.result = cVar;
    }

    /* loaded from: classes.dex */
    public static class c {
        public boolean isSuccess;

        public c(boolean z) {
            this.isSuccess = z;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends c {
        public String authSid;

        public a(boolean z, String str) {
            super(z);
            this.authSid = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c {
        public String aKi;

        public b(boolean z, String str) {
            super(z);
            this.aKi = str;
        }
    }
}
