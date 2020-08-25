package com.baidu.tbadk.mvc.f;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
/* loaded from: classes2.dex */
public abstract class a<D, S extends com.baidu.tbadk.mvc.d.b> extends e<D, S> {
    protected int position;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
    }

    public int getPosition() {
        return this.position;
    }
}
