package com.baidu.tbadk.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.a.c();
        handler = this.a.u;
        handler2 = this.a.u;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
