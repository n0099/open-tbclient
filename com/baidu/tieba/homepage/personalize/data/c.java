package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.fNV = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.fNW = resource.user_image;
            this.fNX = resource.user_link;
            this.fNY = resource.res_title;
            this.fNZ = resource.res_image;
            this.fOa = resource.res_link;
            this.fOb = resource.position.longValue();
            this.fOc = resource.icon_text;
        }
    }
}
