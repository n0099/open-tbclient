package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fFM = BdUniqueId.gen();
    public String entryName;
    public bw fFN;
    public boolean fFO;
    public boolean fFP;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean fFL = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fFM;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.fFN == null) {
            this.fFN = new bw();
        }
        this.fFN.a(threadInfo);
    }

    public bw bcY() {
        return this.fFN;
    }
}
