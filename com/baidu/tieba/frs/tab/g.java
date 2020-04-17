package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class g implements a {
    private TabMenuPopView.a hcK = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, ax axVar) {
            if (g.this.huS != null) {
                g.this.huS.dismissMenu();
            }
            g.this.huU.uD(axVar.hbZ);
        }
    };
    private List<ax> hfn;
    private e huS;
    private e.b huU;
    private TabMenuPopView huV;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.huS = eVar;
            this.huU = eVar.bUz();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.huV = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.huV.setOnItemClickCallBack(this.hcK);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ax> list) {
        if (list != null) {
            this.hfn = list;
            ax axVar = new ax();
            axVar.hbZ = 0;
            axVar.name = this.mContext.getResources().getString(R.string.all);
            axVar.isSelected = false;
            am.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.huV.setData(this.hfn, axVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bUx() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
