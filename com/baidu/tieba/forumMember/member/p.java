package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gjn = BdUniqueId.gen();
    private String gjq;
    private String gjr;
    private int gjo = -1;
    private int gjp = -1;
    private int gjs = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gjn;
    }

    public void sm(int i) {
        this.gjo = i;
    }

    public void sn(int i) {
        this.gjs = i;
    }

    public int bAV() {
        return this.gjp;
    }

    public void so(int i) {
        this.gjp = i;
    }

    public void AG(String str) {
        this.gjq = str;
    }

    public String bAW() {
        return this.gjr;
    }

    public void AH(String str) {
        this.gjr = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gjq) || StringUtils.isNull(this.gjr) || this.gjo < 0 || this.gjp < 0;
    }
}
