package com.baidu.tieba.frs.g.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId enq = BdUniqueId.gen();
    private List<PbContent> content;
    private String enr;
    private int ens;
    private int ent;
    private String enu;
    private String groupName;
    private int rank;

    public b oi(int i) {
        this.ens = i;
        return this;
    }

    public int getRank() {
        return this.rank;
    }

    public b oj(int i) {
        this.rank = i;
        return this;
    }

    public String aJC() {
        return this.enu;
    }

    public String aJo() {
        return this.enr;
    }

    public b oX(String str) {
        this.enr = str;
        return this;
    }

    public b oY(String str) {
        this.enu = str;
        return this;
    }

    public b oZ(String str) {
        this.groupName = str;
        return this;
    }

    public b ok(int i) {
        this.ent = i;
        return this;
    }

    public b bY(List<PbContent> list) {
        this.content = list;
        return this;
    }

    public boolean aJD() {
        return this.ent == 3;
    }

    public int aJE() {
        return this.ens;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<PbContent> aJF() {
        return this.content;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return enq;
    }
}
