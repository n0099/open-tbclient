package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class m extends Handler {
    final /* synthetic */ JigsawAlbumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.a = jigsawAlbumListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.a.a(message.arg1, (Bitmap) message.obj);
                return;
            default:
                return;
        }
    }
}
