package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.emq = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.emr = resource.user_image;
            this.ems = resource.user_link;
            this.emt = resource.res_title;
            this.emu = resource.res_image;
            this.emv = resource.res_link;
            this.emw = resource.position.longValue();
            this.emx = resource.icon_text;
        }
    }
}
