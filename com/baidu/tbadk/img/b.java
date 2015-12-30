package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> awx = new ConcurrentLinkedQueue();
    private volatile C0053b awy;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.CM().fJ(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.awA = bVar;
            aVar.awz = imageFileInfo;
            aVar.awB = z;
            this.awx.add(aVar);
            CR();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void CR() {
        if (this.awy == null && !this.awx.isEmpty()) {
            this.awy = new C0053b(this.awx);
            this.awy.execute(new Void[0]);
        }
    }

    public void CS() {
        this.awx = new ConcurrentLinkedQueue();
        if (this.awy != null) {
            this.awy.cancel(true);
            this.awy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0053b extends BdAsyncTask<Void, a, a> {
        final Queue<a> awF;

        public C0053b(Queue<a> queue) {
            this.awF = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.awF.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.awF.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fJ = com.baidu.tbadk.imageManager.c.CM().fJ(poll.awz.toCachedKey(poll.awB));
                    if (fJ != null) {
                        poll.awC = fJ;
                        poll.awD = true;
                    } else {
                        Bitmap b = b.this.b(poll.awz, poll.awB);
                        if (b != null) {
                            poll.awC = new com.baidu.adp.widget.a.a(b, false, poll.awz.getFilePath());
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
            b.this.awy = null;
            b.this.CR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.awC;
                    if (aVar2 != null && !aVar.awD) {
                        com.baidu.tbadk.imageManager.c.CM().c(aVar.awz.toCachedKey(aVar.awB), aVar2);
                    }
                    if (aVar.awA != null) {
                        aVar.awA.a(aVar2, aVar.awz.toCachedKey(aVar.awB), aVar.awD);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.awy = null;
            while (true) {
                a poll = this.awF.poll();
                if (poll != null) {
                    if (poll.awA != null) {
                        poll.awA.a(null, poll.awz.toCachedKey(poll.awB), false);
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
                return com.baidu.tbadk.img.effect.c.CT().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.CT().d(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.cM(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        com.baidu.tbadk.imageManager.b awA;
        boolean awB;
        com.baidu.adp.widget.a.a awC;
        boolean awD;
        ImageFileInfo awz;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
