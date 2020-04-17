package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gVr = BdUniqueId.gen();
    private String gVu;
    private String gVv;
    private int gVs = -1;
    private int gVt = -1;
    private int gVw = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gVr;
    }

    public void sR(int i) {
        this.gVs = i;
    }

    public void sS(int i) {
        this.gVw = i;
    }

    public int bNg() {
        return this.gVt;
    }

    public void sT(int i) {
        this.gVt = i;
    }

    public void CJ(String str) {
        this.gVu = str;
    }

    public String bNh() {
        return this.gVv;
    }

    public void CK(String str) {
        this.gVv = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gVu) || StringUtils.isNull(this.gVv) || this.gVs < 0 || this.gVt < 0;
    }
}
