package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jdl = BdUniqueId.gen();
    private String jdo;
    private String jdp;
    private int jdm = -1;
    private int jdn = -1;
    private int jdq = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdl;
    }

    public void yl(int i) {
        this.jdm = i;
    }

    public void ym(int i) {
        this.jdq = i;
    }

    public int cAV() {
        return this.jdn;
    }

    public void yn(int i) {
        this.jdn = i;
    }

    public void JY(String str) {
        this.jdo = str;
    }

    public String cAW() {
        return this.jdp;
    }

    public void JZ(String str) {
        this.jdp = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jdo) || StringUtils.isNull(this.jdp) || this.jdm < 0 || this.jdn < 0;
    }
}
