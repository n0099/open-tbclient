package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aDg = new ConcurrentLinkedQueue();
    private volatile C0043b aDh;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.EJ().fO(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aDj = bVar;
            aVar.aDi = imageFileInfo;
            aVar.aDk = z;
            this.aDg.add(aVar);
            EO();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EO() {
        if (this.aDh == null && !this.aDg.isEmpty()) {
            this.aDh = new C0043b(this.aDg);
            this.aDh.execute(new Void[0]);
        }
    }

    public void EP() {
        this.aDg = new ConcurrentLinkedQueue();
        if (this.aDh != null) {
            this.aDh.cancel(true);
            this.aDh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0043b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aDo;

        public C0043b(Queue<a> queue) {
            this.aDo = queue;
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
                a poll = this.aDo.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aDo.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fO = com.baidu.tbadk.imageManager.c.EJ().fO(poll.aDi.toCachedKey(poll.aDk));
                    if (fO != null) {
                        poll.aDl = fO;
                        poll.aDm = true;
                    } else {
                        Bitmap b = b.this.b(poll.aDi, poll.aDk);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aDi.getFilePath());
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
                                poll.aDl = new com.baidu.adp.widget.a.a(bitmap, false, poll.aDi.getFilePath());
                            } else {
                                poll.aDl = new com.baidu.adp.widget.a.a(b, false, poll.aDi.getFilePath());
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
            b.this.aDh = null;
            b.this.EO();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aDl;
                    if (aVar2 != null && !aVar.aDm) {
                        com.baidu.tbadk.imageManager.c.EJ().c(aVar.aDi.toCachedKey(aVar.aDk), aVar2);
                    }
                    if (aVar.aDj != null) {
                        aVar.aDj.a(aVar2, aVar.aDi.toCachedKey(aVar.aDk), aVar.aDm);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aDh = null;
            while (true) {
                a poll = this.aDo.poll();
                if (poll != null) {
                    if (poll.aDj != null) {
                        poll.aDj.a(null, poll.aDi.toCachedKey(poll.aDk), false);
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
                return com.baidu.tbadk.img.effect.c.EQ().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EQ().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aDi;
        com.baidu.tbadk.imageManager.b aDj;
        boolean aDk;
        com.baidu.adp.widget.a.a aDl;
        boolean aDm;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
