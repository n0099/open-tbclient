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
    private View axT;
    private e cFW;
    private e.b cFZ;
    private List<as> cGa;
    private TabMenuPopView cGb;
    private TabMenuPopView.a ctq = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.cFW != null) {
                g.this.cFW.alz();
            }
            g.this.cFZ.jQ(asVar.csJ);
        }
    };
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cFW = eVar;
            this.cFZ = eVar.alA();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.axT = this.mContentView.findViewById(d.h.top_line);
            this.cGb = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cGb.setOnItemClickCallBack(this.ctq);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.cGa = list;
            as asVar = new as();
            asVar.csJ = 0;
            asVar.name = this.mContext.getResources().getString(d.l.all);
            asVar.isSelected = false;
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.axT, d.e.cp_bg_line_b);
            this.cGb.a(this.cGa, asVar);
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
            aj.k(this.axT, d.e.cp_bg_line_b);
        }
        if (this.cGb != null) {
            this.cGb.xc();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int alx() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
