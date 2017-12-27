package com.baidu.tieba.enterForum.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.f.d;
import com.baidu.tieba.enterForum.b.e;
import com.baidu.tieba.enterForum.data.f;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends d<f, com.baidu.tbadk.mvc.d.b, e> implements c {
    private int dhm;

    public b(TbPageContext<?> tbPageContext, Class<e> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cls, i, viewEventCenter);
        this.dhm = -1;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void br(int i, int i2) {
        List<f> dataList = getDataList();
        com.baidu.tieba.enterForum.model.b.d(dataList, i, i2);
        N(dataList);
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void mk(int i) {
        this.dhm = i;
    }

    @Override // com.baidu.tieba.enterForum.a.c
    public void akL() {
        notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.mvc.f.c
    public void N(List<f> list) {
        if (list != null) {
            if (list.size() >= 1 && list.get(0) != null && list.get(0).getType() == 1) {
                super.N(list);
            } else {
                super.N(list);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 != null) {
            if (i == this.dhm) {
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
