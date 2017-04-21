package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class q implements f {
    private View avJ;
    private TabMenuPopView.a bTc = new r(this);
    private j cbU;
    private j.b cbX;
    private List<cv> cbY;
    private TabMenuPopView cbZ;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cbU = jVar;
            this.cbX = jVar.aev();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(w.j.tab_menu_multline_view, (ViewGroup) null);
            this.avJ = this.mContentView.findViewById(w.h.top_line);
            this.cbZ = (TabMenuPopView) this.mContentView.findViewById(w.h.categorycontainer);
            this.cbZ.setOnItemClickCallBack(this.bTc);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cv> list) {
        if (list != null) {
            this.cbY = list;
            cv cvVar = new cv();
            cvVar.bSf = 0;
            cvVar.name = this.mContext.getResources().getString(w.l.forum_list_menu_all);
            cvVar.isSelected = false;
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avJ, w.e.cp_bg_line_b);
            this.cbZ.a(this.cbY, cvVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xl() {
        if (this.mContentView != null) {
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avJ, w.e.cp_bg_line_b);
        }
        if (this.cbZ != null) {
            this.cbZ.xl();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int aes() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
