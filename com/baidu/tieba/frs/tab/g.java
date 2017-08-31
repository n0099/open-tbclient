package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class g implements a {
    private View axW;
    private e cFe;
    private e.b cFh;
    private List<as> cFi;
    private TabMenuPopView cFj;
    private TabMenuPopView.a csy = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.cFe != null) {
                g.this.cFe.alo();
            }
            g.this.cFh.jO(asVar.crR);
        }
    };
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cFe = eVar;
            this.cFh = eVar.alp();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.axW = this.mContentView.findViewById(d.h.top_line);
            this.cFj = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cFj.setOnItemClickCallBack(this.csy);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.cFi = list;
            as asVar = new as();
            asVar.crR = 0;
            asVar.name = this.mContext.getResources().getString(d.l.all);
            asVar.isSelected = false;
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.axW, d.e.cp_bg_line_b);
            this.cFj.a(this.cFi, asVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void xc() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.axW, d.e.cp_bg_line_b);
        }
        if (this.cFj != null) {
            this.cFj.xc();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int alm() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
