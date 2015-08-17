package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> atT = new ConcurrentLinkedQueue();
    private volatile C0051b atU;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ce().fb(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.atW = bVar;
            aVar.atV = imageFileInfo;
            aVar.atX = z;
            this.atT.add(aVar);
            Ck();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ck() {
        if (this.atU == null && !this.atT.isEmpty()) {
            this.atU = new C0051b(this.atT);
            this.atU.execute(new Void[0]);
        }
    }

    public void Cl() {
        this.atT = new ConcurrentLinkedQueue();
        if (this.atU != null) {
            this.atU.cancel(true);
            this.atU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aub;

        public C0051b(Queue<a> queue) {
            this.aub = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.aub.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aub.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fb = com.baidu.tbadk.imageManager.c.Ce().fb(poll.atV.toCachedKey(poll.atX));
                    if (fb != null) {
                        poll.atY = fb;
                        poll.atZ = true;
                    } else {
                        Bitmap b = b.this.b(poll.atV, poll.atX);
                        if (b != null) {
                            poll.atY = new com.baidu.adp.widget.a.a(b, false, poll.atV.getFilePath());
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
            b.this.atU = null;
            b.this.Ck();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.atY;
                    if (aVar2 != null && !aVar.atZ) {
                        com.baidu.tbadk.imageManager.c.Ce().c(aVar.atV.toCachedKey(aVar.atX), aVar2);
                    }
                    if (aVar.atW != null) {
                        aVar.atW.a(aVar2, aVar.atV.toCachedKey(aVar.atX), aVar.atZ);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.atU = null;
            while (true) {
                a poll = this.aub.poll();
                if (poll != null) {
                    if (poll.atW != null) {
                        poll.atW.a(null, poll.atV.toCachedKey(poll.atX), false);
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
                return com.baidu.tbadk.img.effect.c.Cm().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Cm().d(imageFileInfo.getFilePath(), linkedList);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return com.baidu.tbadk.core.util.c.cu(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        ImageFileInfo atV;
        com.baidu.tbadk.imageManager.b atW;
        boolean atX;
        com.baidu.adp.widget.a.a atY;
        boolean atZ;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
