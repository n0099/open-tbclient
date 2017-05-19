package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.byj = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.byk = resource.user_image;
            this.byl = resource.user_link;
            this.bym = resource.res_title;
            this.byn = resource.res_image;
            this.byo = resource.res_link;
            this.byp = resource.position.longValue();
            this.byq = resource.icon_text;
        }
    }
}
