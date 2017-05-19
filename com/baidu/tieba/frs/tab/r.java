package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class r implements g {
    private View avN;
    private TabMenuPopView.a bRv = new s(this);
    private k bZN;
    private k.b bZQ;
    private List<cm> bZR;
    private TabMenuPopView bZS;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.g
    public void a(Context context, k kVar) {
        if (context != null && kVar != null) {
            this.mContext = context;
            this.bZN = kVar;
            this.bZQ = kVar.acy();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(w.j.tab_menu_multline_view, (ViewGroup) null);
            this.avN = this.mContentView.findViewById(w.h.top_line);
            this.bZS = (TabMenuPopView) this.mContentView.findViewById(w.h.categorycontainer);
            this.bZS.setOnItemClickCallBack(this.bRv);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void setData(List<cm> list) {
        if (list != null) {
            this.bZR = list;
            cm cmVar = new cm();
            cmVar.bQR = 0;
            cmVar.name = this.mContext.getResources().getString(w.l.forum_list_menu_all);
            cmVar.isSelected = false;
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avN, w.e.cp_bg_line_b);
            this.bZS.a(this.bZR, cmVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void ww() {
        if (this.mContentView != null) {
            aq.k(this.mContentView, w.e.cp_bg_line_d);
            aq.k(this.avN, w.e.cp_bg_line_b);
        }
        if (this.bZS != null) {
            this.bZS.ww();
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public int acv() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
