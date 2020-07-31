package com.baidu.tbadk.imageManager;

import android.content.Context;
/* loaded from: classes.dex */
public interface a {
    C0508a ak(Context context, String str);

    int biY();

    int zx(String str);

    int zy(String str);

    String zz(String str);

    /* renamed from: com.baidu.tbadk.imageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0508a {
        private int mHeight;
        private int mWidth;

        public C0508a(int i, int i2) {
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
