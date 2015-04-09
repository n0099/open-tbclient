package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.message.EmptyMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Void, Void, Void> {
    final ArrayList<ad> ajE = new ArrayList<>();
    final b ajF = new ac(this);
    final /* synthetic */ aa ajG;

    public ab(aa aaVar) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        this.ajG = aaVar;
        setPriority(4);
        bdAsyncTaskParallel = aa.ajD;
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
            list = this.ajG.ajC;
            if (i2 < list.size()) {
                list2 = this.ajG.ajC;
                ((a) list2.get(i2)).a(this.ajF);
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
        this.ajG.ajB = this.ajE;
        MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(2001120));
    }
}
