package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bLb = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bLc = resource.user_image;
            this.bLd = resource.user_link;
            this.bLe = resource.res_title;
            this.bLf = resource.res_image;
            this.bLg = resource.res_link;
            this.bLh = resource.position.longValue();
            this.bLi = resource.icon_text;
        }
    }
}
