package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.g.d;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes.dex */
public class a extends d<v, com.baidu.tbadk.mvc.d.b, m> implements c {
    private int aLq;

    public a(TbPageContext<?> tbPageContext, Class<m> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.aLq = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void R(int i, int i2) {
        List<v> Dc = Dc();
        com.baidu.tieba.enterForum.c.b.II().a(Dc, i, i2);
        s(Dc);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void fc(int i) {
        this.aLq = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void If() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.aLq) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
