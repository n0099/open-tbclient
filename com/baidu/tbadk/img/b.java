package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aua = new ConcurrentLinkedQueue();
    private volatile C0051b aub;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Cf().fo(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aud = bVar;
            aVar.auc = imageFileInfo;
            aVar.aue = z;
            this.aua.add(aVar);
            Cl();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Cl() {
        if (this.aub == null && !this.aua.isEmpty()) {
            this.aub = new C0051b(this.aua);
            this.aub.execute(new Void[0]);
        }
    }

    public void Cm() {
        this.aua = new ConcurrentLinkedQueue();
        if (this.aub != null) {
            this.aub.cancel(true);
            this.aub = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0051b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aui;

        public C0051b(Queue<a> queue) {
            this.aui = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            while (true) {
                a poll = this.aui.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aui.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fo = com.baidu.tbadk.imageManager.c.Cf().fo(poll.auc.toCachedKey(poll.aue));
                    if (fo != null) {
                        poll.auf = fo;
                        poll.aug = true;
                    } else {
                        Bitmap b = b.this.b(poll.auc, poll.aue);
                        if (b != null) {
                            poll.auf = new com.baidu.adp.widget.a.a(b, false, poll.auc.getFilePath());
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
            b.this.aub = null;
            b.this.Cl();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.auf;
                    if (aVar2 != null && !aVar.aug) {
                        com.baidu.tbadk.imageManager.c.Cf().c(aVar.auc.toCachedKey(aVar.aue), aVar2);
                    }
                    if (aVar.aud != null) {
                        aVar.aud.a(aVar2, aVar.auc.toCachedKey(aVar.aue), aVar.aug);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aub = null;
            while (true) {
                a poll = this.aui.poll();
                if (poll != null) {
                    if (poll.aud != null) {
                        poll.aud.a(null, poll.auc.toCachedKey(poll.aue), false);
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
                return com.baidu.tbadk.img.effect.c.Cn().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Cn().d(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo auc;
        com.baidu.tbadk.imageManager.b aud;
        boolean aue;
        com.baidu.adp.widget.a.a auf;
        boolean aug;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
