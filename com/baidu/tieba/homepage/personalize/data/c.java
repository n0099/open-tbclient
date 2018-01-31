package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.cYo = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cYp = resource.user_image;
            this.cYq = resource.user_link;
            this.cYr = resource.res_title;
            this.cYs = resource.res_image;
            this.cYt = resource.res_link;
            this.cYu = resource.position.longValue();
            this.cYv = resource.icon_text;
        }
    }
}
