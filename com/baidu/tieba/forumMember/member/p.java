package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId djJ = BdUniqueId.gen();
    private String djM;
    private String djN;
    private int djK = -1;
    private int djL = -1;
    private int djO = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return djJ;
    }

    public int atd() {
        return this.djK;
    }

    public void kh(int i) {
        this.djK = i;
    }

    public int ate() {
        return this.djO;
    }

    public void ki(int i) {
        this.djO = i;
    }

    public int atf() {
        return this.djL;
    }

    public void kj(int i) {
        this.djL = i;
    }

    public String atg() {
        return this.djM;
    }

    public void mn(String str) {
        this.djM = str;
    }

    public String ath() {
        return this.djN;
    }

    public void mo(String str) {
        this.djN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.djM) || StringUtils.isNull(this.djN) || this.djK < 0 || this.djL < 0;
    }
}
