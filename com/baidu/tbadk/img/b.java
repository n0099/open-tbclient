package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cva = new ConcurrentLinkedQueue();
    private volatile C0255b cvb;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.asp().qr(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.cvd = bVar;
            aVar.cvc = imageFileInfo;
            aVar.cve = z;
            this.cva.add(aVar);
            asy();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void asy() {
        if (this.cvb == null && !this.cva.isEmpty()) {
            this.cvb = new C0255b(this.cva);
            this.cvb.execute(new Void[0]);
        }
    }

    public void asz() {
        this.cva = new ConcurrentLinkedQueue();
        if (this.cvb != null) {
            this.cvb.cancel(true);
            this.cvb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0255b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cvi;

        public C0255b(Queue<a> queue) {
            this.cvi = queue;
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
                a poll = this.cvi.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cvi.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a qr = com.baidu.tbadk.imageManager.c.asp().qr(poll.cvc.toCachedKey(poll.cve));
                    if (qr != null) {
                        poll.cvf = qr;
                        poll.cvg = true;
                    } else {
                        Bitmap b = b.this.b(poll.cvc, poll.cve);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cvc.getFilePath());
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
                                poll.cvf = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cvc.isGif(), poll.cvc.getFilePath());
                            } else {
                                poll.cvf = new com.baidu.adp.widget.ImageView.a(b, poll.cvc.isGif(), poll.cvc.getFilePath());
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
            b.this.cvb = null;
            b.this.asy();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cvf;
                    if (aVar2 != null && !aVar.cvg) {
                        com.baidu.tbadk.imageManager.c.asp().c(aVar.cvc.toCachedKey(aVar.cve), aVar2);
                    }
                    if (aVar.cvd != null) {
                        aVar.cvd.a(aVar2, aVar.cvc.toCachedKey(aVar.cve), aVar.cvg);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cvb = null;
            while (true) {
                a poll = this.cvi.poll();
                if (poll != null) {
                    if (poll.cvd != null) {
                        poll.cvd.a(null, poll.cvc.toCachedKey(poll.cve), false);
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
                return com.baidu.tbadk.img.effect.c.asA().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.asA().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo cvc;
        com.baidu.tbadk.imageManager.b cvd;
        boolean cve;
        com.baidu.adp.widget.ImageView.a cvf;
        boolean cvg;

        private a() {
        }
    }
}
