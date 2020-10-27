package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gbY = BdUniqueId.gen();
    public String entryName;
    public bw gbZ;
    public boolean gca;
    public boolean gcb;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gbX = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gbY;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.gbZ == null) {
            this.gbZ = new bw();
        }
        this.gbZ.a(threadInfo);
    }

    public bw bhz() {
        return this.gbZ;
    }
}
