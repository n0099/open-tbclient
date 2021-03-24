package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ReadCacheRespMsg<T> extends CustomResponsedMessage<T> {
    public ReadCacheRespMsg(int i) {
        super(i);
    }

    public ReadCacheRespMsg(int i, T t) {
        super(i, t);
    }
}
