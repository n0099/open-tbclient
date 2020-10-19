package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes22.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.hJX = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.hJY = resource.user_image;
            this.hJZ = resource.user_link;
            this.hKa = resource.res_title;
            this.hKb = resource.res_image;
            this.hKc = resource.res_link;
            this.hKd = resource.position.longValue();
            this.hKe = resource.icon_text;
        }
    }
}
