package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ekl = BdUniqueId.gen();
    public bj ekm;
    public boolean ekn;
    public boolean eko;
    public String entryName;
    public String labelName;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean ekk = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ekl;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.ekm == null) {
            this.ekm = new bj();
        }
        this.ekm.a(threadInfo);
    }

    public bj aAj() {
        return this.ekm;
    }
}
