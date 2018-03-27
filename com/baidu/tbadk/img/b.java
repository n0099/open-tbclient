package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> bwL = new ConcurrentLinkedQueue();
    private volatile C0111b bwM;

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
            aVar.bwO = bVar;
            aVar.bwN = imageFileInfo;
            aVar.bwP = z;
            this.bwL.add(aVar);
            MG();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void MG() {
        if (this.bwM == null && !this.bwL.isEmpty()) {
            this.bwM = new C0111b(this.bwL);
            this.bwM.execute(new Void[0]);
        }
    }

    public void MH() {
        this.bwL = new ConcurrentLinkedQueue();
        if (this.bwM != null) {
            this.bwM.cancel(true);
            this.bwM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0111b extends BdAsyncTask<Void, a, a> {
        final Queue<a> bwT;

        public C0111b(Queue<a> queue) {
            this.bwT = queue;
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
                a poll = this.bwT.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.bwT.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mx().gP(poll.bwN.toCachedKey(poll.bwP));
                    if (gP != null) {
                        poll.bwQ = gP;
                        poll.bwR = true;
                    } else {
                        Bitmap b = b.this.b(poll.bwN, poll.bwP);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.bwN.getFilePath());
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
                                poll.bwQ = new com.baidu.adp.widget.a.a(bitmap, poll.bwN.isGif(), poll.bwN.getFilePath());
                            } else {
                                poll.bwQ = new com.baidu.adp.widget.a.a(b, poll.bwN.isGif(), poll.bwN.getFilePath());
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
            b.this.bwM = null;
            b.this.MG();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.bwQ;
                    if (aVar2 != null && !aVar.bwR) {
                        com.baidu.tbadk.imageManager.c.Mx().c(aVar.bwN.toCachedKey(aVar.bwP), aVar2);
                    }
                    if (aVar.bwO != null) {
                        aVar.bwO.a(aVar2, aVar.bwN.toCachedKey(aVar.bwP), aVar.bwR);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.bwM = null;
            while (true) {
                a poll = this.bwT.poll();
                if (poll != null) {
                    if (poll.bwO != null) {
                        poll.bwO.a(null, poll.bwN.toCachedKey(poll.bwP), false);
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
        ImageFileInfo bwN;
        com.baidu.tbadk.imageManager.b bwO;
        boolean bwP;
        com.baidu.adp.widget.a.a bwQ;
        boolean bwR;

        private a() {
        }
    }
}
