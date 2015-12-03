package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class p implements f {
    private TabMenuPopView.a bfW = new q(this);
    private i biI;
    private i.a biL;
    private List<fc> biM;
    private TabMenuPopView biN;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.biI = iVar;
            this.biL = iVar.Pk();
            this.mContentView = LayoutInflater.from(this.mContext).inflate(n.g.tab_menu_multline_view, (ViewGroup) null);
            this.biN = (TabMenuPopView) this.mContentView.findViewById(n.f.categorycontainer);
            this.biN.setOnItemClickCallBack(this.bfW);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fc> list) {
        if (list != null) {
            this.biM = list;
            fc fcVar = new fc();
            fcVar.beF = 0;
            fcVar.name = this.mContext.getResources().getString(n.i.forum_list_menu_all);
            fcVar.isSelected = false;
            as.j(this.mContentView, n.c.cp_bg_line_d);
            this.biN.a(this.biM, fcVar);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wh() {
        if (this.mContentView != null) {
            as.j(this.mContentView, n.c.cp_bg_line_d);
        }
        if (this.biN != null) {
            this.biN.wh();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int Pi() {
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.mContentView.getMeasuredHeight();
    }
}
