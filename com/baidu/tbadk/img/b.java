package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aGC = new ConcurrentLinkedQueue();
    private volatile C0059b aGD;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ex().gt(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aGF = bVar;
            aVar.aGE = imageFileInfo;
            aVar.aGG = z;
            this.aGC.add(aVar);
            EG();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EG() {
        if (this.aGD == null && !this.aGC.isEmpty()) {
            this.aGD = new C0059b(this.aGC);
            this.aGD.execute(new Void[0]);
        }
    }

    public void EH() {
        this.aGC = new ConcurrentLinkedQueue();
        if (this.aGD != null) {
            this.aGD.cancel(true);
            this.aGD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aGK;

        public C0059b(Queue<a> queue) {
            this.aGK = queue;
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
                a poll = this.aGK.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aGK.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gt = com.baidu.tbadk.imageManager.c.Ex().gt(poll.aGE.toCachedKey(poll.aGG));
                    if (gt != null) {
                        poll.aGH = gt;
                        poll.aGI = true;
                    } else {
                        Bitmap b = b.this.b(poll.aGE, poll.aGG);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aGE.getFilePath());
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
                                poll.aGH = new com.baidu.adp.widget.a.a(bitmap, false, poll.aGE.getFilePath());
                            } else {
                                poll.aGH = new com.baidu.adp.widget.a.a(b, false, poll.aGE.getFilePath());
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
            b.this.aGD = null;
            b.this.EG();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aGH;
                    if (aVar2 != null && !aVar.aGI) {
                        com.baidu.tbadk.imageManager.c.Ex().c(aVar.aGE.toCachedKey(aVar.aGG), aVar2);
                    }
                    if (aVar.aGF != null) {
                        aVar.aGF.a(aVar2, aVar.aGE.toCachedKey(aVar.aGG), aVar.aGI);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aGD = null;
            while (true) {
                a poll = this.aGK.poll();
                if (poll != null) {
                    if (poll.aGF != null) {
                        poll.aGF.a(null, poll.aGE.toCachedKey(poll.aGG), false);
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
                return com.baidu.tbadk.img.effect.c.EI().b(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aGE;
        com.baidu.tbadk.imageManager.b aGF;
        boolean aGG;
        com.baidu.adp.widget.a.a aGH;
        boolean aGI;

        private a() {
        }
    }
}
