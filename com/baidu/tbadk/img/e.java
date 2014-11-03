package com.baidu.tbadk.img;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class e {
    private Queue<f> Vb = new ConcurrentLinkedQueue();
    private volatile g Vc;
    public Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.e.si().dt(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a = a(imageFileInfo, z);
        if (a == null) {
            if (z2) {
                return null;
            }
            f fVar = new f(this, null);
            fVar.Ve = dVar;
            fVar.Vd = imageFileInfo;
            fVar.Vf = z;
            this.Vb.add(fVar);
            sp();
            return null;
        }
        return a;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z) {
        return a(imageFileInfo, dVar, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sp() {
        if (this.Vc == null && !this.Vb.isEmpty()) {
            this.Vc = new g(this, this.Vb);
            this.Vc.execute(new Void[0]);
        }
    }

    public void sq() {
        this.Vb = new ConcurrentLinkedQueue();
        if (this.Vc != null) {
            this.Vc.cancel(true);
            this.Vc = null;
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
                return com.baidu.tbadk.img.effect.c.ss().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.ss().a(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.d.bk(imageFileInfo.getFilePath());
        }
    }
}
