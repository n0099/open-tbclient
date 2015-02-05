package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ JigsawAlbumActivity acZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acZ = jigsawAlbumActivity;
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
                jVar3 = this.acZ.acK;
                jVar3.t(null);
                jVar4 = this.acZ.acK;
                jVar4.notifyDataSetChanged();
                runnable = this.acZ.mRunnable;
                new Thread(runnable).start();
                break;
            case 2:
                this.acZ.acN = new l(this.acZ);
                lVar = this.acZ.acN;
                lVar.setDaemon(true);
                lVar2 = this.acZ.acN;
                lVar2.start();
                jVar = this.acZ.acK;
                arrayList = this.acZ.acI;
                jVar.t(arrayList);
                jVar2 = this.acZ.acK;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
