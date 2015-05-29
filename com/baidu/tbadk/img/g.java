package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e amv;
    final Queue<f> amw;

    public g(e eVar, Queue<f> queue) {
        this.amv = eVar;
        this.amw = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.amw.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.amw.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a eL = com.baidu.tbadk.imageManager.e.Al().eL(poll.amq.toCachedKey(poll.ams));
                if (eL != null) {
                    poll.amt = eL;
                    poll.amu = true;
                } else {
                    Bitmap b = this.amv.b(poll.amq, poll.ams);
                    if (b != null) {
                        poll.amt = new com.baidu.adp.widget.a.a(b, false, poll.amq.getFilePath());
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
        this.amv.amp = null;
        this.amv.Ar();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.amt;
                if (aVar != null && !fVar.amu) {
                    com.baidu.tbadk.imageManager.e.Al().c(fVar.amq.toCachedKey(fVar.ams), aVar);
                }
                if (fVar.amr != null) {
                    fVar.amr.a(aVar, fVar.amq.toCachedKey(fVar.ams), fVar.amu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.amv.amp = null;
        while (true) {
            f poll = this.amw.poll();
            if (poll != null) {
                if (poll.amr != null) {
                    poll.amr.a(null, poll.amq.toCachedKey(poll.ams), false);
                }
            } else {
                return;
            }
        }
    }
}
