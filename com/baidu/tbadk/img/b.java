package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aDh = new ConcurrentLinkedQueue();
    private volatile C0047b aDi;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.DN().fL(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aDk = bVar;
            aVar.aDj = imageFileInfo;
            aVar.aDl = z;
            this.aDh.add(aVar);
            DS();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void DS() {
        if (this.aDi == null && !this.aDh.isEmpty()) {
            this.aDi = new C0047b(this.aDh);
            this.aDi.execute(new Void[0]);
        }
    }

    public void DT() {
        this.aDh = new ConcurrentLinkedQueue();
        if (this.aDi != null) {
            this.aDi.cancel(true);
            this.aDi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aDp;

        public C0047b(Queue<a> queue) {
            this.aDp = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public a doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                a poll = this.aDp.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aDp.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fL = com.baidu.tbadk.imageManager.c.DN().fL(poll.aDj.toCachedKey(poll.aDl));
                    if (fL != null) {
                        poll.aDm = fL;
                        poll.aDn = true;
                    } else {
                        Bitmap b = b.this.b(poll.aDj, poll.aDl);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aDj.getFilePath());
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
                                poll.aDm = new com.baidu.adp.widget.a.a(bitmap, false, poll.aDj.getFilePath());
                            } else {
                                poll.aDm = new com.baidu.adp.widget.a.a(b, false, poll.aDj.getFilePath());
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
            b.this.aDi = null;
            b.this.DS();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aDm;
                    if (aVar2 != null && !aVar.aDn) {
                        com.baidu.tbadk.imageManager.c.DN().c(aVar.aDj.toCachedKey(aVar.aDl), aVar2);
                    }
                    if (aVar.aDk != null) {
                        aVar.aDk.a(aVar2, aVar.aDj.toCachedKey(aVar.aDl), aVar.aDn);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aDi = null;
            while (true) {
                a poll = this.aDp.poll();
                if (poll != null) {
                    if (poll.aDk != null) {
                        poll.aDk.a(null, poll.aDj.toCachedKey(poll.aDl), false);
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
                return com.baidu.tbadk.img.effect.c.DU().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.DU().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aDj;
        com.baidu.tbadk.imageManager.b aDk;
        boolean aDl;
        com.baidu.adp.widget.a.a aDm;
        boolean aDn;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
