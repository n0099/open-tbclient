package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.gVz = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.gVA = resource.user_image;
            this.gVB = resource.user_link;
            this.gVC = resource.res_title;
            this.gVD = resource.res_image;
            this.gVE = resource.res_link;
            this.gVF = resource.position.longValue();
            this.gVG = resource.icon_text;
        }
    }
}
