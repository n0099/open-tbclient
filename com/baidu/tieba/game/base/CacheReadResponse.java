package com.baidu.tieba.game.base;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class CacheReadResponse extends CustomResponsedMessage<byte[]> {
    public CacheReadResponse(byte[] bArr) {
        super(2001239, bArr);
    }
}
