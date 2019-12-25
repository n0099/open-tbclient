package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements a {
    private e gET;
    private e.b gEV;
    private TabMenuPopView gEW;
    private TabMenuPopView.a gnw = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.gET != null) {
                g.this.gET.dismissMenu();
            }
            g.this.gEV.tP(asVar.gmF);
        }
    };
    private List<as> gqa;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.gET = eVar;
            this.gEV = eVar.bHi();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.gEW = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.gEW.setOnItemClickCallBack(this.gnw);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.gqa = list;
            as asVar = new as();
            asVar.gmF = 0;
            asVar.name = this.mContext.getResources().getString(R.string.all);
            asVar.isSelected = false;
            am.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.gEW.setData(this.gqa, asVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bHg() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
