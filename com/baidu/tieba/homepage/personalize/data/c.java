package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bNV = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bNW = resource.user_image;
            this.bNX = resource.user_link;
            this.bNY = resource.res_title;
            this.bNZ = resource.res_image;
            this.bOa = resource.res_link;
            this.bOb = resource.position.longValue();
            this.bOc = resource.icon_text;
        }
    }
}
