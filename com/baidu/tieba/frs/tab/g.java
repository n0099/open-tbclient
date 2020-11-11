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
/* loaded from: classes22.dex */
public class g implements a {
    private TabMenuPopView.a iMD = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bf bfVar) {
            if (g.this.jgA != null) {
                g.this.jgA.dismissMenu();
            }
            g.this.jgC.Am(bfVar.iLN);
        }
    };
    private List<bf> iPM;
    private e jgA;
    private e.b jgC;
    private TabMenuPopView jgD;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.jgA = eVar;
            this.jgC = eVar.cEU();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.jgD = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.jgD.setOnItemClickCallBack(this.iMD);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bf> list) {
        if (list != null) {
            this.iPM = list;
            bf bfVar = new bf();
            bfVar.iLN = 0;
            bfVar.name = this.mContext.getResources().getString(R.string.all);
            bfVar.isSelected = false;
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.jgD.setData(this.iPM, bfVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cES() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
