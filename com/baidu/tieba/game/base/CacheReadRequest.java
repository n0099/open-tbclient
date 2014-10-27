package com.baidu.tieba.game.base;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class CacheReadRequest extends CustomMessage<String> {
    public CacheReadRequest(String str) {
        super(2001239, str);
    }
}
