package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class g implements a {
    private TabMenuPopView.a hEG = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bd bdVar) {
            if (g.this.hXK != null) {
                g.this.hXK.dismissMenu();
            }
            g.this.hXM.vQ(bdVar.hDR);
        }
    };
    private List<bd> hHi;
    private e hXK;
    private e.b hXM;
    private TabMenuPopView hXN;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.hXK = eVar;
            this.hXM = eVar.cev();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.hXN = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.hXN.setOnItemClickCallBack(this.hEG);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bd> list) {
        if (list != null) {
            this.hHi = list;
            bd bdVar = new bd();
            bdVar.hDR = 0;
            bdVar.name = this.mContext.getResources().getString(R.string.all);
            bdVar.isSelected = false;
            an.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.hXN.setData(this.hHi, bdVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cet() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
