package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class p implements f {
    private TabMenuPopView.a brV = new q(this);
    private i bup;
    private i.b bus;
    private List<fu> but;
    private TabMenuPopView buu;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bup = iVar;
            this.bus = iVar.Tu();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(t.h.tab_menu_multline_view, (ViewGroup) null);
            this.buu = (TabMenuPopView) this.mContentView.findViewById(t.g.categorycontainer);
            this.buu.setOnItemClickCallBack(this.brV);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fu> list) {
        if (list != null) {
            this.but = list;
            fu fuVar = new fu();
            fuVar.bqM = 0;
            fuVar.name = this.mContext.getResources().getString(t.j.forum_list_menu_all);
            fuVar.isSelected = false;
            at.l(this.mContentView, t.d.cp_bg_line_d);
            this.buu.a(this.but, fuVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xy() {
        if (this.mContentView != null) {
            at.l(this.mContentView, t.d.cp_bg_line_d);
        }
        if (this.buu != null) {
            this.buu.xy();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int Ts() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
