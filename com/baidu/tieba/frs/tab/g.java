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
    private TabMenuPopView.a dPy = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.efG != null) {
                g.this.efG.dismissMenu();
            }
            g.this.efI.nA(atVar.dOM);
        }
    };
    private List<at> dRO;
    private e efG;
    private e.b efI;
    private TabMenuPopView efJ;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.efG = eVar;
            this.efI = eVar.aIb();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(e.h.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(e.g.top_line);
            this.efJ = (TabMenuPopView) this.mContentView.findViewById(e.g.categorycontainer);
            this.efJ.setOnItemClickCallBack(this.dPy);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.dRO = list;
            at atVar = new at();
            atVar.dOM = 0;
            atVar.name = this.mContext.getResources().getString(e.j.all);
            atVar.isSelected = false;
            al.j(this.mContentView, e.d.cp_bg_line_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            this.efJ.setData(this.dRO, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aHZ() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
