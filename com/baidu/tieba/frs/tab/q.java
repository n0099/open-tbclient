package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View aro;
    private TabMenuPopView.a bWq = new r(this);
    private j chT;
    private j.b chW;
    private List<cx> chX;
    private TabMenuPopView chY;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.chT = jVar;
            this.chW = jVar.aha();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(r.h.tab_menu_multline_view, (ViewGroup) null);
            this.aro = this.mContentView.findViewById(r.g.top_line);
            this.chY = (TabMenuPopView) this.mContentView.findViewById(r.g.categorycontainer);
            this.chY.setOnItemClickCallBack(this.bWq);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cx> list) {
        if (list != null) {
            this.chX = list;
            cx cxVar = new cx();
            cxVar.bVo = 0;
            cxVar.name = this.mContext.getResources().getString(r.j.forum_list_menu_all);
            cxVar.isSelected = false;
            at.l(this.mContentView, r.d.cp_bg_line_d);
            at.l(this.aro, r.d.cp_bg_line_b);
            this.chY.a(this.chX, cxVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wM() {
        if (this.mContentView != null) {
            at.l(this.mContentView, r.d.cp_bg_line_d);
            at.l(this.aro, r.d.cp_bg_line_b);
        }
        if (this.chY != null) {
            this.chY.wM();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int agX() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
