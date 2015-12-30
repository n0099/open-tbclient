package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes.dex */
public class a implements u {
    public static final BdUniqueId bGZ = BdUniqueId.gen();
    public String bHa;
    public String bHb;
    public long bHc;
    public int bHd;
    public String bHe;
    public String bHf;
    public long bHg;
    public long bHh;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bGZ;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.bHa = commonInteraction.module_name;
            this.bHb = commonInteraction.ques_desc;
            this.bHc = commonInteraction.total_num.longValue();
            this.bHd = commonInteraction.has_clicked.intValue();
            this.bHe = commonInteraction.before_click_pic;
            this.bHf = commonInteraction.after_click_pic;
            this.bHg = commonInteraction.pk_id.longValue();
            this.bHh = commonInteraction.user_pk_id.longValue();
        }
    }
}
