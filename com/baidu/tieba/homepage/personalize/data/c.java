package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.fNT = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.fNU = resource.user_image;
            this.fNV = resource.user_link;
            this.fNW = resource.res_title;
            this.fNX = resource.res_image;
            this.fNY = resource.res_link;
            this.fNZ = resource.position.longValue();
            this.fOa = resource.icon_text;
        }
    }
}
