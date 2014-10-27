package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ JigsawAlbumActivity Wv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wv = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.Wv.refresh();
        handler = this.Wv.mHandler;
        handler2 = this.Wv.mHandler;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
