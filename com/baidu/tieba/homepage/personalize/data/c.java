package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.iBD = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.iBE = resource.user_image;
            this.iBF = resource.user_link;
            this.iBG = resource.res_title;
            this.iBH = resource.res_image;
            this.iBI = resource.res_link;
            this.iBJ = resource.position.longValue();
            this.iBK = resource.icon_text;
        }
    }
}
