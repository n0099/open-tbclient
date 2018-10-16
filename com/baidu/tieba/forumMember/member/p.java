package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dxE = BdUniqueId.gen();
    private String dxH;
    private String dxI;
    private int dxF = -1;
    private int dxG = -1;
    private int dxJ = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dxE;
    }

    public int ayn() {
        return this.dxF;
    }

    public void le(int i) {
        this.dxF = i;
    }

    public int ayo() {
        return this.dxJ;
    }

    public void lf(int i) {
        this.dxJ = i;
    }

    public int ayp() {
        return this.dxG;
    }

    public void lg(int i) {
        this.dxG = i;
    }

    public String ayq() {
        return this.dxH;
    }

    public void nr(String str) {
        this.dxH = str;
    }

    public String ayr() {
        return this.dxI;
    }

    public void ns(String str) {
        this.dxI = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dxH) || StringUtils.isNull(this.dxI) || this.dxF < 0 || this.dxG < 0;
    }
}
