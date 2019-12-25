package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId efs = BdUniqueId.gen();
    public bj eft;
    public boolean efu;
    public boolean efv;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean efw = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return efs;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.eft == null) {
            this.eft = new bj();
        }
        this.eft.a(threadInfo);
    }

    public bj axx() {
        return this.eft;
    }
}
