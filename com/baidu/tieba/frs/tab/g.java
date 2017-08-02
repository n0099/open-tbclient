package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class g implements a {
    private View axs;
    private TabMenuPopView.a clj = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.cvi != null) {
                g.this.cvi.aiR();
            }
            g.this.cvl.jq(asVar.ckC);
        }
    };
    private e cvi;
    private e.b cvl;
    private List<as> cvm;
    private TabMenuPopView cvn;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cvi = eVar;
            this.cvl = eVar.aiS();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.axs = this.mContentView.findViewById(d.h.top_line);
            this.cvn = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cvn.setOnItemClickCallBack(this.clj);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.cvm = list;
            as asVar = new as();
            asVar.ckC = 0;
            asVar.name = this.mContext.getResources().getString(d.l.forum_list_menu_all);
            asVar.isSelected = false;
            ai.k(this.mContentView, d.e.cp_bg_line_d);
            ai.k(this.axs, d.e.cp_bg_line_b);
            this.cvn.a(this.cvm, asVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wV() {
        if (this.mContentView != null) {
            ai.k(this.mContentView, d.e.cp_bg_line_d);
            ai.k(this.axs, d.e.cp_bg_line_b);
        }
        if (this.cvn != null) {
            this.cvn.wV();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aiP() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
