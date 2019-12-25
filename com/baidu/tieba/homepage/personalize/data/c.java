package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.fIn = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.fIo = resource.user_image;
            this.fIp = resource.user_link;
            this.fIq = resource.res_title;
            this.fIr = resource.res_image;
            this.fIs = resource.res_link;
            this.fIt = resource.position.longValue();
            this.fIu = resource.icon_text;
        }
    }
}
