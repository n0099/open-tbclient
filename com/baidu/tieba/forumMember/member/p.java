package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dCc = BdUniqueId.gen();
    private String dCf;
    private String dCg;
    private int dCd = -1;
    private int dCe = -1;
    private int dCh = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dCc;
    }

    public int atW() {
        return this.dCd;
    }

    public void mG(int i) {
        this.dCd = i;
    }

    public int atX() {
        return this.dCh;
    }

    public void mH(int i) {
        this.dCh = i;
    }

    public int atY() {
        return this.dCe;
    }

    public void mI(int i) {
        this.dCe = i;
    }

    public String atZ() {
        return this.dCf;
    }

    public void lz(String str) {
        this.dCf = str;
    }

    public String aua() {
        return this.dCg;
    }

    public void lA(String str) {
        this.dCg = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dCf) || StringUtils.isNull(this.dCg) || this.dCd < 0 || this.dCe < 0;
    }
}
