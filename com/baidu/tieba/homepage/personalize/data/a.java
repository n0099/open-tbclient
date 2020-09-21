package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.data.e {
    public void b(App app) {
        if (app != null) {
            if (this.htK == null) {
                this.htK = new AdvertAppInfo();
            }
            this.htK.a(app);
        }
    }
}
