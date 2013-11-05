package com.baidu.tieba.im.codec;

import com.baidu.tieba.im.message.Message;
import java.util.List;
/* loaded from: classes.dex */
public interface b<T> {
    List<Message> a(byte[] bArr, boolean z, int i, int i2);

    void a(int i, n<T> nVar);

    byte[] a(NetworkMessage networkMessage);
}
