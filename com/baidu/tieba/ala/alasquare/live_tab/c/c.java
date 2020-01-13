package com.baidu.tieba.ala.alasquare.live_tab.c;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private boolean hasMore = false;
    private List<String> ekl = new ArrayList();
    private List<bj> ekm = new ArrayList();
    private List<m> ekn = new ArrayList();

    public c(List<bj> list, boolean z) {
        j(list, z);
    }

    public boolean j(List<bj> list, boolean z) {
        if (list == null) {
            return false;
        }
        boolean bi = bi(list);
        this.hasMore = z;
        return bi;
    }

    private boolean bi(List<bj> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (bj bjVar : list) {
            if (bjVar != null) {
                String tid = bjVar.getTid();
                if (!this.ekl.contains(tid)) {
                    arrayList.add(bjVar);
                    this.ekl.add(tid);
                }
            }
        }
        if (v.isEmpty(arrayList)) {
            return false;
        }
        this.ekm.addAll(arrayList);
        this.ekn = bj(this.ekm);
        return !v.isEmpty(this.ekn);
    }

    private ArrayList<m> bj(List<bj> list) {
        ArrayList<m> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            k kVar = new k();
            com.baidu.tieba.ala.alasquare.a.c cVar = new com.baidu.tieba.ala.alasquare.a.c();
            cVar.efE = list.get(i);
            cVar.isLeft = true;
            kVar.ehP = cVar;
            if (i + 1 < size) {
                com.baidu.tieba.ala.alasquare.a.c cVar2 = new com.baidu.tieba.ala.alasquare.a.c();
                cVar2.efE = list.get(i + 1);
                kVar.ehQ = cVar2;
                cVar2.isRight = true;
            } else {
                cVar.isLeft = false;
                cVar.efC = true;
            }
            arrayList.add(kVar);
        }
        return arrayList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public List<m> getData() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.ekn)) {
            arrayList.addAll(this.ekn);
        }
        return arrayList;
    }

    public void clear() {
        this.hasMore = false;
        if (this.ekl != null) {
            this.ekl.clear();
        }
        if (this.ekm != null) {
            this.ekm.clear();
        }
        if (this.ekn != null) {
            this.ekn.clear();
        }
    }
}
