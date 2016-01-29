package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> axo = new ConcurrentLinkedQueue();
    private volatile C0054b axp;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ed().fH(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.axr = bVar;
            aVar.axq = imageFileInfo;
            aVar.axs = z;
            this.axo.add(aVar);
            Ei();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ei() {
        if (this.axp == null && !this.axo.isEmpty()) {
            this.axp = new C0054b(this.axo);
            this.axp.execute(new Void[0]);
        }
    }

    public void Ej() {
        this.axo = new ConcurrentLinkedQueue();
        if (this.axp != null) {
            this.axp.cancel(true);
            this.axp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054b extends BdAsyncTask<Void, a, a> {
        final Queue<a> axw;

        public C0054b(Queue<a> queue) {
            this.axw = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.axw.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.axw.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fH = com.baidu.tbadk.imageManager.c.Ed().fH(poll.axq.toCachedKey(poll.axs));
                    if (fH != null) {
                        poll.axt = fH;
                        poll.axu = true;
                    } else {
                        Bitmap b = b.this.b(poll.axq, poll.axs);
                        if (b != null) {
                            poll.axt = new com.baidu.adp.widget.a.a(b, false, poll.axq.getFilePath());
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
            b.this.axp = null;
            b.this.Ei();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.axt;
                    if (aVar2 != null && !aVar.axu) {
                        com.baidu.tbadk.imageManager.c.Ed().c(aVar.axq.toCachedKey(aVar.axs), aVar2);
                    }
                    if (aVar.axr != null) {
                        aVar.axr.a(aVar2, aVar.axq.toCachedKey(aVar.axs), aVar.axu);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.axp = null;
            while (true) {
                a poll = this.axw.poll();
                if (poll != null) {
                    if (poll.axr != null) {
                        poll.axr.a(null, poll.axq.toCachedKey(poll.axs), false);
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
                return com.baidu.tbadk.img.effect.c.Ek().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Ek().d(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo axq;
        com.baidu.tbadk.imageManager.b axr;
        boolean axs;
        com.baidu.adp.widget.a.a axt;
        boolean axu;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
