package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class e implements Handler.Callback {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        m mVar;
        m mVar2;
        k kVar;
        ArrayList arrayList;
        k kVar2;
        k kVar3;
        k kVar4;
        Runnable runnable;
        switch (message.what) {
            case 1:
                kVar3 = this.a.i;
                kVar3.a((List<c>) null);
                kVar4 = this.a.i;
                kVar4.notifyDataSetChanged();
                runnable = this.a.w;
                new Thread(runnable).start();
                break;
            case 2:
                this.a.l = new m(this.a);
                mVar = this.a.l;
                mVar.setDaemon(true);
                mVar2 = this.a.l;
                mVar2.start();
                kVar = this.a.i;
                arrayList = this.a.f;
                kVar.a(arrayList);
                kVar2 = this.a.i;
                kVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
