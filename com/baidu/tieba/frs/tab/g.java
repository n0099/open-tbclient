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
    private TabMenuPopView.a daG = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view2, ar arVar) {
            if (g.this.dpk != null) {
                g.this.dpk.auM();
            }
            g.this.dpn.lh(arVar.cZZ);
        }
    };
    private e dpk;
    private e.b dpn;
    private List<ar> dpo;
    private TabMenuPopView dpp;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dpk = eVar;
            this.dpn = eVar.auN();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.i.tab_menu_multline_view, (ViewGroup) null);
            this.aze = this.mContentView.findViewById(d.g.top_line);
            this.dpp = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.dpp.setOnItemClickCallBack(this.daG);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        if (list != null) {
            this.dpo = list;
            ar arVar = new ar();
            arVar.cZZ = 0;
            arVar.name = this.mContext.getResources().getString(d.k.all);
            arVar.isSelected = false;
            ak.j(this.mContentView, d.C0126d.cp_bg_line_d);
            ak.j(this.aze, d.C0126d.cp_bg_line_b);
            this.dpp.setData(this.dpo, arVar);
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
