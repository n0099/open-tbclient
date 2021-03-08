package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.d {
    public void b(App app) {
        if (app != null) {
            if (this.iCk == null) {
                this.iCk = new AdvertAppInfo();
            }
            this.iCk.a(app);
            this.position = this.iCk.position;
        }
    }
}
