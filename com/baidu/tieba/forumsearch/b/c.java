package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum hlJ;
    private List<SearchForum> hlK;
    private ArrayList<o> hlL;
    private String hli;

    public c(String str) {
        this.hli = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hlJ = dataRes.exact_match;
            this.hlK = dataRes.fuzzy_match;
            this.hlL = new ArrayList<>();
            b bVar = new b(this.hli);
            if (this.hlJ != null) {
                bVar.a(this.hlJ);
                this.hlL.add(bVar);
            }
            if (this.hlK != null) {
                for (SearchForum searchForum : this.hlK) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hli);
                        bVar2.a(searchForum);
                        this.hlL.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<o> bTV() {
        return this.hlL;
    }
}
