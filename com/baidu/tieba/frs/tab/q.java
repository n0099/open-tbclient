package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View aSU;
    private TabMenuPopView.a bJg = new r(this);
    private j bSN;
    private j.b bSQ;
    private List<dy> bSR;
    private TabMenuPopView bSS;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bSN = jVar;
            this.bSQ = jVar.aar();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(u.h.tab_menu_multline_view, (ViewGroup) null);
            this.aSU = this.mContentView.findViewById(u.g.top_line);
            this.bSS = (TabMenuPopView) this.mContentView.findViewById(u.g.categorycontainer);
            this.bSS.setOnItemClickCallBack(this.bJg);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dy> list) {
        if (list != null) {
            this.bSR = list;
            dy dyVar = new dy();
            dyVar.bIj = 0;
            dyVar.name = this.mContext.getResources().getString(u.j.forum_list_menu_all);
            dyVar.isSelected = false;
            av.l(this.mContentView, u.d.cp_bg_line_d);
            av.l(this.aSU, u.d.cp_bg_line_b);
            this.bSS.a(this.bSR, dyVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vm() {
        if (this.mContentView != null) {
            av.l(this.mContentView, u.d.cp_bg_line_d);
            av.l(this.aSU, u.d.cp_bg_line_b);
        }
        if (this.bSS != null) {
            this.bSS.vm();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int aao() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
