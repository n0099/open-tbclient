package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ftl = BdUniqueId.gen();
    private String fto;
    private String ftp;
    private int ftm = -1;
    private int ftn = -1;
    private int ftq = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftl;
    }

    public void rj(int i) {
        this.ftm = i;
    }

    public void rk(int i) {
        this.ftq = i;
    }

    public int blu() {
        return this.ftn;
    }

    public void rl(int i) {
        this.ftn = i;
    }

    public void xm(String str) {
        this.fto = str;
    }

    public String blv() {
        return this.ftp;
    }

    public void xn(String str) {
        this.ftp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.fto) || StringUtils.isNull(this.ftp) || this.ftm < 0 || this.ftn < 0;
    }
}
