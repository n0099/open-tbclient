package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes21.dex */
public class a implements q {
    public static final BdUniqueId kdb = BdUniqueId.gen();
    public String kdc;
    public String kdd;
    public int kde;
    public String kdf;
    public String kdg;
    public int kdh;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kdb;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.kdc = commonInteraction.module_name;
            this.kdd = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.kde = commonInteraction.has_clicked.intValue();
            this.kdf = commonInteraction.before_click_pic;
            this.kdg = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
