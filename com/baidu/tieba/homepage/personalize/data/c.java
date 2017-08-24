package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bLc = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bLd = resource.user_image;
            this.bLe = resource.user_link;
            this.bLf = resource.res_title;
            this.bLg = resource.res_image;
            this.bLh = resource.res_link;
            this.bLi = resource.position.longValue();
            this.bLj = resource.icon_text;
        }
    }
}
