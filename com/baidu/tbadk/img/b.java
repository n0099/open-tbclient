package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aFk = new ConcurrentLinkedQueue();
    private volatile C0059b aFl;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ep().gk(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aFn = bVar;
            aVar.aFm = imageFileInfo;
            aVar.aFo = z;
            this.aFk.add(aVar);
            Ey();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ey() {
        if (this.aFl == null && !this.aFk.isEmpty()) {
            this.aFl = new C0059b(this.aFk);
            this.aFl.execute(new Void[0]);
        }
    }

    public void Ez() {
        this.aFk = new ConcurrentLinkedQueue();
        if (this.aFl != null) {
            this.aFl.cancel(true);
            this.aFl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0059b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aFs;

        public C0059b(Queue<a> queue) {
            this.aFs = queue;
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
                a poll = this.aFs.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aFs.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gk = com.baidu.tbadk.imageManager.c.Ep().gk(poll.aFm.toCachedKey(poll.aFo));
                    if (gk != null) {
                        poll.aFp = gk;
                        poll.aFq = true;
                    } else {
                        Bitmap b = b.this.b(poll.aFm, poll.aFo);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aFm.getFilePath());
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
                                poll.aFp = new com.baidu.adp.widget.a.a(bitmap, false, poll.aFm.getFilePath());
                            } else {
                                poll.aFp = new com.baidu.adp.widget.a.a(b, false, poll.aFm.getFilePath());
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
            b.this.aFl = null;
            b.this.Ey();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aFp;
                    if (aVar2 != null && !aVar.aFq) {
                        com.baidu.tbadk.imageManager.c.Ep().c(aVar.aFm.toCachedKey(aVar.aFo), aVar2);
                    }
                    if (aVar.aFn != null) {
                        aVar.aFn.a(aVar2, aVar.aFm.toCachedKey(aVar.aFo), aVar.aFq);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aFl = null;
            while (true) {
                a poll = this.aFs.poll();
                if (poll != null) {
                    if (poll.aFn != null) {
                        poll.aFn.a(null, poll.aFm.toCachedKey(poll.aFo), false);
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
                return com.baidu.tbadk.img.effect.c.EA().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EA().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aFm;
        com.baidu.tbadk.imageManager.b aFn;
        boolean aFo;
        com.baidu.adp.widget.a.a aFp;
        boolean aFq;

        private a() {
        }
    }
}
