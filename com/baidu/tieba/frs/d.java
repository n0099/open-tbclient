package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
final class d extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<com.baidu.tieba.download.a>, List<com.baidu.tieba.download.a>> {
    ArrayList<com.baidu.tbadk.core.data.b> a;
    final /* synthetic */ b b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ List<com.baidu.tieba.download.a> a(ArrayList<com.baidu.tbadk.core.data.b>... arrayListArr) {
        ArrayList<com.baidu.tbadk.core.data.b> arrayList = arrayListArr[0];
        LinkedList linkedList = new LinkedList();
        if (arrayList == null) {
            return linkedList;
        }
        this.a = arrayList;
        Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.b next = it.next();
            String e = next.e();
            String f = next.f();
            b bVar = this.b;
            if (com.baidu.tbadk.core.util.w.d(b.a(f)) != null) {
                com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(e);
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
        List<com.baidu.tieba.download.a> list2 = list;
        super.a((d) list2);
        if (list2 == null) {
            list2 = new LinkedList<>();
        }
        com.baidu.tieba.download.c.a();
        for (com.baidu.tieba.download.a aVar : com.baidu.tieba.download.c.b()) {
            Iterator<com.baidu.tbadk.core.data.b> it = this.a.iterator();
            while (it.hasNext()) {
                if (aVar.a().equals(it.next().e())) {
                    list2.add(aVar);
                }
            }
        }
        b bVar = this.b;
        b.a(list2);
    }

    private d(b bVar) {
        this.b = bVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar, byte b) {
        this(bVar);
    }
}
