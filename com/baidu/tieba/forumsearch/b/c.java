package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dqC;
    private SearchForum dqY;
    private List<SearchForum> dqZ;
    private ArrayList<h> dra;

    public c(String str) {
        this.dqC = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dqY = dataRes.exact_match;
            this.dqZ = dataRes.fuzzy_match;
            if (this.dqY != null && this.dqZ != null) {
                this.dra = new ArrayList<>();
                b bVar = new b(this.dqC);
                bVar.a(this.dqY);
                this.dra.add(bVar);
                for (SearchForum searchForum : this.dqZ) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dqC);
                        bVar2.a(searchForum);
                        this.dra.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> avo() {
        return this.dra;
    }
}
