package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aYq = new ConcurrentLinkedQueue();
    private volatile C0139b aYr;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Me().hO(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aYt = bVar;
            aVar.aYs = imageFileInfo;
            aVar.aYu = z;
            this.aYq.add(aVar);
            Mn();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Mn() {
        if (this.aYr == null && !this.aYq.isEmpty()) {
            this.aYr = new C0139b(this.aYq);
            this.aYr.execute(new Void[0]);
        }
    }

    public void Mo() {
        this.aYq = new ConcurrentLinkedQueue();
        if (this.aYr != null) {
            this.aYr.cancel(true);
            this.aYr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0139b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aYy;

        public C0139b(Queue<a> queue) {
            this.aYy = queue;
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
                a poll = this.aYy.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aYy.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a hO = com.baidu.tbadk.imageManager.c.Me().hO(poll.aYs.toCachedKey(poll.aYu));
                    if (hO != null) {
                        poll.aYv = hO;
                        poll.aYw = true;
                    } else {
                        Bitmap b = b.this.b(poll.aYs, poll.aYu);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aYs.getFilePath());
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
                                poll.aYv = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aYs.isGif(), poll.aYs.getFilePath());
                            } else {
                                poll.aYv = new com.baidu.adp.widget.ImageView.a(b, poll.aYs.isGif(), poll.aYs.getFilePath());
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
            b.this.aYr = null;
            b.this.Mn();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aYv;
                    if (aVar2 != null && !aVar.aYw) {
                        com.baidu.tbadk.imageManager.c.Me().c(aVar.aYs.toCachedKey(aVar.aYu), aVar2);
                    }
                    if (aVar.aYt != null) {
                        aVar.aYt.a(aVar2, aVar.aYs.toCachedKey(aVar.aYu), aVar.aYw);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aYr = null;
            while (true) {
                a poll = this.aYy.poll();
                if (poll != null) {
                    if (poll.aYt != null) {
                        poll.aYt.a(null, poll.aYs.toCachedKey(poll.aYu), false);
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
                return com.baidu.tbadk.img.effect.c.Mp().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Mp().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo aYs;
        com.baidu.tbadk.imageManager.b aYt;
        boolean aYu;
        com.baidu.adp.widget.ImageView.a aYv;
        boolean aYw;

        private a() {
        }
    }
}
