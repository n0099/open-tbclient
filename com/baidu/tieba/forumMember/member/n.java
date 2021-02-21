package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jdw = BdUniqueId.gen();
    private String jdp;
    private int jdn = -1;
    private int jdx = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdw;
    }

    public int cAX() {
        return this.jdx;
    }

    public void yo(int i) {
        this.jdx = i;
    }

    public int cAV() {
        return this.jdn;
    }

    public void yn(int i) {
        this.jdn = i;
    }

    public String cAW() {
        return this.jdp;
    }

    public void JZ(String str) {
        this.jdp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jdp) || this.jdn < 0;
    }
}
