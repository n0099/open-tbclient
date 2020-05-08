package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNQ = BdUniqueId.gen();
    public bj eNR;
    public boolean eNS;
    public boolean eNT;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean eNP = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNQ;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.eNR == null) {
            this.eNR = new bj();
        }
        this.eNR.a(threadInfo);
    }

    public bj aIu() {
        return this.eNR;
    }
}
