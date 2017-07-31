package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aGA = new ConcurrentLinkedQueue();
    private volatile C0059b aGB;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ex().gp(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aGD = bVar;
            aVar.aGC = imageFileInfo;
            aVar.aGE = z;
            this.aGA.add(aVar);
            EG();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EG() {
        if (this.aGB == null && !this.aGA.isEmpty()) {
            this.aGB = new C0059b(this.aGA);
            this.aGB.execute(new Void[0]);
        }
    }

    public void EH() {
        this.aGA = new ConcurrentLinkedQueue();
        if (this.aGB != null) {
            this.aGB.cancel(true);
            this.aGB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aGI;

        public C0059b(Queue<a> queue) {
            this.aGI = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public a doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                a poll = this.aGI.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aGI.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gp = com.baidu.tbadk.imageManager.c.Ex().gp(poll.aGC.toCachedKey(poll.aGE));
                    if (gp != null) {
                        poll.aGF = gp;
                        poll.aGG = true;
                    } else {
                        Bitmap b = b.this.b(poll.aGC, poll.aGE);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aGC.getFilePath());
                                if (i != 0) {
                                    try {
                                        bitmap = BitmapHelper.rotateBitmapBydegree(b, i);
                                        if (b != bitmap) {
                                            try {
                                                b.recycle();
                                                b = null;
                                            } catch (Exception e) {
                                            }
                                        }
                                    } catch (Exception e2) {
                                        bitmap = null;
                                    }
                                } else {
                                    bitmap = null;
                                }
                            } catch (Exception e3) {
                                bitmap = null;
                                i = 0;
                            }
                            if (i != 0 && bitmap != null) {
                                poll.aGF = new com.baidu.adp.widget.a.a(bitmap, false, poll.aGC.getFilePath());
                            } else {
                                poll.aGF = new com.baidu.adp.widget.a.a(b, false, poll.aGC.getFilePath());
                            }
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
            b.this.aGB = null;
            b.this.EG();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aGF;
                    if (aVar2 != null && !aVar.aGG) {
                        com.baidu.tbadk.imageManager.c.Ex().c(aVar.aGC.toCachedKey(aVar.aGE), aVar2);
                    }
                    if (aVar.aGD != null) {
                        aVar.aGD.a(aVar2, aVar.aGC.toCachedKey(aVar.aGE), aVar.aGG);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aGB = null;
            while (true) {
                a poll = this.aGI.poll();
                if (poll != null) {
                    if (poll.aGD != null) {
                        poll.aGD.a(null, poll.aGC.toCachedKey(poll.aGE), false);
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
                return com.baidu.tbadk.img.effect.c.EI().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EI().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aGC;
        com.baidu.tbadk.imageManager.b aGD;
        boolean aGE;
        com.baidu.adp.widget.a.a aGF;
        boolean aGG;

        private a() {
        }
    }
}
