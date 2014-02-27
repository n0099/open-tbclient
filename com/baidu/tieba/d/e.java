package com.baidu.tieba.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.MyEmotionGroupData;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
final class e extends BdAsyncTask<List<String>, List<a>, List<a>> {
    final /* synthetic */ d a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ List<a> a(List<String>... listArr) {
        List<String>[] listArr2 = listArr;
        LinkedList linkedList = new LinkedList();
        if (listArr2[0] == null) {
            return linkedList;
        }
        for (int i = 0; i < listArr2[0].size(); i++) {
            MyEmotionGroupData a = com.baidu.tieba.data.emotions.j.a().a(TiebaApplication.v(), listArr2[0].get(i));
            if (a != null && com.baidu.tieba.data.emotions.d.a(a.getGroupId())) {
                a aVar = new a(a.getGroupId());
                aVar.a(3);
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(List<a> list) {
        List<String> list2;
        List<a> list3 = list;
        super.a((e) list3);
        if (list3 == null) {
            list3 = new LinkedList<>();
        }
        g.a();
        for (a aVar : g.b()) {
            list2 = this.a.c;
            for (String str : list2) {
                if (aVar.g() == 11 && aVar.a().equals(str)) {
                    list3.add(aVar);
                }
            }
        }
        d dVar = this.a;
        d.a(list3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }
}
