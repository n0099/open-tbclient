package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.view.m;
import com.baidu.tieba.tbadkCore.x;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.d<x, com.baidu.tbadk.mvc.d.b, m> implements d {
    private int buw;

    public a(TbPageContext<?> tbPageContext, Class<m> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.buw = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void V(int i, int i2) {
        List<x> Ea = Ea();
        com.baidu.tieba.enterForum.c.b.SX().c(Ea, i, i2);
        A(Ea);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void gH(int i) {
        this.buw = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void Sl() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.buw) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
            if (i < getCount() && getItem(i) == null) {
                view2.setVisibility(4);
            }
        }
        return view2;
    }
}
