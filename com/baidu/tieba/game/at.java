package com.baidu.tieba.game;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<String, Integer, List<GameInfoData>> {
    private final /* synthetic */ List aIo;
    private final /* synthetic */ List aIp;
    private final /* synthetic */ List aIq;
    private final /* synthetic */ List aIr;
    final /* synthetic */ as aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, List list, List list2, List list3, List list4) {
        this.aIs = asVar;
        this.aIo = list;
        this.aIp = list2;
        this.aIq = list3;
        this.aIr = list4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public List<GameInfoData> doInBackground(String... strArr) {
        return ab.Hs().G(this.aIo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public void onPostExecute(List<GameInfoData> list) {
        ao aoVar;
        av avVar;
        aoVar = this.aIs.aIm;
        avVar = aoVar.aIh;
        avVar.b(this.aIp, this.aIq, this.aIr, list);
    }
}
