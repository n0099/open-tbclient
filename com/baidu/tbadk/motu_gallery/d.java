package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ JigsawAlbumActivity Wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wz = jigsawAlbumActivity;
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
                jVar3 = this.Wz.Wk;
                jVar3.p(null);
                jVar4 = this.Wz.Wk;
                jVar4.notifyDataSetChanged();
                runnable = this.Wz.mRunnable;
                new Thread(runnable).start();
                break;
            case 2:
                this.Wz.Wn = new l(this.Wz);
                lVar = this.Wz.Wn;
                lVar.setDaemon(true);
                lVar2 = this.Wz.Wn;
                lVar2.start();
                jVar = this.Wz.Wk;
                arrayList = this.Wz.Wi;
                jVar.p(arrayList);
                jVar2 = this.Wz.Wk;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
