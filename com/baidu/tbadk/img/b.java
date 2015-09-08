package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> avD = new ConcurrentLinkedQueue();
    private volatile C0051b avE;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Cs().fj(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.avG = bVar;
            aVar.avF = imageFileInfo;
            aVar.avH = z;
            this.avD.add(aVar);
            Cy();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Cy() {
        if (this.avE == null && !this.avD.isEmpty()) {
            this.avE = new C0051b(this.avD);
            this.avE.execute(new Void[0]);
        }
    }

    public void Cz() {
        this.avD = new ConcurrentLinkedQueue();
        if (this.avE != null) {
            this.avE.cancel(true);
            this.avE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b extends BdAsyncTask<Void, a, a> {
        final Queue<a> avL;

        public C0051b(Queue<a> queue) {
            this.avL = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.avL.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.avL.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fj = com.baidu.tbadk.imageManager.c.Cs().fj(poll.avF.toCachedKey(poll.avH));
                    if (fj != null) {
                        poll.avI = fj;
                        poll.avJ = true;
                    } else {
                        Bitmap b = b.this.b(poll.avF, poll.avH);
                        if (b != null) {
                            poll.avI = new com.baidu.adp.widget.a.a(b, false, poll.avF.getFilePath());
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
            b.this.avE = null;
            b.this.Cy();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.avI;
                    if (aVar2 != null && !aVar.avJ) {
                        com.baidu.tbadk.imageManager.c.Cs().c(aVar.avF.toCachedKey(aVar.avH), aVar2);
                    }
                    if (aVar.avG != null) {
                        aVar.avG.a(aVar2, aVar.avF.toCachedKey(aVar.avH), aVar.avJ);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.avE = null;
            while (true) {
                a poll = this.avL.poll();
                if (poll != null) {
                    if (poll.avG != null) {
                        poll.avG.a(null, poll.avF.toCachedKey(poll.avH), false);
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
                return com.baidu.tbadk.img.effect.c.CA().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.CA().d(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.cA(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        ImageFileInfo avF;
        com.baidu.tbadk.imageManager.b avG;
        boolean avH;
        com.baidu.adp.widget.a.a avI;
        boolean avJ;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
