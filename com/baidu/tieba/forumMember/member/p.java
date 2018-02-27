package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBZ = BdUniqueId.gen();
    private String dCc;
    private String dCd;
    private int dCa = -1;
    private int dCb = -1;
    private int dCe = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBZ;
    }

    public int atV() {
        return this.dCa;
    }

    public void mG(int i) {
        this.dCa = i;
    }

    public int atW() {
        return this.dCe;
    }

    public void mH(int i) {
        this.dCe = i;
    }

    public int atX() {
        return this.dCb;
    }

    public void mI(int i) {
        this.dCb = i;
    }

    public String atY() {
        return this.dCc;
    }

    public void lz(String str) {
        this.dCc = str;
    }

    public String atZ() {
        return this.dCd;
    }

    public void lA(String str) {
        this.dCd = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dCc) || StringUtils.isNull(this.dCd) || this.dCa < 0 || this.dCb < 0;
    }
}
