package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements a {
    private List<ar> fBA;
    private e fQo;
    private e.b fQq;
    private TabMenuPopView fQr;
    private TabMenuPopView.a fyQ = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, ar arVar) {
            if (g.this.fQo != null) {
                g.this.fQo.brX();
            }
            g.this.fQq.sM(arVar.fxX);
        }
    };
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.fQo = eVar;
            this.fQq = eVar.brY();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.fQr = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.fQr.setOnItemClickCallBack(this.fyQ);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        if (list != null) {
            this.fBA = list;
            ar arVar = new ar();
            arVar.fxX = 0;
            arVar.name = this.mContext.getResources().getString(R.string.all);
            arVar.isSelected = false;
            am.l(this.mContentView, R.color.cp_bg_line_d);
            am.l(this.mTopLine, R.color.cp_bg_line_b);
            this.fQr.setData(this.fBA, arVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int brV() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
