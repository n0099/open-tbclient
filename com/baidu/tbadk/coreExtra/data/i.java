package com.baidu.tbadk.coreExtra.data;

import com.baidu.tieba.tbadkCore.util.f;
/* loaded from: classes.dex */
public class i {
    private String authToken;
    private f.a dmc;
    private int type;

    public static i uh(String str) {
        return new i(0, str);
    }

    public static i aJk() {
        return new i(1, null);
    }

    public static i aJl() {
        return new i(2, null);
    }

    public static i aJm() {
        return new i(3, null);
    }

    public i(int i, String str) {
        this.type = i;
        this.authToken = str;
    }

    public int getType() {
        return this.type;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public f.a aJn() {
        return this.dmc;
    }

    public void a(f.a aVar) {
        this.dmc = aVar;
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
        public String callbackKey;

        public b(boolean z, String str) {
            super(z);
            this.callbackKey = str;
        }
    }
}
