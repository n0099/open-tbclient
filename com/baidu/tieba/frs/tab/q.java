package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private TabMenuPopView.a bnw = new r(this);
    private j btl;
    private j.b bto;
    private List<ft> btp;
    private TabMenuPopView btq;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.btl = jVar;
            this.bto = jVar.TA();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(t.h.tab_menu_multline_view, (ViewGroup) null);
            this.btq = (TabMenuPopView) this.mContentView.findViewById(t.g.categorycontainer);
            this.btq.setOnItemClickCallBack(this.bnw);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ft> list) {
        if (list != null) {
            this.btp = list;
            ft ftVar = new ft();
            ftVar.blZ = 0;
            ftVar.name = this.mContext.getResources().getString(t.j.forum_list_menu_all);
            ftVar.isSelected = false;
            at.l(this.mContentView, t.d.cp_bg_line_d);
            this.btq.a(this.btp, ftVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vm() {
        if (this.mContentView != null) {
            at.l(this.mContentView, t.d.cp_bg_line_d);
        }
        if (this.btq != null) {
            this.btq.vm();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int Ty() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
