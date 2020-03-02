package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejI = BdUniqueId.gen();
    public bj ejJ;
    public boolean ejK;
    public boolean ejL;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ejH = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ejI;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.ejJ == null) {
            this.ejJ = new bj();
        }
        this.ejJ.a(threadInfo);
    }

    public bj aAg() {
        return this.ejJ;
    }
}
