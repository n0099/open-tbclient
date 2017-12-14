package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.ceJ = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.ceK = resource.user_image;
            this.ceL = resource.user_link;
            this.ceM = resource.res_title;
            this.ceN = resource.res_image;
            this.ceO = resource.res_link;
            this.ceP = resource.position.longValue();
            this.ceQ = resource.icon_text;
        }
    }
}
