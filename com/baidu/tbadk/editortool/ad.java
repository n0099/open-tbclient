package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.message.EmptyMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Void, Void, Void> {
    final ArrayList<af> a = new ArrayList<>();
    final f b = new ae(this);
    final /* synthetic */ ac c;

    public ad(ac acVar) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        this.c = acVar;
        setPriority(4);
        bdAsyncTaskParallel = ac.d;
        setParallel(bdAsyncTaskParallel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        List list;
        List list2;
        int i = 0;
        while (true) {
            int i2 = i;
            list = this.c.c;
            if (i2 < list.size()) {
                list2 = this.c.c;
                ((e) list2.get(i2)).a(this.b);
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        this.c.b = this.a;
        MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(MessageTypes.CMD_EMOTIONS_GROUP_CHANGED));
    }
}
