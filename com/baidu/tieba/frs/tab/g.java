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
    private e hJL;
    private e.b hJN;
    private TabMenuPopView hJO;
    private TabMenuPopView.a hrE = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, ax axVar) {
            if (g.this.hJL != null) {
                g.this.hJL.dismissMenu();
            }
            g.this.hJN.vj(axVar.hqT);
        }
    };
    private List<ax> huh;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.hJL = eVar;
            this.hJN = eVar.caV();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.hJO = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.hJO.setOnItemClickCallBack(this.hrE);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ax> list) {
        if (list != null) {
            this.huh = list;
            ax axVar = new ax();
            axVar.hqT = 0;
            axVar.name = this.mContext.getResources().getString(R.string.all);
            axVar.isSelected = false;
            am.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.hJO.setData(this.huh, axVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int caT() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
