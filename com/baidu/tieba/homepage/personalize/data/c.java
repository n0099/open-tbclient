package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.dcs = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.dct = resource.user_image;
            this.dcv = resource.user_link;
            this.dcw = resource.res_title;
            this.dcx = resource.res_image;
            this.dcy = resource.res_link;
            this.dcz = resource.position.longValue();
            this.dcA = resource.icon_text;
        }
    }
}
