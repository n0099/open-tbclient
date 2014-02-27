package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.EmotionGroupData;
import com.baidu.tieba.data.emotions.MyEmotionGroupData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
final class f extends BdAsyncTask<String, Integer, List<e>> {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ List<e> a(String... strArr) {
        List<MyEmotionGroupData> c = com.baidu.tieba.data.emotions.j.a().c(TiebaApplication.v());
        List<EmotionGroupData> a = com.baidu.tieba.data.emotions.j.a().a(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : c) {
            Iterator<EmotionGroupData> it = a.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.data.emotions.d.a(next.getGroupId())) {
                        e eVar = new e(this.a, (byte) 0);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(List<e> list) {
        List<e> list2 = list;
        super.a((f) list2);
        if (list2 == null) {
            list2 = new LinkedList<>();
        }
        this.a.a = list2;
        this.a.a(false);
        this.a.hideProgressBar();
        this.a.a();
    }

    private f(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(EmotionManageActivity emotionManageActivity, byte b) {
        this(emotionManageActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
        this.a.showProgressBar();
    }
}
