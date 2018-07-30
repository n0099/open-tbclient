package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cCU = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cCV = resource.user_image;
            this.cCW = resource.user_link;
            this.cCX = resource.res_title;
            this.cCY = resource.res_image;
            this.cCZ = resource.res_link;
            this.cDa = resource.position.longValue();
            this.cDb = resource.icon_text;
        }
    }
}
