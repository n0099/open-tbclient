package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.ceN = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.ceO = resource.user_image;
            this.ceP = resource.user_link;
            this.ceQ = resource.res_title;
            this.ceR = resource.res_image;
            this.ceS = resource.res_link;
            this.ceT = resource.position.longValue();
            this.ceU = resource.icon_text;
        }
    }
}
