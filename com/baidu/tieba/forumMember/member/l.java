package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jbX = BdUniqueId.gen();
    private String jca;
    private String jcb;
    private int jbY = -1;
    private int jbZ = -1;
    private int jcc = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jbX;
    }

    public void zH(int i) {
        this.jbY = i;
    }

    public void zI(int i) {
        this.jcc = i;
    }

    public int cDv() {
        return this.jbZ;
    }

    public void zJ(int i) {
        this.jbZ = i;
    }

    public void Kx(String str) {
        this.jca = str;
    }

    public String cDw() {
        return this.jcb;
    }

    public void Ky(String str) {
        this.jcb = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jca) || StringUtils.isNull(this.jcb) || this.jbY < 0 || this.jbZ < 0;
    }
}
