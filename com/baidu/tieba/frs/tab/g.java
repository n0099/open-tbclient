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
    private View axw;
    private TabMenuPopView.a cBv = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.cQk != null) {
                g.this.cQk.aoy();
            }
            g.this.cQn.kt(atVar.cAP);
        }
    };
    private e cQk;
    private e.b cQn;
    private List<at> cQo;
    private TabMenuPopView cQp;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cQk = eVar;
            this.cQn = eVar.aoz();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.h.tab_menu_multline_view, (ViewGroup) null);
            this.axw = this.mContentView.findViewById(d.g.top_line);
            this.cQp = (TabMenuPopView) this.mContentView.findViewById(d.g.categorycontainer);
            this.cQp.setOnItemClickCallBack(this.cBv);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.cQo = list;
            at atVar = new at();
            atVar.cAP = 0;
            atVar.name = this.mContext.getResources().getString(d.j.all);
            atVar.isSelected = false;
            aj.k(this.mContentView, d.C0080d.cp_bg_line_d);
            aj.k(this.axw, d.C0080d.cp_bg_line_b);
            this.cQp.a(this.cQo, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wB() {
        if (this.mContentView != null) {
            aj.k(this.mContentView, d.C0080d.cp_bg_line_d);
            aj.k(this.axw, d.C0080d.cp_bg_line_b);
        }
        if (this.cQp != null) {
            this.cQp.wB();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aow() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
