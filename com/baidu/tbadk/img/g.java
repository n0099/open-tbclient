package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e Ve;
    final Queue<f> Vf;

    public g(e eVar, Queue<f> queue) {
        this.Ve = eVar;
        this.Vf = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.Vf.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.Vf.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.sg().dt(poll.UZ.toCachedKey(poll.Vb));
                if (dt != null) {
                    poll.Vc = dt;
                    poll.Vd = true;
                } else {
                    Bitmap b = this.Ve.b(poll.UZ, poll.Vb);
                    if (b != null) {
                        poll.Vc = new com.baidu.adp.widget.a.a(b, false, poll.UZ.getFilePath());
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
        this.Ve.UY = null;
        this.Ve.sn();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.Vc;
                if (aVar != null && !fVar.Vd) {
                    com.baidu.tbadk.imageManager.e.sg().c(fVar.UZ.toCachedKey(fVar.Vb), aVar);
                }
                if (fVar.Va != null) {
                    fVar.Va.a(aVar, fVar.UZ.toCachedKey(fVar.Vb), fVar.Vd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.Ve.UY = null;
        while (true) {
            f poll = this.Vf.poll();
            if (poll != null) {
                if (poll.Va != null) {
                    poll.Va.a(null, poll.UZ.toCachedKey(poll.Vb), false);
                }
            } else {
                return;
            }
        }
    }
}
