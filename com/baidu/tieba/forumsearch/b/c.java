package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class c {
    private SearchForum jeL;
    private List<SearchForum> jeM;
    private ArrayList<n> jeN;
    private String jel;

    public c(String str) {
        this.jel = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jeL = dataRes.exact_match;
            this.jeM = dataRes.fuzzy_match;
            this.jeN = new ArrayList<>();
            b bVar = new b(this.jel);
            if (this.jeL != null) {
                bVar.a(this.jeL);
                this.jeN.add(bVar);
            }
            if (this.jeM != null) {
                for (SearchForum searchForum : this.jeM) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.jel);
                        bVar2.a(searchForum);
                        this.jeN.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<n> cBp() {
        return this.jeN;
    }
}
