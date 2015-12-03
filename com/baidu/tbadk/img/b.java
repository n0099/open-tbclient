package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> auT = new ConcurrentLinkedQueue();
    private volatile C0053b auU;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.CX().fF(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.auW = bVar;
            aVar.auV = imageFileInfo;
            aVar.auX = z;
            this.auT.add(aVar);
            Dc();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Dc() {
        if (this.auU == null && !this.auT.isEmpty()) {
            this.auU = new C0053b(this.auT);
            this.auU.execute(new Void[0]);
        }
    }

    public void Dd() {
        this.auT = new ConcurrentLinkedQueue();
        if (this.auU != null) {
            this.auU.cancel(true);
            this.auU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0053b extends BdAsyncTask<Void, a, a> {
        final Queue<a> avb;

        public C0053b(Queue<a> queue) {
            this.avb = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.avb.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.avb.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fF = com.baidu.tbadk.imageManager.c.CX().fF(poll.auV.toCachedKey(poll.auX));
                    if (fF != null) {
                        poll.auY = fF;
                        poll.auZ = true;
                    } else {
                        Bitmap b = b.this.b(poll.auV, poll.auX);
                        if (b != null) {
                            poll.auY = new com.baidu.adp.widget.a.a(b, false, poll.auV.getFilePath());
                        }
                    }
                    publishProgress(poll);
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(a aVar) {
            super.onPostExecute(aVar);
            b.this.auU = null;
            b.this.Dc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.auY;
                    if (aVar2 != null && !aVar.auZ) {
                        com.baidu.tbadk.imageManager.c.CX().c(aVar.auV.toCachedKey(aVar.auX), aVar2);
                    }
                    if (aVar.auW != null) {
                        aVar.auW.a(aVar2, aVar.auV.toCachedKey(aVar.auX), aVar.auZ);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.auU = null;
            while (true) {
                a poll = this.avb.poll();
                if (poll != null) {
                    if (poll.auW != null) {
                        poll.auW.a(null, poll.auV.toCachedKey(poll.auX), false);
                    }
                } else {
                    return;
                }
            }
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
                return com.baidu.tbadk.img.effect.c.De().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.De().d(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.cJ(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        ImageFileInfo auV;
        com.baidu.tbadk.imageManager.b auW;
        boolean auX;
        com.baidu.adp.widget.a.a auY;
        boolean auZ;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
