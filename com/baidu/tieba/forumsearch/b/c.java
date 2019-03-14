package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private SearchForum eXD;
    private List<SearchForum> eXE;
    private ArrayList<m> eXF;
    private String eXh;

    public c(String str) {
        this.eXh = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eXD = dataRes.exact_match;
            this.eXE = dataRes.fuzzy_match;
            this.eXF = new ArrayList<>();
            b bVar = new b(this.eXh);
            if (this.eXD != null) {
                bVar.a(this.eXD);
                this.eXF.add(bVar);
            }
            if (this.eXE != null) {
                for (SearchForum searchForum : this.eXE) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.eXh);
                        bVar2.a(searchForum);
                        this.eXF.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bbD() {
        return this.eXF;
    }
}
