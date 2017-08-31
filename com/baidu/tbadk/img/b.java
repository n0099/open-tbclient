package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aFU = new ConcurrentLinkedQueue();
    private volatile C0062b aFV;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.Ev().go(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a();
            aVar.aFX = bVar;
            aVar.aFW = imageFileInfo;
            aVar.aFY = z;
            this.aFU.add(aVar);
            EE();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void EE() {
        if (this.aFV == null && !this.aFU.isEmpty()) {
            this.aFV = new C0062b(this.aFU);
            this.aFV.execute(new Void[0]);
        }
    }

    public void EF() {
        this.aFU = new ConcurrentLinkedQueue();
        if (this.aFV != null) {
            this.aFV.cancel(true);
            this.aFV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0062b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aGc;

        public C0062b(Queue<a> queue) {
            this.aGc = queue;
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
                a poll = this.aGc.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aGc.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a go = com.baidu.tbadk.imageManager.c.Ev().go(poll.aFW.toCachedKey(poll.aFY));
                    if (go != null) {
                        poll.aFZ = go;
                        poll.aGa = true;
                    } else {
                        Bitmap b = b.this.b(poll.aFW, poll.aFY);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aFW.getFilePath());
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
                                poll.aFZ = new com.baidu.adp.widget.a.a(bitmap, false, poll.aFW.getFilePath());
                            } else {
                                poll.aFZ = new com.baidu.adp.widget.a.a(b, false, poll.aFW.getFilePath());
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
            b.this.aFV = null;
            b.this.EE();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aFZ;
                    if (aVar2 != null && !aVar.aGa) {
                        com.baidu.tbadk.imageManager.c.Ev().c(aVar.aFW.toCachedKey(aVar.aFY), aVar2);
                    }
                    if (aVar.aFX != null) {
                        aVar.aFX.a(aVar2, aVar.aFW.toCachedKey(aVar.aFY), aVar.aGa);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aFV = null;
            while (true) {
                a poll = this.aGc.poll();
                if (poll != null) {
                    if (poll.aFX != null) {
                        poll.aFX.a(null, poll.aFW.toCachedKey(poll.aFY), false);
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
                return com.baidu.tbadk.img.effect.c.EG().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.EG().b(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aFW;
        com.baidu.tbadk.imageManager.b aFX;
        boolean aFY;
        com.baidu.adp.widget.a.a aFZ;
        boolean aGa;

        private a() {
        }
    }
}
