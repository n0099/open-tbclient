package com.baidu.tbadk.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ JigsawAlbumListActivity adu;
    private volatile boolean adv;
    private Thread adw;

    public q(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.adu = jigsawAlbumListActivity;
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
        this.adw = Thread.currentThread();
        this.adv = false;
        while (!this.adv) {
            i = JigsawAlbumListActivity.currentPosition;
            if (i + 20 > this.adu.acP.getCount()) {
                int count = this.adu.acP.getCount();
                i10 = JigsawAlbumListActivity.currentPosition;
                i2 = count - i10;
            } else {
                i2 = 20;
            }
            viewphotoLinkedHashMap = this.adu.adl;
            if (viewphotoLinkedHashMap.size() != 0) {
                i3 = JigsawAlbumListActivity.currentPosition;
                JigsawAlbumListActivity.ado = i3;
                for (i4 = JigsawAlbumListActivity.ado; i4 < i5 + i2; i4++) {
                    i8 = JigsawAlbumListActivity.ado;
                    i9 = JigsawAlbumListActivity.currentPosition;
                    if (i8 != i9) {
                        break;
                    }
                    try {
                        viewphotoLinkedHashMap2 = this.adu.adl;
                        if (viewphotoLinkedHashMap2.containsKey(Integer.valueOf(i4))) {
                            viewphotoLinkedHashMap3 = this.adu.adl;
                            if (!viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i4)).getTag().toString().equals("bitmap")) {
                                try {
                                    Bitmap a = this.adu.acP.a(this.adu.getPageContext().getContext(), this.adu.acP.dE(i4), this.adu.adr);
                                    if (a != null) {
                                        Message message = new Message();
                                        message.obj = a;
                                        message.arg1 = i4;
                                        message.what = 0;
                                        handler = this.adu.mHandler;
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
                i6 = JigsawAlbumListActivity.ado;
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

    public void wF() {
        this.adv = true;
        if (this.adw != null) {
            this.adw.interrupt();
        }
    }
}
