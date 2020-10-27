package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class c {
    private SearchForum izG;
    private List<SearchForum> izH;
    private ArrayList<q> izI;
    private String izg;

    public c(String str) {
        this.izg = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.izG = dataRes.exact_match;
            this.izH = dataRes.fuzzy_match;
            this.izI = new ArrayList<>();
            b bVar = new b(this.izg);
            if (this.izG != null) {
                bVar.a(this.izG);
                this.izI.add(bVar);
            }
            if (this.izH != null) {
                for (SearchForum searchForum : this.izH) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.izg);
                        bVar2.a(searchForum);
                        this.izI.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> cuC() {
        return this.izI;
    }
}
