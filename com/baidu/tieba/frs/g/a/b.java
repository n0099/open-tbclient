package com.baidu.tieba.frs.g.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId ekz = BdUniqueId.gen();
    private List<PbContent> content;
    private String ekA;
    private int ekB;
    private int ekC;
    private String ekD;
    private String groupName;
    private int rank;

    public b nV(int i) {
        this.ekB = i;
        return this;
    }

    public int getRank() {
        return this.rank;
    }

    public b nW(int i) {
        this.rank = i;
        return this;
    }

    public String aIN() {
        return this.ekD;
    }

    public String aIz() {
        return this.ekA;
    }

    public b oU(String str) {
        this.ekA = str;
        return this;
    }

    public b oV(String str) {
        this.ekD = str;
        return this;
    }

    public b oW(String str) {
        this.groupName = str;
        return this;
    }

    public b nX(int i) {
        this.ekC = i;
        return this;
    }

    public b bX(List<PbContent> list) {
        this.content = list;
        return this;
    }

    public boolean aIO() {
        return this.ekC == 3;
    }

    public int aIP() {
        return this.ekB;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<PbContent> aIQ() {
        return this.content;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ekz;
    }
}
