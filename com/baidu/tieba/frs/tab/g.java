package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements a {
    private TabMenuPopView dFA;
    private e dFx;
    private e.b dFz;
    private TabMenuPopView.a dpX = new TabMenuPopView.a() { // from class: com.baidu.tieba.frs.tab.g.1
        @Override // com.baidu.tieba.frs.TabMenuPopView.a
        public void a(View view, at atVar) {
            if (g.this.dFx != null) {
                g.this.dFx.aAf();
            }
            g.this.dFz.lE(atVar.dps);
        }
    };
    private List<at> dsm;
    private View mContentView;
    private Context mContext;
    private View mTopLine;

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dFx = eVar;
            this.dFz = eVar.aAg();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(f.h.tab_menu_multline_view, (ViewGroup) null);
            this.mTopLine = this.mContentView.findViewById(f.g.top_line);
            this.dFA = (TabMenuPopView) this.mContentView.findViewById(f.g.categorycontainer);
            this.dFA.setOnItemClickCallBack(this.dpX);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        if (list != null) {
            this.dsm = list;
            at atVar = new at();
            atVar.dps = 0;
            atVar.name = this.mContext.getResources().getString(f.j.all);
            atVar.isSelected = false;
            am.j(this.mContentView, f.d.cp_bg_line_d);
            am.j(this.mTopLine, f.d.cp_bg_line_b);
            this.dFA.setData(this.dsm, atVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aAd() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
