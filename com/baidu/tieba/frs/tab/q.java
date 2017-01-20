package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View apX;
    private TabMenuPopView.a bJQ = new r(this);
    private j bTQ;
    private j.b bTT;
    private List<ct> bTU;
    private TabMenuPopView bTV;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bTQ = jVar;
            this.bTT = jVar.acC();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(r.j.tab_menu_multline_view, (ViewGroup) null);
            this.apX = this.mContentView.findViewById(r.h.top_line);
            this.bTV = (TabMenuPopView) this.mContentView.findViewById(r.h.categorycontainer);
            this.bTV.setOnItemClickCallBack(this.bJQ);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ct> list) {
        if (list != null) {
            this.bTU = list;
            ct ctVar = new ct();
            ctVar.bIQ = 0;
            ctVar.name = this.mContext.getResources().getString(r.l.forum_list_menu_all);
            ctVar.isSelected = false;
            ap.k(this.mContentView, r.e.cp_bg_line_d);
            ap.k(this.apX, r.e.cp_bg_line_b);
            this.bTV.a(this.bTU, ctVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void ws() {
        if (this.mContentView != null) {
            ap.k(this.mContentView, r.e.cp_bg_line_d);
            ap.k(this.apX, r.e.cp_bg_line_b);
        }
        if (this.bTV != null) {
            this.bTV.ws();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int acz() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
