package com.baidu.tieba;

import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public interface c6 extends j7 {
    v3 b();

    int c();

    @Override // com.baidu.tieba.j7
    void dispose();

    FloatBuffer getBuffer();

    void invalidate();
}
