package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes22.dex */
public class p implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWJ = BdUniqueId.gen();
    private String hWM;
    private String hWN;
    private int hWK = -1;
    private int hWL = -1;
    private int hWO = -1;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWJ;
    }

    public void xf(int i) {
        this.hWK = i;
    }

    public void xg(int i) {
        this.hWO = i;
    }

    public int cnC() {
        return this.hWL;
    }

    public void xh(int i) {
        this.hWL = i;
    }

    public void IG(String str) {
        this.hWM = str;
    }

    public String cnD() {
        return this.hWN;
    }

    public void IH(String str) {
        this.hWN = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.hWM) || StringUtils.isNull(this.hWN) || this.hWK < 0 || this.hWL < 0;
    }
}
