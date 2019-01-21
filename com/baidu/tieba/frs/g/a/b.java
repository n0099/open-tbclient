package com.baidu.tieba.frs.g.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId enX = BdUniqueId.gen();
    private List<PbContent> content;
    private String enY;
    private int enZ;
    private int eoa;
    private String eob;
    private String groupName;
    private int rank;

    public b oj(int i) {
        this.enZ = i;
        return this;
    }

    public int getRank() {
        return this.rank;
    }

    public b ok(int i) {
        this.rank = i;
        return this;
    }

    public String aKa() {
        return this.eob;
    }

    public String aJM() {
        return this.enY;
    }

    public b pn(String str) {
        this.enY = str;
        return this;
    }

    public b po(String str) {
        this.eob = str;
        return this;
    }

    public b pp(String str) {
        this.groupName = str;
        return this;
    }

    public b ol(int i) {
        this.eoa = i;
        return this;
    }

    public b bZ(List<PbContent> list) {
        this.content = list;
        return this;
    }

    public boolean aKb() {
        return this.eoa == 3;
    }

    public int aKc() {
        return this.enZ;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<PbContent> aKd() {
        return this.content;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return enX;
    }
}
