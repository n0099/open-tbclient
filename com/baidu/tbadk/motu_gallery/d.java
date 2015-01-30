package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ JigsawAlbumActivity adc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.adc = jigsawAlbumActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        l lVar;
        l lVar2;
        j jVar;
        ArrayList arrayList;
        j jVar2;
        j jVar3;
        j jVar4;
        Runnable runnable;
        switch (message.what) {
            case 1:
                jVar3 = this.adc.acN;
                jVar3.t(null);
                jVar4 = this.adc.acN;
                jVar4.notifyDataSetChanged();
                runnable = this.adc.mRunnable;
                new Thread(runnable).start();
                break;
            case 2:
                this.adc.acQ = new l(this.adc);
                lVar = this.adc.acQ;
                lVar.setDaemon(true);
                lVar2 = this.adc.acQ;
                lVar2.start();
                jVar = this.adc.acN;
                arrayList = this.adc.acL;
                jVar.t(arrayList);
                jVar2 = this.adc.acN;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
