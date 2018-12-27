package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dIj = BdUniqueId.gen();
    private String dIm;
    private String dIn;
    private int dIk = -1;
    private int dIl = -1;
    private int dIo = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dIj;
    }

    public int aAk() {
        return this.dIk;
    }

    public void lZ(int i) {
        this.dIk = i;
    }

    public int aAl() {
        return this.dIo;
    }

    public void ma(int i) {
        this.dIo = i;
    }

    public int aAm() {
        return this.dIl;
    }

    public void mb(int i) {
        this.dIl = i;
    }

    public String aAn() {
        return this.dIm;
    }

    public void nU(String str) {
        this.dIm = str;
    }

    public String aAo() {
        return this.dIn;
    }

    public void nV(String str) {
        this.dIn = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dIm) || StringUtils.isNull(this.dIn) || this.dIk < 0 || this.dIl < 0;
    }
}
