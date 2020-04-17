package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gVB = BdUniqueId.gen();
    private String gVv;
    private int gVt = -1;
    private int gVC = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gVB;
    }

    public int bNi() {
        return this.gVC;
    }

    public void sU(int i) {
        this.gVC = i;
    }

    public int bNg() {
        return this.gVt;
    }

    public void sT(int i) {
        this.gVt = i;
    }

    public String bNh() {
        return this.gVv;
    }

    public void CK(String str) {
        this.gVv = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.gVv) || this.gVt < 0;
    }
}
