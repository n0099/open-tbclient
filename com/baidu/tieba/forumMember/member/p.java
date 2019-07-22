package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fqY = BdUniqueId.gen();
    private String frb;
    private String frc;
    private int fqZ = -1;
    private int fra = -1;
    private int frd = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fqY;
    }

    public void re(int i) {
        this.fqZ = i;
    }

    public void rf(int i) {
        this.frd = i;
    }

    public int bkC() {
        return this.fra;
    }

    public void rg(int i) {
        this.fra = i;
    }

    public void wM(String str) {
        this.frb = str;
    }

    public String bkD() {
        return this.frc;
    }

    public void wN(String str) {
        this.frc = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.frb) || StringUtils.isNull(this.frc) || this.fqZ < 0 || this.fra < 0;
    }
}
