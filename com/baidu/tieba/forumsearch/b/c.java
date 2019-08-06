package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private SearchForum fsV;
    private List<SearchForum> fsW;
    private ArrayList<m> fsX;
    private String fsx;

    public c(String str) {
        this.fsx = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fsV = dataRes.exact_match;
            this.fsW = dataRes.fuzzy_match;
            this.fsX = new ArrayList<>();
            b bVar = new b(this.fsx);
            if (this.fsV != null) {
                bVar.a(this.fsV);
                this.fsX.add(bVar);
            }
            if (this.fsW != null) {
                for (SearchForum searchForum : this.fsW) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.fsx);
                        bVar2.a(searchForum);
                        this.fsX.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bld() {
        return this.fsX;
    }
}
