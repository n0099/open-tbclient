package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> bwV = new ConcurrentLinkedQueue();
    private volatile C0110b bwW;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Mx().gP(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.bwY = bVar;
            aVar.bwX = imageFileInfo;
            aVar.bwZ = z;
            this.bwV.add(aVar);
            MG();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void MG() {
        if (this.bwW == null && !this.bwV.isEmpty()) {
            this.bwW = new C0110b(this.bwV);
            this.bwW.execute(new Void[0]);
        }
    }

    public void MH() {
        this.bwV = new ConcurrentLinkedQueue();
        if (this.bwW != null) {
            this.bwW.cancel(true);
            this.bwW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0110b extends BdAsyncTask<Void, a, a> {
        final Queue<a> bxd;

        public C0110b(Queue<a> queue) {
            this.bxd = queue;
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
                a poll = this.bxd.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.bxd.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mx().gP(poll.bwX.toCachedKey(poll.bwZ));
                    if (gP != null) {
                        poll.bxa = gP;
                        poll.bxb = true;
                    } else {
                        Bitmap b = b.this.b(poll.bwX, poll.bwZ);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.bwX.getFilePath());
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
                                poll.bxa = new com.baidu.adp.widget.a.a(bitmap, poll.bwX.isGif(), poll.bwX.getFilePath());
                            } else {
                                poll.bxa = new com.baidu.adp.widget.a.a(b, poll.bwX.isGif(), poll.bwX.getFilePath());
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
            b.this.bwW = null;
            b.this.MG();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.bxa;
                    if (aVar2 != null && !aVar.bxb) {
                        com.baidu.tbadk.imageManager.c.Mx().c(aVar.bwX.toCachedKey(aVar.bwZ), aVar2);
                    }
                    if (aVar.bwY != null) {
                        aVar.bwY.a(aVar2, aVar.bwX.toCachedKey(aVar.bwZ), aVar.bxb);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.bwW = null;
            while (true) {
                a poll = this.bxd.poll();
                if (poll != null) {
                    if (poll.bwY != null) {
                        poll.bwY.a(null, poll.bwX.toCachedKey(poll.bwZ), false);
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
                return com.baidu.tbadk.img.effect.c.MI().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.MI().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo bwX;
        com.baidu.tbadk.imageManager.b bwY;
        boolean bwZ;
        com.baidu.adp.widget.a.a bxa;
        boolean bxb;

        private a() {
        }
    }
}
