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
    private View ayf;
    private TabMenuPopView.a cKN = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, au auVar) {
            if (g.this.cZP != null) {
                g.this.cZP.aqB();
            }
            g.this.cZS.kT(auVar.cKh);
        }
    };
    private e cZP;
    private e.b cZS;
    private List<au> cZT;
    private TabMenuPopView cZU;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cZP = eVar;
            this.cZS = eVar.aqC();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.h.tab_menu_multline_view, (ViewGroup) null);
            this.ayf = this.mContentView.findViewById(d.g.top_line);
            this.cZU = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.cZU.setOnItemClickCallBack(this.cKN);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<au> list) {
        if (list != null) {
            this.cZT = list;
            au auVar = new au();
            auVar.cKh = 0;
            auVar.name = this.mContext.getResources().getString(d.j.all);
            auVar.isSelected = false;
            aj.k(this.mContentView, d.C0095d.cp_bg_line_d);
            aj.k(this.ayf, d.C0095d.cp_bg_line_b);
            this.cZU.a(this.cZT, auVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wC() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.C0095d.cp_bg_line_d);
            aj.k(this.ayf, d.C0095d.cp_bg_line_b);
        }
        if (this.cZU != null) {
            this.cZU.wC();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aqz() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
