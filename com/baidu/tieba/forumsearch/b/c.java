package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private String fsG;
    private SearchForum fte;
    private List<SearchForum> ftf;
    private ArrayList<m> ftg;

    public c(String str) {
        this.fsG = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fte = dataRes.exact_match;
            this.ftf = dataRes.fuzzy_match;
            this.ftg = new ArrayList<>();
            b bVar = new b(this.fsG);
            if (this.fte != null) {
                bVar.a(this.fte);
                this.ftg.add(bVar);
            }
            if (this.ftf != null) {
                for (SearchForum searchForum : this.ftf) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.fsG);
                        bVar2.a(searchForum);
                        this.ftg.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> biS() {
        return this.ftg;
    }
}
