package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements a {
    private View aze;
    private TabMenuPopView.a daD = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view2, ar arVar) {
            if (g.this.dph != null) {
                g.this.dph.auM();
            }
            g.this.dpk.lg(arVar.cZW);
        }
    };
    private e dph;
    private e.b dpk;
    private List<ar> dpl;
    private TabMenuPopView dpm;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dph = eVar;
            this.dpk = eVar.auN();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.i.tab_menu_multline_view, (ViewGroup) null);
            this.aze = this.mContentView.findViewById(d.g.top_line);
            this.dpm = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.dpm.setOnItemClickCallBack(this.daD);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        if (list != null) {
            this.dpl = list;
            ar arVar = new ar();
            arVar.cZW = 0;
            arVar.name = this.mContext.getResources().getString(d.k.all);
            arVar.isSelected = false;
            ak.j(this.mContentView, d.C0126d.cp_bg_line_d);
            ak.j(this.aze, d.C0126d.cp_bg_line_b);
            this.dpm.setData(this.dpl, arVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int auK() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
