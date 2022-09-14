package com.baidu.tieba;

import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public interface b6 extends i7 {
    u3 b();

    int c();

    @Override // com.baidu.tieba.i7
    void dispose();

    FloatBuffer getBuffer();

    void invalidate();
}
