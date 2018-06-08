package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cCv = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cCw = resource.user_image;
            this.cCx = resource.user_link;
            this.cCy = resource.res_title;
            this.cCz = resource.res_image;
            this.cCA = resource.res_link;
            this.cCB = resource.position.longValue();
            this.cCC = resource.icon_text;
        }
    }
}
