package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.tab.k;
import java.util.List;
/* loaded from: classes.dex */
public class o implements g {
    private List<cm> aWb;
    private BdListView bZM;
    private k bZN;
    private k.b bZp;
    private Context mContext;
    private final BaseAdapter bZO = new p(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new q(this);

    private void initView() {
        this.bZM = new BdListView(this.mContext);
        this.bZM.setAlwaysDrawnWithCacheEnabled(false);
        this.bZM.setDivider(null);
        this.bZM.setDividerHeight(0);
        this.bZM.setSelector(17170445);
        this.bZM.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bZM.setOnItemClickListener(this.mOnItemClickListener);
        this.bZM.setAdapter((ListAdapter) this.bZO);
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void a(Context context, k kVar) {
        if (context != null && kVar != null) {
            this.mContext = context;
            this.bZN = kVar;
            this.bZp = kVar.acy();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void setData(List<cm> list) {
        this.aWb = list;
        this.bZO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.g
    public View getView() {
        return this.bZM;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void ww() {
        this.bZO.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.g
    public int acv() {
        return 0;
    }
}
