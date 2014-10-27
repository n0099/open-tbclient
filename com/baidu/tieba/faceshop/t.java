package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, List<s>> {
    final /* synthetic */ EmotionManageActivity asH;

    private t(EmotionManageActivity emotionManageActivity) {
        this.asH = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(EmotionManageActivity emotionManageActivity, t tVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public List<s> doInBackground(String... strArr) {
        List<MyEmotionGroupData> eJ = d.CG().eJ(TbadkApplication.getCurrentAccount());
        List<EmotionGroupData> cI = com.baidu.tbadk.editortool.u.rw().cI(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : eJ) {
            Iterator<EmotionGroupData> it = cI.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && e.eK(next.getGroupId())) {
                        s sVar = new s(this.asH, null);
                        sVar.id = next.getGroupId();
                        sVar.name = next.getGroupName();
                        sVar.asJ = com.baidu.tbadk.editortool.aa.rz().U(sVar.id, "list.png");
                        linkedList.add(sVar);
                        break;
                    }
                }
            }
        }
        eJ.clear();
        cI.clear();
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.asH.showProgressBar();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public void onPostExecute(List<s> list) {
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        this.asH.asu = list;
        this.asH.bC(false);
        this.asH.hideProgressBar();
        this.asH.CJ();
    }
}
