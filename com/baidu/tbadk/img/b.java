package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> bcF = new ConcurrentLinkedQueue();
    private volatile C0173b bcG;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Nv().ii(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.bcI = bVar;
            aVar.bcH = imageFileInfo;
            aVar.bcJ = z;
            this.bcF.add(aVar);
            NE();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void NE() {
        if (this.bcG == null && !this.bcF.isEmpty()) {
            this.bcG = new C0173b(this.bcF);
            this.bcG.execute(new Void[0]);
        }
    }

    public void NF() {
        this.bcF = new ConcurrentLinkedQueue();
        if (this.bcG != null) {
            this.bcG.cancel(true);
            this.bcG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0173b extends BdAsyncTask<Void, a, a> {
        final Queue<a> bcN;

        public C0173b(Queue<a> queue) {
            this.bcN = queue;
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
                a poll = this.bcN.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.bcN.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a ii = com.baidu.tbadk.imageManager.c.Nv().ii(poll.bcH.toCachedKey(poll.bcJ));
                    if (ii != null) {
                        poll.bcK = ii;
                        poll.bcL = true;
                    } else {
                        Bitmap b = b.this.b(poll.bcH, poll.bcJ);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.bcH.getFilePath());
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
                                poll.bcK = new com.baidu.adp.widget.ImageView.a(bitmap, poll.bcH.isGif(), poll.bcH.getFilePath());
                            } else {
                                poll.bcK = new com.baidu.adp.widget.ImageView.a(b, poll.bcH.isGif(), poll.bcH.getFilePath());
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
            b.this.bcG = null;
            b.this.NE();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.bcK;
                    if (aVar2 != null && !aVar.bcL) {
                        com.baidu.tbadk.imageManager.c.Nv().c(aVar.bcH.toCachedKey(aVar.bcJ), aVar2);
                    }
                    if (aVar.bcI != null) {
                        aVar.bcI.a(aVar2, aVar.bcH.toCachedKey(aVar.bcJ), aVar.bcL);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.bcG = null;
            while (true) {
                a poll = this.bcN.poll();
                if (poll != null) {
                    if (poll.bcI != null) {
                        poll.bcI.a(null, poll.bcH.toCachedKey(poll.bcJ), false);
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
                return com.baidu.tbadk.img.effect.c.NG().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.NG().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo bcH;
        com.baidu.tbadk.imageManager.b bcI;
        boolean bcJ;
        com.baidu.adp.widget.ImageView.a bcK;
        boolean bcL;

        private a() {
        }
    }
}
