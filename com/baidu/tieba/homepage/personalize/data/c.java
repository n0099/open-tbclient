package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.cev = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cew = resource.user_image;
            this.cex = resource.user_link;
            this.cey = resource.res_title;
            this.cez = resource.res_image;
            this.ceA = resource.res_link;
            this.ceB = resource.position.longValue();
            this.ceC = resource.icon_text;
        }
    }
}
