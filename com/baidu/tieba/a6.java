package com.baidu.tieba;

import java.nio.ShortBuffer;
/* loaded from: classes3.dex */
public interface a6 extends o7 {
    @Override // com.baidu.tieba.o7
    void dispose();

    int e();

    ShortBuffer getBuffer();

    void invalidate();
}
