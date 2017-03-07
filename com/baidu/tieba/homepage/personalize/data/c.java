package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.s;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends s {
    public void a(Resource resource) {
        if (resource != null) {
            this.bvZ = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bwa = resource.user_image;
            this.bwb = resource.user_link;
            this.bwc = resource.res_title;
            this.bwd = resource.res_image;
            this.bwe = resource.res_link;
            this.bwf = resource.position.longValue();
            this.bwg = resource.icon_text;
        }
    }
}
