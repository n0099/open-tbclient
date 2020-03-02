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
/* loaded from: classes9.dex */
public class g implements a {
    private e gKj;
    private e.b gKl;
    private TabMenuPopView gKm;
    private TabMenuPopView.a gsI = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, as asVar) {
            if (g.this.gKj != null) {
                g.this.gKj.dismissMenu();
            }
            g.this.gKl.ua(asVar.grR);
        }
    };
    private List<as> gvm;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.gKj = eVar;
            this.gKl = eVar.bJO();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.gKm = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.gKm.setOnItemClickCallBack(this.gsI);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        if (list != null) {
            this.gvm = list;
            as asVar = new as();
            asVar.grR = 0;
            asVar.name = this.mContext.getResources().getString(R.string.all);
            asVar.isSelected = false;
            am.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.gKm.setData(this.gvm, asVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bJM() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
