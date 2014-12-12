package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ JigsawAlbumActivity acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acF = jigsawAlbumActivity;
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
                jVar3 = this.acF.acp;
                jVar3.t(null);
                jVar4 = this.acF.acp;
                jVar4.notifyDataSetChanged();
                runnable = this.acF.mRunnable;
                new Thread(runnable).start();
                break;
            case 2:
                this.acF.acs = new l(this.acF);
                lVar = this.acF.acs;
                lVar.setDaemon(true);
                lVar2 = this.acF.acs;
                lVar2.start();
                jVar = this.acF.acp;
                arrayList = this.acF.acn;
                jVar.t(arrayList);
                jVar2 = this.acF.acp;
                jVar2.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
