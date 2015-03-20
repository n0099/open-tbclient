package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public abstract class e<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> extends NetModel<T, D, ActivityType> {
    public e(TbPageContext<ActivityType> tbPageContext, T t) {
        super(tbPageContext, t, NetModel.NetModelType.TYPE_AUTO);
    }
}
