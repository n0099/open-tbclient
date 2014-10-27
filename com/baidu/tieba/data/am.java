package com.baidu.tieba.data;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.pb.main.PbActivity;
/* loaded from: classes.dex */
class am extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ al amn;
    private final /* synthetic */ com.baidu.tbadk.widget.m amo;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, com.baidu.tbadk.widget.m mVar, Context context) {
        this.amn = alVar;
        this.amo = mVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ak akVar;
        ListAdapter adapter;
        super.a((am) aVar, str, i);
        if (aVar != null && aVar.hm()) {
            akVar = this.amn.aml;
            this.amo.setDrawable(akVar.e(aVar));
            if (this.val$context instanceof PbActivity) {
                PbActivity pbActivity = (PbActivity) this.val$context;
                if (!pbActivity.isFinishing() && (adapter = pbActivity.getListView().getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
        }
    }
}
