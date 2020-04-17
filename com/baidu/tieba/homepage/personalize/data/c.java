package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.gtx = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.gty = resource.user_image;
            this.gtz = resource.user_link;
            this.gtA = resource.res_title;
            this.gtB = resource.res_image;
            this.gtC = resource.res_link;
            this.gtD = resource.position.longValue();
            this.gtE = resource.icon_text;
        }
    }
}
