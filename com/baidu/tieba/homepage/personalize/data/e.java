package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.a.r;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends r {
    public void a(Resource resource) {
        if (resource != null) {
            this.aWL = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.aWM = resource.user_image;
            this.aWN = resource.user_link;
            this.aWO = resource.res_title;
            this.aWP = resource.res_image;
            this.aWQ = resource.res_link;
            this.aWR = resource.position.longValue();
            this.aWS = resource.icon_text;
        }
    }
}
