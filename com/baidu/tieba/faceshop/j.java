package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<List<String>, List<com.baidu.tieba.download.a>, List<com.baidu.tieba.download.a>> {
    final /* synthetic */ g a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ List<com.baidu.tieba.download.a> a(List<String>... listArr) {
        List<String>[] listArr2 = listArr;
        LinkedList linkedList = new LinkedList();
        if (listArr2[0] == null) {
            return linkedList;
        }
        for (int i = 0; i < listArr2[0].size(); i++) {
            MyEmotionGroupData a = d.a().a(TbadkApplication.E(), listArr2[0].get(i));
            if (a != null && e.a(a.getGroupId())) {
                com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(a.getGroupId());
                aVar.a(3);
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(List<com.baidu.tieba.download.a> list) {
        List<String> list2;
        List<com.baidu.tieba.download.a> list3 = list;
        super.a((j) list3);
        if (list3 == null) {
            list3 = new LinkedList<>();
        }
        com.baidu.tieba.download.c.a();
        for (com.baidu.tieba.download.a aVar : com.baidu.tieba.download.c.b()) {
            list2 = this.a.c;
            for (String str : list2) {
                if (aVar.g() == 11 && aVar.a().equals(str)) {
                    list3.add(aVar);
                }
            }
        }
        g gVar = this.a;
        g.a(list3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }
}
