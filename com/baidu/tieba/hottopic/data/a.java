package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes21.dex */
public class a implements q {
    public static final BdUniqueId jOO = BdUniqueId.gen();
    public String jOP;
    public String jOQ;
    public int jOR;
    public String jOS;
    public String jOT;
    public int jOU;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jOO;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.jOP = commonInteraction.module_name;
            this.jOQ = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.jOR = commonInteraction.has_clicked.intValue();
            this.jOS = commonInteraction.before_click_pic;
            this.jOT = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
