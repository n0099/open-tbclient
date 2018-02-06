package com.baidu.tieba.homepage.personalize.data;

import com.baidu.tieba.card.data.p;
import tbclient.Personalized.Resource;
/* loaded from: classes2.dex */
public class c extends p {
    public void a(Resource resource) {
        if (resource != null) {
            this.dbb = resource.res_id.longValue();
            this.userName = resource.user_name;
            this.dbc = resource.user_image;
            this.dbd = resource.user_link;
            this.dbe = resource.res_title;
            this.dbf = resource.res_image;
            this.dbg = resource.res_link;
            this.dbh = resource.position.longValue();
            this.dbi = resource.icon_text;
        }
    }
}
