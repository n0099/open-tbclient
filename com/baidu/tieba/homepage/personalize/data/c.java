package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.gtD = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.gtE = resource.user_image;
            this.gtF = resource.user_link;
            this.gtG = resource.res_title;
            this.gtH = resource.res_image;
            this.gtI = resource.res_link;
            this.gtJ = resource.position.longValue();
            this.gtK = resource.icon_text;
        }
    }
}
