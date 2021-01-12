package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iXq = BdUniqueId.gen();
    private String iXt;
    private String iXu;
    private int iXr = -1;
    private int iXs = -1;
    private int iXv = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iXq;
    }

    public void yb(int i) {
        this.iXr = i;
    }

    public void yc(int i) {
        this.iXv = i;
    }

    public int czD() {
        return this.iXs;
    }

    public void yd(int i) {
        this.iXs = i;
    }

    public void Jm(String str) {
        this.iXt = str;
    }

    public String czE() {
        return this.iXu;
    }

    public void Jn(String str) {
        this.iXu = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iXt) || StringUtils.isNull(this.iXu) || this.iXr < 0 || this.iXs < 0;
    }
}
