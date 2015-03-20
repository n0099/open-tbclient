package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
/* loaded from: classes.dex */
public interface r<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k> {
    void a(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
}
