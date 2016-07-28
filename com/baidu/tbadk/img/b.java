package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> avB = new ConcurrentLinkedQueue();
    private volatile C0046b avC;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.CP().fQ(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.avE = bVar;
            aVar.avD = imageFileInfo;
            aVar.avF = z;
            this.avB.add(aVar);
            CU();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void CU() {
        if (this.avC == null && !this.avB.isEmpty()) {
            this.avC = new C0046b(this.avB);
            this.avC.execute(new Void[0]);
        }
    }

    public void CV() {
        this.avB = new ConcurrentLinkedQueue();
        if (this.avC != null) {
            this.avC.cancel(true);
            this.avC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046b extends BdAsyncTask<Void, a, a> {
        final Queue<a> avJ;

        public C0046b(Queue<a> queue) {
            this.avJ = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.avJ.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.avJ.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fQ = com.baidu.tbadk.imageManager.c.CP().fQ(poll.avD.toCachedKey(poll.avF));
                    if (fQ != null) {
                        poll.avG = fQ;
                        poll.avH = true;
                    } else {
                        Bitmap b = b.this.b(poll.avD, poll.avF);
                        if (b != null) {
                            poll.avG = new com.baidu.adp.widget.a.a(b, false, poll.avD.getFilePath());
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
            b.this.avC = null;
            b.this.CU();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.avG;
                    if (aVar2 != null && !aVar.avH) {
                        com.baidu.tbadk.imageManager.c.CP().c(aVar.avD.toCachedKey(aVar.avF), aVar2);
                    }
                    if (aVar.avE != null) {
                        aVar.avE.a(aVar2, aVar.avD.toCachedKey(aVar.avF), aVar.avH);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.avC = null;
            while (true) {
                a poll = this.avJ.poll();
                if (poll != null) {
                    if (poll.avE != null) {
                        poll.avE.a(null, poll.avD.toCachedKey(poll.avF), false);
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
                return com.baidu.tbadk.img.effect.c.CW().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.CW().c(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        ImageFileInfo avD;
        com.baidu.tbadk.imageManager.b avE;
        boolean avF;
        com.baidu.adp.widget.a.a avG;
        boolean avH;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
