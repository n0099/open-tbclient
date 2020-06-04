package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.gIz = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.gIA = resource.user_image;
            this.gIB = resource.user_link;
            this.gIC = resource.res_title;
            this.gID = resource.res_image;
            this.gIE = resource.res_link;
            this.gIF = resource.position.longValue();
            this.gIG = resource.icon_text;
        }
    }
}
