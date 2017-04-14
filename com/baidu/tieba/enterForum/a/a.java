package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.c.m;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.d<u, com.baidu.tbadk.mvc.d.b, m> implements d {
    private int bDD;

    public a(TbPageContext<?> tbPageContext, Class<m> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bDD = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void ac(int i, int i2) {
        List<u> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        w(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void hj(int i) {
        this.bDD = i;
    }

    @Override // com.baidu.tieba.enterForum.a.d
    public void Uf() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bDD) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(0);
            }
            if (i < getCount() && getItem(i) == null) {
                view2.setVisibility(4);
            }
        }
        return view2;
    }
}
