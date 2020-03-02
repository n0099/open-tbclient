package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum gmP;
    private List<SearchForum> gmQ;
    private ArrayList<m> gmR;
    private String gmp;

    public c(String str) {
        this.gmp = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gmP = dataRes.exact_match;
            this.gmQ = dataRes.fuzzy_match;
            this.gmR = new ArrayList<>();
            b bVar = new b(this.gmp);
            if (this.gmP != null) {
                bVar.a(this.gmP);
                this.gmR.add(bVar);
            }
            if (this.gmQ != null) {
                for (SearchForum searchForum : this.gmQ) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gmp);
                        bVar2.a(searchForum);
                        this.gmR.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bCT() {
        return this.gmR;
    }
}
