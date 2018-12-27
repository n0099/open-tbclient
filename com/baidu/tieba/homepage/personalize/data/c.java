package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.dbG = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.dbH = resource.user_image;
            this.dbI = resource.user_link;
            this.dbJ = resource.res_title;
            this.dbK = resource.res_image;
            this.dbL = resource.res_link;
            this.dbM = resource.position.longValue();
            this.dbN = resource.icon_text;
        }
    }
}
