package com.baidu.tieba;

import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public interface a6 extends h7 {
    t3 b();

    int c();

    @Override // com.baidu.tieba.h7
    void dispose();

    FloatBuffer getBuffer();

    void invalidate();
}
