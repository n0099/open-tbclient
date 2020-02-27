package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejH = BdUniqueId.gen();
    public bj ejI;
    public boolean ejJ;
    public boolean ejK;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ejG = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ejH;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.ejI == null) {
            this.ejI = new bj();
        }
        this.ejI.a(threadInfo);
    }

    public bj aAe() {
        return this.ejI;
    }
}
