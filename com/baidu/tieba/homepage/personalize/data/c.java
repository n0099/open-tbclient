package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.iAA = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.iAB = resource.user_image;
            this.iAC = resource.user_link;
            this.iAD = resource.res_title;
            this.iAE = resource.res_image;
            this.iAF = resource.res_link;
            this.iAG = resource.position.longValue();
            this.iAH = resource.icon_text;
        }
    }
}
