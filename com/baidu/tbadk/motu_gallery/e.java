package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ JigsawAlbumActivity acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acF = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.acF.refresh();
        handler = this.acF.mHandler;
        handler2 = this.acF.mHandler;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
