package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements a {
    private e.b fKB;
    private TabMenuPopView fKC;
    private e fKz;
    private TabMenuPopView.a ftu = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, ar arVar) {
            if (g.this.fKz != null) {
                g.this.fKz.bpE();
            }
            g.this.fKB.ss(arVar.fsB);
        }
    };
    private List<ar> fvP;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.fKz = eVar;
            this.fKB = eVar.bpF();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.fKC = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.fKC.setOnItemClickCallBack(this.ftu);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        if (list != null) {
            this.fvP = list;
            ar arVar = new ar();
            arVar.fsB = 0;
            arVar.name = this.mContext.getResources().getString(R.string.all);
            arVar.isSelected = false;
            al.l(this.mContentView, R.color.cp_bg_line_d);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            this.fKC.setData(this.fvP, arVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bpC() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
