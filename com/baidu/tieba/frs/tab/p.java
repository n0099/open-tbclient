package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class p implements f {
    private TabMenuPopView.a aZT = new q(this);
    private i bcd;
    private i.a bcg;
    private List<ek> bch;
    private TabMenuPopView bci;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bcd = iVar;
            this.bcg = iVar.NE();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(i.g.tab_menu_multline_view, (ViewGroup) null);
            this.bci = (TabMenuPopView) this.mContentView.findViewById(i.f.categorycontainer);
            this.bci.setOnItemClickCallBack(this.aZT);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ek> list) {
        if (list != null) {
            this.bch = list;
            ek ekVar = new ek();
            ekVar.aYG = 0;
            ekVar.name = this.mContext.getResources().getString(i.h.forum_list_menu_all);
            ekVar.isSelected = false;
            an.j(this.mContentView, i.c.cp_bg_line_d);
            this.bci.a(this.bch, ekVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vB() {
        if (this.mContentView != null) {
            an.j(this.mContentView, i.c.cp_bg_line_d);
        }
        if (this.bci != null) {
            this.bci.vB();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int NC() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
