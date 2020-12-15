package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes22.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.iog = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.ioh = resource.user_image;
            this.ioi = resource.user_link;
            this.ioj = resource.res_title;
            this.iok = resource.res_image;
            this.iol = resource.res_link;
            this.iom = resource.position.longValue();
            this.ion = resource.icon_text;
        }
    }
}
