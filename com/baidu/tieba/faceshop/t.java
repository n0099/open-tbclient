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
    final /* synthetic */ EmotionManageActivity a;

    private t(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(EmotionManageActivity emotionManageActivity, t tVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<s> doInBackground(String... strArr) {
        List<MyEmotionGroupData> a = d.a().a(TbadkApplication.getCurrentAccount());
        List<EmotionGroupData> a2 = com.baidu.tbadk.editortool.u.a().a(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : a) {
            Iterator<EmotionGroupData> it = a2.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && e.a(next.getGroupId())) {
                        s sVar = new s(this.a, null);
                        sVar.a = next.getGroupId();
                        sVar.b = next.getGroupName();
                        sVar.d = com.baidu.tbadk.editortool.aa.a().b(sVar.a, "list.png");
                        linkedList.add(sVar);
                        break;
                    }
                }
            }
        }
        a.clear();
        a2.clear();
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.a.showProgressBar();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(List<s> list) {
        super.onPostExecute(list);
        if (list == null) {
            list = new LinkedList<>();
        }
        this.a.a = list;
        this.a.a(false);
        this.a.hideProgressBar();
        this.a.c();
    }
}
