package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aCQ = new ConcurrentLinkedQueue();
    private volatile C0045b aCR;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.El().fI(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aCT = bVar;
            aVar.aCS = imageFileInfo;
            aVar.aCU = z;
            this.aCQ.add(aVar);
            Eq();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Eq() {
        if (this.aCR == null && !this.aCQ.isEmpty()) {
            this.aCR = new C0045b(this.aCQ);
            this.aCR.execute(new Void[0]);
        }
    }

    public void Er() {
        this.aCQ = new ConcurrentLinkedQueue();
        if (this.aCR != null) {
            this.aCR.cancel(true);
            this.aCR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aCY;

        public C0045b(Queue<a> queue) {
            this.aCY = queue;
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
                a poll = this.aCY.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aCY.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fI = com.baidu.tbadk.imageManager.c.El().fI(poll.aCS.toCachedKey(poll.aCU));
                    if (fI != null) {
                        poll.aCV = fI;
                        poll.aCW = true;
                    } else {
                        Bitmap b = b.this.b(poll.aCS, poll.aCU);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aCS.getFilePath());
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
                                poll.aCV = new com.baidu.adp.widget.a.a(bitmap, false, poll.aCS.getFilePath());
                            } else {
                                poll.aCV = new com.baidu.adp.widget.a.a(b, false, poll.aCS.getFilePath());
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
            b.this.aCR = null;
            b.this.Eq();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aCV;
                    if (aVar2 != null && !aVar.aCW) {
                        com.baidu.tbadk.imageManager.c.El().c(aVar.aCS.toCachedKey(aVar.aCU), aVar2);
                    }
                    if (aVar.aCT != null) {
                        aVar.aCT.a(aVar2, aVar.aCS.toCachedKey(aVar.aCU), aVar.aCW);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aCR = null;
            while (true) {
                a poll = this.aCY.poll();
                if (poll != null) {
                    if (poll.aCT != null) {
                        poll.aCT.a(null, poll.aCS.toCachedKey(poll.aCU), false);
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
                return com.baidu.tbadk.img.effect.c.Es().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Es().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aCS;
        com.baidu.tbadk.imageManager.b aCT;
        boolean aCU;
        com.baidu.adp.widget.a.a aCV;
        boolean aCW;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
