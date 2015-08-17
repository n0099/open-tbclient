package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.g.d;
import com.baidu.tieba.enterForum.d.t;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d<u, com.baidu.tbadk.mvc.d.b, t> implements c {
    private int aLT;

    public b(TbPageContext<?> tbPageContext, Class<t> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.aLT = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void R(int i, int i2) {
        List<u> Dp = Dp();
        com.baidu.tieba.enterForum.c.b.IM().a(Dp, i, i2);
        r(Dp);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void eI(int i) {
        this.aLT = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Il() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.aLT) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
