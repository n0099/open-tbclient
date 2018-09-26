package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.cII = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cIJ = resource.user_image;
            this.cIK = resource.user_link;
            this.cIL = resource.res_title;
            this.cIM = resource.res_image;
            this.cIN = resource.res_link;
            this.cIO = resource.position.longValue();
            this.cIP = resource.icon_text;
        }
    }
}
