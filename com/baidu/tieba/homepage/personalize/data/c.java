package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.iBR = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.iBS = resource.user_image;
            this.iBT = resource.user_link;
            this.iBU = resource.res_title;
            this.iBV = resource.res_image;
            this.iBW = resource.res_link;
            this.iBX = resource.position.longValue();
            this.iBY = resource.icon_text;
        }
    }
}
