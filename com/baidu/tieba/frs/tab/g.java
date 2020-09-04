package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes16.dex */
public class g implements a {
    private TabMenuPopView.a hYj = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bf bfVar) {
            if (g.this.irY != null) {
                g.this.irY.dismissMenu();
            }
            g.this.isa.yB(bfVar.hXt);
        }
    };
    private List<bf> ibr;
    private e irY;
    private e.b isa;
    private TabMenuPopView isb;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.irY = eVar;
            this.isa = eVar.csA();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.isb = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.isb.setOnItemClickCallBack(this.hYj);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bf> list) {
        if (list != null) {
            this.ibr = list;
            bf bfVar = new bf();
            bfVar.hXt = 0;
            bfVar.name = this.mContext.getResources().getString(R.string.all);
            bfVar.isSelected = false;
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.isb.setData(this.ibr, bfVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int csy() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
