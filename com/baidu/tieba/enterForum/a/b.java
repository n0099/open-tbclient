package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.view.u;
import com.baidu.tieba.tbadkCore.x;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.d<x, com.baidu.tbadk.mvc.d.b, u> implements d {
    private int bsh;

    public b(TbPageContext<?> tbPageContext, Class<u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bsh = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void U(int i, int i2) {
        List<x> Eb = Eb();
        com.baidu.tieba.enterForum.c.b.Sp().c(Eb, i, i2);
        A((List) Eb);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void gH(int i) {
        this.bsh = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void RE() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bsh) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
