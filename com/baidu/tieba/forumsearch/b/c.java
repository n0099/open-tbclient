package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes9.dex */
public class c {
    private SearchForum gkM;
    private List<SearchForum> gkN;
    private ArrayList<m> gkO;
    private String gkm;

    public c(String str) {
        this.gkm = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gkM = dataRes.exact_match;
            this.gkN = dataRes.fuzzy_match;
            this.gkO = new ArrayList<>();
            b bVar = new b(this.gkm);
            if (this.gkM != null) {
                bVar.a(this.gkM);
                this.gkO.add(bVar);
            }
            if (this.gkN != null) {
                for (SearchForum searchForum : this.gkN) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gkm);
                        bVar2.a(searchForum);
                        this.gkO.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bBp() {
        return this.gkO;
    }
}
