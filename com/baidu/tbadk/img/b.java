package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aQC = new ConcurrentLinkedQueue();
    private volatile C0115b aQD;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.IQ().he(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aQF = bVar;
            aVar.aQE = imageFileInfo;
            aVar.aQG = z;
            this.aQC.add(aVar);
            IZ();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void IZ() {
        if (this.aQD == null && !this.aQC.isEmpty()) {
            this.aQD = new C0115b(this.aQC);
            this.aQD.execute(new Void[0]);
        }
    }

    public void Ja() {
        this.aQC = new ConcurrentLinkedQueue();
        if (this.aQD != null) {
            this.aQD.cancel(true);
            this.aQD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aQK;

        public C0115b(Queue<a> queue) {
            this.aQK = queue;
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
                a poll = this.aQK.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aQK.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.IQ().he(poll.aQE.toCachedKey(poll.aQG));
                    if (he != null) {
                        poll.aQH = he;
                        poll.aQI = true;
                    } else {
                        Bitmap b = b.this.b(poll.aQE, poll.aQG);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aQE.getFilePath());
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
                                poll.aQH = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aQE.isGif(), poll.aQE.getFilePath());
                            } else {
                                poll.aQH = new com.baidu.adp.widget.ImageView.a(b, poll.aQE.isGif(), poll.aQE.getFilePath());
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
            b.this.aQD = null;
            b.this.IZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aQH;
                    if (aVar2 != null && !aVar.aQI) {
                        com.baidu.tbadk.imageManager.c.IQ().c(aVar.aQE.toCachedKey(aVar.aQG), aVar2);
                    }
                    if (aVar.aQF != null) {
                        aVar.aQF.a(aVar2, aVar.aQE.toCachedKey(aVar.aQG), aVar.aQI);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aQD = null;
            while (true) {
                a poll = this.aQK.poll();
                if (poll != null) {
                    if (poll.aQF != null) {
                        poll.aQF.a(null, poll.aQE.toCachedKey(poll.aQG), false);
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
                return com.baidu.tbadk.img.effect.c.Jb().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Jb().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aQE;
        com.baidu.tbadk.imageManager.b aQF;
        boolean aQG;
        com.baidu.adp.widget.ImageView.a aQH;
        boolean aQI;

        private a() {
        }
    }
}
