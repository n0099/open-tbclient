package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bEe = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bEf = resource.user_image;
            this.bEg = resource.user_link;
            this.bEh = resource.res_title;
            this.bEi = resource.res_image;
            this.bEj = resource.res_link;
            this.bEk = resource.position.longValue();
            this.bEl = resource.icon_text;
        }
    }
}
