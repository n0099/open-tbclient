package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.o;
import tbclient.Personalized.Resource;
/* loaded from: classes4.dex */
public class c extends o {
    public void a(Resource resource) {
        if (resource != null) {
            this.emc = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.emd = resource.user_image;
            this.eme = resource.user_link;
            this.emf = resource.res_title;
            this.emg = resource.res_image;
            this.emh = resource.res_link;
            this.emi = resource.position.longValue();
            this.emj = resource.icon_text;
        }
    }
}
