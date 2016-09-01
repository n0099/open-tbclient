package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View aYc;
    private TabMenuPopView.a bUh = new r(this);
    private j cdT;
    private j.b cdW;
    private List<dt> cdX;
    private TabMenuPopView cdY;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cdT = jVar;
            this.cdW = jVar.afc();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(t.h.tab_menu_multline_view, (ViewGroup) null);
            this.aYc = this.mContentView.findViewById(t.g.top_line);
            this.cdY = (TabMenuPopView) this.mContentView.findViewById(t.g.categorycontainer);
            this.cdY.setOnItemClickCallBack(this.bUh);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dt> list) {
        if (list != null) {
            this.cdX = list;
            dt dtVar = new dt();
            dtVar.bTp = 0;
            dtVar.name = this.mContext.getResources().getString(t.j.forum_list_menu_all);
            dtVar.isSelected = false;
            av.l(this.mContentView, t.d.cp_bg_line_d);
            av.l(this.aYc, t.d.cp_bg_line_b);
            this.cdY.a(this.cdX, dtVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wq() {
        if (this.mContentView != null) {
            av.l(this.mContentView, t.d.cp_bg_line_d);
            av.l(this.aYc, t.d.cp_bg_line_b);
        }
        if (this.cdY != null) {
            this.cdY.wq();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int aeZ() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
