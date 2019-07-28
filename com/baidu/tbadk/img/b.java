package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cwp = new ConcurrentLinkedQueue();
    private volatile C0257b cwq;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.atw().qH(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.cws = bVar;
            aVar.cwr = imageFileInfo;
            aVar.cwt = z;
            this.cwp.add(aVar);
            atF();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void atF() {
        if (this.cwq == null && !this.cwp.isEmpty()) {
            this.cwq = new C0257b(this.cwp);
            this.cwq.execute(new Void[0]);
        }
    }

    public void atG() {
        this.cwp = new ConcurrentLinkedQueue();
        if (this.cwq != null) {
            this.cwq.cancel(true);
            this.cwq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0257b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cwx;

        public C0257b(Queue<a> queue) {
            this.cwx = queue;
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
                a poll = this.cwx.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cwx.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.atw().qH(poll.cwr.toCachedKey(poll.cwt));
                    if (qH != null) {
                        poll.cwu = qH;
                        poll.cwv = true;
                    } else {
                        Bitmap b = b.this.b(poll.cwr, poll.cwt);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cwr.getFilePath());
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
                                poll.cwu = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cwr.isGif(), poll.cwr.getFilePath());
                            } else {
                                poll.cwu = new com.baidu.adp.widget.ImageView.a(b, poll.cwr.isGif(), poll.cwr.getFilePath());
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
            b.this.cwq = null;
            b.this.atF();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cwu;
                    if (aVar2 != null && !aVar.cwv) {
                        com.baidu.tbadk.imageManager.c.atw().c(aVar.cwr.toCachedKey(aVar.cwt), aVar2);
                    }
                    if (aVar.cws != null) {
                        aVar.cws.a(aVar2, aVar.cwr.toCachedKey(aVar.cwt), aVar.cwv);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cwq = null;
            while (true) {
                a poll = this.cwx.poll();
                if (poll != null) {
                    if (poll.cws != null) {
                        poll.cws.a(null, poll.cwr.toCachedKey(poll.cwt), false);
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
                return com.baidu.tbadk.img.effect.c.atH().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.atH().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo cwr;
        com.baidu.tbadk.imageManager.b cws;
        boolean cwt;
        com.baidu.adp.widget.ImageView.a cwu;
        boolean cwv;

        private a() {
        }
    }
}
