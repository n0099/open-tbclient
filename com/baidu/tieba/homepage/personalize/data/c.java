package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eGU = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eGV = resource.user_image;
            this.eGW = resource.user_link;
            this.eGX = resource.res_title;
            this.eGY = resource.res_image;
            this.eGZ = resource.res_link;
            this.eHa = resource.position.longValue();
            this.eHb = resource.icon_text;
        }
    }
}
