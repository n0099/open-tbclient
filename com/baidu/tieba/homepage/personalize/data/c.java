package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bOg = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bOh = resource.user_image;
            this.bOi = resource.user_link;
            this.bOj = resource.res_title;
            this.bOk = resource.res_image;
            this.bOl = resource.res_link;
            this.bOm = resource.position.longValue();
            this.bOn = resource.icon_text;
        }
    }
}
