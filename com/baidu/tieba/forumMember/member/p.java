package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dpC = BdUniqueId.gen();
    private String dpF;
    private String dpG;
    private int dpD = -1;
    private int dpE = -1;
    private int dpH = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dpC;
    }

    public int auR() {
        return this.dpD;
    }

    public void kG(int i) {
        this.dpD = i;
    }

    public int auS() {
        return this.dpH;
    }

    public void kH(int i) {
        this.dpH = i;
    }

    public int auT() {
        return this.dpE;
    }

    public void kI(int i) {
        this.dpE = i;
    }

    public String auU() {
        return this.dpF;
    }

    public void mP(String str) {
        this.dpF = str;
    }

    public String auV() {
        return this.dpG;
    }

    public void mQ(String str) {
        this.dpG = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dpF) || StringUtils.isNull(this.dpG) || this.dpD < 0 || this.dpE < 0;
    }
}
