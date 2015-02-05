package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ JigsawAlbumListActivity adr;
    private volatile boolean ads;
    private Thread adt;

    public q(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.adr = jigsawAlbumListActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x0047 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        int i2;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap2;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap3;
        Handler handler;
        int i10;
        this.adt = Thread.currentThread();
        this.ads = false;
        while (!this.ads) {
            i = JigsawAlbumListActivity.currentPosition;
            if (i + 20 > this.adr.acM.getCount()) {
                int count = this.adr.acM.getCount();
                i10 = JigsawAlbumListActivity.currentPosition;
                i2 = count - i10;
            } else {
                i2 = 20;
            }
            viewphotoLinkedHashMap = this.adr.adi;
            if (viewphotoLinkedHashMap.size() != 0) {
                i3 = JigsawAlbumListActivity.currentPosition;
                JigsawAlbumListActivity.adl = i3;
                for (i4 = JigsawAlbumListActivity.adl; i4 < i5 + i2; i4++) {
                    i8 = JigsawAlbumListActivity.adl;
                    i9 = JigsawAlbumListActivity.currentPosition;
                    if (i8 != i9) {
                        break;
                    }
                    try {
                        viewphotoLinkedHashMap2 = this.adr.adi;
                        if (viewphotoLinkedHashMap2.containsKey(Integer.valueOf(i4))) {
                            viewphotoLinkedHashMap3 = this.adr.adi;
                            if (!viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i4)).getTag().toString().equals("bitmap")) {
                                try {
                                    Bitmap a = this.adr.acM.a(this.adr.getPageContext().getContext(), this.adr.acM.dE(i4), this.adr.ado);
                                    if (a != null) {
                                        Message message = new Message();
                                        message.obj = a;
                                        message.arg1 = i4;
                                        message.what = 0;
                                        handler = this.adr.mHandler;
                                        handler.sendMessage(message);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                i6 = JigsawAlbumListActivity.adl;
                i7 = JigsawAlbumListActivity.currentPosition;
                if (i6 == i7) {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e3) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void wz() {
        this.ads = true;
        if (this.adt != null) {
            this.adt.interrupt();
        }
    }
}
