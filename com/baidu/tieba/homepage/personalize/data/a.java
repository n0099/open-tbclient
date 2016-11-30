package com.baidu.tieba.homepage.personalize.data;

import tbclient.App;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.d {
    public void b(App app) {
        if (app != null) {
            if (this.beQ == null) {
                this.beQ = new com.baidu.tbadk.core.data.c();
            }
            this.beQ.a(app);
        }
    }
}
