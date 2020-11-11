package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class c {
    private SearchForum iFD;
    private List<SearchForum> iFE;
    private ArrayList<q> iFF;
    private String iFd;

    public c(String str) {
        this.iFd = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iFD = dataRes.exact_match;
            this.iFE = dataRes.fuzzy_match;
            this.iFF = new ArrayList<>();
            b bVar = new b(this.iFd);
            if (this.iFD != null) {
                bVar.a(this.iFD);
                this.iFF.add(bVar);
            }
            if (this.iFE != null) {
                for (SearchForum searchForum : this.iFE) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.iFd);
                        bVar2.a(searchForum);
                        this.iFF.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> cxd() {
        return this.iFF;
    }
}
