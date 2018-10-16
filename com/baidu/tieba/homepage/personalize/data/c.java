package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cRb = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cRc = resource.user_image;
            this.cRd = resource.user_link;
            this.cRe = resource.res_title;
            this.cRf = resource.res_image;
            this.cRg = resource.res_link;
            this.cRh = resource.position.longValue();
            this.cRi = resource.icon_text;
        }
    }
}
