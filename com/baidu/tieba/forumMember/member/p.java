package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes17.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hCo = BdUniqueId.gen();
    private String hCr;
    private String hCs;
    private int hCp = -1;
    private int hCq = -1;
    private int hCt = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hCo;
    }

    public void ur(int i) {
        this.hCp = i;
    }

    public void us(int i) {
        this.hCt = i;
    }

    public int bZS() {
        return this.hCq;
    }

    public void ut(int i) {
        this.hCq = i;
    }

    public void FH(String str) {
        this.hCr = str;
    }

    public String bZT() {
        return this.hCs;
    }

    public void FI(String str) {
        this.hCs = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hCr) || StringUtils.isNull(this.hCs) || this.hCp < 0 || this.hCq < 0;
    }
}
