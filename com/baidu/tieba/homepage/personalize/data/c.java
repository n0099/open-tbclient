package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eQr = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eQs = resource.user_image;
            this.eQt = resource.user_link;
            this.eQu = resource.res_title;
            this.eQv = resource.res_image;
            this.eQw = resource.res_link;
            this.eQx = resource.position.longValue();
            this.eQy = resource.icon_text;
        }
    }
}
