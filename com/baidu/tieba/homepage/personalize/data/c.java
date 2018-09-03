package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cCR = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cCS = resource.user_image;
            this.cCT = resource.user_link;
            this.cCU = resource.res_title;
            this.cCV = resource.res_image;
            this.cCW = resource.res_link;
            this.cCX = resource.position.longValue();
            this.cCY = resource.icon_text;
        }
    }
}
