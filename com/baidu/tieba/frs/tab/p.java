package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class p implements f {
    private TabMenuPopView.a bjO = new q(this);
    private i.a bmC;
    private List<fc> bmD;
    private TabMenuPopView bmE;
    private i bmz;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bmz = iVar;
            this.bmC = iVar.PC();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(n.h.tab_menu_multline_view, (ViewGroup) null);
            this.bmE = (TabMenuPopView) this.mContentView.findViewById(n.g.categorycontainer);
            this.bmE.setOnItemClickCallBack(this.bjO);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fc> list) {
        if (list != null) {
            this.bmD = list;
            fc fcVar = new fc();
            fcVar.biz = 0;
            fcVar.name = this.mContext.getResources().getString(n.j.forum_list_menu_all);
            fcVar.isSelected = false;
            as.j(this.mContentView, n.d.cp_bg_line_d);
            this.bmE.a(this.bmD, fcVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vR() {
        if (this.mContentView != null) {
            as.j(this.mContentView, n.d.cp_bg_line_d);
        }
        if (this.bmE != null) {
            this.bmE.vR();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int PA() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
