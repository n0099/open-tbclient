package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iXB = BdUniqueId.gen();
    private String iXu;
    private int iXs = -1;
    private int iXC = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iXB;
    }

    public int czF() {
        return this.iXC;
    }

    public void ye(int i) {
        this.iXC = i;
    }

    public int czD() {
        return this.iXs;
    }

    public void yd(int i) {
        this.iXs = i;
    }

    public String czE() {
        return this.iXu;
    }

    public void Jn(String str) {
        this.iXu = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iXu) || this.iXs < 0;
    }
}
