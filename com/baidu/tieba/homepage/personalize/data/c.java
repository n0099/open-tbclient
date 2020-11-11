package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes22.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.icr = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.ics = resource.user_image;
            this.ict = resource.user_link;
            this.icu = resource.res_title;
            this.icv = resource.res_image;
            this.icw = resource.res_link;
            this.icx = resource.position.longValue();
            this.icy = resource.icon_text;
        }
    }
}
