package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements a {
    private View aIx;
    private e dCO;
    private e.b dCR;
    private TabMenuPopView dCS;
    private TabMenuPopView.a dnh = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.dCO != null) {
                g.this.dCO.azB();
            }
            g.this.dCR.lt(atVar.dmC);
        }
    };
    private List<at> dpC;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dCO = eVar;
            this.dCR = eVar.azC();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.i.tab_menu_multline_view, (ViewGroup) null);
            this.aIx = this.mContentView.findViewById(d.g.top_line);
            this.dCS = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.dCS.setOnItemClickCallBack(this.dnh);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.dpC = list;
            at atVar = new at();
            atVar.dmC = 0;
            atVar.name = this.mContext.getResources().getString(d.k.all);
            atVar.isSelected = false;
            am.j(this.mContentView, d.C0142d.cp_bg_line_d);
            am.j(this.aIx, d.C0142d.cp_bg_line_b);
            this.dCS.setData(this.dpC, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int azz() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
