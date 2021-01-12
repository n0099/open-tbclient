package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.ivT = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.ivU = resource.user_image;
            this.ivV = resource.user_link;
            this.ivW = resource.res_title;
            this.ivX = resource.res_image;
            this.ivY = resource.res_link;
            this.ivZ = resource.position.longValue();
            this.iwa = resource.icon_text;
        }
    }
}
