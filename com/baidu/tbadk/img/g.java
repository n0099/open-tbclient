package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e abm;
    final Queue<f> abn;

    public g(e eVar, Queue<f> queue) {
        this.abm = eVar;
        this.abn = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.abn.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.abn.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.vL().en(poll.abh.toCachedKey(poll.abj));
                if (en != null) {
                    poll.abk = en;
                    poll.abl = true;
                } else {
                    Bitmap b = this.abm.b(poll.abh, poll.abj);
                    if (b != null) {
                        poll.abk = new com.baidu.adp.widget.a.a(b, false, poll.abh.getFilePath());
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
        this.abm.abg = null;
        this.abm.vS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.abk;
                if (aVar != null && !fVar.abl) {
                    com.baidu.tbadk.imageManager.e.vL().c(fVar.abh.toCachedKey(fVar.abj), aVar);
                }
                if (fVar.abi != null) {
                    fVar.abi.a(aVar, fVar.abh.toCachedKey(fVar.abj), fVar.abl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.abm.abg = null;
        while (true) {
            f poll = this.abn.poll();
            if (poll != null) {
                if (poll.abi != null) {
                    poll.abi.a(null, poll.abh.toCachedKey(poll.abj), false);
                }
            } else {
                return;
            }
        }
    }
}
