package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cmR = new ConcurrentLinkedQueue();
    private volatile C0240b cmS;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.anm().pj(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.cmU = bVar;
            aVar.cmT = imageFileInfo;
            aVar.cmV = z;
            this.cmR.add(aVar);
            anv();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void anv() {
        if (this.cmS == null && !this.cmR.isEmpty()) {
            this.cmS = new C0240b(this.cmR);
            this.cmS.execute(new Void[0]);
        }
    }

    public void anw() {
        this.cmR = new ConcurrentLinkedQueue();
        if (this.cmS != null) {
            this.cmS.cancel(true);
            this.cmS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0240b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cmZ;

        public C0240b(Queue<a> queue) {
            this.cmZ = queue;
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
                a poll = this.cmZ.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cmZ.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a pj = com.baidu.tbadk.imageManager.c.anm().pj(poll.cmT.toCachedKey(poll.cmV));
                    if (pj != null) {
                        poll.cmW = pj;
                        poll.cmX = true;
                    } else {
                        Bitmap b = b.this.b(poll.cmT, poll.cmV);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cmT.getFilePath());
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
                                poll.cmW = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cmT.isGif(), poll.cmT.getFilePath());
                            } else {
                                poll.cmW = new com.baidu.adp.widget.ImageView.a(b, poll.cmT.isGif(), poll.cmT.getFilePath());
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
            b.this.cmS = null;
            b.this.anv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cmW;
                    if (aVar2 != null && !aVar.cmX) {
                        com.baidu.tbadk.imageManager.c.anm().c(aVar.cmT.toCachedKey(aVar.cmV), aVar2);
                    }
                    if (aVar.cmU != null) {
                        aVar.cmU.a(aVar2, aVar.cmT.toCachedKey(aVar.cmV), aVar.cmX);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cmS = null;
            while (true) {
                a poll = this.cmZ.poll();
                if (poll != null) {
                    if (poll.cmU != null) {
                        poll.cmU.a(null, poll.cmT.toCachedKey(poll.cmV), false);
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
                return com.baidu.tbadk.img.effect.c.anx().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.anx().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo cmT;
        com.baidu.tbadk.imageManager.b cmU;
        boolean cmV;
        com.baidu.adp.widget.ImageView.a cmW;
        boolean cmX;

        private a() {
        }
    }
}
