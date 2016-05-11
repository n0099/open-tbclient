package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.g.d;
import com.baidu.tieba.enterForum.e.u;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d<w, com.baidu.tbadk.mvc.d.b, u> implements c {
    private int aWA;

    public b(TbPageContext<?> tbPageContext, Class<u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.aWA = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Q(int i, int i2) {
        List<w> DR = DR();
        com.baidu.tieba.enterForum.c.b.ML().b(DR, i, i2);
        z((List) DR);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void fI(int i) {
        this.aWA = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Ma() {
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
        }
        return view2;
    }
}
