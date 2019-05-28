package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private String fmZ;
    private SearchForum fnx;
    private List<SearchForum> fny;
    private ArrayList<m> fnz;

    public c(String str) {
        this.fmZ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fnx = dataRes.exact_match;
            this.fny = dataRes.fuzzy_match;
            this.fnz = new ArrayList<>();
            b bVar = new b(this.fmZ);
            if (this.fnx != null) {
                bVar.a(this.fnx);
                this.fnz.add(bVar);
            }
            if (this.fny != null) {
                for (SearchForum searchForum : this.fny) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.fmZ);
                        bVar2.a(searchForum);
                        this.fnz.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> biU() {
        return this.fnz;
    }
}
