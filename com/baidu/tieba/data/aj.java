package com.baidu.tieba.data;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.pb.main.PbActivity;
/* loaded from: classes.dex */
class aj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ai a;
    private final /* synthetic */ com.baidu.adp.widget.r b;
    private final /* synthetic */ Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, com.baidu.adp.widget.r rVar, Context context) {
        this.a = aiVar;
        this.b = rVar;
        this.c = context;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ah ahVar;
        ListAdapter adapter;
        if (aVar != null && aVar.i()) {
            ahVar = this.a.a;
            this.b.a(ahVar.a(aVar));
            if (this.c instanceof PbActivity) {
                PbActivity pbActivity = (PbActivity) this.c;
                if (!pbActivity.isFinishing() && (adapter = pbActivity.a().getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
        }
    }
}
