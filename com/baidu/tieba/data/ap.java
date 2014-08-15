package com.baidu.tieba.data;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.pb.main.PbActivity;
/* loaded from: classes.dex */
class ap extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ao a;
    private final /* synthetic */ com.baidu.adp.widget.r b;
    private final /* synthetic */ Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, com.baidu.adp.widget.r rVar, Context context) {
        this.a = aoVar;
        this.b = rVar;
        this.c = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        an anVar;
        ListAdapter adapter;
        super.a((ap) aVar, str, i);
        if (aVar != null && aVar.i()) {
            anVar = this.a.a;
            this.b.a(anVar.a(aVar));
            if (this.c instanceof PbActivity) {
                PbActivity pbActivity = (PbActivity) this.c;
                if (!pbActivity.isFinishing() && (adapter = pbActivity.a().getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
        }
    }
}
