package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.r;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends r {
    public void a(Resource resource) {
        if (resource != null) {
            this.bcX = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bcY = resource.user_image;
            this.bcZ = resource.user_link;
            this.bda = resource.res_title;
            this.bdb = resource.res_image;
            this.bdc = resource.res_link;
            this.bdd = resource.position.longValue();
            this.bde = resource.icon_text;
        }
    }
}
