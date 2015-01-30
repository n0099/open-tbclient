package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e abP;
    final Queue<f> abQ;

    public g(e eVar, Queue<f> queue) {
        this.abP = eVar;
        this.abQ = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public f doInBackground(Void... voidArr) {
        f poll = this.abQ.poll();
        if (poll == null) {
            return null;
        }
        if (isCancelled()) {
            this.abQ.add(poll);
            return null;
        }
        com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.we().en(poll.abK.toCachedKey(poll.abM));
        if (en != null) {
            poll.abN = en;
            poll.abO = true;
        } else {
            Bitmap b = this.abP.b(poll.abK, poll.abM);
            if (b != null) {
                poll.abN = new com.baidu.adp.widget.a.a(b, false, poll.abK.getFilePath());
            }
        }
        publishProgress(poll);
        return poll;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(f fVar) {
        super.onPostExecute(fVar);
        this.abP.abJ = null;
        this.abP.wl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.abN;
                if (aVar != null && !fVar.abO) {
                    com.baidu.tbadk.imageManager.e.we().c(fVar.abK.toCachedKey(fVar.abM), aVar);
                }
                if (fVar.abL != null) {
                    fVar.abL.a(aVar, fVar.abK.toCachedKey(fVar.abM), fVar.abO);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.abP.abJ = null;
        while (true) {
            f poll = this.abQ.poll();
            if (poll != null) {
                if (poll.abL != null) {
                    poll.abL.a(null, poll.abK.toCachedKey(poll.abM), false);
                }
            } else {
                return;
            }
        }
    }
}
