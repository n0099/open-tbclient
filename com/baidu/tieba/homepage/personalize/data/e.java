package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.r;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e extends r {
    public void a(Resource resource) {
        if (resource != null) {
            this.bcD = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bcE = resource.user_image;
            this.bcF = resource.user_link;
            this.bcG = resource.res_title;
            this.bcH = resource.res_image;
            this.bcI = resource.res_link;
            this.bcJ = resource.position.longValue();
            this.bcK = resource.icon_text;
        }
    }
}
