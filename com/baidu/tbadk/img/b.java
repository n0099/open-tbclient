package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cmS = new ConcurrentLinkedQueue();
    private volatile C0240b cmT;

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
            aVar.cmV = bVar;
            aVar.cmU = imageFileInfo;
            aVar.cmW = z;
            this.cmS.add(aVar);
            anv();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void anv() {
        if (this.cmT == null && !this.cmS.isEmpty()) {
            this.cmT = new C0240b(this.cmS);
            this.cmT.execute(new Void[0]);
        }
    }

    public void anw() {
        this.cmS = new ConcurrentLinkedQueue();
        if (this.cmT != null) {
            this.cmT.cancel(true);
            this.cmT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0240b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cna;

        public C0240b(Queue<a> queue) {
            this.cna = queue;
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
                a poll = this.cna.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cna.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a pj = com.baidu.tbadk.imageManager.c.anm().pj(poll.cmU.toCachedKey(poll.cmW));
                    if (pj != null) {
                        poll.cmX = pj;
                        poll.cmY = true;
                    } else {
                        Bitmap b = b.this.b(poll.cmU, poll.cmW);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cmU.getFilePath());
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
                                poll.cmX = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cmU.isGif(), poll.cmU.getFilePath());
                            } else {
                                poll.cmX = new com.baidu.adp.widget.ImageView.a(b, poll.cmU.isGif(), poll.cmU.getFilePath());
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
            b.this.cmT = null;
            b.this.anv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cmX;
                    if (aVar2 != null && !aVar.cmY) {
                        com.baidu.tbadk.imageManager.c.anm().c(aVar.cmU.toCachedKey(aVar.cmW), aVar2);
                    }
                    if (aVar.cmV != null) {
                        aVar.cmV.a(aVar2, aVar.cmU.toCachedKey(aVar.cmW), aVar.cmY);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cmT = null;
            while (true) {
                a poll = this.cna.poll();
                if (poll != null) {
                    if (poll.cmV != null) {
                        poll.cmV.a(null, poll.cmU.toCachedKey(poll.cmW), false);
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
        ImageFileInfo cmU;
        com.baidu.tbadk.imageManager.b cmV;
        boolean cmW;
        com.baidu.adp.widget.ImageView.a cmX;
        boolean cmY;

        private a() {
        }
    }
}
