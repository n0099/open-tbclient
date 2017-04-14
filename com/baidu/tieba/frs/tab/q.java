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
    private View avH;
    private TabMenuPopView.a bQL = new r(this);
    private j bZD;
    private j.b bZG;
    private List<cv> bZH;
    private TabMenuPopView bZI;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bZD = jVar;
            this.bZG = jVar.adu();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(w.j.tab_menu_multline_view, (ViewGroup) null);
            this.avH = this.mContentView.findViewById(w.h.top_line);
            this.bZI = (TabMenuPopView) this.mContentView.findViewById(w.h.categorycontainer);
            this.bZI.setOnItemClickCallBack(this.bQL);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cv> list) {
        if (list != null) {
            this.bZH = list;
            cv cvVar = new cv();
            cvVar.bPO = 0;
            cvVar.name = this.mContext.getResources().getString(w.l.forum_list_menu_all);
            cvVar.isSelected = false;
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avH, w.e.cp_bg_line_b);
            this.bZI.a(this.bZH, cvVar);
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
            aq.k(this.avH, w.e.cp_bg_line_b);
        }
        if (this.bZI != null) {
            this.bZI.xl();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int adr() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
