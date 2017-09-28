package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class g implements a {
    private View axd;
    private e cGP;
    private e.b cGS;
    private List<at> cGT;
    private TabMenuPopView cGU;
    private TabMenuPopView.a ctV = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.cGP != null) {
                g.this.cGP.alD();
            }
            g.this.cGS.jY(atVar.ctl);
        }
    };
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cGP = eVar;
            this.cGS = eVar.alE();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.axd = this.mContentView.findViewById(d.h.top_line);
            this.cGU = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cGU.setOnItemClickCallBack(this.ctV);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.cGT = list;
            at atVar = new at();
            atVar.ctl = 0;
            atVar.name = this.mContext.getResources().getString(d.l.all);
            atVar.isSelected = false;
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.axd, d.e.cp_bg_line_b);
            this.cGU.a(this.cGT, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wB() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.axd, d.e.cp_bg_line_b);
        }
        if (this.cGU != null) {
            this.cGU.wB();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int alB() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
