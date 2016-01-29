package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class p implements f {
    private TabMenuPopView.a bmK = new q(this);
    private i bpn;
    private i.a bpr;
    private List<fm> bps;
    private TabMenuPopView bpt;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bpn = iVar;
            this.bpr = iVar.RG();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(t.h.tab_menu_multline_view, (ViewGroup) null);
            this.bpt = (TabMenuPopView) this.mContentView.findViewById(t.g.categorycontainer);
            this.bpt.setOnItemClickCallBack(this.bmK);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fm> list) {
        if (list != null) {
            this.bps = list;
            fm fmVar = new fm();
            fmVar.blu = 0;
            fmVar.name = this.mContext.getResources().getString(t.j.forum_list_menu_all);
            fmVar.isSelected = false;
            ar.l(this.mContentView, t.d.cp_bg_line_d);
            this.bpt.a(this.bps, fmVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xf() {
        if (this.mContentView != null) {
            ar.l(this.mContentView, t.d.cp_bg_line_d);
        }
        if (this.bpt != null) {
            this.bpt.xf();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int RE() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
