package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.fOi = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.fOj = resource.user_image;
            this.fOk = resource.user_link;
            this.fOl = resource.res_title;
            this.fOm = resource.res_image;
            this.fOn = resource.res_link;
            this.fOo = resource.position.longValue();
            this.fOp = resource.icon_text;
        }
    }
}
