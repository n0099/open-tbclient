package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.EmotionGroupData;
import com.baidu.tieba.data.emotions.MyEmotionGroupData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, List<e>> {
    final /* synthetic */ EmotionManageActivity a;

    private f(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(EmotionManageActivity emotionManageActivity, a aVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public List<e> a(String... strArr) {
        List<MyEmotionGroupData> c = com.baidu.tieba.data.emotions.j.a().c(TiebaApplication.A());
        List<EmotionGroupData> a = com.baidu.tieba.data.emotions.j.a().a(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : c) {
            Iterator<EmotionGroupData> it = a.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.data.emotions.d.a(next.getGroupId())) {
                        e eVar = new e(this.a, null);
                        eVar.a = next.getGroupId();
                        eVar.b = next.getGroupName();
                        eVar.d = com.baidu.tieba.data.emotions.d.a(eVar.a, "list.png");
                        linkedList.add(eVar);
                        break;
                    }
                }
            }
        }
        c.clear();
        a.clear();
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
        this.a.showProgressBar();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(List<e> list) {
        super.a((f) list);
        if (list == null) {
            list = new LinkedList<>();
        }
        this.a.a = list;
        this.a.a(false);
        this.a.hideProgressBar();
        this.a.c();
    }
}
