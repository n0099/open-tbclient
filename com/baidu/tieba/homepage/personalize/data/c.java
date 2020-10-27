package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes22.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.hWu = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.hWv = resource.user_image;
            this.hWw = resource.user_link;
            this.hWx = resource.res_title;
            this.hWy = resource.res_image;
            this.hWz = resource.res_link;
            this.hWA = resource.position.longValue();
            this.hWB = resource.icon_text;
        }
    }
}
