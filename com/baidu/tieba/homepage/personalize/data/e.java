package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.r;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends r {
    public void a(Resource resource) {
        if (resource != null) {
            this.bfW = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bfX = resource.user_image;
            this.bfY = resource.user_link;
            this.bfZ = resource.res_title;
            this.bga = resource.res_image;
            this.bgb = resource.res_link;
            this.bgc = resource.position.longValue();
            this.bgd = resource.icon_text;
        }
    }
}
