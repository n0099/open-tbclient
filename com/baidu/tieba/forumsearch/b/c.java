package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dkL;
    private SearchForum dlh;
    private List<SearchForum> dli;
    private ArrayList<h> dlj;

    public c(String str) {
        this.dkL = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dlh = dataRes.exact_match;
            this.dli = dataRes.fuzzy_match;
            if (this.dlh != null && this.dli != null) {
                this.dlj = new ArrayList<>();
                b bVar = new b(this.dkL);
                bVar.a(this.dlh);
                this.dlj.add(bVar);
                for (SearchForum searchForum : this.dli) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dkL);
                        bVar2.a(searchForum);
                        this.dlj.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> atB() {
        return this.dlj;
    }
}
