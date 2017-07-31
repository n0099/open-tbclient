package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.f.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.c.e;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d<g, com.baidu.tbadk.mvc.d.b, e> implements c {
    private int bXP;

    public b(TbPageContext<?> tbPageContext, Class<e> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.bXP = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void aj(int i, int i2) {
        List<g> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        D(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void ia(int i) {
        this.bXP = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void XG() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void D(List<g> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.D((List) list);
            } else {
                super.D((List) list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.bXP) {
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
