package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cYO = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cYP = resource.user_image;
            this.cYQ = resource.user_link;
            this.cYR = resource.res_title;
            this.cYS = resource.res_image;
            this.cYT = resource.res_link;
            this.cYU = resource.position.longValue();
            this.cYV = resource.icon_text;
        }
    }
}
