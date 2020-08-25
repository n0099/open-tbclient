package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes17.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPD = BdUniqueId.gen();
    private String hPG;
    private String hPH;
    private int hPE = -1;
    private int hPF = -1;
    private int hPI = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPD;
    }

    public void wG(int i) {
        this.hPE = i;
    }

    public void wH(int i) {
        this.hPI = i;
    }

    public int cko() {
        return this.hPF;
    }

    public void wI(int i) {
        this.hPF = i;
    }

    public void Ii(String str) {
        this.hPG = str;
    }

    public String ckp() {
        return this.hPH;
    }

    public void Ij(String str) {
        this.hPH = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hPG) || StringUtils.isNull(this.hPH) || this.hPE < 0 || this.hPF < 0;
    }
}
