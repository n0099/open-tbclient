package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ JigsawAlbumActivity adc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.adc = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.adc.refresh();
        handler = this.adc.mHandler;
        handler2 = this.adc.mHandler;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
