package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class g implements a {
    private View ayc;
    private TabMenuPopView.a cKJ = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, au auVar) {
            if (g.this.cZL != null) {
                g.this.cZL.aqA();
            }
            g.this.cZO.kT(auVar.cKd);
        }
    };
    private e cZL;
    private e.b cZO;
    private List<au> cZP;
    private TabMenuPopView cZQ;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cZL = eVar;
            this.cZO = eVar.aqB();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.h.tab_menu_multline_view, (ViewGroup) null);
            this.ayc = this.mContentView.findViewById(d.g.top_line);
            this.cZQ = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.cZQ.setOnItemClickCallBack(this.cKJ);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<au> list) {
        if (list != null) {
            this.cZP = list;
            au auVar = new au();
            auVar.cKd = 0;
            auVar.name = this.mContext.getResources().getString(d.j.all);
            auVar.isSelected = false;
            aj.k(this.mContentView, d.C0096d.cp_bg_line_d);
            aj.k(this.ayc, d.C0096d.cp_bg_line_b);
            this.cZQ.a(this.cZP, auVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wC() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.C0096d.cp_bg_line_d);
            aj.k(this.ayc, d.C0096d.cp_bg_line_b);
        }
        if (this.cZQ != null) {
            this.cZQ.wC();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aqy() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
