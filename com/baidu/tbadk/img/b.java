package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> axV = new ConcurrentLinkedQueue();
    private volatile C0054b axW;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.EO().fP(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.axY = bVar;
            aVar.axX = imageFileInfo;
            aVar.axZ = z;
            this.axV.add(aVar);
            ET();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void ET() {
        if (this.axW == null && !this.axV.isEmpty()) {
            this.axW = new C0054b(this.axV);
            this.axW.execute(new Void[0]);
        }
    }

    public void EU() {
        this.axV = new ConcurrentLinkedQueue();
        if (this.axW != null) {
            this.axW.cancel(true);
            this.axW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054b extends BdAsyncTask<Void, a, a> {
        final Queue<a> ayd;

        public C0054b(Queue<a> queue) {
            this.ayd = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.ayd.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.ayd.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fP = com.baidu.tbadk.imageManager.c.EO().fP(poll.axX.toCachedKey(poll.axZ));
                    if (fP != null) {
                        poll.aya = fP;
                        poll.ayb = true;
                    } else {
                        Bitmap b = b.this.b(poll.axX, poll.axZ);
                        if (b != null) {
                            poll.aya = new com.baidu.adp.widget.a.a(b, false, poll.axX.getFilePath());
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
            b.this.axW = null;
            b.this.ET();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aya;
                    if (aVar2 != null && !aVar.ayb) {
                        com.baidu.tbadk.imageManager.c.EO().c(aVar.axX.toCachedKey(aVar.axZ), aVar2);
                    }
                    if (aVar.axY != null) {
                        aVar.axY.a(aVar2, aVar.axX.toCachedKey(aVar.axZ), aVar.ayb);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.axW = null;
            while (true) {
                a poll = this.ayd.poll();
                if (poll != null) {
                    if (poll.axY != null) {
                        poll.axY.a(null, poll.axX.toCachedKey(poll.axZ), false);
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
                return com.baidu.tbadk.img.effect.c.EW().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EW().b(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo axX;
        com.baidu.tbadk.imageManager.b axY;
        boolean axZ;
        com.baidu.adp.widget.a.a aya;
        boolean ayb;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
