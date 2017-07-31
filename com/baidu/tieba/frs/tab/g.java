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
    private View ayJ;
    private TabMenuPopView.a cms = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.cwA != null) {
                g.this.cwA.ajd();
            }
            g.this.cwD.jq(asVar.clK);
        }
    };
    private e cwA;
    private e.b cwD;
    private List<as> cwE;
    private TabMenuPopView cwF;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cwA = eVar;
            this.cwD = eVar.aje();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.ayJ = this.mContentView.findViewById(d.h.top_line);
            this.cwF = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cwF.setOnItemClickCallBack(this.cms);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.cwE = list;
            as asVar = new as();
            asVar.clK = 0;
            asVar.name = this.mContext.getResources().getString(d.l.forum_list_menu_all);
            asVar.isSelected = false;
            ai.k(this.mContentView, d.e.cp_bg_line_d);
            ai.k(this.ayJ, d.e.cp_bg_line_b);
            this.cwF.a(this.cwE, asVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void xd() {
        if (this.mContentView != null) {
            ai.k(this.mContentView, d.e.cp_bg_line_d);
            ai.k(this.ayJ, d.e.cp_bg_line_b);
        }
        if (this.cwF != null) {
            this.cwF.xd();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int ajb() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
