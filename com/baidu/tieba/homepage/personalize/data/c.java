package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes21.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.hvc = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.hvd = resource.user_image;
            this.hve = resource.user_link;
            this.hvf = resource.res_title;
            this.hvg = resource.res_image;
            this.hvh = resource.res_link;
            this.hvi = resource.position.longValue();
            this.hvj = resource.icon_text;
        }
    }
}
