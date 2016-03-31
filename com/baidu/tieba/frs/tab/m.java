package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* loaded from: classes.dex */
public class m implements f {
    private List<fu> aLU;
    private i.b btT;
    private BdListView buo;
    private i bup;
    private Context mContext;
    private final BaseAdapter buq = new n(this);
    private AdapterView.OnItemClickListener Iy = new o(this);

    private void initView() {
        this.buo = new BdListView(this.mContext);
        this.buo.setAlwaysDrawnWithCacheEnabled(false);
        this.buo.setDivider(null);
        this.buo.setDividerHeight(0);
        this.buo.setSelector(17170445);
        this.buo.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.buo.setOnItemClickListener(this.Iy);
        this.buo.setAdapter((ListAdapter) this.buq);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bup = iVar;
            this.btT = iVar.Tu();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fu> list) {
        this.aLU = list;
        this.buq.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.buo;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void xy() {
        this.buq.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int Ts() {
        return 0;
    }
}
