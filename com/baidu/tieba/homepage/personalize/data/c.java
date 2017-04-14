package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.s;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends s {
    public void a(Resource resource) {
        if (resource != null) {
            this.bvS = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bvT = resource.user_image;
            this.bvU = resource.user_link;
            this.bvV = resource.res_title;
            this.bvW = resource.res_image;
            this.bvX = resource.res_link;
            this.bvY = resource.position.longValue();
            this.bvZ = resource.icon_text;
        }
    }
}
