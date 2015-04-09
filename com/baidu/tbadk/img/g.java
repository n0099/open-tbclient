package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e alu;
    final Queue<f> alv;

    public g(e eVar, Queue<f> queue) {
        this.alu = eVar;
        this.alv = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.alv.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.alv.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a eu = com.baidu.tbadk.imageManager.e.zy().eu(poll.alp.toCachedKey(poll.alr));
                if (eu != null) {
                    poll.als = eu;
                    poll.alt = true;
                } else {
                    Bitmap b = this.alu.b(poll.alp, poll.alr);
                    if (b != null) {
                        poll.als = new com.baidu.adp.widget.a.a(b, false, poll.alp.getFilePath());
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
    public void onPostExecute(f fVar) {
        super.onPostExecute(fVar);
        this.alu.alo = null;
        this.alu.zF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.als;
                if (aVar != null && !fVar.alt) {
                    com.baidu.tbadk.imageManager.e.zy().c(fVar.alp.toCachedKey(fVar.alr), aVar);
                }
                if (fVar.alq != null) {
                    fVar.alq.a(aVar, fVar.alp.toCachedKey(fVar.alr), fVar.alt);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.alu.alo = null;
        while (true) {
            f poll = this.alv.poll();
            if (poll != null) {
                if (poll.alq != null) {
                    poll.alq.a(null, poll.alp.toCachedKey(poll.alr), false);
                }
            } else {
                return;
            }
        }
    }
}
