package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class c {
    private SearchForum ghC;
    private List<SearchForum> ghD;
    private ArrayList<m> ghE;
    private String ghc;

    public c(String str) {
        this.ghc = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ghC = dataRes.exact_match;
            this.ghD = dataRes.fuzzy_match;
            this.ghE = new ArrayList<>();
            b bVar = new b(this.ghc);
            if (this.ghC != null) {
                bVar.a(this.ghC);
                this.ghE.add(bVar);
            }
            if (this.ghD != null) {
                for (SearchForum searchForum : this.ghD) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.ghc);
                        bVar2.a(searchForum);
                        this.ghE.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bAn() {
        return this.ghE;
    }
}
