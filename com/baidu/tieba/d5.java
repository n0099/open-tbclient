package com.baidu.tieba;

import java.nio.ShortBuffer;
/* loaded from: classes4.dex */
public interface d5 extends r6 {
    @Override // com.baidu.tieba.r6
    void dispose();

    int e();

    ShortBuffer getBuffer();

    void invalidate();
}
