package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class r implements g {
    private View avx;
    private TabMenuPopView.a bXl = new s(this);
    private k cfZ;
    private k.b cgc;
    private List<cn> cgd;
    private TabMenuPopView cge;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.g
    public void a(Context context, k kVar) {
        if (context != null && kVar != null) {
            this.mContext = context;
            this.cfZ = kVar;
            this.cgc = kVar.adB();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(w.j.tab_menu_multline_view, (ViewGroup) null);
            this.avx = this.mContentView.findViewById(w.h.top_line);
            this.cge = (TabMenuPopView) this.mContentView.findViewById(w.h.categorycontainer);
            this.cge.setOnItemClickCallBack(this.bXl);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void setData(List<cn> list) {
        if (list != null) {
            this.cgd = list;
            cn cnVar = new cn();
            cnVar.bWI = 0;
            cnVar.name = this.mContext.getResources().getString(w.l.forum_list_menu_all);
            cnVar.isSelected = false;
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avx, w.e.cp_bg_line_b);
            this.cge.a(this.cgd, cnVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void ws() {
        if (this.mContentView != null) {
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avx, w.e.cp_bg_line_b);
        }
        if (this.cge != null) {
            this.cge.ws();
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public int adz() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
