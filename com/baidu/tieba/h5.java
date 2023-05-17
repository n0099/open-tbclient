package com.baidu.tieba;

import java.nio.ShortBuffer;
/* loaded from: classes5.dex */
public interface h5 extends v6 {
    @Override // com.baidu.tieba.v6
    void dispose();

    int e();

    ShortBuffer getBuffer();

    void invalidate();
}
