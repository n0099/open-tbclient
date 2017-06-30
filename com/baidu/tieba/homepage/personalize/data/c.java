package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bEW = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bEX = resource.user_image;
            this.bEY = resource.user_link;
            this.bEZ = resource.res_title;
            this.bFa = resource.res_image;
            this.bFb = resource.res_link;
            this.bFc = resource.position.longValue();
            this.bFd = resource.icon_text;
        }
    }
}
