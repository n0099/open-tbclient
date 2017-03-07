package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View avr;
    private TabMenuPopView.a bQW = new r(this);
    private j cbc;
    private j.b cbf;
    private List<ct> cbg;
    private TabMenuPopView cbh;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cbc = jVar;
            this.cbf = jVar.adA();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(w.j.tab_menu_multline_view, (ViewGroup) null);
            this.avr = this.mContentView.findViewById(w.h.top_line);
            this.cbh = (TabMenuPopView) this.mContentView.findViewById(w.h.categorycontainer);
            this.cbh.setOnItemClickCallBack(this.bQW);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ct> list) {
        if (list != null) {
            this.cbg = list;
            ct ctVar = new ct();
            ctVar.bPZ = 0;
            ctVar.name = this.mContext.getResources().getString(w.l.forum_list_menu_all);
            ctVar.isSelected = false;
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avr, w.e.cp_bg_line_b);
            this.cbh.a(this.cbg, ctVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wP() {
        if (this.mContentView != null) {
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avr, w.e.cp_bg_line_b);
        }
        if (this.cbh != null) {
            this.cbh.wP();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int adx() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
