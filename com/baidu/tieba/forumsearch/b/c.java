package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dyD;
    private SearchForum dyZ;
    private List<SearchForum> dza;
    private ArrayList<h> dzb;

    public c(String str) {
        this.dyD = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dyZ = dataRes.exact_match;
            this.dza = dataRes.fuzzy_match;
            if (this.dyZ != null && this.dza != null) {
                this.dzb = new ArrayList<>();
                b bVar = new b(this.dyD);
                bVar.a(this.dyZ);
                this.dzb.add(bVar);
                for (SearchForum searchForum : this.dza) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dyD);
                        bVar2.a(searchForum);
                        this.dzb.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> ayL() {
        return this.dzb;
    }
}
