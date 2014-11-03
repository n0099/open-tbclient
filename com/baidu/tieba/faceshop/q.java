package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<List<String>, Integer, Boolean> {
    final /* synthetic */ EmotionManageActivity asQ;

    private q(EmotionManageActivity emotionManageActivity) {
        this.asQ = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(EmotionManageActivity emotionManageActivity, q qVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Boolean doInBackground(List<String>... listArr) {
        List<String> list = listArr[0];
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        for (String str : list) {
            MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
            myEmotionGroupData.setGroupId(str);
            myEmotionGroupData.setUid(TbadkApplication.getCurrentAccount());
            if (d.CI().a(myEmotionGroupData)) {
                i++;
            }
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            com.baidu.tbadk.editortool.aa.rB().rC();
            this.asQ.asP = true;
            this.asQ.bC(true);
        }
    }
}
