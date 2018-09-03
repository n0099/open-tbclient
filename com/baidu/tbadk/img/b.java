package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private volatile C0115b aQA;
    private Queue<a> aQz = new ConcurrentLinkedQueue();

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
            aVar.aQC = bVar;
            aVar.aQB = imageFileInfo;
            aVar.aQD = z;
            this.aQz.add(aVar);
            IZ();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void IZ() {
        if (this.aQA == null && !this.aQz.isEmpty()) {
            this.aQA = new C0115b(this.aQz);
            this.aQA.execute(new Void[0]);
        }
    }

    public void Ja() {
        this.aQz = new ConcurrentLinkedQueue();
        if (this.aQA != null) {
            this.aQA.cancel(true);
            this.aQA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aQH;

        public C0115b(Queue<a> queue) {
            this.aQH = queue;
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
                a poll = this.aQH.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aQH.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.IQ().he(poll.aQB.toCachedKey(poll.aQD));
                    if (he != null) {
                        poll.aQE = he;
                        poll.aQF = true;
                    } else {
                        Bitmap b = b.this.b(poll.aQB, poll.aQD);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aQB.getFilePath());
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
                                poll.aQE = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aQB.isGif(), poll.aQB.getFilePath());
                            } else {
                                poll.aQE = new com.baidu.adp.widget.ImageView.a(b, poll.aQB.isGif(), poll.aQB.getFilePath());
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
            b.this.aQA = null;
            b.this.IZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aQE;
                    if (aVar2 != null && !aVar.aQF) {
                        com.baidu.tbadk.imageManager.c.IQ().c(aVar.aQB.toCachedKey(aVar.aQD), aVar2);
                    }
                    if (aVar.aQC != null) {
                        aVar.aQC.a(aVar2, aVar.aQB.toCachedKey(aVar.aQD), aVar.aQF);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aQA = null;
            while (true) {
                a poll = this.aQH.poll();
                if (poll != null) {
                    if (poll.aQC != null) {
                        poll.aQC.a(null, poll.aQB.toCachedKey(poll.aQD), false);
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
        ImageFileInfo aQB;
        com.baidu.tbadk.imageManager.b aQC;
        boolean aQD;
        com.baidu.adp.widget.ImageView.a aQE;
        boolean aQF;

        private a() {
        }
    }
}
