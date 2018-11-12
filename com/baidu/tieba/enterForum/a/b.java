package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.f;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tbadk.mvc.f.d<f, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.enterForum.view.c> implements c {
    private int dgX;

    public b(TbPageContext<?> tbPageContext, Class<com.baidu.tieba.enterForum.view.c> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.dgX = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void aE(int i, int i2) {
        List<f> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.d(dataList, i, i2);
        R(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void kV(int i) {
        this.dgX = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void notifyDataChanged() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void R(List<f> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.R(list);
            } else {
                super.R(list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.dgX) {
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
