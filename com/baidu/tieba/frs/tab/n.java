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
    private List<cx> aUV;
    private BdListView chS;
    private j chT;
    private j.b chx;
    private Context mContext;
    private final BaseAdapter chU = new o(this);
    private AdapterView.OnItemClickListener BG = new p(this);

    private void initView() {
        this.chS = new BdListView(this.mContext);
        this.chS.setAlwaysDrawnWithCacheEnabled(false);
        this.chS.setDivider(null);
        this.chS.setDividerHeight(0);
        this.chS.setSelector(17170445);
        this.chS.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.chS.setOnItemClickListener(this.BG);
        this.chS.setAdapter((ListAdapter) this.chU);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.chT = jVar;
            this.chx = jVar.aha();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<cx> list) {
        this.aUV = list;
        this.chU.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.chS;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wM() {
        this.chU.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int agX() {
        return 0;
    }
}
