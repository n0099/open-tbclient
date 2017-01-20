package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import java.util.List;
/* loaded from: classes.dex */
public class n implements f {
    private List<ct> aPE;
    private BdListView bTP;
    private j bTQ;
    private j.b bTu;
    private Context mContext;
    private final BaseAdapter bTR = new o(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new p(this);

    private void initView() {
        this.bTP = new BdListView(this.mContext);
        this.bTP.setAlwaysDrawnWithCacheEnabled(false);
        this.bTP.setDivider(null);
        this.bTP.setDividerHeight(0);
        this.bTP.setSelector(17170445);
        this.bTP.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.bTP.setOnItemClickListener(this.mOnItemClickListener);
        this.bTP.setAdapter((ListAdapter) this.bTR);
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            this.mContext = context;
            this.bTQ = jVar;
            this.bTu = jVar.acC();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void setData(List<ct> list) {
        this.aPE = list;
        this.bTR.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public View getView() {
        return this.bTP;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void ws() {
        this.bTR.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.f
    public int acz() {
        return 0;
    }
}
