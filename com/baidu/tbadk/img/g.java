package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e alm;
    final Queue<f> aln;

    public g(e eVar, Queue<f> queue) {
        this.alm = eVar;
        this.aln = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.aln.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.aln.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a er = com.baidu.tbadk.imageManager.e.zs().er(poll.alh.toCachedKey(poll.alj));
                if (er != null) {
                    poll.alk = er;
                    poll.all = true;
                } else {
                    Bitmap b = this.alm.b(poll.alh, poll.alj);
                    if (b != null) {
                        poll.alk = new com.baidu.adp.widget.a.a(b, false, poll.alh.getFilePath());
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
        this.alm.alg = null;
        this.alm.zz();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.alk;
                if (aVar != null && !fVar.all) {
                    com.baidu.tbadk.imageManager.e.zs().c(fVar.alh.toCachedKey(fVar.alj), aVar);
                }
                if (fVar.ali != null) {
                    fVar.ali.a(aVar, fVar.alh.toCachedKey(fVar.alj), fVar.all);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.alm.alg = null;
        while (true) {
            f poll = this.aln.poll();
            if (poll != null) {
                if (poll.ali != null) {
                    poll.ali.a(null, poll.alh.toCachedKey(poll.alj), false);
                }
            } else {
                return;
            }
        }
    }
}
