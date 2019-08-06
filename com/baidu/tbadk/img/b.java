package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cww = new ConcurrentLinkedQueue();
    private volatile C0257b cwx;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.aty().qH(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.cwz = bVar;
            aVar.cwy = imageFileInfo;
            aVar.cwA = z;
            this.cww.add(aVar);
            atH();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void atH() {
        if (this.cwx == null && !this.cww.isEmpty()) {
            this.cwx = new C0257b(this.cww);
            this.cwx.execute(new Void[0]);
        }
    }

    public void atI() {
        this.cww = new ConcurrentLinkedQueue();
        if (this.cwx != null) {
            this.cwx.cancel(true);
            this.cwx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0257b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cwE;

        public C0257b(Queue<a> queue) {
            this.cwE = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public a doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                a poll = this.cwE.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cwE.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.aty().qH(poll.cwy.toCachedKey(poll.cwA));
                    if (qH != null) {
                        poll.cwB = qH;
                        poll.cwC = true;
                    } else {
                        Bitmap b = b.this.b(poll.cwy, poll.cwA);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cwy.getFilePath());
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
                                poll.cwB = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cwy.isGif(), poll.cwy.getFilePath());
                            } else {
                                poll.cwB = new com.baidu.adp.widget.ImageView.a(b, poll.cwy.isGif(), poll.cwy.getFilePath());
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
            b.this.cwx = null;
            b.this.atH();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cwB;
                    if (aVar2 != null && !aVar.cwC) {
                        com.baidu.tbadk.imageManager.c.aty().c(aVar.cwy.toCachedKey(aVar.cwA), aVar2);
                    }
                    if (aVar.cwz != null) {
                        aVar.cwz.a(aVar2, aVar.cwy.toCachedKey(aVar.cwA), aVar.cwC);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cwx = null;
            while (true) {
                a poll = this.cwE.poll();
                if (poll != null) {
                    if (poll.cwz != null) {
                        poll.cwz.a(null, poll.cwy.toCachedKey(poll.cwA), false);
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
                return com.baidu.tbadk.img.effect.c.atJ().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.atJ().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        boolean cwA;
        com.baidu.adp.widget.ImageView.a cwB;
        boolean cwC;
        ImageFileInfo cwy;
        com.baidu.tbadk.imageManager.b cwz;

        private a() {
        }
    }
}
