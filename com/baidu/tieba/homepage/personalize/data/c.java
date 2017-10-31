package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bVL = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bVM = resource.user_image;
            this.bVN = resource.user_link;
            this.bVO = resource.res_title;
            this.bVP = resource.res_image;
            this.bVQ = resource.res_link;
            this.bVR = resource.position.longValue();
            this.bVS = resource.icon_text;
        }
    }
}
