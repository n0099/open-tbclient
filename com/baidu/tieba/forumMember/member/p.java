package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iEd = BdUniqueId.gen();
    private String iEg;
    private String iEh;
    private int iEe = -1;
    private int iEf = -1;
    private int iEi = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEd;
    }

    public void yr(int i) {
        this.iEe = i;
    }

    public void ys(int i) {
        this.iEi = i;
    }

    public int cwI() {
        return this.iEf;
    }

    public void yt(int i) {
        this.iEf = i;
    }

    public void Kj(String str) {
        this.iEg = str;
    }

    public String cwJ() {
        return this.iEh;
    }

    public void Kk(String str) {
        this.iEh = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iEg) || StringUtils.isNull(this.iEh) || this.iEe < 0 || this.iEf < 0;
    }
}
