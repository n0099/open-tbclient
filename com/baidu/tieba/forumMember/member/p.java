package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dyW = BdUniqueId.gen();
    private String dyZ;
    private String dza;
    private int dyX = -1;
    private int dyY = -1;
    private int dzb = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dyW;
    }

    public int axL() {
        return this.dyX;
    }

    public void lw(int i) {
        this.dyX = i;
    }

    public int axM() {
        return this.dzb;
    }

    public void lx(int i) {
        this.dzb = i;
    }

    public int axN() {
        return this.dyY;
    }

    public void ly(int i) {
        this.dyY = i;
    }

    public String axO() {
        return this.dyZ;
    }

    public void ns(String str) {
        this.dyZ = str;
    }

    public String axP() {
        return this.dza;
    }

    public void nt(String str) {
        this.dza = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dyZ) || StringUtils.isNull(this.dza) || this.dyX < 0 || this.dyY < 0;
    }
}
