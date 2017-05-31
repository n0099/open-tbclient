package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.c.o;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.mvc.f.d<g, com.baidu.tbadk.mvc.d.b, o> implements e {
    private int bLV;

    public d(TbPageContext<?> tbPageContext, Class<o> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bLV = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.e
    public void ad(int i, int i2) {
        List<g> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        x(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.e
    public void hK(int i) {
        this.bLV = i;
    }

    @Override // com.baidu.tieba.enterForum.a.e
    public void VC() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void x(List<g> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.x(list);
            } else {
                super.x(list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bLV) {
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
