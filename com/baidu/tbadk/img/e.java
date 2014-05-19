package com.baidu.tbadk.img;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class e {
    public Context a;
    private Queue<f> b = new ConcurrentLinkedQueue();
    private volatile g c;

    public e(Context context) {
        this.a = context;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.e.a().c(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z) {
        com.baidu.adp.widget.a.a a = a(imageFileInfo, z);
        if (a == null) {
            f fVar = new f(this, null);
            fVar.b = dVar;
            fVar.a = imageFileInfo;
            fVar.c = z;
            this.b.add(fVar);
            a();
            return null;
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.c == null && !this.b.isEmpty()) {
            this.c = new g(this, this.b);
            this.c.execute(new Void[0]);
        }
    }

    public void b() {
        this.b = new ConcurrentLinkedQueue();
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
    }

    public Bitmap b(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (z && imageFileInfo.getPersistActionsList() != null) {
            linkedList.addAll(imageFileInfo.getPersistActionsList());
        }
        if (imageFileInfo.getPageActionsList() != null) {
            linkedList.addAll(imageFileInfo.getPageActionsList());
        }
        if (imageFileInfo.getOrginalBitmap() != null) {
            try {
                return com.baidu.tbadk.img.effect.c.a().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.a().a(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.g.a(imageFileInfo.getFilePath());
        }
    }
}
