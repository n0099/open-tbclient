package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<cv> aVD;
    private BdListView bZC;
    private j bZD;
    private j.b bZh;
    private Context mContext;
    private final BaseAdapter bZE = new o(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new p(this);

    private void initView() {
        this.bZC = new BdListView(this.mContext);
        this.bZC.setAlwaysDrawnWithCacheEnabled(false);
        this.bZC.setDivider(null);
        this.bZC.setDividerHeight(0);
        this.bZC.setSelector(17170445);
        this.bZC.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bZC.setOnItemClickListener(this.mOnItemClickListener);
        this.bZC.setAdapter((ListAdapter) this.bZE);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bZD = jVar;
            this.bZh = jVar.adu();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cv> list) {
        this.aVD = list;
        this.bZE.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bZC;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xl() {
        this.bZE.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int adr() {
        return 0;
    }
}
