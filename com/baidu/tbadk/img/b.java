package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> ayI = new ConcurrentLinkedQueue();
    private volatile C0046b ayJ;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ek().fT(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.ayL = bVar;
            aVar.ayK = imageFileInfo;
            aVar.ayM = z;
            this.ayI.add(aVar);
            Ep();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ep() {
        if (this.ayJ == null && !this.ayI.isEmpty()) {
            this.ayJ = new C0046b(this.ayI);
            this.ayJ.execute(new Void[0]);
        }
    }

    public void Eq() {
        this.ayI = new ConcurrentLinkedQueue();
        if (this.ayJ != null) {
            this.ayJ.cancel(true);
            this.ayJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046b extends BdAsyncTask<Void, a, a> {
        final Queue<a> ayQ;

        public C0046b(Queue<a> queue) {
            this.ayQ = queue;
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
                a poll = this.ayQ.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.ayQ.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.Ek().fT(poll.ayK.toCachedKey(poll.ayM));
                    if (fT != null) {
                        poll.ayN = fT;
                        poll.ayO = true;
                    } else {
                        Bitmap b = b.this.b(poll.ayK, poll.ayM);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.ayK.getFilePath());
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
                                poll.ayN = new com.baidu.adp.widget.a.a(bitmap, false, poll.ayK.getFilePath());
                            } else {
                                poll.ayN = new com.baidu.adp.widget.a.a(b, false, poll.ayK.getFilePath());
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
            b.this.ayJ = null;
            b.this.Ep();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.ayN;
                    if (aVar2 != null && !aVar.ayO) {
                        com.baidu.tbadk.imageManager.c.Ek().c(aVar.ayK.toCachedKey(aVar.ayM), aVar2);
                    }
                    if (aVar.ayL != null) {
                        aVar.ayL.a(aVar2, aVar.ayK.toCachedKey(aVar.ayM), aVar.ayO);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.ayJ = null;
            while (true) {
                a poll = this.ayQ.poll();
                if (poll != null) {
                    if (poll.ayL != null) {
                        poll.ayL.a(null, poll.ayK.toCachedKey(poll.ayM), false);
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
                return com.baidu.tbadk.img.effect.c.Er().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Er().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo ayK;
        com.baidu.tbadk.imageManager.b ayL;
        boolean ayM;
        com.baidu.adp.widget.a.a ayN;
        boolean ayO;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
