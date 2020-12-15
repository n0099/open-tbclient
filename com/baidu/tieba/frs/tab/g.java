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
    private TabMenuPopView.a iYj = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bf bfVar) {
            if (g.this.juQ != null) {
                g.this.juQ.dismissMenu();
            }
            g.this.juS.By(bfVar.iXt);
        }
    };
    private List<bf> jbs;
    private e juQ;
    private e.b juS;
    private TabMenuPopView juT;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.juQ = eVar;
            this.juS = eVar.cJN();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.juT = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.juT.setOnItemClickCallBack(this.iYj);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bf> list) {
        if (list != null) {
            this.jbs = list;
            bf bfVar = new bf();
            bfVar.iXt = 0;
            bfVar.name = this.mContext.getResources().getString(R.string.all);
            bfVar.isSelected = false;
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            this.juT.setData(this.jbs, bfVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cJL() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
