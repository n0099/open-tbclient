package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ JigsawAlbumActivity Wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wz = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.Wz.refresh();
        handler = this.Wz.mHandler;
        handler2 = this.Wz.mHandler;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
