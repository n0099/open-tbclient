package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private String hxA;
    private SearchForum hyb;
    private List<SearchForum> hyc;
    private ArrayList<q> hyd;

    public c(String str) {
        this.hxA = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hyb = dataRes.exact_match;
            this.hyc = dataRes.fuzzy_match;
            this.hyd = new ArrayList<>();
            b bVar = new b(this.hxA);
            if (this.hyb != null) {
                bVar.a(this.hyb);
                this.hyd.add(bVar);
            }
            if (this.hyc != null) {
                for (SearchForum searchForum : this.hyc) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hxA);
                        bVar2.a(searchForum);
                        this.hyd.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> bWU() {
        return this.hyd;
    }
}
