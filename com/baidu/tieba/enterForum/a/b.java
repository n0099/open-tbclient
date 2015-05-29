package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.j.d;
import com.baidu.tieba.enterForum.d.t;
import com.baidu.tieba.tbadkCore.ae;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d<ae, com.baidu.tbadk.mvc.e.c, t> implements c {
    private int aEt;

    public b(TbPageContext<?> tbPageContext, Class<t> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.aEt = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void H(int i, int i2) {
        List<ae> CM = CM();
        com.baidu.tieba.enterForum.c.b.HY().a(CM, i, i2);
        s(CM);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void eC(int i) {
        this.aEt = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void Hv() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.j.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.aEt) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
