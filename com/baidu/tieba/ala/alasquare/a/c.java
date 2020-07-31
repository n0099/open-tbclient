package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fra = BdUniqueId.gen();
    public String entryName;
    public bv frb;
    public boolean frd;
    public boolean fre;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean fqZ = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return fra;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.frb == null) {
            this.frb = new bv();
        }
        this.frb.a(threadInfo);
    }

    public bv aTN() {
        return this.frb;
    }
}
