package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.ctR = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.ctS = resource.user_image;
            this.ctT = resource.user_link;
            this.ctU = resource.res_title;
            this.ctV = resource.res_image;
            this.ctW = resource.res_link;
            this.ctX = resource.position.longValue();
            this.ctY = resource.icon_text;
        }
    }
}
