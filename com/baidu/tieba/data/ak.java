package com.baidu.tieba.data;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.pb.main.PbActivity;
/* loaded from: classes.dex */
class ak implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ aj a;
    private final /* synthetic */ com.baidu.adp.widget.r b;
    private final /* synthetic */ Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, com.baidu.adp.widget.r rVar, Context context) {
        this.a = ajVar;
        this.b = rVar;
        this.c = context;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ai aiVar;
        ListAdapter adapter;
        if (aVar != null && aVar.i()) {
            aiVar = this.a.a;
            this.b.a(aiVar.a(aVar));
            if (this.c instanceof PbActivity) {
                PbActivity pbActivity = (PbActivity) this.c;
                if (!pbActivity.isFinishing() && (adapter = pbActivity.a().getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
        }
    }
}
