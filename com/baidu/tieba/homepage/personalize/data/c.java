package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes6.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.dct = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.dcv = resource.user_image;
            this.dcw = resource.user_link;
            this.dcx = resource.res_title;
            this.dcy = resource.res_image;
            this.dcz = resource.res_link;
            this.dcA = resource.position.longValue();
            this.dcB = resource.icon_text;
        }
    }
}
