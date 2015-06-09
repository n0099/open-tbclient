package com.baidu.tbadk.img;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class e {
    private Queue<f> amo = new ConcurrentLinkedQueue();
    private volatile g amp;
    public Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.e.Am().eL(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a = a(imageFileInfo, z);
        if (a == null) {
            if (z2) {
                return null;
            }
            f fVar = new f(this, null);
            fVar.amr = dVar;
            fVar.amq = imageFileInfo;
            fVar.ams = z;
            this.amo.add(fVar);
            As();
            return null;
        }
        return a;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.d dVar, boolean z) {
        return a(imageFileInfo, dVar, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void As() {
        if (this.amp == null && !this.amo.isEmpty()) {
            this.amp = new g(this, this.amo);
            this.amp.execute(new Void[0]);
        }
    }

    public void At() {
        this.amo = new ConcurrentLinkedQueue();
        if (this.amp != null) {
            this.amp.cancel(true);
            this.amp = null;
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
                return com.baidu.tbadk.img.effect.c.Au().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Au().b(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.ct(imageFileInfo.getFilePath());
        }
    }
}
