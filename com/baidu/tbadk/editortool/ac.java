package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.message.EmptyMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Void, Void, Void> {
    final ArrayList<ae> Zc = new ArrayList<>();
    final f Zd = new ad(this);
    final /* synthetic */ ab Ze;

    public ac(ab abVar) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        this.Ze = abVar;
        setPriority(4);
        bdAsyncTaskParallel = ab.Zb;
        setParallel(bdAsyncTaskParallel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        List list;
        List list2;
        int i = 0;
        while (true) {
            int i2 = i;
            list = this.Ze.Za;
            if (i2 < list.size()) {
                list2 = this.Ze.Za;
                ((e) list2.get(i2)).a(this.Zd);
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        this.Ze.YZ = this.Zc;
        MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(2001120));
    }
}
