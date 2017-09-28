package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bOs = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bOt = resource.user_image;
            this.bOu = resource.user_link;
            this.bOv = resource.res_title;
            this.bOw = resource.res_image;
            this.bOx = resource.res_link;
            this.bOy = resource.position.longValue();
            this.bOz = resource.icon_text;
        }
    }
}
