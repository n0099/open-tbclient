package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId faI = BdUniqueId.gen();
    public String entryName;
    public bk faJ;
    public boolean faK;
    public boolean faL;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean faH = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return faI;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.faJ == null) {
            this.faJ = new bk();
        }
        this.faJ.a(threadInfo);
    }

    public bk aOi() {
        return this.faJ;
    }
}
