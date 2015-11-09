package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> asP = new ConcurrentLinkedQueue();
    private volatile C0051b asQ;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.BV().fq(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.asS = bVar;
            aVar.asR = imageFileInfo;
            aVar.asT = z;
            this.asP.add(aVar);
            Cb();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Cb() {
        if (this.asQ == null && !this.asP.isEmpty()) {
            this.asQ = new C0051b(this.asP);
            this.asQ.execute(new Void[0]);
        }
    }

    public void Cc() {
        this.asP = new ConcurrentLinkedQueue();
        if (this.asQ != null) {
            this.asQ.cancel(true);
            this.asQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b extends BdAsyncTask<Void, a, a> {
        final Queue<a> asX;

        public C0051b(Queue<a> queue) {
            this.asX = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.asX.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.asX.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fq = com.baidu.tbadk.imageManager.c.BV().fq(poll.asR.toCachedKey(poll.asT));
                    if (fq != null) {
                        poll.asU = fq;
                        poll.asV = true;
                    } else {
                        Bitmap b = b.this.b(poll.asR, poll.asT);
                        if (b != null) {
                            poll.asU = new com.baidu.adp.widget.a.a(b, false, poll.asR.getFilePath());
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
            b.this.asQ = null;
            b.this.Cb();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.asU;
                    if (aVar2 != null && !aVar.asV) {
                        com.baidu.tbadk.imageManager.c.BV().c(aVar.asR.toCachedKey(aVar.asT), aVar2);
                    }
                    if (aVar.asS != null) {
                        aVar.asS.a(aVar2, aVar.asR.toCachedKey(aVar.asT), aVar.asV);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.asQ = null;
            while (true) {
                a poll = this.asX.poll();
                if (poll != null) {
                    if (poll.asS != null) {
                        poll.asS.a(null, poll.asR.toCachedKey(poll.asT), false);
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
                return com.baidu.tbadk.img.effect.c.Cd().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Cd().d(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.cB(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        ImageFileInfo asR;
        com.baidu.tbadk.imageManager.b asS;
        boolean asT;
        com.baidu.adp.widget.a.a asU;
        boolean asV;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
