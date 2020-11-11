package com.baidu.tbadk.imageManager;

import android.content.Context;
/* loaded from: classes.dex */
public interface a {
    int DD(String str);

    int DE(String str);

    String DF(String str);

    C0593a av(Context context, String str);

    int bzP();

    /* renamed from: com.baidu.tbadk.imageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0593a {
        private int mHeight;
        private int mWidth;

        public C0593a(int i, int i2) {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public int getWidth() {
            return this.mWidth;
        }
    }
}
