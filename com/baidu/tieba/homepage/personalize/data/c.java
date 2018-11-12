package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cSh = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cSi = resource.user_image;
            this.cSj = resource.user_link;
            this.cSk = resource.res_title;
            this.cSl = resource.res_image;
            this.cSm = resource.res_link;
            this.cSn = resource.position.longValue();
            this.cSo = resource.icon_text;
        }
    }
}
