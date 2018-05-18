package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aHj = new ConcurrentLinkedQueue();
    private volatile C0100b aHk;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.EY().gG(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aHm = bVar;
            aVar.aHl = imageFileInfo;
            aVar.aHn = z;
            this.aHj.add(aVar);
            Fh();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Fh() {
        if (this.aHk == null && !this.aHj.isEmpty()) {
            this.aHk = new C0100b(this.aHj);
            this.aHk.execute(new Void[0]);
        }
    }

    public void Fi() {
        this.aHj = new ConcurrentLinkedQueue();
        if (this.aHk != null) {
            this.aHk.cancel(true);
            this.aHk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0100b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aHr;

        public C0100b(Queue<a> queue) {
            this.aHr = queue;
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
                a poll = this.aHr.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aHr.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.EY().gG(poll.aHl.toCachedKey(poll.aHn));
                    if (gG != null) {
                        poll.aHo = gG;
                        poll.aHp = true;
                    } else {
                        Bitmap b = b.this.b(poll.aHl, poll.aHn);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aHl.getFilePath());
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
                                poll.aHo = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aHl.isGif(), poll.aHl.getFilePath());
                            } else {
                                poll.aHo = new com.baidu.adp.widget.ImageView.a(b, poll.aHl.isGif(), poll.aHl.getFilePath());
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
            b.this.aHk = null;
            b.this.Fh();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aHo;
                    if (aVar2 != null && !aVar.aHp) {
                        com.baidu.tbadk.imageManager.c.EY().c(aVar.aHl.toCachedKey(aVar.aHn), aVar2);
                    }
                    if (aVar.aHm != null) {
                        aVar.aHm.a(aVar2, aVar.aHl.toCachedKey(aVar.aHn), aVar.aHp);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aHk = null;
            while (true) {
                a poll = this.aHr.poll();
                if (poll != null) {
                    if (poll.aHm != null) {
                        poll.aHm.a(null, poll.aHl.toCachedKey(poll.aHn), false);
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
                return com.baidu.tbadk.img.effect.c.Fj().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Fj().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aHl;
        com.baidu.tbadk.imageManager.b aHm;
        boolean aHn;
        com.baidu.adp.widget.ImageView.a aHo;
        boolean aHp;

        private a() {
        }
    }
}
