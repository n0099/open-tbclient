package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.cXT = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cXU = resource.user_image;
            this.cXV = resource.user_link;
            this.cXW = resource.res_title;
            this.cXX = resource.res_image;
            this.cXY = resource.res_link;
            this.cXZ = resource.position.longValue();
            this.cYa = resource.icon_text;
        }
    }
}
