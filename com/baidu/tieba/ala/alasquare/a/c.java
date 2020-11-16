package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId ghu = BdUniqueId.gen();
    public String entryName;
    public bx ghv;
    public boolean ghw;
    public boolean ghx;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ght = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ghu;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.ghv == null) {
            this.ghv = new bx();
        }
        this.ghv.a(threadInfo);
    }

    public bx bjd() {
        return this.ghv;
    }
}
