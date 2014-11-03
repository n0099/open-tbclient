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
    final /* synthetic */ EmotionManageActivity asQ;

    private t(EmotionManageActivity emotionManageActivity) {
        this.asQ = emotionManageActivity;
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
        List<MyEmotionGroupData> eJ = d.CI().eJ(TbadkApplication.getCurrentAccount());
        List<EmotionGroupData> cI = com.baidu.tbadk.editortool.u.ry().cI(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : eJ) {
            Iterator<EmotionGroupData> it = cI.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && e.eK(next.getGroupId())) {
                        s sVar = new s(this.asQ, null);
                        sVar.id = next.getGroupId();
                        sVar.name = next.getGroupName();
                        sVar.asS = com.baidu.tbadk.editortool.aa.rB().U(sVar.id, "list.png");
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
        this.asQ.showProgressBar();
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
        this.asQ.asD = list;
        this.asQ.bC(false);
        this.asQ.hideProgressBar();
        this.asQ.CL();
    }
}
