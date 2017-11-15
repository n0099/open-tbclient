package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aFR = new ConcurrentLinkedQueue();
    private volatile C0060b aFS;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Es().gp(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aFU = bVar;
            aVar.aFT = imageFileInfo;
            aVar.aFV = z;
            this.aFR.add(aVar);
            EC();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EC() {
        if (this.aFS == null && !this.aFR.isEmpty()) {
            this.aFS = new C0060b(this.aFR);
            this.aFS.execute(new Void[0]);
        }
    }

    public void ED() {
        this.aFR = new ConcurrentLinkedQueue();
        if (this.aFS != null) {
            this.aFS.cancel(true);
            this.aFS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aFZ;

        public C0060b(Queue<a> queue) {
            this.aFZ = queue;
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
                a poll = this.aFZ.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aFZ.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a gp = com.baidu.tbadk.imageManager.c.Es().gp(poll.aFT.toCachedKey(poll.aFV));
                    if (gp != null) {
                        poll.aFW = gp;
                        poll.aFX = true;
                    } else {
                        Bitmap b = b.this.b(poll.aFT, poll.aFV);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aFT.getFilePath());
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
                                poll.aFW = new com.baidu.adp.widget.a.a(bitmap, poll.aFT.isGif(), poll.aFT.getFilePath());
                            } else {
                                poll.aFW = new com.baidu.adp.widget.a.a(b, poll.aFT.isGif(), poll.aFT.getFilePath());
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
            b.this.aFS = null;
            b.this.EC();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aFW;
                    if (aVar2 != null && !aVar.aFX) {
                        com.baidu.tbadk.imageManager.c.Es().c(aVar.aFT.toCachedKey(aVar.aFV), aVar2);
                    }
                    if (aVar.aFU != null) {
                        aVar.aFU.a(aVar2, aVar.aFT.toCachedKey(aVar.aFV), aVar.aFX);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aFS = null;
            while (true) {
                a poll = this.aFZ.poll();
                if (poll != null) {
                    if (poll.aFU != null) {
                        poll.aFU.a(null, poll.aFT.toCachedKey(poll.aFV), false);
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
                return com.baidu.tbadk.img.effect.c.EE().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EE().b(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aFT;
        com.baidu.tbadk.imageManager.b aFU;
        boolean aFV;
        com.baidu.adp.widget.a.a aFW;
        boolean aFX;

        private a() {
        }
    }
}
