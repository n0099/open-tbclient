package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.csK = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.csL = resource.user_image;
            this.csM = resource.user_link;
            this.csN = resource.res_title;
            this.csO = resource.res_image;
            this.csP = resource.res_link;
            this.csQ = resource.position.longValue();
            this.csR = resource.icon_text;
        }
    }
}
