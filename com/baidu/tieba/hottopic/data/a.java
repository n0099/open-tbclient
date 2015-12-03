package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes.dex */
public class a implements u {
    public static final BdUniqueId bDv = BdUniqueId.gen();
    public String bDA;
    public String bDB;
    public long bDC;
    public long bDD;
    public String bDw;
    public String bDx;
    public long bDy;
    public int bDz;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bDv;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.bDw = commonInteraction.module_name;
            this.bDx = commonInteraction.ques_desc;
            this.bDy = commonInteraction.total_num.longValue();
            this.bDz = commonInteraction.has_clicked.intValue();
            this.bDA = commonInteraction.before_click_pic;
            this.bDB = commonInteraction.after_click_pic;
            this.bDC = commonInteraction.pk_id.longValue();
            this.bDD = commonInteraction.user_pk_id.longValue();
        }
    }
}
