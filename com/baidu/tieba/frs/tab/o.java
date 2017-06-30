package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.tab.k;
import java.util.List;
/* loaded from: classes.dex */
public class o implements g {
    private List<co> aUW;
    private k.b cnR;
    private BdListView coo;
    private k cop;
    private Context mContext;
    private final BaseAdapter coq = new p(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new q(this);

    private void initView() {
        this.coo = new BdListView(this.mContext);
        this.coo.setAlwaysDrawnWithCacheEnabled(false);
        this.coo.setDivider(null);
        this.coo.setDividerHeight(0);
        this.coo.setSelector(17170445);
        this.coo.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.coo.setOnItemClickListener(this.mOnItemClickListener);
        this.coo.setAdapter((ListAdapter) this.coq);
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void a(Context context, k kVar) {
        if (context != null && kVar != null) {
            this.mContext = context;
            this.cop = kVar;
            this.cnR = kVar.ahu();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void setData(List<co> list) {
        this.aUW = list;
        this.coq.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.g
    public View getView() {
        return this.coo;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void wK() {
        this.coq.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.g
    public int ahr() {
        return 0;
    }
}
