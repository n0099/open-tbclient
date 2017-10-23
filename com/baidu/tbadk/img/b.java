package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aEZ = new ConcurrentLinkedQueue();
    private volatile C0060b aFa;

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.DT().gh(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aFc = bVar;
            aVar.aFb = imageFileInfo;
            aVar.aFd = z;
            this.aEZ.add(aVar);
            Ed();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ed() {
        if (this.aFa == null && !this.aEZ.isEmpty()) {
            this.aFa = new C0060b(this.aEZ);
            this.aFa.execute(new Void[0]);
        }
    }

    public void Ee() {
        this.aEZ = new ConcurrentLinkedQueue();
        if (this.aFa != null) {
            this.aFa.cancel(true);
            this.aFa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aFh;

        public C0060b(Queue<a> queue) {
            this.aFh = queue;
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
                a poll = this.aFh.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aFh.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a gh = com.baidu.tbadk.imageManager.c.DT().gh(poll.aFb.toCachedKey(poll.aFd));
                    if (gh != null) {
                        poll.aFe = gh;
                        poll.aFf = true;
                    } else {
                        Bitmap b = b.this.b(poll.aFb, poll.aFd);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aFb.getFilePath());
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
                                poll.aFe = new com.baidu.adp.widget.ImageView.a(bitmap, poll.aFb.isGif(), poll.aFb.getFilePath());
                            } else {
                                poll.aFe = new com.baidu.adp.widget.ImageView.a(b, poll.aFb.isGif(), poll.aFb.getFilePath());
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
            b.this.aFa = null;
            b.this.Ed();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.aFe;
                    if (aVar2 != null && !aVar.aFf) {
                        com.baidu.tbadk.imageManager.c.DT().c(aVar.aFb.toCachedKey(aVar.aFd), aVar2);
                    }
                    if (aVar.aFc != null) {
                        aVar.aFc.a(aVar2, aVar.aFb.toCachedKey(aVar.aFd), aVar.aFf);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aFa = null;
            while (true) {
                a poll = this.aFh.poll();
                if (poll != null) {
                    if (poll.aFc != null) {
                        poll.aFc.a(null, poll.aFb.toCachedKey(poll.aFd), false);
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
                return com.baidu.tbadk.img.effect.c.Ef().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Ef().b(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aFb;
        com.baidu.tbadk.imageManager.b aFc;
        boolean aFd;
        com.baidu.adp.widget.ImageView.a aFe;
        boolean aFf;

        private a() {
        }
    }
}
