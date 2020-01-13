package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes7.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.fLx = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.fLy = resource.user_image;
            this.fLz = resource.user_link;
            this.fLA = resource.res_title;
            this.fLB = resource.res_image;
            this.fLC = resource.res_link;
            this.fLD = resource.position.longValue();
            this.fLE = resource.icon_text;
        }
    }
}
