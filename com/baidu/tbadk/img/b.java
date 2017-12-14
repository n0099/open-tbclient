package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aGw = new ConcurrentLinkedQueue();
    private volatile C0074b aGx;

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
            aVar.aGz = bVar;
            aVar.aGy = imageFileInfo;
            aVar.aGA = z;
            this.aGw.add(aVar);
            EK();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EK() {
        if (this.aGx == null && !this.aGw.isEmpty()) {
            this.aGx = new C0074b(this.aGw);
            this.aGx.execute(new Void[0]);
        }
    }

    public void EL() {
        this.aGw = new ConcurrentLinkedQueue();
        if (this.aGx != null) {
            this.aGx.cancel(true);
            this.aGx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aGE;

        public C0074b(Queue<a> queue) {
            this.aGE = queue;
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
                a poll = this.aGE.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aGE.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gr = com.baidu.tbadk.imageManager.c.EA().gr(poll.aGy.toCachedKey(poll.aGA));
                    if (gr != null) {
                        poll.aGB = gr;
                        poll.aGC = true;
                    } else {
                        Bitmap b = b.this.b(poll.aGy, poll.aGA);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aGy.getFilePath());
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
                                poll.aGB = new com.baidu.adp.widget.a.a(bitmap, poll.aGy.isGif(), poll.aGy.getFilePath());
                            } else {
                                poll.aGB = new com.baidu.adp.widget.a.a(b, poll.aGy.isGif(), poll.aGy.getFilePath());
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
            b.this.aGx = null;
            b.this.EK();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aGB;
                    if (aVar2 != null && !aVar.aGC) {
                        com.baidu.tbadk.imageManager.c.EA().c(aVar.aGy.toCachedKey(aVar.aGA), aVar2);
                    }
                    if (aVar.aGz != null) {
                        aVar.aGz.a(aVar2, aVar.aGy.toCachedKey(aVar.aGA), aVar.aGC);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aGx = null;
            while (true) {
                a poll = this.aGE.poll();
                if (poll != null) {
                    if (poll.aGz != null) {
                        poll.aGz.a(null, poll.aGy.toCachedKey(poll.aGA), false);
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
        boolean aGA;
        com.baidu.adp.widget.a.a aGB;
        boolean aGC;
        ImageFileInfo aGy;
        com.baidu.tbadk.imageManager.b aGz;

        private a() {
        }
    }
}
