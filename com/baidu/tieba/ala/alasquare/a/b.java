package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId duq = BdUniqueId.gen();
    public bh dur;
    public boolean dus;
    public boolean dut;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean duu = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return duq;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.dur == null) {
            this.dur = new bh();
        }
        this.dur.a(threadInfo);
    }

    public bh agG() {
        return this.dur;
    }
}
