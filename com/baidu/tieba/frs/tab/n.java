package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<cx> aUm;
    private BdListView bNB;
    private j bNC;
    private j.b bNg;
    private Context mContext;
    private final BaseAdapter bND = new o(this);
    private AdapterView.OnItemClickListener BH = new p(this);

    private void initView() {
        this.bNB = new BdListView(this.mContext);
        this.bNB.setAlwaysDrawnWithCacheEnabled(false);
        this.bNB.setDivider(null);
        this.bNB.setDividerHeight(0);
        this.bNB.setSelector(17170445);
        this.bNB.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bNB.setOnItemClickListener(this.BH);
        this.bNB.setAdapter((ListAdapter) this.bND);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bNC = jVar;
            this.bNg = jVar.abv();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cx> list) {
        this.aUm = list;
        this.bND.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bNB;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wx() {
        this.bND.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int abs() {
        return 0;
    }
}
