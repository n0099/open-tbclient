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
    private BdListView biH;
    private i biI;
    private i.a bin;
    private Context mContext;
    private List<fc> mData;
    private final BaseAdapter biJ = new n(this);
    private AdapterView.OnItemClickListener HP = new o(this);

    private void initView() {
        this.biH = new BdListView(this.mContext);
        this.biH.setAlwaysDrawnWithCacheEnabled(false);
        this.biH.setDivider(null);
        this.biH.setDividerHeight(0);
        this.biH.setSelector(17170445);
        this.biH.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.biH.setOnItemClickListener(this.HP);
        this.biH.setAdapter((ListAdapter) this.biJ);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, i iVar) {
        if (context != null && iVar != null) {
            this.mContext = context;
            this.biI = iVar;
            this.bin = iVar.Pk();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<fc> list) {
        this.mData = list;
        this.biJ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.biH;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void wh() {
        this.biJ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int Pi() {
        return 0;
    }
}
