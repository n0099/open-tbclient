package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jci = BdUniqueId.gen();
    private String jcb;
    private int jbZ = -1;
    private int jcj = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jci;
    }

    public int cDw() {
        return this.jcj;
    }

    public void zK(int i) {
        this.jcj = i;
    }

    public int cDu() {
        return this.jbZ;
    }

    public void zJ(int i) {
        this.jbZ = i;
    }

    public String cDv() {
        return this.jcb;
    }

    public void Kz(String str) {
        this.jcb = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jcb) || this.jbZ < 0;
    }
}
