package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bOM = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bON = resource.user_image;
            this.bOO = resource.user_link;
            this.bOP = resource.res_title;
            this.bOQ = resource.res_image;
            this.bOR = resource.res_link;
            this.bOS = resource.position.longValue();
            this.bOT = resource.icon_text;
        }
    }
}
