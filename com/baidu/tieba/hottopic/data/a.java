package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes.dex */
public class a implements u {
    public static final BdUniqueId bKz = BdUniqueId.gen();
    public String bKA;
    public String bKB;
    public long bKC;
    public int bKD;
    public String bKE;
    public String bKF;
    public long bKG;
    public long bKH;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bKz;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.bKA = commonInteraction.module_name;
            this.bKB = commonInteraction.ques_desc;
            this.bKC = commonInteraction.total_num.longValue();
            this.bKD = commonInteraction.has_clicked.intValue();
            this.bKE = commonInteraction.before_click_pic;
            this.bKF = commonInteraction.after_click_pic;
            this.bKG = commonInteraction.pk_id.longValue();
            this.bKH = commonInteraction.user_pk_id.longValue();
        }
    }
}
