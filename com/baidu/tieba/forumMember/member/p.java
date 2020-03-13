package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes10.dex */
public class p implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId glD = BdUniqueId.gen();
    private String glG;
    private String glH;
    private int glE = -1;
    private int glF = -1;
    private int glI = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glD;
    }

    public void ss(int i) {
        this.glE = i;
    }

    public void st(int i) {
        this.glI = i;
    }

    public int bCA() {
        return this.glF;
    }

    public void su(int i) {
        this.glF = i;
    }

    public void AX(String str) {
        this.glG = str;
    }

    public String bCB() {
        return this.glH;
    }

    public void AY(String str) {
        this.glH = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.glG) || StringUtils.isNull(this.glH) || this.glE < 0 || this.glF < 0;
    }
}
