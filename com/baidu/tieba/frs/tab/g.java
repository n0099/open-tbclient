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
/* loaded from: classes2.dex */
public class g implements a {
    private View aHA;
    private TabMenuPopView.a dla = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, ar arVar) {
            if (g.this.dzB != null) {
                g.this.dzB.ayV();
            }
            g.this.dzE.lm(arVar.dkv);
        }
    };
    private e dzB;
    private e.b dzE;
    private List<ar> dzF;
    private TabMenuPopView dzG;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dzB = eVar;
            this.dzE = eVar.ayW();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.i.tab_menu_multline_view, (ViewGroup) null);
            this.aHA = this.mContentView.findViewById(d.g.top_line);
            this.dzG = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.dzG.setOnItemClickCallBack(this.dla);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        if (list != null) {
            this.dzF = list;
            ar arVar = new ar();
            arVar.dkv = 0;
            arVar.name = this.mContext.getResources().getString(d.k.all);
            arVar.isSelected = false;
            al.j(this.mContentView, d.C0141d.cp_bg_line_d);
            al.j(this.aHA, d.C0141d.cp_bg_line_b);
            this.dzG.setData(this.dzF, arVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int ayT() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
