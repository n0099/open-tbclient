package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.f;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.d<f, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.enterForum.view.c> implements c {
    private int cXB;

    public b(TbPageContext<?> tbPageContext, Class<com.baidu.tieba.enterForum.view.c> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.cXB = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void az(int i, int i2) {
        List<f> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.d(dataList, i, i2);
        J(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void kf(int i) {
        this.cXB = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void alQ() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void J(List<f> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.J(list);
            } else {
                super.J(list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.cXB) {
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
