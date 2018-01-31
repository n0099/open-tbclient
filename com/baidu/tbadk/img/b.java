package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> buL = new ConcurrentLinkedQueue();
    private volatile C0087b buM;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.LR().gF(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.buO = bVar;
            aVar.buN = imageFileInfo;
            aVar.buP = z;
            this.buL.add(aVar);
            Ma();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ma() {
        if (this.buM == null && !this.buL.isEmpty()) {
            this.buM = new C0087b(this.buL);
            this.buM.execute(new Void[0]);
        }
    }

    public void Mb() {
        this.buL = new ConcurrentLinkedQueue();
        if (this.buM != null) {
            this.buM.cancel(true);
            this.buM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0087b extends BdAsyncTask<Void, a, a> {
        final Queue<a> buT;

        public C0087b(Queue<a> queue) {
            this.buT = queue;
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
                a poll = this.buT.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.buT.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gF = com.baidu.tbadk.imageManager.c.LR().gF(poll.buN.toCachedKey(poll.buP));
                    if (gF != null) {
                        poll.buQ = gF;
                        poll.buR = true;
                    } else {
                        Bitmap b = b.this.b(poll.buN, poll.buP);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.buN.getFilePath());
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
                                poll.buQ = new com.baidu.adp.widget.a.a(bitmap, poll.buN.isGif(), poll.buN.getFilePath());
                            } else {
                                poll.buQ = new com.baidu.adp.widget.a.a(b, poll.buN.isGif(), poll.buN.getFilePath());
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
            b.this.buM = null;
            b.this.Ma();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.buQ;
                    if (aVar2 != null && !aVar.buR) {
                        com.baidu.tbadk.imageManager.c.LR().c(aVar.buN.toCachedKey(aVar.buP), aVar2);
                    }
                    if (aVar.buO != null) {
                        aVar.buO.a(aVar2, aVar.buN.toCachedKey(aVar.buP), aVar.buR);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.buM = null;
            while (true) {
                a poll = this.buT.poll();
                if (poll != null) {
                    if (poll.buO != null) {
                        poll.buO.a(null, poll.buN.toCachedKey(poll.buP), false);
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
                return com.baidu.tbadk.img.effect.c.Mc().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Mc().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo buN;
        com.baidu.tbadk.imageManager.b buO;
        boolean buP;
        com.baidu.adp.widget.a.a buQ;
        boolean buR;

        private a() {
        }
    }
}
