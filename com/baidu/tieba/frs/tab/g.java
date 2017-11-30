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
    private View axX;
    private TabMenuPopView.a cKz = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.cZz != null) {
                g.this.cZz.aqs();
            }
            g.this.cZC.kR(atVar.cJT);
        }
    };
    private e.b cZC;
    private List<at> cZD;
    private TabMenuPopView cZE;
    private e cZz;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cZz = eVar;
            this.cZC = eVar.aqt();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.h.tab_menu_multline_view, (ViewGroup) null);
            this.axX = this.mContentView.findViewById(d.g.top_line);
            this.cZE = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.cZE.setOnItemClickCallBack(this.cKz);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.cZD = list;
            at atVar = new at();
            atVar.cJT = 0;
            atVar.name = this.mContext.getResources().getString(d.j.all);
            atVar.isSelected = false;
            aj.k(this.mContentView, d.C0082d.cp_bg_line_d);
            aj.k(this.axX, d.C0082d.cp_bg_line_b);
            this.cZE.a(this.cZD, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wE() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.C0082d.cp_bg_line_d);
            aj.k(this.axX, d.C0082d.cp_bg_line_b);
        }
        if (this.cZE != null) {
            this.cZE.wE();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aqq() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
