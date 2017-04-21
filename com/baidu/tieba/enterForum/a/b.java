package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.f.d<u, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.enterForum.c.u> implements d {
    private int bFU;

    public b(TbPageContext<?> tbPageContext, Class<com.baidu.tieba.enterForum.c.u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bFU = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void ac(int i, int i2) {
        List<u> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        w(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void hp(int i) {
        this.bFU = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void Vg() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bFU) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
