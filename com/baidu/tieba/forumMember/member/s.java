package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ftv = BdUniqueId.gen();
    private String ftp;
    private int ftn = -1;
    private int ftw = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftv;
    }

    public int blw() {
        return this.ftw;
    }

    public void rm(int i) {
        this.ftw = i;
    }

    public int blu() {
        return this.ftn;
    }

    public void rl(int i) {
        this.ftn = i;
    }

    public String blv() {
        return this.ftp;
    }

    public void xn(String str) {
        this.ftp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.ftp) || this.ftn < 0;
    }
}
