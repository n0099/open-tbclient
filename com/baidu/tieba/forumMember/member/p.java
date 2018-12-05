package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dFv = BdUniqueId.gen();
    private String dFy;
    private String dFz;
    private int dFw = -1;
    private int dFx = -1;
    private int dFA = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dFv;
    }

    public int azv() {
        return this.dFw;
    }

    public void lM(int i) {
        this.dFw = i;
    }

    public int azw() {
        return this.dFA;
    }

    public void lN(int i) {
        this.dFA = i;
    }

    public int azx() {
        return this.dFx;
    }

    public void lO(int i) {
        this.dFx = i;
    }

    public String azy() {
        return this.dFy;
    }

    public void nR(String str) {
        this.dFy = str;
    }

    public String azz() {
        return this.dFz;
    }

    public void nS(String str) {
        this.dFz = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dFy) || StringUtils.isNull(this.dFz) || this.dFw < 0 || this.dFx < 0;
    }
}
