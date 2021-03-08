package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class l implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jeU = BdUniqueId.gen();
    private String jeX;
    private String jeY;
    private int jeV = -1;
    private int jeW = -1;
    private int jeZ = -1;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jeU;
    }

    public void ym(int i) {
        this.jeV = i;
    }

    public void yn(int i) {
        this.jeZ = i;
    }

    public int cBb() {
        return this.jeW;
    }

    public void yo(int i) {
        this.jeW = i;
    }

    public void Kh(String str) {
        this.jeX = str;
    }

    public String cBc() {
        return this.jeY;
    }

    public void Ki(String str) {
        this.jeY = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.jeX) || StringUtils.isNull(this.jeY) || this.jeV < 0 || this.jeW < 0;
    }
}
