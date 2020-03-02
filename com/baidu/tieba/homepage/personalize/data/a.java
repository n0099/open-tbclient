package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import tbclient.App;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.d {
    public void b(App app) {
        if (app != null) {
            if (this.fMy == null) {
                this.fMy = new AdvertAppInfo();
            }
            this.fMy.a(app);
        }
    }
}
