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
    private List<dt> aRP;
    private BdListView cdS;
    private j cdT;
    private j.b cdy;
    private Context mContext;
    private final BaseAdapter cdU = new o(this);
    private AdapterView.OnItemClickListener BG = new p(this);

    private void initView() {
        this.cdS = new BdListView(this.mContext);
        this.cdS.setAlwaysDrawnWithCacheEnabled(false);
        this.cdS.setDivider(null);
        this.cdS.setDividerHeight(0);
        this.cdS.setSelector(17170445);
        this.cdS.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cdS.setOnItemClickListener(this.BG);
        this.cdS.setAdapter((ListAdapter) this.cdU);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cdT = jVar;
            this.cdy = jVar.afc();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dt> list) {
        this.aRP = list;
        this.cdU.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.cdS;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wq() {
        this.cdU.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int aeZ() {
        return 0;
    }
}
