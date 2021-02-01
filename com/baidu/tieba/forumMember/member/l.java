package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jcX = BdUniqueId.gen();
    private String jda;
    private String jdb;
    private int jcY = -1;
    private int jcZ = -1;
    private int jdc = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jcX;
    }

    public void yl(int i) {
        this.jcY = i;
    }

    public void ym(int i) {
        this.jdc = i;
    }

    public int cAO() {
        return this.jcZ;
    }

    public void yn(int i) {
        this.jcZ = i;
    }

    public void JX(String str) {
        this.jda = str;
    }

    public String cAP() {
        return this.jdb;
    }

    public void JY(String str) {
        this.jdb = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jda) || StringUtils.isNull(this.jdb) || this.jcY < 0 || this.jcZ < 0;
    }
}
