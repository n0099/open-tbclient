package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private volatile C0552b eRE;
    private Queue<a> imagesWaitingForLoad = new ConcurrentLinkedQueue();

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.bub().CI(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.ImageView.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.ImageView.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.eRG = bVar;
            aVar.eRF = imageFileInfo;
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
        if (this.eRE == null && !this.imagesWaitingForLoad.isEmpty()) {
            this.eRE = new C0552b(this.imagesWaitingForLoad);
            this.eRE.execute(new Void[0]);
        }
    }

    public void cancelAllAsyncTask() {
        this.imagesWaitingForLoad = new ConcurrentLinkedQueue();
        if (this.eRE != null) {
            this.eRE.cancel(true);
            this.eRE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0552b extends BdAsyncTask<Void, a, a> {
        final Queue<a> imagesWaitingForLoadRef;

        public C0552b(Queue<a> queue) {
            this.imagesWaitingForLoadRef = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
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
                    com.baidu.adp.widget.ImageView.a CI = com.baidu.tbadk.imageManager.c.bub().CI(poll.eRF.toCachedKey(poll.includePersistActions));
                    if (CI != null) {
                        poll.eRH = CI;
                        poll.isFromCache = true;
                    } else {
                        Bitmap b = b.this.b(poll.eRF, poll.includePersistActions);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.eRF.getFilePath());
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
                                poll.eRH = new com.baidu.adp.widget.ImageView.a(bitmap, poll.eRF.isGif(), poll.eRF.getFilePath());
                            } else {
                                poll.eRH = new com.baidu.adp.widget.ImageView.a(b, poll.eRF.isGif(), poll.eRF.getFilePath());
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
            b.this.eRE = null;
            b.this.notifyNewTaskAdded();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.ImageView.a aVar2 = aVar.eRH;
                    if (aVar2 != null && !aVar.isFromCache) {
                        com.baidu.tbadk.imageManager.c.bub().c(aVar.eRF.toCachedKey(aVar.includePersistActions), aVar2);
                    }
                    if (aVar.eRG != null) {
                        aVar.eRG.a(aVar2, aVar.eRF.toCachedKey(aVar.includePersistActions), aVar.isFromCache);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.eRE = null;
            while (true) {
                a poll = this.imagesWaitingForLoadRef.poll();
                if (poll != null) {
                    if (poll.eRG != null) {
                        poll.eRG.a(null, poll.eRF.toCachedKey(poll.includePersistActions), false);
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
                return com.baidu.tbadk.img.effect.c.bud().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.bud().a(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        ImageFileInfo eRF;
        com.baidu.tbadk.imageManager.b eRG;
        com.baidu.adp.widget.ImageView.a eRH;
        boolean includePersistActions;
        boolean isFromCache;

        private a() {
        }
    }
}
