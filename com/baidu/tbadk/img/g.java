package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, f, f> {
    final Queue<f> a;
    final /* synthetic */ e b;

    public g(e eVar, Queue<f> queue) {
        this.b = eVar;
        this.a = queue;
        super.setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public f doInBackground(Void... voidArr) {
        while (true) {
            f poll = this.a.poll();
            if (poll == null) {
                break;
            } else if (isCancelled()) {
                this.a.add(poll);
                break;
            } else {
                com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(poll.a.toCachedKey(poll.c));
                if (c != null) {
                    poll.d = c;
                    poll.e = true;
                } else {
                    Bitmap b = this.b.b(poll.a, poll.c);
                    if (b != null) {
                        poll.d = new com.baidu.adp.widget.a.a(b, false, poll.a.getFilePath());
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
        this.b.c = null;
        this.b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(f... fVarArr) {
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                com.baidu.adp.widget.a.a aVar = fVar.d;
                if (aVar != null && !fVar.e) {
                    com.baidu.tbadk.imageManager.e.a().b(fVar.a.toCachedKey(fVar.c), aVar);
                }
                if (fVar.b != null) {
                    fVar.b.a(aVar, fVar.a.toCachedKey(fVar.c), fVar.e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.b.c = null;
        while (true) {
            f poll = this.a.poll();
            if (poll != null) {
                if (poll.b != null) {
                    poll.b.a(null, poll.a.toCachedKey(poll.c), false);
                }
            } else {
                return;
            }
        }
    }
}
