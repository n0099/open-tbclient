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
    private View axo;
    private TabMenuPopView.a cBc = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.cPQ != null) {
                g.this.cPQ.aoj();
            }
            g.this.cPT.kt(atVar.cAw);
        }
    };
    private e cPQ;
    private e.b cPT;
    private List<at> cPU;
    private TabMenuPopView cPV;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cPQ = eVar;
            this.cPT = eVar.aok();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.h.tab_menu_multline_view, (ViewGroup) null);
            this.axo = this.mContentView.findViewById(d.g.top_line);
            this.cPV = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.cPV.setOnItemClickCallBack(this.cBc);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.cPU = list;
            at atVar = new at();
            atVar.cAw = 0;
            atVar.name = this.mContext.getResources().getString(d.j.all);
            atVar.isSelected = false;
            aj.k(this.mContentView, d.C0080d.cp_bg_line_d);
            aj.k(this.axo, d.C0080d.cp_bg_line_b);
            this.cPV.a(this.cPU, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wB() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.C0080d.cp_bg_line_d);
            aj.k(this.axo, d.C0080d.cp_bg_line_b);
        }
        if (this.cPV != null) {
            this.cPV.wB();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aoh() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
