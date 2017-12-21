package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private volatile C0073b aGA;
    private Queue<a> aGz = new ConcurrentLinkedQueue();

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.EA().gr(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aGC = bVar;
            aVar.aGB = imageFileInfo;
            aVar.aGD = z;
            this.aGz.add(aVar);
            EK();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EK() {
        if (this.aGA == null && !this.aGz.isEmpty()) {
            this.aGA = new C0073b(this.aGz);
            this.aGA.execute(new Void[0]);
        }
    }

    public void EL() {
        this.aGz = new ConcurrentLinkedQueue();
        if (this.aGA != null) {
            this.aGA.cancel(true);
            this.aGA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0073b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aGH;

        public C0073b(Queue<a> queue) {
            this.aGH = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                a poll = this.aGH.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aGH.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gr = com.baidu.tbadk.imageManager.c.EA().gr(poll.aGB.toCachedKey(poll.aGD));
                    if (gr != null) {
                        poll.aGE = gr;
                        poll.aGF = true;
                    } else {
                        Bitmap b = b.this.b(poll.aGB, poll.aGD);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aGB.getFilePath());
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
                                poll.aGE = new com.baidu.adp.widget.a.a(bitmap, poll.aGB.isGif(), poll.aGB.getFilePath());
                            } else {
                                poll.aGE = new com.baidu.adp.widget.a.a(b, poll.aGB.isGif(), poll.aGB.getFilePath());
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
            b.this.aGA = null;
            b.this.EK();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aGE;
                    if (aVar2 != null && !aVar.aGF) {
                        com.baidu.tbadk.imageManager.c.EA().c(aVar.aGB.toCachedKey(aVar.aGD), aVar2);
                    }
                    if (aVar.aGC != null) {
                        aVar.aGC.a(aVar2, aVar.aGB.toCachedKey(aVar.aGD), aVar.aGF);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aGA = null;
            while (true) {
                a poll = this.aGH.poll();
                if (poll != null) {
                    if (poll.aGC != null) {
                        poll.aGC.a(null, poll.aGB.toCachedKey(poll.aGD), false);
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
                return com.baidu.tbadk.img.effect.c.EM().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EM().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aGB;
        com.baidu.tbadk.imageManager.b aGC;
        boolean aGD;
        com.baidu.adp.widget.a.a aGE;
        boolean aGF;

        private a() {
        }
    }
}
