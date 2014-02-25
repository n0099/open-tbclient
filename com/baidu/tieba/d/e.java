package com.baidu.tieba.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.MyEmotionGroupData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<List<String>, List<a>, List<a>> {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public List<a> a(List<String>... listArr) {
        LinkedList linkedList = new LinkedList();
        if (listArr[0] == null) {
            return linkedList;
        }
        for (int i = 0; i < listArr[0].size(); i++) {
            MyEmotionGroupData a = com.baidu.tieba.data.emotions.j.a().a(TiebaApplication.A(), listArr[0].get(i));
            if (a != null && com.baidu.tieba.data.emotions.d.a(a.getGroupId())) {
                a aVar = new a(a.getGroupId());
                aVar.a(3);
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(List<a> list) {
        List<String> list2;
        super.a((e) list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (a aVar : g.a().b()) {
            list2 = this.a.c;
            for (String str : list2) {
                if (aVar.g() == 11 && aVar.a().equals(str)) {
                    list.add(aVar);
                }
            }
        }
        this.a.a(list);
    }
}
