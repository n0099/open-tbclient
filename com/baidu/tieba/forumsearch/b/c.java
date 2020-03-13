package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private String gmC;
    private SearchForum gnc;
    private List<SearchForum> gnd;
    private ArrayList<m> gne;

    public c(String str) {
        this.gmC = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gnc = dataRes.exact_match;
            this.gnd = dataRes.fuzzy_match;
            this.gne = new ArrayList<>();
            b bVar = new b(this.gmC);
            if (this.gnc != null) {
                bVar.a(this.gnc);
                this.gne.add(bVar);
            }
            if (this.gnd != null) {
                for (SearchForum searchForum : this.gnd) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gmC);
                        bVar2.a(searchForum);
                        this.gne.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bCU() {
        return this.gne;
    }
}
