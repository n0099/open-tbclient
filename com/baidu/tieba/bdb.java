package com.baidu.tieba;

import java.io.IOException;
/* loaded from: classes5.dex */
public interface bdb {
    void close() throws IOException;

    int write(byte[] bArr, int i, int i2) throws IOException;
}
