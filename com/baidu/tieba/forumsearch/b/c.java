package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes23.dex */
public class c {
    private String iFR;
    private SearchForum iGr;
    private List<SearchForum> iGs;
    private ArrayList<q> iGt;

    public c(String str) {
        this.iFR = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iGr = dataRes.exact_match;
            this.iGs = dataRes.fuzzy_match;
            this.iGt = new ArrayList<>();
            b bVar = new b(this.iFR);
            if (this.iGr != null) {
                bVar.a(this.iGr);
                this.iGt.add(bVar);
            }
            if (this.iGs != null) {
                for (SearchForum searchForum : this.iGs) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.iFR);
                        bVar2.a(searchForum);
                        this.iGt.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> cwF() {
        return this.iGt;
    }
}
