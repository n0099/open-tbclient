package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends BdAsyncTask<ArrayList<g>, List<com.baidu.tieba.d.a>, List<com.baidu.tieba.d.a>> {
    ArrayList<g> a;
    final /* synthetic */ b b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ List<com.baidu.tieba.d.a> a(ArrayList<g>... arrayListArr) {
        ArrayList<g> arrayList = arrayListArr[0];
        LinkedList linkedList = new LinkedList();
        if (arrayList == null) {
            return linkedList;
        }
        this.a = arrayList;
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String v = next.v();
            String w = next.w();
            b bVar = this.b;
            if (com.baidu.tieba.util.af.d(b.a(w)) != null) {
                com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(v);
                aVar.a(3);
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(List<com.baidu.tieba.d.a> list) {
        List<com.baidu.tieba.d.a> list2 = list;
        super.a((d) list2);
        if (list2 == null) {
            list2 = new LinkedList<>();
        }
        com.baidu.tieba.d.g.a();
        for (com.baidu.tieba.d.a aVar : com.baidu.tieba.d.g.b()) {
            Iterator<g> it = this.a.iterator();
            while (it.hasNext()) {
                if (aVar.a().equals(it.next().v())) {
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
