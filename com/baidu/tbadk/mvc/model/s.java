package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* loaded from: classes.dex */
public interface s<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k> {
    void a(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
}
