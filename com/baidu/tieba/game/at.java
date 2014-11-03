package com.baidu.tieba.game;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<String, Integer, List<GameInfoData>> {
    private final /* synthetic */ List aIB;
    private final /* synthetic */ List aIC;
    private final /* synthetic */ List aID;
    private final /* synthetic */ List aIE;
    final /* synthetic */ as aIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, List list, List list2, List list3, List list4) {
        this.aIF = asVar;
        this.aIB = list;
        this.aIC = list2;
        this.aID = list3;
        this.aIE = list4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public List<GameInfoData> doInBackground(String... strArr) {
        return ab.Hu().G(this.aIB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public void onPostExecute(List<GameInfoData> list) {
        ao aoVar;
        av avVar;
        aoVar = this.aIF.aIz;
        avVar = aoVar.aIt;
        avVar.b(this.aIC, this.aID, this.aIE, list);
    }
}
