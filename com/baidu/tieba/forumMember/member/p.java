package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId ilI = BdUniqueId.gen();
    private String ilL;
    private String ilM;
    private int ilJ = -1;
    private int ilK = -1;
    private int ilN = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ilI;
    }

    public void xL(int i) {
        this.ilJ = i;
    }

    public void xM(int i) {
        this.ilN = i;
    }

    public int cra() {
        return this.ilK;
    }

    public void xN(int i) {
        this.ilK = i;
    }

    public void Jt(String str) {
        this.ilL = str;
    }

    public String crb() {
        return this.ilM;
    }

    public void Ju(String str) {
        this.ilM = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.ilL) || StringUtils.isNull(this.ilM) || this.ilJ < 0 || this.ilK < 0;
    }
}
