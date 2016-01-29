package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* loaded from: classes.dex */
public class m implements f {
    private List<fm> aIY;
    private i.a boS;
    private BdListView bpm;
    private i bpn;
    private Context mContext;
    private final BaseAdapter bpo = new n(this);
    private AdapterView.OnItemClickListener Is = new o(this);

    private void initView() {
        this.bpm = new BdListView(this.mContext);
        this.bpm.setAlwaysDrawnWithCacheEnabled(false);
        this.bpm.setDivider(null);
        this.bpm.setDividerHeight(0);
        this.bpm.setSelector(17170445);
        this.bpm.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bpm.setOnItemClickListener(this.Is);
        this.bpm.setAdapter((ListAdapter) this.bpo);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bpn = iVar;
            this.boS = iVar.RG();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fm> list) {
        this.aIY = list;
        this.bpo.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bpm;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xf() {
        this.bpo.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int RE() {
        return 0;
    }
}
