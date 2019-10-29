package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eRi = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eRj = resource.user_image;
            this.eRk = resource.user_link;
            this.eRl = resource.res_title;
            this.eRm = resource.res_image;
            this.eRn = resource.res_link;
            this.eRo = resource.position.longValue();
            this.eRp = resource.icon_text;
        }
    }
}
