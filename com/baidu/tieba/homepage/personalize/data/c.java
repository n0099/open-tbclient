package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.q;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends q {
    public void a(Resource resource) {
        if (resource != null) {
            this.cTr = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.cTs = resource.user_image;
            this.cTt = resource.user_link;
            this.cTu = resource.res_title;
            this.cTv = resource.res_image;
            this.cTw = resource.res_link;
            this.cTx = resource.position.longValue();
            this.cTy = resource.icon_text;
        }
    }
}
