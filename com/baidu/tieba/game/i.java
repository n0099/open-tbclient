package com.baidu.tieba.game;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, List<com.baidu.tbadk.game.b>> {
    final /* synthetic */ h a;
    private final /* synthetic */ List b;
    private final /* synthetic */ List c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, List list, List list2) {
        this.a = hVar;
        this.b = list;
        this.c = list2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<com.baidu.tbadk.game.b> doInBackground(String... strArr) {
        return ae.a().a(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(List<com.baidu.tbadk.game.b> list) {
        GameCenterHomeActivity gameCenterHomeActivity;
        n nVar;
        gameCenterHomeActivity = this.a.a;
        nVar = gameCenterHomeActivity.a;
        nVar.a(this.c, this.b, list);
    }
}
