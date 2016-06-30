package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View aSa;
    private TabMenuPopView.a bHK = new r(this);
    private j bQP;
    private j.b bQS;
    private List<dy> bQT;
    private TabMenuPopView bQU;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bQP = jVar;
            this.bQS = jVar.ZP();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(u.h.tab_menu_multline_view, (ViewGroup) null);
            this.aSa = this.mContentView.findViewById(u.g.top_line);
            this.bQU = (TabMenuPopView) this.mContentView.findViewById(u.g.categorycontainer);
            this.bQU.setOnItemClickCallBack(this.bHK);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dy> list) {
        if (list != null) {
            this.bQT = list;
            dy dyVar = new dy();
            dyVar.bGN = 0;
            dyVar.name = this.mContext.getResources().getString(u.j.forum_list_menu_all);
            dyVar.isSelected = false;
            av.l(this.mContentView, u.d.cp_bg_line_d);
            av.l(this.aSa, u.d.cp_bg_line_b);
            this.bQU.a(this.bQT, dyVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vm() {
        if (this.mContentView != null) {
            av.l(this.mContentView, u.d.cp_bg_line_d);
            av.l(this.aSa, u.d.cp_bg_line_b);
        }
        if (this.bQU != null) {
            this.bQU.vm();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int ZN() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
