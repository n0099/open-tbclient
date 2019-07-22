package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eGN = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eGO = resource.user_image;
            this.eGP = resource.user_link;
            this.eGQ = resource.res_title;
            this.eGR = resource.res_image;
            this.eGS = resource.res_link;
            this.eGT = resource.position.longValue();
            this.eGU = resource.icon_text;
        }
    }
}
