package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class p implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dgV = BdUniqueId.gen();
    private String dgY;
    private String dgZ;
    private int dgW = -1;
    private int dgX = -1;
    private int dha = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dgV;
    }

    public int asA() {
        return this.dgW;
    }

    public void jX(int i) {
        this.dgW = i;
    }

    public int asB() {
        return this.dha;
    }

    public void jY(int i) {
        this.dha = i;
    }

    public int asC() {
        return this.dgX;
    }

    public void jZ(int i) {
        this.dgX = i;
    }

    public String asD() {
        return this.dgY;
    }

    public void mm(String str) {
        this.dgY = str;
    }

    public String asE() {
        return this.dgZ;
    }

    public void mn(String str) {
        this.dgZ = str;
    }

    public boolean isEmpty() {
        return StringUtils.isNull(this.dgY) || StringUtils.isNull(this.dgZ) || this.dgW < 0 || this.dgX < 0;
    }
}
