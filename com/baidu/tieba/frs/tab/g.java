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
    private View awR;
    private e cGD;
    private e.b cGG;
    private List<at> cGH;
    private TabMenuPopView cGI;
    private TabMenuPopView.a ctJ = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.cGD != null) {
                g.this.cGD.aly();
            }
            g.this.cGG.jX(atVar.csZ);
        }
    };
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cGD = eVar;
            this.cGG = eVar.alz();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.awR = this.mContentView.findViewById(d.h.top_line);
            this.cGI = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cGI.setOnItemClickCallBack(this.ctJ);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.cGH = list;
            at atVar = new at();
            atVar.csZ = 0;
            atVar.name = this.mContext.getResources().getString(d.l.all);
            atVar.isSelected = false;
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.awR, d.e.cp_bg_line_b);
            this.cGI.a(this.cGH, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wu() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.e.cp_bg_line_d);
            aj.k(this.awR, d.e.cp_bg_line_b);
        }
        if (this.cGI != null) {
            this.cGI.wu();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int alw() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
