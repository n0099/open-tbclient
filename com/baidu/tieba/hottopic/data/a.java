package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes15.dex */
public class a implements q {
    public static final BdUniqueId iYN = BdUniqueId.gen();
    public String iYO;
    public String iYP;
    public int iYQ;
    public String iYR;
    public String iYS;
    public int iYT;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iYN;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.iYO = commonInteraction.module_name;
            this.iYP = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.iYQ = commonInteraction.has_clicked.intValue();
            this.iYR = commonInteraction.before_click_pic;
            this.iYS = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
