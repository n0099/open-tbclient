package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId gpG = BdUniqueId.gen();
    public String entryName;
    public by gpH;
    public boolean gpI;
    public boolean gpJ;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gpF = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gpG;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.gpH == null) {
            this.gpH = new by();
        }
        this.gpH.a(threadInfo);
    }

    public by bmn() {
        return this.gpH;
    }
}
