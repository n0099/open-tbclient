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
    private List<cv> aVF;
    private BdListView cbT;
    private j cbU;
    private j.b cby;
    private Context mContext;
    private final BaseAdapter cbV = new o(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new p(this);

    private void initView() {
        this.cbT = new BdListView(this.mContext);
        this.cbT.setAlwaysDrawnWithCacheEnabled(false);
        this.cbT.setDivider(null);
        this.cbT.setDividerHeight(0);
        this.cbT.setSelector(17170445);
        this.cbT.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cbT.setOnItemClickListener(this.mOnItemClickListener);
        this.cbT.setAdapter((ListAdapter) this.cbV);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.cbU = jVar;
            this.cby = jVar.aev();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cv> list) {
        this.aVF = list;
        this.cbV.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.cbT;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xl() {
        this.cbV.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int aes() {
        return 0;
    }
}
