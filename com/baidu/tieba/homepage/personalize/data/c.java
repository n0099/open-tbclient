package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bVY = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bVZ = resource.user_image;
            this.bWa = resource.user_link;
            this.bWb = resource.res_title;
            this.bWc = resource.res_image;
            this.bWd = resource.res_link;
            this.bWe = resource.position.longValue();
            this.bWf = resource.icon_text;
        }
    }
}
