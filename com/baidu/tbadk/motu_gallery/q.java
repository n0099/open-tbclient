package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ JigsawAlbumListActivity WR;
    private volatile boolean WS;
    private Thread WT;

    public q(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.WR = jigsawAlbumListActivity;
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
        this.WT = Thread.currentThread();
        this.WS = false;
        while (!this.WS) {
            i = JigsawAlbumListActivity.currentPosition;
            if (i + 20 > this.WR.Wm.getCount()) {
                int count = this.WR.Wm.getCount();
                i10 = JigsawAlbumListActivity.currentPosition;
                i2 = count - i10;
            } else {
                i2 = 20;
            }
            viewphotoLinkedHashMap = this.WR.WI;
            if (viewphotoLinkedHashMap.size() != 0) {
                i3 = JigsawAlbumListActivity.currentPosition;
                JigsawAlbumListActivity.WL = i3;
                for (i4 = JigsawAlbumListActivity.WL; i4 < i5 + i2; i4++) {
                    i8 = JigsawAlbumListActivity.WL;
                    i9 = JigsawAlbumListActivity.currentPosition;
                    if (i8 != i9) {
                        break;
                    }
                    try {
                        viewphotoLinkedHashMap2 = this.WR.WI;
                        if (viewphotoLinkedHashMap2.containsKey(Integer.valueOf(i4))) {
                            viewphotoLinkedHashMap3 = this.WR.WI;
                            if (!viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i4)).getTag().toString().equals("bitmap")) {
                                try {
                                    Bitmap a = this.WR.Wm.a(this.WR, this.WR.Wm.db(i4), this.WR.WO);
                                    if (a != null) {
                                        Message message = new Message();
                                        message.obj = a;
                                        message.arg1 = i4;
                                        message.what = 0;
                                        handler = this.WR.mHandler;
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
                i6 = JigsawAlbumListActivity.WL;
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

    public void sN() {
        this.WS = true;
        if (this.WT != null) {
            this.WT.interrupt();
        }
    }
}
