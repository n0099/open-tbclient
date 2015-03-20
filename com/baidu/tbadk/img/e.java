package com.baidu.tbadk.img;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class e {
    private Queue<f> alf = new ConcurrentLinkedQueue();
    private volatile g alg;
    public Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.e.zs().er(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a = a(imageFileInfo, z);
        if (a == null) {
            if (z2) {
                return null;
            }
            f fVar = new f(this, null);
            fVar.ali = dVar;
            fVar.alh = imageFileInfo;
            fVar.alj = z;
            this.alf.add(fVar);
            zz();
            return null;
        }
        return a;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z) {
        return a(imageFileInfo, dVar, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zz() {
        if (this.alg == null && !this.alf.isEmpty()) {
            this.alg = new g(this, this.alf);
            this.alg.execute(new Void[0]);
        }
    }

    public void zA() {
        this.alf = new ConcurrentLinkedQueue();
        if (this.alg != null) {
            this.alg.cancel(true);
            this.alg = null;
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
                return com.baidu.tbadk.img.effect.c.zB().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.zB().b(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.ce(imageFileInfo.getFilePath());
        }
    }
}
