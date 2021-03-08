package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements a {
    private e jKg;
    private e.b jKi;
    private TabMenuPopView jKj;
    private TabMenuPopView.a jnu = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bc bcVar) {
            if (g.this.jKg != null) {
                g.this.jKg.cKw();
            }
            g.this.jKi.Ap(bcVar.jmD);
        }
    };
    private List<bc> jqD;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.jKg = eVar;
            this.jKi = eVar.cKx();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.jKj = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.jKj.setOnItemClickCallBack(this.jnu);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bc> list) {
        if (list != null) {
            this.jqD = list;
            bc bcVar = new bc();
            bcVar.jmD = 0;
            bcVar.name = this.mContext.getResources().getString(R.string.all);
            bcVar.isSelected = false;
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            this.jKj.setData(this.jqD, bcVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cKu() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
