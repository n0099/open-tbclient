package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jdi = BdUniqueId.gen();
    private String jdb;
    private int jcZ = -1;
    private int jdj = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdi;
    }

    public int cAQ() {
        return this.jdj;
    }

    public void yo(int i) {
        this.jdj = i;
    }

    public int cAO() {
        return this.jcZ;
    }

    public void yn(int i) {
        this.jcZ = i;
    }

    public String cAP() {
        return this.jdb;
    }

    public void JY(String str) {
        this.jdb = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jdb) || this.jcZ < 0;
    }
}
