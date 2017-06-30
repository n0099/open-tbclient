package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class r implements g {
    private View awA;
    private TabMenuPopView.a cfu = new s(this);
    private k cop;
    private k.b cos;
    private List<co> cot;
    private TabMenuPopView cou;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.g
    public void a(Context context, k kVar) {
        if (context != null && kVar != null) {
            this.mContext = context;
            this.cop = kVar;
            this.cos = kVar.ahu();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(w.j.tab_menu_multline_view, (ViewGroup) null);
            this.awA = this.mContentView.findViewById(w.h.top_line);
            this.cou = (TabMenuPopView) this.mContentView.findViewById(w.h.categorycontainer);
            this.cou.setOnItemClickCallBack(this.cfu);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void setData(List<co> list) {
        if (list != null) {
            this.cot = list;
            co coVar = new co();
            coVar.ceQ = 0;
            coVar.name = this.mContext.getResources().getString(w.l.forum_list_menu_all);
            coVar.isSelected = false;
            as.k(this.mContentView, w.e.cp_bg_line_d);
            as.k(this.awA, w.e.cp_bg_line_b);
            this.cou.a(this.cot, coVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void wK() {
        if (this.mContentView != null) {
            as.k(this.mContentView, w.e.cp_bg_line_d);
            as.k(this.awA, w.e.cp_bg_line_b);
        }
        if (this.cou != null) {
            this.cou.wK();
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public int ahr() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
