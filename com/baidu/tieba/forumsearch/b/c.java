package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum gnL;
    private List<SearchForum> gnM;
    private ArrayList<m> gnN;
    private String gnk;

    public c(String str) {
        this.gnk = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gnL = dataRes.exact_match;
            this.gnM = dataRes.fuzzy_match;
            this.gnN = new ArrayList<>();
            b bVar = new b(this.gnk);
            if (this.gnL != null) {
                bVar.a(this.gnL);
                this.gnN.add(bVar);
            }
            if (this.gnM != null) {
                for (SearchForum searchForum : this.gnM) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gnk);
                        bVar2.a(searchForum);
                        this.gnN.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bDb() {
        return this.gnN;
    }
}
