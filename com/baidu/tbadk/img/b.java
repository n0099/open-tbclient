package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class b {
    private Queue<a> ayA = new ConcurrentLinkedQueue();
    private volatile C0046b ayB;

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return com.baidu.tbadk.imageManager.c.DX().fW(imageFileInfo.toCachedKey(z));
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z, boolean z2) {
        com.baidu.adp.widget.a.a a2 = a(imageFileInfo, z);
        if (a2 == null) {
            if (z2) {
                return null;
            }
            a aVar = new a(this, null);
            aVar.ayD = bVar;
            aVar.ayC = imageFileInfo;
            aVar.ayE = z;
            this.ayA.add(aVar);
            Ec();
            return null;
        }
        return a2;
    }

    public com.baidu.adp.widget.a.a a(ImageFileInfo imageFileInfo, com.baidu.tbadk.imageManager.b bVar, boolean z) {
        return a(imageFileInfo, bVar, z, false);
    }

    protected void Ec() {
        if (this.ayB == null && !this.ayA.isEmpty()) {
            this.ayB = new C0046b(this.ayA);
            this.ayB.execute(new Void[0]);
        }
    }

    public void Ed() {
        this.ayA = new ConcurrentLinkedQueue();
        if (this.ayB != null) {
            this.ayB.cancel(true);
            this.ayB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.img.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046b extends BdAsyncTask<Void, a, a> {
        final Queue<a> ayI;

        public C0046b(Queue<a> queue) {
            this.ayI = queue;
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
                a poll = this.ayI.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.ayI.add(poll);
                    break;
                } else {
                    com.baidu.adp.widget.a.a fW = com.baidu.tbadk.imageManager.c.DX().fW(poll.ayC.toCachedKey(poll.ayE));
                    if (fW != null) {
                        poll.ayF = fW;
                        poll.ayG = true;
                    } else {
                        Bitmap b = b.this.b(poll.ayC, poll.ayE);
                        if (b != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.ayC.getFilePath());
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
                                poll.ayF = new com.baidu.adp.widget.a.a(bitmap, false, poll.ayC.getFilePath());
                            } else {
                                poll.ayF = new com.baidu.adp.widget.a.a(b, false, poll.ayC.getFilePath());
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
            b.this.ayB = null;
            b.this.Ec();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    com.baidu.adp.widget.a.a aVar2 = aVar.ayF;
                    if (aVar2 != null && !aVar.ayG) {
                        com.baidu.tbadk.imageManager.c.DX().c(aVar.ayC.toCachedKey(aVar.ayE), aVar2);
                    }
                    if (aVar.ayD != null) {
                        aVar.ayD.a(aVar2, aVar.ayC.toCachedKey(aVar.ayE), aVar.ayG);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.ayB = null;
            while (true) {
                a poll = this.ayI.poll();
                if (poll != null) {
                    if (poll.ayD != null) {
                        poll.ayD.a(null, poll.ayC.toCachedKey(poll.ayE), false);
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
                return com.baidu.tbadk.img.effect.c.Ee().a(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return com.baidu.tbadk.img.effect.c.Ee().c(imageFileInfo.getFilePath(), linkedList);
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
        ImageFileInfo ayC;
        com.baidu.tbadk.imageManager.b ayD;
        boolean ayE;
        com.baidu.adp.widget.a.a ayF;
        boolean ayG;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
