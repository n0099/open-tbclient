package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aPG = new ConcurrentLinkedQueue();
    private volatile C0117b aPH;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.ID().he(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aPJ = bVar;
            aVar.aPI = imageFileInfo;
            aVar.aPK = z;
            this.aPG.add(aVar);
            IM();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void IM() {
        if (this.aPH == null && !this.aPG.isEmpty()) {
            this.aPH = new C0117b(this.aPG);
            this.aPH.execute(new Void[0]);
        }
    }

    public void IN() {
        this.aPG = new ConcurrentLinkedQueue();
        if (this.aPH != null) {
            this.aPH.cancel(true);
            this.aPH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0117b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aPO;

        public C0117b(Queue<a> queue) {
            this.aPO = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                a poll = this.aPO.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aPO.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.ID().he(poll.aPI.toCachedKey(poll.aPK));
                    if (he != null) {
                        poll.aPL = he;
                        poll.aPM = true;
                    } else {
                        Bitmap b = b.this.b(poll.aPI, poll.aPK);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aPI.getFilePath());
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
                                poll.aPL = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aPI.isGif(), poll.aPI.getFilePath());
                            } else {
                                poll.aPL = new com.baidu.adp.widget.ImageView.a(b, poll.aPI.isGif(), poll.aPI.getFilePath());
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
            b.this.aPH = null;
            b.this.IM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aPL;
                    if (aVar2 != null && !aVar.aPM) {
                        com.baidu.tbadk.imageManager.c.ID().c(aVar.aPI.toCachedKey(aVar.aPK), aVar2);
                    }
                    if (aVar.aPJ != null) {
                        aVar.aPJ.a(aVar2, aVar.aPI.toCachedKey(aVar.aPK), aVar.aPM);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aPH = null;
            while (true) {
                a poll = this.aPO.poll();
                if (poll != null) {
                    if (poll.aPJ != null) {
                        poll.aPJ.a(null, poll.aPI.toCachedKey(poll.aPK), false);
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
                return com.baidu.tbadk.img.effect.c.IO().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.IO().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aPI;
        com.baidu.tbadk.imageManager.b aPJ;
        boolean aPK;
        com.baidu.adp.widget.ImageView.a aPL;
        boolean aPM;

        private a() {
        }
    }
}
