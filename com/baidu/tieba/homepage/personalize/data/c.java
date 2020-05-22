package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes9.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.gIo = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.gIp = resource.user_image;
            this.gIq = resource.user_link;
            this.gIr = resource.res_title;
            this.gIs = resource.res_image;
            this.gIt = resource.res_link;
            this.gIu = resource.position.longValue();
            this.gIv = resource.icon_text;
        }
    }
}
