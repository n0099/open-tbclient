package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.d<w, com.baidu.tbadk.mvc.d.b, u> implements d {
    private int bIO;

    public b(TbPageContext<?> tbPageContext, Class<u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bIO = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void ac(int i, int i2) {
        List<w> Fy = Fy();
        com.baidu.tieba.enterForum.c.b.d(Fy, i, i2);
        A(Fy);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void ho(int i) {
        this.bIO = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void Ys() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.g.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bIO) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
