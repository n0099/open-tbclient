package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId flS = BdUniqueId.gen();
    public String entryName;
    public bu flT;
    public boolean flU;
    public boolean flV;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean flR = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return flS;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.flT == null) {
            this.flT = new bu();
        }
        this.flT.a(threadInfo);
    }

    public bu aPS() {
        return this.flT;
    }
}
