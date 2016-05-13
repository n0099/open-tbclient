package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<ft> aIe;
    private j.b bsQ;
    private BdListView btk;
    private j btl;
    private Context mContext;
    private final BaseAdapter btm = new o(this);
    private AdapterView.OnItemClickListener yR = new p(this);

    private void initView() {
        this.btk = new BdListView(this.mContext);
        this.btk.setAlwaysDrawnWithCacheEnabled(false);
        this.btk.setDivider(null);
        this.btk.setDividerHeight(0);
        this.btk.setSelector(17170445);
        this.btk.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.btk.setOnItemClickListener(this.yR);
        this.btk.setAdapter((ListAdapter) this.btm);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.btl = jVar;
            this.bsQ = jVar.TA();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ft> list) {
        this.aIe = list;
        this.btm.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.btk;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vm() {
        this.btm.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int Ty() {
        return 0;
    }
}
