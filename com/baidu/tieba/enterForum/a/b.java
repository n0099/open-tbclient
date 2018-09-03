package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.f;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.d<f, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.enterForum.view.c> implements c {
    private int cRK;

    public b(TbPageContext<?> tbPageContext, Class<com.baidu.tieba.enterForum.view.c> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.cRK = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void av(int i, int i2) {
        List<f> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.c(dataList, i, i2);
        I(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void jG(int i) {
        this.cRK = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void akf() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void I(List<f> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.I(list);
            } else {
                super.I(list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.cRK) {
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
