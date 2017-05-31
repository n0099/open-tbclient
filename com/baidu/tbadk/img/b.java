package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> aCU = new ConcurrentLinkedQueue();
    private volatile C0047b aCV;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.DH().fK(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.aCX = bVar;
            aVar.aCW = imageFileInfo;
            aVar.aCY = z;
            this.aCU.add(aVar);
            DM();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void DM() {
        if (this.aCV == null && !this.aCU.isEmpty()) {
            this.aCV = new C0047b(this.aCU);
            this.aCV.execute(new Void[0]);
        }
    }

    public void DN() {
        this.aCU = new ConcurrentLinkedQueue();
        if (this.aCV != null) {
            this.aCV.cancel(true);
            this.aCV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047b extends BdAsyncTask<Void, a, a> {
        final Queue<a> aDc;

        public C0047b(Queue<a> queue) {
            this.aDc = queue;
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
                a poll = this.aDc.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.aDc.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fK = com.baidu.tbadk.imageManager.c.DH().fK(poll.aCW.toCachedKey(poll.aCY));
                    if (fK != null) {
                        poll.aCZ = fK;
                        poll.aDa = true;
                    } else {
                        Bitmap b = b.this.b(poll.aCW, poll.aCY);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.aCW.getFilePath());
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
                                poll.aCZ = new com.baidu.adp.widget.a.a(bitmap, false, poll.aCW.getFilePath());
                            } else {
                                poll.aCZ = new com.baidu.adp.widget.a.a(b, false, poll.aCW.getFilePath());
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
            b.this.aCV = null;
            b.this.DM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.aCZ;
                    if (aVar2 != null && !aVar.aDa) {
                        com.baidu.tbadk.imageManager.c.DH().c(aVar.aCW.toCachedKey(aVar.aCY), aVar2);
                    }
                    if (aVar.aCX != null) {
                        aVar.aCX.a(aVar2, aVar.aCW.toCachedKey(aVar.aCY), aVar.aDa);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.aCV = null;
            while (true) {
                a poll = this.aDc.poll();
                if (poll != null) {
                    if (poll.aCX != null) {
                        poll.aCX.a(null, poll.aCW.toCachedKey(poll.aCY), false);
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
                return com.baidu.tbadk.img.effect.c.DO().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.DO().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo aCW;
        com.baidu.tbadk.imageManager.b aCX;
        boolean aCY;
        com.baidu.adp.widget.a.a aCZ;
        boolean aDa;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
