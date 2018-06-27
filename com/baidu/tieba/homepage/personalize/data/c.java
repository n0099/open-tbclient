package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cAp = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cAq = resource.user_image;
            this.cAr = resource.user_link;
            this.cAs = resource.res_title;
            this.cAt = resource.res_image;
            this.cAu = resource.res_link;
            this.cAv = resource.position.longValue();
            this.cAw = resource.icon_text;
        }
    }
}
