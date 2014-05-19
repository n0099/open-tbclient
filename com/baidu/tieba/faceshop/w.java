package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, List<v>> {
    final /* synthetic */ EmotionManageActivity a;

    private w(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EmotionManageActivity emotionManageActivity, w wVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public List<v> doInBackground(String... strArr) {
        List<MyEmotionGroupData> a = d.a().a(TbadkApplication.getCurrentAccount());
        List<EmotionGroupData> a2 = com.baidu.tbadk.editortool.v.a().a(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : a) {
            Iterator<EmotionGroupData> it = a2.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && e.a(next.getGroupId())) {
                        v vVar = new v(this.a, null);
                        vVar.a = next.getGroupId();
                        vVar.b = next.getGroupName();
                        vVar.d = com.baidu.tbadk.editortool.ac.a().c(vVar.a, "list.png");
                        linkedList.add(vVar);
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
    public void onPostExecute(List<v> list) {
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
