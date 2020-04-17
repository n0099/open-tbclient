package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum gWR;
    private List<SearchForum> gWS;
    private ArrayList<m> gWT;
    private String gWq;

    public c(String str) {
        this.gWq = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gWR = dataRes.exact_match;
            this.gWS = dataRes.fuzzy_match;
            this.gWT = new ArrayList<>();
            b bVar = new b(this.gWq);
            if (this.gWR != null) {
                bVar.a(this.gWR);
                this.gWT.add(bVar);
            }
            if (this.gWS != null) {
                for (SearchForum searchForum : this.gWS) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gWq);
                        bVar2.a(searchForum);
                        this.gWT.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bNB() {
        return this.gWT;
    }
}
