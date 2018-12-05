package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements a {
    private TabMenuPopView.a dMb = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.ecj != null) {
                g.this.ecj.dismissMenu();
            }
            g.this.ecl.nm(atVar.dLp);
        }
    };
    private List<at> dOr;
    private e ecj;
    private e.b ecl;
    private TabMenuPopView ecm;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.ecj = eVar;
            this.ecl = eVar.aGP();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(e.h.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(e.g.top_line);
            this.ecm = (TabMenuPopView) this.mContentView.findViewById(e.g.categorycontainer);
            this.ecm.setOnItemClickCallBack(this.dMb);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.dOr = list;
            at atVar = new at();
            atVar.dLp = 0;
            atVar.name = this.mContext.getResources().getString(e.j.all);
            atVar.isSelected = false;
            al.j(this.mContentView, e.d.cp_bg_line_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            this.ecm.setData(this.dOr, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aGN() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
