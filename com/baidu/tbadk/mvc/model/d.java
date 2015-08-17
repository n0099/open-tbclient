package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public abstract class d<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends NetModel<T, D, ActivityType> {
    public d(TbPageContext<ActivityType> tbPageContext, T t) {
        super(tbPageContext, t, NetModel.NetModelType.TYPE_AUTO);
    }
}
