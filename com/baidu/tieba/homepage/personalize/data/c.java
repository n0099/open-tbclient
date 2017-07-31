package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bKs = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bKt = resource.user_image;
            this.bKu = resource.user_link;
            this.bKv = resource.res_title;
            this.bKw = resource.res_image;
            this.bKx = resource.res_link;
            this.bKy = resource.position.longValue();
            this.bKz = resource.icon_text;
        }
    }
}
