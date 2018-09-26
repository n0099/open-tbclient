package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aTR = new ConcurrentLinkedQueue();
    private volatile C0115b aTS;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Kg().hA(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aTU = bVar;
            aVar.aTT = imageFileInfo;
            aVar.aTV = z;
            this.aTR.add(aVar);
            Kp();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Kp() {
        if (this.aTS == null && !this.aTR.isEmpty()) {
            this.aTS = new C0115b(this.aTR);
            this.aTS.execute(new Void[0]);
        }
    }

    public void Kq() {
        this.aTR = new ConcurrentLinkedQueue();
        if (this.aTS != null) {
            this.aTS.cancel(true);
            this.aTS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aTZ;

        public C0115b(Queue<a> queue) {
            this.aTZ = queue;
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
                a poll = this.aTZ.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aTZ.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a hA = com.baidu.tbadk.imageManager.c.Kg().hA(poll.aTT.toCachedKey(poll.aTV));
                    if (hA != null) {
                        poll.aTW = hA;
                        poll.aTX = true;
                    } else {
                        Bitmap b = b.this.b(poll.aTT, poll.aTV);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aTT.getFilePath());
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
                                poll.aTW = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aTT.isGif(), poll.aTT.getFilePath());
                            } else {
                                poll.aTW = new com.baidu.adp.widget.ImageView.a(b, poll.aTT.isGif(), poll.aTT.getFilePath());
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
            b.this.aTS = null;
            b.this.Kp();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aTW;
                    if (aVar2 != null && !aVar.aTX) {
                        com.baidu.tbadk.imageManager.c.Kg().c(aVar.aTT.toCachedKey(aVar.aTV), aVar2);
                    }
                    if (aVar.aTU != null) {
                        aVar.aTU.a(aVar2, aVar.aTT.toCachedKey(aVar.aTV), aVar.aTX);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aTS = null;
            while (true) {
                a poll = this.aTZ.poll();
                if (poll != null) {
                    if (poll.aTU != null) {
                        poll.aTU.a(null, poll.aTT.toCachedKey(poll.aTV), false);
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
                return com.baidu.tbadk.img.effect.c.Kr().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Kr().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aTT;
        com.baidu.tbadk.imageManager.b aTU;
        boolean aTV;
        com.baidu.adp.widget.ImageView.a aTW;
        boolean aTX;

        private a() {
        }
    }
}
