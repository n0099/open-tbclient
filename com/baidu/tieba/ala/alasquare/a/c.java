package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fax = BdUniqueId.gen();
    public String entryName;
    public boolean faA;
    public bk fay;
    public boolean faz;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean faw = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return fax;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.fay == null) {
            this.fay = new bk();
        }
        this.fay.a(threadInfo);
    }

    public bk aOi() {
        return this.fay;
    }
}
