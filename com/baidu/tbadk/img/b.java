package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> cmP = new ConcurrentLinkedQueue();
    private volatile C0240b cmQ;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.anp().pi(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.cmS = bVar;
            aVar.cmR = imageFileInfo;
            aVar.cmT = z;
            this.cmP.add(aVar);
            any();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void any() {
        if (this.cmQ == null && !this.cmP.isEmpty()) {
            this.cmQ = new C0240b(this.cmP);
            this.cmQ.execute(new Void[0]);
        }
    }

    public void anz() {
        this.cmP = new ConcurrentLinkedQueue();
        if (this.cmQ != null) {
            this.cmQ.cancel(true);
            this.cmQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0240b extends BdAsyncTask<Void, a, a> {
        final Queue<a> cmX;

        public C0240b(Queue<a> queue) {
            this.cmX = queue;
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
                a poll = this.cmX.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.cmX.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a pi = com.baidu.tbadk.imageManager.c.anp().pi(poll.cmR.toCachedKey(poll.cmT));
                    if (pi != null) {
                        poll.cmU = pi;
                        poll.cmV = true;
                    } else {
                        Bitmap b = b.this.b(poll.cmR, poll.cmT);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.cmR.getFilePath());
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
                                poll.cmU = new com.baidu.adp.widget.ImageView.a(bitmap, poll.cmR.isGif(), poll.cmR.getFilePath());
                            } else {
                                poll.cmU = new com.baidu.adp.widget.ImageView.a(b, poll.cmR.isGif(), poll.cmR.getFilePath());
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
            b.this.cmQ = null;
            b.this.any();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.cmU;
                    if (aVar2 != null && !aVar.cmV) {
                        com.baidu.tbadk.imageManager.c.anp().c(aVar.cmR.toCachedKey(aVar.cmT), aVar2);
                    }
                    if (aVar.cmS != null) {
                        aVar.cmS.a(aVar2, aVar.cmR.toCachedKey(aVar.cmT), aVar.cmV);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.cmQ = null;
            while (true) {
                a poll = this.cmX.poll();
                if (poll != null) {
                    if (poll.cmS != null) {
                        poll.cmS.a(null, poll.cmR.toCachedKey(poll.cmT), false);
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
                return com.baidu.tbadk.img.effect.c.anA().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.anA().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo cmR;
        com.baidu.tbadk.imageManager.b cmS;
        boolean cmT;
        com.baidu.adp.widget.ImageView.a cmU;
        boolean cmV;

        private a() {
        }
    }
}
