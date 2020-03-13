package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejV = BdUniqueId.gen();
    public bj ejW;
    public boolean ejX;
    public boolean ejY;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ejU = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ejV;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.ejW == null) {
            this.ejW = new bj();
        }
        this.ejW.a(threadInfo);
    }

    public bj aAg() {
        return this.ejW;
    }
}
