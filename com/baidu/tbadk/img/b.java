package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> auM = new ConcurrentLinkedQueue();
    private volatile C0045b auN;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.CQ().fS(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.auP = bVar;
            aVar.auO = imageFileInfo;
            aVar.auQ = z;
            this.auM.add(aVar);
            CV();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void CV() {
        if (this.auN == null && !this.auM.isEmpty()) {
            this.auN = new C0045b(this.auM);
            this.auN.execute(new Void[0]);
        }
    }

    public void CW() {
        this.auM = new ConcurrentLinkedQueue();
        if (this.auN != null) {
            this.auN.cancel(true);
            this.auN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b extends BdAsyncTask<Void, a, a> {
        final Queue<a> auU;

        public C0045b(Queue<a> queue) {
            this.auU = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.auU.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.auU.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fS = com.baidu.tbadk.imageManager.c.CQ().fS(poll.auO.toCachedKey(poll.auQ));
                    if (fS != null) {
                        poll.auR = fS;
                        poll.auS = true;
                    } else {
                        Bitmap b = b.this.b(poll.auO, poll.auQ);
                        if (b != null) {
                            poll.auR = new com.baidu.adp.widget.a.a(b, false, poll.auO.getFilePath());
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
            b.this.auN = null;
            b.this.CV();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.auR;
                    if (aVar2 != null && !aVar.auS) {
                        com.baidu.tbadk.imageManager.c.CQ().c(aVar.auO.toCachedKey(aVar.auQ), aVar2);
                    }
                    if (aVar.auP != null) {
                        aVar.auP.a(aVar2, aVar.auO.toCachedKey(aVar.auQ), aVar.auS);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.auN = null;
            while (true) {
                a poll = this.auU.poll();
                if (poll != null) {
                    if (poll.auP != null) {
                        poll.auP.a(null, poll.auO.toCachedKey(poll.auQ), false);
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
                return com.baidu.tbadk.img.effect.c.CX().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.CX().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo auO;
        com.baidu.tbadk.imageManager.b auP;
        boolean auQ;
        com.baidu.adp.widget.a.a auR;
        boolean auS;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
