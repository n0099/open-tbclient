package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fCw = BdUniqueId.gen();
    public String entryName;
    public bw fCx;
    public boolean fCy;
    public boolean fCz;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean fCv = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fCw;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.fCx == null) {
            this.fCx = new bw();
        }
        this.fCx.a(threadInfo);
    }

    public bw bce() {
        return this.fCx;
    }
}
