package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ JigsawAlbumActivity Wv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wv = jigsawAlbumActivity;
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
                jVar3 = this.Wv.Wg;
                jVar3.p(null);
                jVar4 = this.Wv.Wg;
                jVar4.notifyDataSetChanged();
                runnable = this.Wv.mRunnable;
                new Thread(runnable).start();
                break;
            case 2:
                this.Wv.Wj = new l(this.Wv);
                lVar = this.Wv.Wj;
                lVar.setDaemon(true);
                lVar2 = this.Wv.Wj;
                lVar2.start();
                jVar = this.Wv.Wg;
                arrayList = this.Wv.We;
                jVar.p(arrayList);
                jVar2 = this.Wv.Wg;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
