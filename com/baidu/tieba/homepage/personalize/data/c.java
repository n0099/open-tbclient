package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.bJi = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bJj = resource.user_image;
            this.bJk = resource.user_link;
            this.bJl = resource.res_title;
            this.bJm = resource.res_image;
            this.bJn = resource.res_link;
            this.bJo = resource.position.longValue();
            this.bJp = resource.icon_text;
        }
    }
}
