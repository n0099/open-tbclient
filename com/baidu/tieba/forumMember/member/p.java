package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId djL = BdUniqueId.gen();
    private String djO;
    private String djP;
    private int djM = -1;
    private int djN = -1;
    private int djQ = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return djL;
    }

    public int ate() {
        return this.djM;
    }

    public void ki(int i) {
        this.djM = i;
    }

    public int atf() {
        return this.djQ;
    }

    public void kj(int i) {
        this.djQ = i;
    }

    public int atg() {
        return this.djN;
    }

    public void kk(int i) {
        this.djN = i;
    }

    public String ath() {
        return this.djO;
    }

    public void ml(String str) {
        this.djO = str;
    }

    public String ati() {
        return this.djP;
    }

    public void mm(String str) {
        this.djP = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.djO) || StringUtils.isNull(this.djP) || this.djM < 0 || this.djN < 0;
    }
}
