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
    protected abstract Class<? extends MvcProtobufHttpResponsedMessage> TE();

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected abstract Class<? extends MvcSocketResponsedMessage> TG();

    public NetAutoModel(TbPageContext<ActivityType> tbPageContext, T t) {
        super(tbPageContext, t, NetModel.NetModelType.TYPE_AUTO);
    }
}
