package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dCl = BdUniqueId.gen();
    private String dCo;
    private String dCp;
    private int dCm = -1;
    private int dCn = -1;
    private int dCq = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dCl;
    }

    public int atW() {
        return this.dCm;
    }

    public void mG(int i) {
        this.dCm = i;
    }

    public int atX() {
        return this.dCq;
    }

    public void mH(int i) {
        this.dCq = i;
    }

    public int atY() {
        return this.dCn;
    }

    public void mI(int i) {
        this.dCn = i;
    }

    public String atZ() {
        return this.dCo;
    }

    public void lz(String str) {
        this.dCo = str;
    }

    public String aua() {
        return this.dCp;
    }

    public void lA(String str) {
        this.dCp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dCo) || StringUtils.isNull(this.dCp) || this.dCm < 0 || this.dCn < 0;
    }
}
