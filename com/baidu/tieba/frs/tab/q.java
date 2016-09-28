package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View aqu;
    private TabMenuPopView.a bUa = new r(this);
    private j cdS;
    private j.b cdV;
    private List<dt> cdW;
    private TabMenuPopView cdX;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cdS = jVar;
            this.cdV = jVar.afq();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(r.h.tab_menu_multline_view, (ViewGroup) null);
            this.aqu = this.mContentView.findViewById(r.g.top_line);
            this.cdX = (TabMenuPopView) this.mContentView.findViewById(r.g.categorycontainer);
            this.cdX.setOnItemClickCallBack(this.bUa);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dt> list) {
        if (list != null) {
            this.cdW = list;
            dt dtVar = new dt();
            dtVar.bTi = 0;
            dtVar.name = this.mContext.getResources().getString(r.j.forum_list_menu_all);
            dtVar.isSelected = false;
            av.l(this.mContentView, r.d.cp_bg_line_d);
            av.l(this.aqu, r.d.cp_bg_line_b);
            this.cdX.a(this.cdW, dtVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wH() {
        if (this.mContentView != null) {
            av.l(this.mContentView, r.d.cp_bg_line_d);
            av.l(this.aqu, r.d.cp_bg_line_b);
        }
        if (this.cdX != null) {
            this.cdX.wH();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int afn() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
