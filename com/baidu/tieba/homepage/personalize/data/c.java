package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eBQ = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eBR = resource.user_image;
            this.eBS = resource.user_link;
            this.eBT = resource.res_title;
            this.eBU = resource.res_image;
            this.eBV = resource.res_link;
            this.eBW = resource.position.longValue();
            this.eBX = resource.icon_text;
        }
    }
}
