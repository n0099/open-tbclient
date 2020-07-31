package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes16.dex */
public class g implements a {
    private TabMenuPopView.a hKE = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bd bdVar) {
            if (g.this.idM != null) {
                g.this.idM.dismissMenu();
            }
            g.this.idO.wi(bdVar.hJP);
        }
    };
    private List<bd> hNe;
    private e idM;
    private e.b idO;
    private TabMenuPopView idP;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.idM = eVar;
            this.idO = eVar.chV();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.idP = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.idP.setOnItemClickCallBack(this.hKE);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bd> list) {
        if (list != null) {
            this.hNe = list;
            bd bdVar = new bd();
            bdVar.hJP = 0;
            bdVar.name = this.mContext.getResources().getString(R.string.all);
            bdVar.isSelected = false;
            ao.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.idP.setData(this.hNe, bdVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int chT() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
