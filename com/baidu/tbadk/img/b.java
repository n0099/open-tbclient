package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> but = new ConcurrentLinkedQueue();
    private volatile C0087b buu;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Mb().gx(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.buw = bVar;
            aVar.buv = imageFileInfo;
            aVar.bux = z;
            this.but.add(aVar);
            Mk();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Mk() {
        if (this.buu == null && !this.but.isEmpty()) {
            this.buu = new C0087b(this.but);
            this.buu.execute(new Void[0]);
        }
    }

    public void Ml() {
        this.but = new ConcurrentLinkedQueue();
        if (this.buu != null) {
            this.buu.cancel(true);
            this.buu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0087b extends BdAsyncTask<Void, a, a> {
        final Queue<a> buB;

        public C0087b(Queue<a> queue) {
            this.buB = queue;
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
                a poll = this.buB.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.buB.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gx = com.baidu.tbadk.imageManager.c.Mb().gx(poll.buv.toCachedKey(poll.bux));
                    if (gx != null) {
                        poll.buy = gx;
                        poll.buz = true;
                    } else {
                        Bitmap b = b.this.b(poll.buv, poll.bux);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.buv.getFilePath());
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
                                poll.buy = new com.baidu.adp.widget.a.a(bitmap, poll.buv.isGif(), poll.buv.getFilePath());
                            } else {
                                poll.buy = new com.baidu.adp.widget.a.a(b, poll.buv.isGif(), poll.buv.getFilePath());
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
            b.this.buu = null;
            b.this.Mk();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.buy;
                    if (aVar2 != null && !aVar.buz) {
                        com.baidu.tbadk.imageManager.c.Mb().c(aVar.buv.toCachedKey(aVar.bux), aVar2);
                    }
                    if (aVar.buw != null) {
                        aVar.buw.a(aVar2, aVar.buv.toCachedKey(aVar.bux), aVar.buz);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.buu = null;
            while (true) {
                a poll = this.buB.poll();
                if (poll != null) {
                    if (poll.buw != null) {
                        poll.buw.a(null, poll.buv.toCachedKey(poll.bux), false);
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
                return com.baidu.tbadk.img.effect.c.Mm().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Mm().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo buv;
        com.baidu.tbadk.imageManager.b buw;
        boolean bux;
        com.baidu.adp.widget.a.a buy;
        boolean buz;

        private a() {
        }
    }
}
