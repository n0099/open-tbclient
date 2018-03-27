package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.daS = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.daT = resource.user_image;
            this.daU = resource.user_link;
            this.daV = resource.res_title;
            this.daW = resource.res_image;
            this.daX = resource.res_link;
            this.daY = resource.position.longValue();
            this.daZ = resource.icon_text;
        }
    }
}
