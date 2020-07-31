package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.d {
    public void b(App app) {
        if (app != null) {
            if (this.gZK == null) {
                this.gZK = new AdvertAppInfo();
            }
            this.gZK.a(app);
        }
    }
}
