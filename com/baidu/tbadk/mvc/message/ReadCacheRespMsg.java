package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ReadCacheRespMsg<T> extends CustomResponsedMessage<T> {
    public ReadCacheRespMsg(int i2) {
        super(i2);
    }

    public ReadCacheRespMsg(int i2, T t) {
        super(i2, t);
    }
}
