package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.s;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class c extends s {
    public void a(Resource resource) {
        if (resource != null) {
            this.bpe = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.bpf = resource.user_image;
            this.bpg = resource.user_link;
            this.bph = resource.res_title;
            this.bpi = resource.res_image;
            this.bpj = resource.res_link;
            this.bpk = resource.position.longValue();
            this.bpl = resource.icon_text;
        }
    }
}
