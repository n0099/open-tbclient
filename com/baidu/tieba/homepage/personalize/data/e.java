package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.a.r;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends r {
    public void a(Resource resource) {
        if (resource != null) {
            this.aVN = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.aVO = resource.user_image;
            this.aVP = resource.user_link;
            this.aVQ = resource.res_title;
            this.aVR = resource.res_image;
            this.aVS = resource.res_link;
            this.aVT = resource.position.longValue();
            this.aVU = resource.icon_text;
        }
    }
}
