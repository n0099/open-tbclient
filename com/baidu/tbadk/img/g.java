package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final /* synthetic */ e Vi;
    final Queue<f> Vj;

    public g(e eVar, Queue<f> queue) {
        this.Vi = eVar;
        this.Vj = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.Vj.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.Vj.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.si().dt(poll.Vd.toCachedKey(poll.Vf));
                if (dt != null) {
                    poll.Vg = dt;
                    poll.Vh = true;
                } else {
                    Bitmap b = this.Vi.b(poll.Vd, poll.Vf);
                    if (b != null) {
                        poll.Vg = new com.baidu.adp.widget.a.a(b, false, poll.Vd.getFilePath());
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
        this.Vi.Vc = null;
        this.Vi.sp();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.Vg;
                if (aVar != null && !fVar.Vh) {
                    com.baidu.tbadk.imageManager.e.si().c(fVar.Vd.toCachedKey(fVar.Vf), aVar);
                }
                if (fVar.Ve != null) {
                    fVar.Ve.a(aVar, fVar.Vd.toCachedKey(fVar.Vf), fVar.Vh);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.Vi.Vc = null;
        while (true) {
            f poll = this.Vj.poll();
            if (poll != null) {
                if (poll.Ve != null) {
                    poll.Ve.a(null, poll.Vd.toCachedKey(poll.Vf), false);
                }
            } else {
                return;
            }
        }
    }
}
