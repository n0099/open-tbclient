package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cvb = new ConcurrentLinkedQueue();
    private volatile C0255b cvc;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.asp().qq(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.cve = bVar;
            aVar.cvd = imageFileInfo;
            aVar.cvf = z;
            this.cvb.add(aVar);
            asy();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void asy() {
        if (this.cvc == null && !this.cvb.isEmpty()) {
            this.cvc = new C0255b(this.cvb);
            this.cvc.execute(new Void[0]);
        }
    }

    public void asz() {
        this.cvb = new ConcurrentLinkedQueue();
        if (this.cvc != null) {
            this.cvc.cancel(true);
            this.cvc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0255b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cvj;

        public C0255b(Queue<a> queue) {
            this.cvj = queue;
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
                a poll = this.cvj.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cvj.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a qq = com.baidu.tbadk.imageManager.c.asp().qq(poll.cvd.toCachedKey(poll.cvf));
                    if (qq != null) {
                        poll.cvg = qq;
                        poll.cvh = true;
                    } else {
                        Bitmap b = b.this.b(poll.cvd, poll.cvf);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cvd.getFilePath());
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
                                poll.cvg = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cvd.isGif(), poll.cvd.getFilePath());
                            } else {
                                poll.cvg = new com.baidu.adp.widget.ImageView.a(b, poll.cvd.isGif(), poll.cvd.getFilePath());
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
            b.this.cvc = null;
            b.this.asy();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cvg;
                    if (aVar2 != null && !aVar.cvh) {
                        com.baidu.tbadk.imageManager.c.asp().c(aVar.cvd.toCachedKey(aVar.cvf), aVar2);
                    }
                    if (aVar.cve != null) {
                        aVar.cve.a(aVar2, aVar.cvd.toCachedKey(aVar.cvf), aVar.cvh);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cvc = null;
            while (true) {
                a poll = this.cvj.poll();
                if (poll != null) {
                    if (poll.cve != null) {
                        poll.cve.a(null, poll.cvd.toCachedKey(poll.cvf), false);
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
        ImageFileInfo cvd;
        com.baidu.tbadk.imageManager.b cve;
        boolean cvf;
        com.baidu.adp.widget.ImageView.a cvg;
        boolean cvh;

        private a() {
        }
    }
}
