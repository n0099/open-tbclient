package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNL = BdUniqueId.gen();
    public bj eNM;
    public boolean eNN;
    public boolean eNO;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean eNK = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNL;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.eNM == null) {
            this.eNM = new bj();
        }
        this.eNM.a(threadInfo);
    }

    public bj aIw() {
        return this.eNM;
    }
}
