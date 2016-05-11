package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> atW = new ConcurrentLinkedQueue();
    private volatile C0045b atX;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.CH().fM(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.atZ = bVar;
            aVar.atY = imageFileInfo;
            aVar.aua = z;
            this.atW.add(aVar);
            CM();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void CM() {
        if (this.atX == null && !this.atW.isEmpty()) {
            this.atX = new C0045b(this.atW);
            this.atX.execute(new Void[0]);
        }
    }

    public void CN() {
        this.atW = new ConcurrentLinkedQueue();
        if (this.atX != null) {
            this.atX.cancel(true);
            this.atX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aue;

        public C0045b(Queue<a> queue) {
            this.aue = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.aue.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aue.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fM = com.baidu.tbadk.imageManager.c.CH().fM(poll.atY.toCachedKey(poll.aua));
                    if (fM != null) {
                        poll.aub = fM;
                        poll.auc = true;
                    } else {
                        Bitmap b = b.this.b(poll.atY, poll.aua);
                        if (b != null) {
                            poll.aub = new com.baidu.adp.widget.a.a(b, false, poll.atY.getFilePath());
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
            b.this.atX = null;
            b.this.CM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aub;
                    if (aVar2 != null && !aVar.auc) {
                        com.baidu.tbadk.imageManager.c.CH().c(aVar.atY.toCachedKey(aVar.aua), aVar2);
                    }
                    if (aVar.atZ != null) {
                        aVar.atZ.a(aVar2, aVar.atY.toCachedKey(aVar.aua), aVar.auc);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.atX = null;
            while (true) {
                a poll = this.aue.poll();
                if (poll != null) {
                    if (poll.atZ != null) {
                        poll.atZ.a(null, poll.atY.toCachedKey(poll.aua), false);
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
                return com.baidu.tbadk.img.effect.c.CO().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.CO().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo atY;
        com.baidu.tbadk.imageManager.b atZ;
        boolean aua;
        com.baidu.adp.widget.a.a aub;
        boolean auc;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
