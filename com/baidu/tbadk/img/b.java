package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aEf = new ConcurrentLinkedQueue();
    private volatile C0049b aEg;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Eb().ge(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aEi = bVar;
            aVar.aEh = imageFileInfo;
            aVar.aEj = z;
            this.aEf.add(aVar);
            Ej();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ej() {
        if (this.aEg == null && !this.aEf.isEmpty()) {
            this.aEg = new C0049b(this.aEf);
            this.aEg.execute(new Void[0]);
        }
    }

    public void Ek() {
        this.aEf = new ConcurrentLinkedQueue();
        if (this.aEg != null) {
            this.aEg.cancel(true);
            this.aEg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aEn;

        public C0049b(Queue<a> queue) {
            this.aEn = queue;
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
                a poll = this.aEn.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aEn.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a ge = com.baidu.tbadk.imageManager.c.Eb().ge(poll.aEh.toCachedKey(poll.aEj));
                    if (ge != null) {
                        poll.aEk = ge;
                        poll.aEl = true;
                    } else {
                        Bitmap b = b.this.b(poll.aEh, poll.aEj);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aEh.getFilePath());
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
                                poll.aEk = new com.baidu.adp.widget.a.a(bitmap, false, poll.aEh.getFilePath());
                            } else {
                                poll.aEk = new com.baidu.adp.widget.a.a(b, false, poll.aEh.getFilePath());
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
            b.this.aEg = null;
            b.this.Ej();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aEk;
                    if (aVar2 != null && !aVar.aEl) {
                        com.baidu.tbadk.imageManager.c.Eb().c(aVar.aEh.toCachedKey(aVar.aEj), aVar2);
                    }
                    if (aVar.aEi != null) {
                        aVar.aEi.a(aVar2, aVar.aEh.toCachedKey(aVar.aEj), aVar.aEl);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aEg = null;
            while (true) {
                a poll = this.aEn.poll();
                if (poll != null) {
                    if (poll.aEi != null) {
                        poll.aEi.a(null, poll.aEh.toCachedKey(poll.aEj), false);
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
                return com.baidu.tbadk.img.effect.c.El().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.El().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aEh;
        com.baidu.tbadk.imageManager.b aEi;
        boolean aEj;
        com.baidu.adp.widget.a.a aEk;
        boolean aEl;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
