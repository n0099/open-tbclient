package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId ilT = BdUniqueId.gen();
    private String ilM;
    private int ilK = -1;
    private int ilU = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ilT;
    }

    public int crc() {
        return this.ilU;
    }

    public void xO(int i) {
        this.ilU = i;
    }

    public int cra() {
        return this.ilK;
    }

    public void xN(int i) {
        this.ilK = i;
    }

    public String crb() {
        return this.ilM;
    }

    public void Ju(String str) {
        this.ilM = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.ilM) || this.ilK < 0;
    }
}
