package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements a {
    private e jCF;
    private e.b jCH;
    private TabMenuPopView jCI;
    private TabMenuPopView.a jfP = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, bc bcVar) {
            if (g.this.jCF != null) {
                g.this.jCF.cIW();
            }
            g.this.jCH.Ae(bcVar.jeY);
        }
    };
    private List<bc> jiZ;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.jCF = eVar;
            this.jCH = eVar.cIX();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.jCI = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.jCI.setOnItemClickCallBack(this.jfP);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bc> list) {
        if (list != null) {
            this.jiZ = list;
            bc bcVar = new bc();
            bcVar.jeY = 0;
            bcVar.name = this.mContext.getResources().getString(R.string.all);
            bcVar.isSelected = false;
            ao.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
            ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            this.jCI.setData(this.jiZ, bcVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cIU() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
