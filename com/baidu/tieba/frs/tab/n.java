package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<dy> aLB;
    private BdListView bQO;
    private j bQP;
    private j.b bQu;
    private Context mContext;
    private final BaseAdapter bQQ = new o(this);
    private AdapterView.OnItemClickListener yQ = new p(this);

    private void initView() {
        this.bQO = new BdListView(this.mContext);
        this.bQO.setAlwaysDrawnWithCacheEnabled(false);
        this.bQO.setDivider(null);
        this.bQO.setDividerHeight(0);
        this.bQO.setSelector(17170445);
        this.bQO.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bQO.setOnItemClickListener(this.yQ);
        this.bQO.setAdapter((ListAdapter) this.bQQ);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bQP = jVar;
            this.bQu = jVar.ZP();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dy> list) {
        this.aLB = list;
        this.bQQ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bQO;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vm() {
        this.bQQ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int ZN() {
        return 0;
    }
}
