package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private SearchForum ftV;
    private List<SearchForum> ftW;
    private ArrayList<m> ftX;
    private String ftx;

    public c(String str) {
        this.ftx = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ftV = dataRes.exact_match;
            this.ftW = dataRes.fuzzy_match;
            this.ftX = new ArrayList<>();
            b bVar = new b(this.ftx);
            if (this.ftV != null) {
                bVar.a(this.ftV);
                this.ftX.add(bVar);
            }
            if (this.ftW != null) {
                for (SearchForum searchForum : this.ftW) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.ftx);
                        bVar2.a(searchForum);
                        this.ftX.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> biU() {
        return this.ftX;
    }
}
