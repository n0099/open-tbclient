package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class s implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId fri = BdUniqueId.gen();
    private String frc;
    private int fra = -1;
    private int frj = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fri;
    }

    public int bkE() {
        return this.frj;
    }

    public void rh(int i) {
        this.frj = i;
    }

    public int bkC() {
        return this.fra;
    }

    public void rg(int i) {
        this.fra = i;
    }

    public String bkD() {
        return this.frc;
    }

    public void wN(String str) {
        this.frc = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.frc) || this.fra < 0;
    }
}
