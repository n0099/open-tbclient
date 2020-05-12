package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum gWX;
    private List<SearchForum> gWY;
    private ArrayList<m> gWZ;
    private String gWw;

    public c(String str) {
        this.gWw = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gWX = dataRes.exact_match;
            this.gWY = dataRes.fuzzy_match;
            this.gWZ = new ArrayList<>();
            b bVar = new b(this.gWw);
            if (this.gWX != null) {
                bVar.a(this.gWX);
                this.gWZ.add(bVar);
            }
            if (this.gWY != null) {
                for (SearchForum searchForum : this.gWY) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.gWw);
                        bVar2.a(searchForum);
                        this.gWZ.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bNA() {
        return this.gWZ;
    }
}
