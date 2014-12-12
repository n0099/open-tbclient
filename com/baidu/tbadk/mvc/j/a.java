package com.baidu.tbadk.mvc.j;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
/* loaded from: classes.dex */
public abstract class a<D, S extends com.baidu.tbadk.mvc.e.c> extends d<D, S> {
    protected int position;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
    }

    public int getPosition() {
        return this.position;
    }
}
