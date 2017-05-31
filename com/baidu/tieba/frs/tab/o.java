package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.tab.k;
import java.util.List;
/* loaded from: classes.dex */
public class o implements g {
    private List<cn> aTD;
    private k.b cfB;
    private BdListView cfY;
    private k cfZ;
    private Context mContext;
    private final BaseAdapter cga = new p(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new q(this);

    private void initView() {
        this.cfY = new BdListView(this.mContext);
        this.cfY.setAlwaysDrawnWithCacheEnabled(false);
        this.cfY.setDivider(null);
        this.cfY.setDividerHeight(0);
        this.cfY.setSelector(17170445);
        this.cfY.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cfY.setOnItemClickListener(this.mOnItemClickListener);
        this.cfY.setAdapter((ListAdapter) this.cga);
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void a(Context context, k kVar) {
        if (context != null && kVar != null) {
            this.mContext = context;
            this.cfZ = kVar;
            this.cfB = kVar.adB();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void setData(List<cn> list) {
        this.aTD = list;
        this.cga.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.g
    public View getView() {
        return this.cfY;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void ws() {
        this.cga.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.g
    public int adz() {
        return 0;
    }
}
