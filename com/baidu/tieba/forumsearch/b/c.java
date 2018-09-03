package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dkJ;
    private SearchForum dlf;
    private List<SearchForum> dlg;
    private ArrayList<h> dlh;

    public c(String str) {
        this.dkJ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dlf = dataRes.exact_match;
            this.dlg = dataRes.fuzzy_match;
            if (this.dlf != null && this.dlg != null) {
                this.dlh = new ArrayList<>();
                b bVar = new b(this.dkJ);
                bVar.a(this.dlf);
                this.dlh.add(bVar);
                for (SearchForum searchForum : this.dlg) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dkJ);
                        bVar2.a(searchForum);
                        this.dlh.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> atA() {
        return this.dlh;
    }
}
