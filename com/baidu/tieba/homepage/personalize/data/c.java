package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes16.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.hbd = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.hbe = resource.user_image;
            this.hbf = resource.user_link;
            this.hbg = resource.res_title;
            this.hbh = resource.res_image;
            this.hbi = resource.res_link;
            this.hbj = resource.position.longValue();
            this.hbk = resource.icon_text;
        }
    }
}
