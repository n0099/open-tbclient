package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes22.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.ioe = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.iof = resource.user_image;
            this.iog = resource.user_link;
            this.ioh = resource.res_title;
            this.ioi = resource.res_image;
            this.ioj = resource.res_link;
            this.iok = resource.position.longValue();
            this.iol = resource.icon_text;
        }
    }
}
