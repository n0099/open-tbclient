package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aGs = new ConcurrentLinkedQueue();
    private volatile C0060b aGt;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ez().gt(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aGv = bVar;
            aVar.aGu = imageFileInfo;
            aVar.aGw = z;
            this.aGs.add(aVar);
            EJ();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EJ() {
        if (this.aGt == null && !this.aGs.isEmpty()) {
            this.aGt = new C0060b(this.aGs);
            this.aGt.execute(new Void[0]);
        }
    }

    public void EK() {
        this.aGs = new ConcurrentLinkedQueue();
        if (this.aGt != null) {
            this.aGt.cancel(true);
            this.aGt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aGA;

        public C0060b(Queue<a> queue) {
            this.aGA = queue;
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
                a poll = this.aGA.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aGA.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gt = com.baidu.tbadk.imageManager.c.Ez().gt(poll.aGu.toCachedKey(poll.aGw));
                    if (gt != null) {
                        poll.aGx = gt;
                        poll.aGy = true;
                    } else {
                        Bitmap b = b.this.b(poll.aGu, poll.aGw);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aGu.getFilePath());
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
                                poll.aGx = new com.baidu.adp.widget.a.a(bitmap, poll.aGu.isGif(), poll.aGu.getFilePath());
                            } else {
                                poll.aGx = new com.baidu.adp.widget.a.a(b, poll.aGu.isGif(), poll.aGu.getFilePath());
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
            b.this.aGt = null;
            b.this.EJ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aGx;
                    if (aVar2 != null && !aVar.aGy) {
                        com.baidu.tbadk.imageManager.c.Ez().c(aVar.aGu.toCachedKey(aVar.aGw), aVar2);
                    }
                    if (aVar.aGv != null) {
                        aVar.aGv.a(aVar2, aVar.aGu.toCachedKey(aVar.aGw), aVar.aGy);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aGt = null;
            while (true) {
                a poll = this.aGA.poll();
                if (poll != null) {
                    if (poll.aGv != null) {
                        poll.aGv.a(null, poll.aGu.toCachedKey(poll.aGw), false);
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
                return com.baidu.tbadk.img.effect.c.EL().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EL().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aGu;
        com.baidu.tbadk.imageManager.b aGv;
        boolean aGw;
        com.baidu.adp.widget.a.a aGx;
        boolean aGy;

        private a() {
        }
    }
}
