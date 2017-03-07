package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<ct> aVq;
    private j.b caG;
    private BdListView cbb;
    private j cbc;
    private Context mContext;
    private final BaseAdapter cbd = new o(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new p(this);

    private void initView() {
        this.cbb = new BdListView(this.mContext);
        this.cbb.setAlwaysDrawnWithCacheEnabled(false);
        this.cbb.setDivider(null);
        this.cbb.setDividerHeight(0);
        this.cbb.setSelector(17170445);
        this.cbb.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cbb.setOnItemClickListener(this.mOnItemClickListener);
        this.cbb.setAdapter((ListAdapter) this.cbd);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cbc = jVar;
            this.caG = jVar.adA();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ct> list) {
        this.aVq = list;
        this.cbd.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.cbb;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wP() {
        this.cbd.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int adx() {
        return 0;
    }
}
