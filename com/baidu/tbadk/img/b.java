package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> bwI = new ConcurrentLinkedQueue();
    private volatile C0111b bwJ;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Mw().gP(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.bwL = bVar;
            aVar.bwK = imageFileInfo;
            aVar.bwM = z;
            this.bwI.add(aVar);
            MF();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void MF() {
        if (this.bwJ == null && !this.bwI.isEmpty()) {
            this.bwJ = new C0111b(this.bwI);
            this.bwJ.execute(new Void[0]);
        }
    }

    public void MG() {
        this.bwI = new ConcurrentLinkedQueue();
        if (this.bwJ != null) {
            this.bwJ.cancel(true);
            this.bwJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0111b extends BdAsyncTask<Void, a, a> {
        final Queue<a> bwQ;

        public C0111b(Queue<a> queue) {
            this.bwQ = queue;
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
                a poll = this.bwQ.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.bwQ.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mw().gP(poll.bwK.toCachedKey(poll.bwM));
                    if (gP != null) {
                        poll.bwN = gP;
                        poll.bwO = true;
                    } else {
                        Bitmap b = b.this.b(poll.bwK, poll.bwM);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.bwK.getFilePath());
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
                                poll.bwN = new com.baidu.adp.widget.a.a(bitmap, poll.bwK.isGif(), poll.bwK.getFilePath());
                            } else {
                                poll.bwN = new com.baidu.adp.widget.a.a(b, poll.bwK.isGif(), poll.bwK.getFilePath());
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
            b.this.bwJ = null;
            b.this.MF();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.bwN;
                    if (aVar2 != null && !aVar.bwO) {
                        com.baidu.tbadk.imageManager.c.Mw().c(aVar.bwK.toCachedKey(aVar.bwM), aVar2);
                    }
                    if (aVar.bwL != null) {
                        aVar.bwL.a(aVar2, aVar.bwK.toCachedKey(aVar.bwM), aVar.bwO);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.bwJ = null;
            while (true) {
                a poll = this.bwQ.poll();
                if (poll != null) {
                    if (poll.bwL != null) {
                        poll.bwL.a(null, poll.bwK.toCachedKey(poll.bwM), false);
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
                return com.baidu.tbadk.img.effect.c.MH().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.MH().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo bwK;
        com.baidu.tbadk.imageManager.b bwL;
        boolean bwM;
        com.baidu.adp.widget.a.a bwN;
        boolean bwO;

        private a() {
        }
    }
}
