package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes21.dex */
public class a implements q {
    public static final BdUniqueId jIQ = BdUniqueId.gen();
    public String jIR;
    public String jIS;
    public int jIT;
    public String jIU;
    public String jIV;
    public int jIW;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jIQ;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.jIR = commonInteraction.module_name;
            this.jIS = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.jIT = commonInteraction.has_clicked.intValue();
            this.jIU = commonInteraction.before_click_pic;
            this.jIV = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
