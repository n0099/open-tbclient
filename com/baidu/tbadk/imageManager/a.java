package com.baidu.tbadk.imageManager;

import android.content.Context;
/* loaded from: classes.dex */
public interface a {
    int AQ();

    C0049a F(Context context, String str);

    int eM(String str);

    int eN(String str);

    String eO(String str);

    /* renamed from: com.baidu.tbadk.imageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0049a {
        private int mHeight;
        private int mWidth;

        public C0049a(int i, int i2) {
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
