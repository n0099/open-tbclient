package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<dt> aSU;
    private BdListView cdR;
    private j cdS;
    private j.b cdw;
    private Context mContext;
    private final BaseAdapter cdT = new o(this);
    private AdapterView.OnItemClickListener BG = new p(this);

    private void initView() {
        this.cdR = new BdListView(this.mContext);
        this.cdR.setAlwaysDrawnWithCacheEnabled(false);
        this.cdR.setDivider(null);
        this.cdR.setDividerHeight(0);
        this.cdR.setSelector(17170445);
        this.cdR.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cdR.setOnItemClickListener(this.BG);
        this.cdR.setAdapter((ListAdapter) this.cdT);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cdS = jVar;
            this.cdw = jVar.afq();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dt> list) {
        this.aSU = list;
        this.cdT.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.cdR;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wH() {
        this.cdT.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int afn() {
        return 0;
    }
}
