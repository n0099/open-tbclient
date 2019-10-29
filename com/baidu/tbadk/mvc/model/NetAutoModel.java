package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public abstract class NetAutoModel<T extends h, D extends j, ActivityType> extends NetModel<T, D, ActivityType> {
    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected abstract Class<? extends MvcProtobufHttpResponsedMessage> awe();

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected abstract Class<? extends MvcSocketResponsedMessage> awf();

    public NetAutoModel(TbPageContext<ActivityType> tbPageContext, T t) {
        super(tbPageContext, t, NetModel.NetModelType.TYPE_AUTO);
    }
}
