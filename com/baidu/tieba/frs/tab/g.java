package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class g implements a {
    private e gLA;
    private e.b gLC;
    private TabMenuPopView gLD;
    private TabMenuPopView.a gtz = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.gLA != null) {
                g.this.gLA.dismissMenu();
            }
            g.this.gLC.ug(atVar.gsO);
        }
    };
    private List<at> gwc;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.gLA = eVar;
            this.gLC = eVar.bKc();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(R.id.top_line);
            this.gLD = (TabMenuPopView) this.mContentView.findViewById(R.id.categorycontainer);
            this.gLD.setOnItemClickCallBack(this.gtz);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.gwc = list;
            at atVar = new at();
            atVar.gsO = 0;
            atVar.name = this.mContext.getResources().getString(R.string.all);
            atVar.isSelected = false;
            am.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            this.gLD.setData(this.gwc, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bKa() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
