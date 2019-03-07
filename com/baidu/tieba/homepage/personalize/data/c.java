package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.emu = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.emv = resource.user_image;
            this.emw = resource.user_link;
            this.emx = resource.res_title;
            this.emy = resource.res_image;
            this.emz = resource.res_link;
            this.emA = resource.position.longValue();
            this.emB = resource.icon_text;
        }
    }
}
