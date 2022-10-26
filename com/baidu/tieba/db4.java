package com.baidu.tieba;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
/* loaded from: classes3.dex */
public interface db4 extends fb4 {
    void a(Object obj);

    void c(Object obj);

    String d(Object obj);

    void e(Object obj, gc4 gc4Var);

    void f(Object obj);

    gc4 h(Object obj, File file, long j, ReadableByteChannel readableByteChannel) throws IOException;

    void i(Object obj);

    void j(Object obj);

    Map k();
}
