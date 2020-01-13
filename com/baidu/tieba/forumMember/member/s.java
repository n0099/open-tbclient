package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gjx = BdUniqueId.gen();
    private String gjr;
    private int gjp = -1;
    private int gjy = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gjx;
    }

    public int bAX() {
        return this.gjy;
    }

    public void sp(int i) {
        this.gjy = i;
    }

    public int bAV() {
        return this.gjp;
    }

    public void so(int i) {
        this.gjp = i;
    }

    public String bAW() {
        return this.gjr;
    }

    public void AH(String str) {
        this.gjr = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gjr) || this.gjp < 0;
    }
}
