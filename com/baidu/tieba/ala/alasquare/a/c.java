package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gpE = BdUniqueId.gen();
    public String entryName;
    public by gpF;
    public boolean gpG;
    public boolean gpH;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gpD = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gpE;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.gpF == null) {
            this.gpF = new by();
        }
        this.gpF.a(threadInfo);
    }

    public by bmn() {
        return this.gpF;
    }
}
