package com.baidu.tbadk.imageManager;

import android.content.Context;
/* loaded from: classes.dex */
public interface a {
    int BA();

    C0051a F(Context context, String str);

    int fe(String str);

    int ff(String str);

    String fg(String str);

    /* renamed from: com.baidu.tbadk.imageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0051a {
        private int mHeight;
        private int mWidth;

        public C0051a(int i, int i2) {
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
