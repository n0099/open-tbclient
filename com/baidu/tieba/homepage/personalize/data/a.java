package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.e {
    public void b(App app) {
        if (app != null) {
            if (this.hmD == null) {
                this.hmD = new AdvertAppInfo();
            }
            this.hmD.a(app);
        }
    }
}
