package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aub = new ConcurrentLinkedQueue();
    private volatile C0051b auc;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Cc().fo(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aue = bVar;
            aVar.aud = imageFileInfo;
            aVar.auf = z;
            this.aub.add(aVar);
            Ci();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ci() {
        if (this.auc == null && !this.aub.isEmpty()) {
            this.auc = new C0051b(this.aub);
            this.auc.execute(new Void[0]);
        }
    }

    public void Cj() {
        this.aub = new ConcurrentLinkedQueue();
        if (this.auc != null) {
            this.auc.cancel(true);
            this.auc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b extends BdAsyncTask<Void, a, a> {
        final Queue<a> auj;

        public C0051b(Queue<a> queue) {
            this.auj = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.auj.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.auj.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fo = com.baidu.tbadk.imageManager.c.Cc().fo(poll.aud.toCachedKey(poll.auf));
                    if (fo != null) {
                        poll.aug = fo;
                        poll.auh = true;
                    } else {
                        Bitmap b = b.this.b(poll.aud, poll.auf);
                        if (b != null) {
                            poll.aug = new com.baidu.adp.widget.a.a(b, false, poll.aud.getFilePath());
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
            b.this.auc = null;
            b.this.Ci();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aug;
                    if (aVar2 != null && !aVar.auh) {
                        com.baidu.tbadk.imageManager.c.Cc().c(aVar.aud.toCachedKey(aVar.auf), aVar2);
                    }
                    if (aVar.aue != null) {
                        aVar.aue.a(aVar2, aVar.aud.toCachedKey(aVar.auf), aVar.auh);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.auc = null;
            while (true) {
                a poll = this.auj.poll();
                if (poll != null) {
                    if (poll.aue != null) {
                        poll.aue.a(null, poll.aud.toCachedKey(poll.auf), false);
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
                return com.baidu.tbadk.img.effect.c.Ck().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Ck().d(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aud;
        com.baidu.tbadk.imageManager.b aue;
        boolean auf;
        com.baidu.adp.widget.a.a aug;
        boolean auh;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
