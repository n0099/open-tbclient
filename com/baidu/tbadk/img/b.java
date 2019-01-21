package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> bdq = new ConcurrentLinkedQueue();
    private volatile C0173b bdr;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.NM().iw(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.bdt = bVar;
            aVar.bds = imageFileInfo;
            aVar.bdu = z;
            this.bdq.add(aVar);
            NV();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void NV() {
        if (this.bdr == null && !this.bdq.isEmpty()) {
            this.bdr = new C0173b(this.bdq);
            this.bdr.execute(new Void[0]);
        }
    }

    public void NW() {
        this.bdq = new ConcurrentLinkedQueue();
        if (this.bdr != null) {
            this.bdr.cancel(true);
            this.bdr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0173b extends BdAsyncTask<Void, a, a> {
        final Queue<a> bdy;

        public C0173b(Queue<a> queue) {
            this.bdy = queue;
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
                a poll = this.bdy.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.bdy.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a iw = com.baidu.tbadk.imageManager.c.NM().iw(poll.bds.toCachedKey(poll.bdu));
                    if (iw != null) {
                        poll.bdv = iw;
                        poll.bdw = true;
                    } else {
                        Bitmap b = b.this.b(poll.bds, poll.bdu);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.bds.getFilePath());
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
                                poll.bdv = new com.baidu.adp.widget.ImageView.a(bitmap, poll.bds.isGif(), poll.bds.getFilePath());
                            } else {
                                poll.bdv = new com.baidu.adp.widget.ImageView.a(b, poll.bds.isGif(), poll.bds.getFilePath());
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
            b.this.bdr = null;
            b.this.NV();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.bdv;
                    if (aVar2 != null && !aVar.bdw) {
                        com.baidu.tbadk.imageManager.c.NM().c(aVar.bds.toCachedKey(aVar.bdu), aVar2);
                    }
                    if (aVar.bdt != null) {
                        aVar.bdt.a(aVar2, aVar.bds.toCachedKey(aVar.bdu), aVar.bdw);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.bdr = null;
            while (true) {
                a poll = this.bdy.poll();
                if (poll != null) {
                    if (poll.bdt != null) {
                        poll.bdt.a(null, poll.bds.toCachedKey(poll.bdu), false);
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
                return com.baidu.tbadk.img.effect.c.NX().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.NX().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo bds;
        com.baidu.tbadk.imageManager.b bdt;
        boolean bdu;
        com.baidu.adp.widget.ImageView.a bdv;
        boolean bdw;

        private a() {
        }
    }
}
