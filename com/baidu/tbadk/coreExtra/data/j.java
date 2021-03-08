package com.baidu.tbadk.coreExtra.data;

import com.baidu.tieba.tbadkCore.util.f;
/* loaded from: classes.dex */
public class j {
    private String authToken;
    private f.a fsd;
    private int type;

    public static j BZ(String str) {
        return new j(0, str);
    }

    public static j bwl() {
        return new j(1, null);
    }

    public static j bwm() {
        return new j(2, null);
    }

    public static j bwn() {
        return new j(3, null);
    }

    public j(int i, String str) {
        this.type = i;
        this.authToken = str;
    }

    public int getType() {
        return this.type;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public f.a bwo() {
        return this.fsd;
    }

    public void a(f.a aVar) {
        this.fsd = aVar;
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
