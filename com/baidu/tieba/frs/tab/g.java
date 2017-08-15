package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class g implements a {
    private View ayK;
    private TabMenuPopView.a cnd = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.cyB != null) {
                g.this.cyB.ajK();
            }
            g.this.cyE.jA(asVar.cmw);
        }
    };
    private e cyB;
    private e.b cyE;
    private List<as> cyF;
    private TabMenuPopView cyG;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cyB = eVar;
            this.cyE = eVar.ajL();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(d.j.tab_menu_multline_view, (ViewGroup) null);
            this.ayK = this.mContentView.findViewById(d.h.top_line);
            this.cyG = (TabMenuPopView) this.mContentView.findViewById(d.h.categorycontainer);
            this.cyG.setOnItemClickCallBack(this.cnd);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.cyF = list;
            as asVar = new as();
            asVar.cmw = 0;
            asVar.name = this.mContext.getResources().getString(d.l.forum_list_menu_all);
            asVar.isSelected = false;
            ai.k(this.mContentView, d.e.cp_bg_line_d);
            ai.k(this.ayK, d.e.cp_bg_line_b);
            this.cyG.a(this.cyF, asVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void xd() {
        if (this.mContentView != null) {
            ai.k(this.mContentView, d.e.cp_bg_line_d);
            ai.k(this.ayK, d.e.cp_bg_line_b);
        }
        if (this.cyG != null) {
            this.cyG.xd();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int ajI() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
