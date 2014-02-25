package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<ArrayList<g>, List<com.baidu.tieba.d.a>, List<com.baidu.tieba.d.a>> {
    ArrayList<g> a;
    final /* synthetic */ b b;

    private d(b bVar) {
        this.b = bVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(b bVar, d dVar) {
        this(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public List<com.baidu.tieba.d.a> a(ArrayList<g>... arrayListArr) {
        ArrayList<g> arrayList = arrayListArr[0];
        LinkedList linkedList = new LinkedList();
        if (arrayList == null) {
            return linkedList;
        }
        this.a = arrayList;
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String y = next.y();
            if (com.baidu.tieba.util.af.d(this.b.a(next.z())) != null) {
                com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(y);
                aVar.a(3);
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(List<com.baidu.tieba.d.a> list) {
        super.a((d) list);
        if (list == null) {
            list = new LinkedList<>();
        }
        for (com.baidu.tieba.d.a aVar : com.baidu.tieba.d.g.a().b()) {
            Iterator<g> it = this.a.iterator();
            while (it.hasNext()) {
                if (aVar.a().equals(it.next().y())) {
                    list.add(aVar);
                }
            }
        }
        this.b.a(list);
    }
}
