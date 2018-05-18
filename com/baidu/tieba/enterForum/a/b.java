package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.f;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.d<f, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.enterForum.view.c> implements c {
    private int cIc;

    public b(TbPageContext<?> tbPageContext, Class<com.baidu.tieba.enterForum.view.c> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.cIc = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void ar(int i, int i2) {
        List<f> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        F(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void ju(int i) {
        this.cIc = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void agD() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void F(List<f> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.F(list);
            } else {
                super.F(list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View view3 = super.getView(i, view2, viewGroup);
        if (view3 != null) {
            if (i == this.cIc) {
                view3.setVisibility(4);
            } else {
                view3.setVisibility(0);
            }
            if (i < getCount() && getItem(i) == null) {
                view3.setVisibility(4);
            }
        }
        return view3;
    }
}
