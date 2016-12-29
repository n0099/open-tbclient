package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.d.u;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.f.d<v, com.baidu.tbadk.mvc.d.b, u> implements d {
    private int boR;

    public b(TbPageContext<?> tbPageContext, Class<u> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.boR = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void X(int i, int i2) {
        List<v> dataList = getDataList();
        com.baidu.tieba.enterForum.c.b.c(dataList, i, i2);
        A(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void gy(int i) {
        this.boR = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void SD() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.boR) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
        }
        return view2;
    }
}
