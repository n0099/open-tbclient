package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.f.d<u, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.enterForum.c.u> implements d {
    private int bwE;

    public b(TbPageContext<?> tbPageContext, Class<com.baidu.tieba.enterForum.c.u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bwE = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void W(int i, int i2) {
        List<u> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        y(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void hk(int i) {
        this.bwE = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void SH() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bwE) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
