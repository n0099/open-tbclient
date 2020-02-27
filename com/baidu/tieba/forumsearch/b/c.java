package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum gmN;
    private List<SearchForum> gmO;
    private ArrayList<m> gmP;
    private String gmn;

    public c(String str) {
        this.gmn = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gmN = dataRes.exact_match;
            this.gmO = dataRes.fuzzy_match;
            this.gmP = new ArrayList<>();
            b bVar = new b(this.gmn);
            if (this.gmN != null) {
                bVar.a(this.gmN);
                this.gmP.add(bVar);
            }
            if (this.gmO != null) {
                for (SearchForum searchForum : this.gmO) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gmn);
                        bVar2.a(searchForum);
                        this.gmP.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bCR() {
        return this.gmP;
    }
}
