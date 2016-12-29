package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.r;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends r {
    public void a(Resource resource) {
        if (resource != null) {
            this.bfl = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bfm = resource.user_image;
            this.bfn = resource.user_link;
            this.bfo = resource.res_title;
            this.bfp = resource.res_image;
            this.bfq = resource.res_link;
            this.bfr = resource.position.longValue();
            this.bfs = resource.icon_text;
        }
    }
}
