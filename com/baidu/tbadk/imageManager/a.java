package com.baidu.tbadk.imageManager;

import android.content.Context;
/* loaded from: classes2.dex */
public interface a {
    int BN(String str);

    int BO(String str);

    String BP(String str);

    C0554a ao(Context context, String str);

    int brK();

    /* renamed from: com.baidu.tbadk.imageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0554a {
        private int mHeight;
        private int mWidth;

        public C0554a(int i, int i2) {
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
