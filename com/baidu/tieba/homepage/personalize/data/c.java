package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.fOQ = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.fOR = resource.user_image;
            this.fOS = resource.user_link;
            this.fOT = resource.res_title;
            this.fOU = resource.res_image;
            this.fOV = resource.res_link;
            this.fOW = resource.position.longValue();
            this.fOX = resource.icon_text;
        }
    }
}
