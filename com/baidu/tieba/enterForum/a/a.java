package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.g.d;
import com.baidu.tieba.enterForum.d.m;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes.dex */
public class a extends d<w, com.baidu.tbadk.mvc.d.b, m> implements c {
    private int aTI;

    public a(TbPageContext<?> tbPageContext, Class<m> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.aTI = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void S(int i, int i2) {
        List<w> DS = DS();
        com.baidu.tieba.enterForum.c.b.Kt().a(DS, i, i2);
        s(DS);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void fm(int i) {
        this.aTI = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void JP() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.aTI) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
