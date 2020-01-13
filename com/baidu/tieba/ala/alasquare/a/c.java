package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId efD = BdUniqueId.gen();
    public bj efE;
    public boolean efF;
    public boolean efG;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean efC = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return efD;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.efE == null) {
            this.efE = new bj();
        }
        this.efE.a(threadInfo);
    }

    public bj axQ() {
        return this.efE;
    }
}
