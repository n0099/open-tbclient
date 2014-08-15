package com.baidu.tieba.game;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, List<ab>> {
    final /* synthetic */ g a;
    private final /* synthetic */ List b;
    private final /* synthetic */ List c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, List list, List list2) {
        this.a = gVar;
        this.b = list;
        this.c = list2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<ab> doInBackground(String... strArr) {
        return ac.a().a(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(List<ab> list) {
        GameCenterHomeActivity gameCenterHomeActivity;
        n nVar;
        gameCenterHomeActivity = this.a.a;
        nVar = gameCenterHomeActivity.a;
        nVar.a(this.c, this.b, list);
    }
}
