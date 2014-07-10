package com.baidu.tieba.data;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.pb.main.PbActivity;
/* loaded from: classes.dex */
class ao implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ an a;
    private final /* synthetic */ com.baidu.adp.widget.r b;
    private final /* synthetic */ Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, com.baidu.adp.widget.r rVar, Context context) {
        this.a = anVar;
        this.b = rVar;
        this.c = context;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        am amVar;
        ListAdapter adapter;
        if (aVar != null && aVar.i()) {
            amVar = this.a.a;
            this.b.a(amVar.a(aVar));
            if (this.c instanceof PbActivity) {
                PbActivity pbActivity = (PbActivity) this.c;
                if (!pbActivity.isFinishing() && (adapter = pbActivity.a().getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
        }
    }
}
