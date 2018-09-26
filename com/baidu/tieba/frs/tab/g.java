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
/* loaded from: classes2.dex */
public class g implements a {
    private e dME;
    private e.b dMG;
    private TabMenuPopView dMH;
    private TabMenuPopView.a dwl = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.dME != null) {
                g.this.dME.aCo();
            }
            g.this.dMG.mg(atVar.dvz);
        }
    };
    private List<at> dyC;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dME = eVar;
            this.dMG = eVar.aCp();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(e.h.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(e.g.top_line);
            this.dMH = (TabMenuPopView) this.mContentView.findViewById(e.g.categorycontainer);
            this.dMH.setOnItemClickCallBack(this.dwl);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.dyC = list;
            at atVar = new at();
            atVar.dvz = 0;
            atVar.name = this.mContext.getResources().getString(e.j.all);
            atVar.isSelected = false;
            al.j(this.mContentView, e.d.cp_bg_line_d);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            this.dMH.setData(this.dyC, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aCm() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
