package com.baidu.tieba.a.a;

import android.util.Log;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tieba.a.a.a {
    public abstract double e(float f, float f2, float f3, int i);

    /* loaded from: classes.dex */
    public static class a extends b {
        @Override // com.baidu.tieba.a.a.b
        public double e(float f, float f2, float f3, int i) {
            return com.baidu.tieba.a.c.a.b(i, 30.0f, 5.0f, 20.0f);
        }

        @Override // com.baidu.tieba.a.a.a
        public boolean b(float f, float f2, float f3, int i) {
            return i >= 61;
        }

        @Override // com.baidu.tieba.a.a.a
        public void d(float f, float f2, float f3, int i) {
            Log.e("action:", "finished");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        @Override // com.baidu.tieba.a.a.b
        public double e(float f, float f2, float f3, int i) {
            return 5.0d;
        }

        @Override // com.baidu.tieba.a.a.a
        public boolean b(float f, float f2, float f3, int i) {
            return false;
        }

        @Override // com.baidu.tieba.a.a.a
        public void d(float f, float f2, float f3, int i) {
        }
    }

    /* renamed from: com.baidu.tieba.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0049b extends b {
        @Override // com.baidu.tieba.a.a.b
        public double e(float f, float f2, float f3, int i) {
            return com.baidu.tieba.a.c.b.a(i, 20.0d);
        }

        @Override // com.baidu.tieba.a.a.a
        public boolean b(float f, float f2, float f3, int i) {
            return i > 17;
        }

        @Override // com.baidu.tieba.a.a.a
        public void d(float f, float f2, float f3, int i) {
        }
    }
}
