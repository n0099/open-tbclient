package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements a {
    private TabMenuPopView.a fdg = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, ar arVar) {
            if (g.this.ftJ != null) {
                g.this.ftJ.bio();
            }
            g.this.ftL.rk(arVar.fcn);
        }
    };
    private List<ar> ffC;
    private e ftJ;
    private e.b ftL;
    private TabMenuPopView ftM;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.ftJ = eVar;
            this.ftL = eVar.bip();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.h.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(d.g.top_line);
            this.ftM = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.ftM.setOnItemClickCallBack(this.fdg);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        if (list != null) {
            this.ffC = list;
            ar arVar = new ar();
            arVar.fcn = 0;
            arVar.name = this.mContext.getResources().getString(d.j.all);
            arVar.isSelected = false;
            al.l(this.mContentView, d.C0277d.cp_bg_line_d);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_b);
            this.ftM.setData(this.ffC, arVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bim() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
