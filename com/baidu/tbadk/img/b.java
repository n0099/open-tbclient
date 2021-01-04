package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private volatile C0598b fIF;
    private Queue<a> imagesWaitingForLoad = new ConcurrentLinkedQueue();

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.bGp().Ef(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.fIH = bVar;
            aVar.fIG = imageFileInfo;
            aVar.includePersistActions = z;
            this.imagesWaitingForLoad.add(aVar);
            notifyNewTaskAdded();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void notifyNewTaskAdded() {
        if (this.fIF == null && !this.imagesWaitingForLoad.isEmpty()) {
            this.fIF = new C0598b(this.imagesWaitingForLoad);
            this.fIF.execute(new Void[0]);
        }
    }

    public void cancelAllAsyncTask() {
        this.imagesWaitingForLoad = new ConcurrentLinkedQueue();
        if (this.fIF != null) {
            this.fIF.cancel(true);
            this.fIF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0598b extends BdAsyncTask<Void, a, a> {
        final Queue<a> imagesWaitingForLoadRef;

        public C0598b(Queue<a> queue) {
            this.imagesWaitingForLoadRef = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public a doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                a poll = this.imagesWaitingForLoadRef.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.imagesWaitingForLoadRef.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.ImageView.a Ef = com.baidu.tbadk.imageManager.c.bGp().Ef(poll.fIG.toCachedKey(poll.includePersistActions));
                    if (Ef != null) {
                        poll.fII = Ef;
                        poll.isFromCache = true;
                    } else {
                        Bitmap b2 = b.this.b(poll.fIG, poll.includePersistActions);
                        if (b2 != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.fIG.getFilePath());
                                if (i != 0) {
                                    try {
                                        bitmap = BitmapHelper.rotateBitmapBydegree(b2, i);
                                        if (b2 != bitmap) {
                                            try {
                                                b2.recycle();
                                                b2 = null;
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
                                poll.fII = new com.baidu.adp.widget.ImageView.a(bitmap, poll.fIG.isGif(), poll.fIG.getFilePath());
                            } else {
                                poll.fII = new com.baidu.adp.widget.ImageView.a(b2, poll.fIG.isGif(), poll.fIG.getFilePath());
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
            b.this.fIF = null;
            b.this.notifyNewTaskAdded();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.fII;
                    if (aVar2 != null && !aVar.isFromCache) {
                        com.baidu.tbadk.imageManager.c.bGp().b(aVar.fIG.toCachedKey(aVar.includePersistActions), aVar2);
                    }
                    if (aVar.fIH != null) {
                        aVar.fIH.a(aVar2, aVar.fIG.toCachedKey(aVar.includePersistActions), aVar.isFromCache);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.fIF = null;
            while (true) {
                a poll = this.imagesWaitingForLoadRef.poll();
                if (poll != null) {
                    if (poll.fIH != null) {
                        poll.fIH.a(null, poll.fIG.toCachedKey(poll.includePersistActions), false);
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
                return com.baidu.tbadk.img.effect.c.bGr().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.bGr().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo fIG;
        com.baidu.tbadk.imageManager.b fIH;
        com.baidu.adp.widget.ImageView.a fII;
        boolean includePersistActions;
        boolean isFromCache;

        private a() {
        }
    }
}
