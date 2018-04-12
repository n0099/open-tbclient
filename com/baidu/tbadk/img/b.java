package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aHi = new ConcurrentLinkedQueue();
    private volatile C0100b aHj;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Fa().gG(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aHl = bVar;
            aVar.aHk = imageFileInfo;
            aVar.aHm = z;
            this.aHi.add(aVar);
            Fj();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Fj() {
        if (this.aHj == null && !this.aHi.isEmpty()) {
            this.aHj = new C0100b(this.aHi);
            this.aHj.execute(new Void[0]);
        }
    }

    public void Fk() {
        this.aHi = new ConcurrentLinkedQueue();
        if (this.aHj != null) {
            this.aHj.cancel(true);
            this.aHj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0100b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aHq;

        public C0100b(Queue<a> queue) {
            this.aHq = queue;
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
                a poll = this.aHq.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aHq.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(poll.aHk.toCachedKey(poll.aHm));
                    if (gG != null) {
                        poll.aHn = gG;
                        poll.aHo = true;
                    } else {
                        Bitmap b = b.this.b(poll.aHk, poll.aHm);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aHk.getFilePath());
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
                                poll.aHn = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aHk.isGif(), poll.aHk.getFilePath());
                            } else {
                                poll.aHn = new com.baidu.adp.widget.ImageView.a(b, poll.aHk.isGif(), poll.aHk.getFilePath());
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
            b.this.aHj = null;
            b.this.Fj();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aHn;
                    if (aVar2 != null && !aVar.aHo) {
                        com.baidu.tbadk.imageManager.c.Fa().c(aVar.aHk.toCachedKey(aVar.aHm), aVar2);
                    }
                    if (aVar.aHl != null) {
                        aVar.aHl.a(aVar2, aVar.aHk.toCachedKey(aVar.aHm), aVar.aHo);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aHj = null;
            while (true) {
                a poll = this.aHq.poll();
                if (poll != null) {
                    if (poll.aHl != null) {
                        poll.aHl.a(null, poll.aHk.toCachedKey(poll.aHm), false);
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
                return com.baidu.tbadk.img.effect.c.Fl().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Fl().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aHk;
        com.baidu.tbadk.imageManager.b aHl;
        boolean aHm;
        com.baidu.adp.widget.ImageView.a aHn;
        boolean aHo;

        private a() {
        }
    }
}
