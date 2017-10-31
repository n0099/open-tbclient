package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aFJ = new ConcurrentLinkedQueue();
    private volatile C0060b aFK;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Eg().go(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aFM = bVar;
            aVar.aFL = imageFileInfo;
            aVar.aFN = z;
            this.aFJ.add(aVar);
            Eq();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Eq() {
        if (this.aFK == null && !this.aFJ.isEmpty()) {
            this.aFK = new C0060b(this.aFJ);
            this.aFK.execute(new Void[0]);
        }
    }

    public void Er() {
        this.aFJ = new ConcurrentLinkedQueue();
        if (this.aFK != null) {
            this.aFK.cancel(true);
            this.aFK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aFR;

        public C0060b(Queue<a> queue) {
            this.aFR = queue;
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
                a poll = this.aFR.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aFR.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a go = com.baidu.tbadk.imageManager.c.Eg().go(poll.aFL.toCachedKey(poll.aFN));
                    if (go != null) {
                        poll.aFO = go;
                        poll.aFP = true;
                    } else {
                        Bitmap b = b.this.b(poll.aFL, poll.aFN);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aFL.getFilePath());
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
                                poll.aFO = new com.baidu.adp.widget.a.a(bitmap, poll.aFL.isGif(), poll.aFL.getFilePath());
                            } else {
                                poll.aFO = new com.baidu.adp.widget.a.a(b, poll.aFL.isGif(), poll.aFL.getFilePath());
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
            b.this.aFK = null;
            b.this.Eq();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aFO;
                    if (aVar2 != null && !aVar.aFP) {
                        com.baidu.tbadk.imageManager.c.Eg().c(aVar.aFL.toCachedKey(aVar.aFN), aVar2);
                    }
                    if (aVar.aFM != null) {
                        aVar.aFM.a(aVar2, aVar.aFL.toCachedKey(aVar.aFN), aVar.aFP);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aFK = null;
            while (true) {
                a poll = this.aFR.poll();
                if (poll != null) {
                    if (poll.aFM != null) {
                        poll.aFM.a(null, poll.aFL.toCachedKey(poll.aFN), false);
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
                return com.baidu.tbadk.img.effect.c.Es().b(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aFL;
        com.baidu.tbadk.imageManager.b aFM;
        boolean aFN;
        com.baidu.adp.widget.a.a aFO;
        boolean aFP;

        private a() {
        }
    }
}
