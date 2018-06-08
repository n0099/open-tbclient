package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dfe = BdUniqueId.gen();
    private String dfh;
    private String dfi;
    private int dff = -1;
    private int dfg = -1;
    private int dfj = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dfe;
    }

    public int asp() {
        return this.dff;
    }

    public void jU(int i) {
        this.dff = i;
    }

    public int asq() {
        return this.dfj;
    }

    public void jV(int i) {
        this.dfj = i;
    }

    public int asr() {
        return this.dfg;
    }

    public void jW(int i) {
        this.dfg = i;
    }

    public String ass() {
        return this.dfh;
    }

    public void mm(String str) {
        this.dfh = str;
    }

    public String ast() {
        return this.dfi;
    }

    public void mn(String str) {
        this.dfi = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dfh) || StringUtils.isNull(this.dfi) || this.dff < 0 || this.dfg < 0;
    }
}
