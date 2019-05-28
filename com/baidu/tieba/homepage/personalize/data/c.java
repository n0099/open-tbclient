package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.eBR = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eBS = resource.user_image;
            this.eBT = resource.user_link;
            this.eBU = resource.res_title;
            this.eBV = resource.res_image;
            this.eBW = resource.res_link;
            this.eBX = resource.position.longValue();
            this.eBY = resource.icon_text;
        }
    }
}
