package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import java.util.List;
/* loaded from: classes.dex */
public class m implements f {
    private i.a bmd;
    private BdListView bmy;
    private i bmz;
    private Context mContext;
    private List<fc> mData;
    private final BaseAdapter bmA = new n(this);
    private AdapterView.OnItemClickListener If = new o(this);

    private void initView() {
        this.bmy = new BdListView(this.mContext);
        this.bmy.setAlwaysDrawnWithCacheEnabled(false);
        this.bmy.setDivider(null);
        this.bmy.setDividerHeight(0);
        this.bmy.setSelector(17170445);
        this.bmy.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bmy.setOnItemClickListener(this.If);
        this.bmy.setAdapter((ListAdapter) this.bmA);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.bmz = iVar;
            this.bmd = iVar.PC();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fc> list) {
        this.mData = list;
        this.bmA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bmy;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void vR() {
        this.bmA.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int PA() {
        return 0;
    }
}
