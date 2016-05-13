package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.g.d;
import com.baidu.tieba.enterForum.e.m;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes.dex */
public class a extends d<w, com.baidu.tbadk.mvc.d.b, m> implements c {
    private int aWA;

    public a(TbPageContext<?> tbPageContext, Class<m> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.aWA = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Q(int i, int i2) {
        List<w> DS = DS();
        com.baidu.tieba.enterForum.c.b.MN().b(DS, i, i2);
        z((List) DS);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void fH(int i) {
        this.aWA = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Mc() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.aWA) {
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
