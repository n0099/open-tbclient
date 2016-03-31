package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.g.d;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d<v, com.baidu.tbadk.mvc.d.b, u> implements c {
    private int bax;

    public b(TbPageContext<?> tbPageContext, Class<u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bax = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void P(int i, int i2) {
        List<v> FZ = FZ();
        com.baidu.tieba.enterForum.c.b.NY().b(FZ, i, i2);
        x(FZ);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void gb(int i) {
        this.bax = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Nr() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bax) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
