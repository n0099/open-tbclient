package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* loaded from: classes.dex */
public class m implements f {
    private i.a bbI;
    private BdListView bcc;
    private i bcd;
    private Context mContext;
    private List<ek> mData;
    private final BaseAdapter bce = new n(this);
    private AdapterView.OnItemClickListener Hy = new o(this);

    private void initView() {
        this.bcc = new BdListView(this.mContext);
        this.bcc.setAlwaysDrawnWithCacheEnabled(false);
        this.bcc.setDivider(null);
        this.bcc.setDividerHeight(0);
        this.bcc.setSelector(17170445);
        this.bcc.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bcc.setOnItemClickListener(this.Hy);
        this.bcc.setAdapter((ListAdapter) this.bce);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bcd = iVar;
            this.bbI = iVar.NE();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ek> list) {
        this.mData = list;
        this.bce.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bcc;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vB() {
        this.bce.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int NC() {
        return 0;
    }
}
