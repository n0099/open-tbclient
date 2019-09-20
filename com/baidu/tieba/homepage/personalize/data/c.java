package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eID = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eIE = resource.user_image;
            this.eIF = resource.user_link;
            this.eIG = resource.res_title;
            this.eIH = resource.res_image;
            this.eII = resource.res_link;
            this.eIJ = resource.position.longValue();
            this.eIK = resource.icon_text;
        }
    }
}
