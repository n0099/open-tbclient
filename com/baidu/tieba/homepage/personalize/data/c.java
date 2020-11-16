package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes21.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.idg = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.idh = resource.user_image;
            this.idi = resource.user_link;
            this.idj = resource.res_title;
            this.idk = resource.res_image;
            this.idm = resource.res_link;
            this.idn = resource.position.longValue();
            this.ido = resource.icon_text;
        }
    }
}
