package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
/* loaded from: classes.dex */
public interface j<T extends com.baidu.tbadk.mvc.b.g, D extends com.baidu.tbadk.mvc.b.i> {
    void a(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
}
