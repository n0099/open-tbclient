package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.daP = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.daQ = resource.user_image;
            this.daR = resource.user_link;
            this.daS = resource.res_title;
            this.daT = resource.res_image;
            this.daU = resource.res_link;
            this.daV = resource.position.longValue();
            this.daW = resource.icon_text;
        }
    }
}
