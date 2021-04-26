package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.NetModel;
import d.a.i0.g0.b.g;
import d.a.i0.g0.b.h;
/* loaded from: classes3.dex */
public abstract class NetAutoModel<T extends g, D extends h, ActivityType> extends NetModel<T, D, ActivityType> {
    public NetAutoModel(TbPageContext<ActivityType> tbPageContext, T t) {
        super(tbPageContext, t, NetModel.NetModelType.TYPE_AUTO);
    }
}
