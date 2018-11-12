package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aZe = new ConcurrentLinkedQueue();
    private volatile C0163b aZf;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Mq().hP(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aZh = bVar;
            aVar.aZg = imageFileInfo;
            aVar.aZi = z;
            this.aZe.add(aVar);
            Mz();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Mz() {
        if (this.aZf == null && !this.aZe.isEmpty()) {
            this.aZf = new C0163b(this.aZe);
            this.aZf.execute(new Void[0]);
        }
    }

    public void MA() {
        this.aZe = new ConcurrentLinkedQueue();
        if (this.aZf != null) {
            this.aZf.cancel(true);
            this.aZf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0163b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aZm;

        public C0163b(Queue<a> queue) {
            this.aZm = queue;
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
                a poll = this.aZm.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aZm.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a hP = com.baidu.tbadk.imageManager.c.Mq().hP(poll.aZg.toCachedKey(poll.aZi));
                    if (hP != null) {
                        poll.aZj = hP;
                        poll.aZk = true;
                    } else {
                        Bitmap b = b.this.b(poll.aZg, poll.aZi);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aZg.getFilePath());
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
                                poll.aZj = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aZg.isGif(), poll.aZg.getFilePath());
                            } else {
                                poll.aZj = new com.baidu.adp.widget.ImageView.a(b, poll.aZg.isGif(), poll.aZg.getFilePath());
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
            b.this.aZf = null;
            b.this.Mz();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aZj;
                    if (aVar2 != null && !aVar.aZk) {
                        com.baidu.tbadk.imageManager.c.Mq().c(aVar.aZg.toCachedKey(aVar.aZi), aVar2);
                    }
                    if (aVar.aZh != null) {
                        aVar.aZh.a(aVar2, aVar.aZg.toCachedKey(aVar.aZi), aVar.aZk);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aZf = null;
            while (true) {
                a poll = this.aZm.poll();
                if (poll != null) {
                    if (poll.aZh != null) {
                        poll.aZh.a(null, poll.aZg.toCachedKey(poll.aZi), false);
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
                return com.baidu.tbadk.img.effect.c.MB().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.MB().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aZg;
        com.baidu.tbadk.imageManager.b aZh;
        boolean aZi;
        com.baidu.adp.widget.ImageView.a aZj;
        boolean aZk;

        private a() {
        }
    }
}
