package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class s implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iEo = BdUniqueId.gen();
    private String iEh;
    private int iEf = -1;
    private int iEp = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEo;
    }

    public int cwK() {
        return this.iEp;
    }

    public void yu(int i) {
        this.iEp = i;
    }

    public int cwI() {
        return this.iEf;
    }

    public void yt(int i) {
        this.iEf = i;
    }

    public String cwJ() {
        return this.iEh;
    }

    public void Kk(String str) {
        this.iEh = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.iEh) || this.iEf < 0;
    }
}
