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
    private List<dy> aMv;
    private BdListView bSM;
    private j bSN;
    private j.b bSs;
    private Context mContext;
    private final BaseAdapter bSO = new o(this);
    private AdapterView.OnItemClickListener zr = new p(this);

    private void initView() {
        this.bSM = new BdListView(this.mContext);
        this.bSM.setAlwaysDrawnWithCacheEnabled(false);
        this.bSM.setDivider(null);
        this.bSM.setDividerHeight(0);
        this.bSM.setSelector(17170445);
        this.bSM.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bSM.setOnItemClickListener(this.zr);
        this.bSM.setAdapter((ListAdapter) this.bSO);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bSN = jVar;
            this.bSs = jVar.aar();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<dy> list) {
        this.aMv = list;
        this.bSO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bSM;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vm() {
        this.bSO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int aao() {
        return 0;
    }
}
