package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e abM;
    final Queue<f> abN;

    public g(e eVar, Queue<f> queue) {
        this.abM = eVar;
        this.abN = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public f doInBackground(Void... voidArr) {
        f poll = this.abN.poll();
        if (poll == null) {
            return null;
        }
        if (isCancelled()) {
            this.abN.add(poll);
            return null;
        }
        com.baidu.adp.widget.a.a ek = com.baidu.tbadk.imageManager.e.vY().ek(poll.abH.toCachedKey(poll.abJ));
        if (ek != null) {
            poll.abK = ek;
            poll.abL = true;
        } else {
            Bitmap b = this.abM.b(poll.abH, poll.abJ);
            if (b != null) {
                poll.abK = new com.baidu.adp.widget.a.a(b, false, poll.abH.getFilePath());
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
        this.abM.abG = null;
        this.abM.wf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.abK;
                if (aVar != null && !fVar.abL) {
                    com.baidu.tbadk.imageManager.e.vY().c(fVar.abH.toCachedKey(fVar.abJ), aVar);
                }
                if (fVar.abI != null) {
                    fVar.abI.a(aVar, fVar.abH.toCachedKey(fVar.abJ), fVar.abL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.abM.abG = null;
        while (true) {
            f poll = this.abN.poll();
            if (poll != null) {
                if (poll.abI != null) {
                    poll.abI.a(null, poll.abH.toCachedKey(poll.abJ), false);
                }
            } else {
                return;
            }
        }
    }
}
