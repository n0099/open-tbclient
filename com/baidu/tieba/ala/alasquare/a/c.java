package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ghN = BdUniqueId.gen();
    public String entryName;
    public bw ghO;
    public boolean ghP;
    public boolean ghQ;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ghM = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ghN;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.ghO == null) {
            this.ghO = new bw();
        }
        this.ghO.a(threadInfo);
    }

    public bw bjZ() {
        return this.ghO;
    }
}
