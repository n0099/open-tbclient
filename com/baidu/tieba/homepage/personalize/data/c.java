package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.emd = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.eme = resource.user_image;
            this.emf = resource.user_link;
            this.emg = resource.res_title;
            this.emh = resource.res_image;
            this.emi = resource.res_link;
            this.emj = resource.position.longValue();
            this.emk = resource.icon_text;
        }
    }
}
