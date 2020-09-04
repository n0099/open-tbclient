package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes17.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPJ = BdUniqueId.gen();
    private String hPM;
    private String hPN;
    private int hPK = -1;
    private int hPL = -1;
    private int hPO = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPJ;
    }

    public void wG(int i) {
        this.hPK = i;
    }

    public void wH(int i) {
        this.hPO = i;
    }

    public int ckp() {
        return this.hPL;
    }

    public void wI(int i) {
        this.hPL = i;
    }

    public void Ij(String str) {
        this.hPM = str;
    }

    public String ckq() {
        return this.hPN;
    }

    public void Ik(String str) {
        this.hPN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hPM) || StringUtils.isNull(this.hPN) || this.hPK < 0 || this.hPL < 0;
    }
}
