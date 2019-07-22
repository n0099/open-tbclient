package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private String frY;
    private SearchForum fsw;
    private List<SearchForum> fsx;
    private ArrayList<m> fsy;

    public c(String str) {
        this.frY = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fsw = dataRes.exact_match;
            this.fsx = dataRes.fuzzy_match;
            this.fsy = new ArrayList<>();
            b bVar = new b(this.frY);
            if (this.fsw != null) {
                bVar.a(this.fsw);
                this.fsy.add(bVar);
            }
            if (this.fsx != null) {
                for (SearchForum searchForum : this.fsx) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.frY);
                        bVar2.a(searchForum);
                        this.fsy.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bkW() {
        return this.fsy;
    }
}
