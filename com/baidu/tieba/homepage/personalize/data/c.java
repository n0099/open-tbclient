package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes16.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.hnU = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.hnV = resource.user_image;
            this.hnW = resource.user_link;
            this.hnX = resource.res_title;
            this.hnY = resource.res_image;
            this.hnZ = resource.res_link;
            this.hoa = resource.position.longValue();
            this.hob = resource.icon_text;
        }
    }
}
