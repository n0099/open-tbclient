package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aKh = BdUniqueId.gen();
    private String aKi;
    private String aKj;
    private boolean aKk = false;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aKh;
    }

    public String GM() {
        return this.aKi;
    }

    public void go(String str) {
        this.aKi = str;
    }

    public String getSmallUrl() {
        return this.aKj;
    }

    public void gp(String str) {
        this.aKj = str;
    }

    public boolean isPortrait() {
        return this.aKk;
    }

    public void bu(boolean z) {
        this.aKk = z;
    }
}
