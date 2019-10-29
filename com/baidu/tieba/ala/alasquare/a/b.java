package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dvh = BdUniqueId.gen();
    public bh dvi;
    public boolean dvj;
    public boolean dvk;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean dvl = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dvh;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.dvi == null) {
            this.dvi = new bh();
        }
        this.dvi.a(threadInfo);
    }

    public bh agI() {
        return this.dvi;
    }
}
