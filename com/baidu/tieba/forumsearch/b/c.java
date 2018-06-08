package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private SearchForum dgA;
    private List<SearchForum> dgB;
    private ArrayList<h> dgC;
    private String dge;

    public c(String str) {
        this.dge = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dgA = dataRes.exact_match;
            this.dgB = dataRes.fuzzy_match;
            if (this.dgA != null && this.dgB != null) {
                this.dgC = new ArrayList<>();
                b bVar = new b(this.dge);
                bVar.a(this.dgA);
                this.dgC.add(bVar);
                for (SearchForum searchForum : this.dgB) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dge);
                        bVar2.a(searchForum);
                        this.dgC.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> asM() {
        return this.dgC;
    }
}
