package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes20.dex */
public class a implements q {
    public static final BdUniqueId jhs = BdUniqueId.gen();
    public String jht;
    public String jhu;
    public int jhv;
    public String jhw;
    public String jhx;
    public int jhy;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jhs;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.jht = commonInteraction.module_name;
            this.jhu = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.jhv = commonInteraction.has_clicked.intValue();
            this.jhw = commonInteraction.before_click_pic;
            this.jhx = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
