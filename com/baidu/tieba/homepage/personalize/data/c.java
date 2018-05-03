package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.csH = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.csI = resource.user_image;
            this.csJ = resource.user_link;
            this.csK = resource.res_title;
            this.csL = resource.res_image;
            this.csM = resource.res_link;
            this.csN = resource.position.longValue();
            this.csO = resource.icon_text;
        }
    }
}
