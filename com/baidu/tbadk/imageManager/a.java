package com.baidu.tbadk.imageManager;

import android.content.Context;
/* loaded from: classes.dex */
public interface a {
    int DH(String str);

    int DI(String str);

    String DJ(String str);

    C0596a aD(Context context, String str);

    int bFa();

    /* renamed from: com.baidu.tbadk.imageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0596a {
        private int mHeight;
        private int mWidth;

        public C0596a(int i, int i2) {
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
