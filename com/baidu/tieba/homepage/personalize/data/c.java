package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.iDA = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.iDB = resource.user_image;
            this.iDC = resource.user_link;
            this.iDD = resource.res_title;
            this.iDE = resource.res_image;
            this.iDF = resource.res_link;
            this.iDG = resource.position.longValue();
            this.iDH = resource.icon_text;
        }
    }
}
