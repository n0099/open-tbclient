package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes21.dex */
public class a implements q {
    public static final BdUniqueId kdd = BdUniqueId.gen();
    public String kde;
    public String kdf;
    public int kdg;
    public String kdh;
    public String kdi;
    public int kdj;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kdd;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.kde = commonInteraction.module_name;
            this.kdf = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.kdg = commonInteraction.has_clicked.intValue();
            this.kdh = commonInteraction.before_click_pic;
            this.kdi = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
