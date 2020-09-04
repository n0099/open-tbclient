package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes16.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.hnY = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.hnZ = resource.user_image;
            this.hoa = resource.user_link;
            this.hob = resource.res_title;
            this.hoc = resource.res_image;
            this.hod = resource.res_link;
            this.hoe = resource.position.longValue();
            this.hof = resource.icon_text;
        }
    }
}
