package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> axw = new ConcurrentLinkedQueue();
    private volatile C0046b axx;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.DS().fT(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.axz = bVar;
            aVar.axy = imageFileInfo;
            aVar.axA = z;
            this.axw.add(aVar);
            DX();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void DX() {
        if (this.axx == null && !this.axw.isEmpty()) {
            this.axx = new C0046b(this.axw);
            this.axx.execute(new Void[0]);
        }
    }

    public void DY() {
        this.axw = new ConcurrentLinkedQueue();
        if (this.axx != null) {
            this.axx.cancel(true);
            this.axx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046b extends BdAsyncTask<Void, a, a> {
        final Queue<a> axE;

        public C0046b(Queue<a> queue) {
            this.axE = queue;
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
                a poll = this.axE.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.axE.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.DS().fT(poll.axy.toCachedKey(poll.axA));
                    if (fT != null) {
                        poll.axB = fT;
                        poll.axC = true;
                    } else {
                        Bitmap b = b.this.b(poll.axy, poll.axA);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.axy.getFilePath());
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
                                poll.axB = new com.baidu.adp.widget.a.a(bitmap, false, poll.axy.getFilePath());
                            } else {
                                poll.axB = new com.baidu.adp.widget.a.a(b, false, poll.axy.getFilePath());
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
            b.this.axx = null;
            b.this.DX();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.axB;
                    if (aVar2 != null && !aVar.axC) {
                        com.baidu.tbadk.imageManager.c.DS().c(aVar.axy.toCachedKey(aVar.axA), aVar2);
                    }
                    if (aVar.axz != null) {
                        aVar.axz.a(aVar2, aVar.axy.toCachedKey(aVar.axA), aVar.axC);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.axx = null;
            while (true) {
                a poll = this.axE.poll();
                if (poll != null) {
                    if (poll.axz != null) {
                        poll.axz.a(null, poll.axy.toCachedKey(poll.axA), false);
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
                return com.baidu.tbadk.img.effect.c.DZ().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.DZ().c(imageFileInfo.getFilePath(), linkedList);
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
        boolean axA;
        com.baidu.adp.widget.a.a axB;
        boolean axC;
        ImageFileInfo axy;
        com.baidu.tbadk.imageManager.b axz;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
