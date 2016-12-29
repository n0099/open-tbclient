package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View aqR;
    private TabMenuPopView.a bCA = new r(this);
    private j bNC;
    private j.b bNF;
    private List<cx> bNG;
    private TabMenuPopView bNH;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bNC = jVar;
            this.bNF = jVar.abv();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(r.h.tab_menu_multline_view, (ViewGroup) null);
            this.aqR = this.mContentView.findViewById(r.g.top_line);
            this.bNH = (TabMenuPopView) this.mContentView.findViewById(r.g.categorycontainer);
            this.bNH.setOnItemClickCallBack(this.bCA);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cx> list) {
        if (list != null) {
            this.bNG = list;
            cx cxVar = new cx();
            cxVar.bBw = 0;
            cxVar.name = this.mContext.getResources().getString(r.j.forum_list_menu_all);
            cxVar.isSelected = false;
            ar.l(this.mContentView, r.d.cp_bg_line_d);
            ar.l(this.aqR, r.d.cp_bg_line_b);
            this.bNH.a(this.bNG, cxVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wx() {
        if (this.mContentView != null) {
            ar.l(this.mContentView, r.d.cp_bg_line_d);
            ar.l(this.aqR, r.d.cp_bg_line_b);
        }
        if (this.bNH != null) {
            this.bNH.wx();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int abs() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
