package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes15.dex */
public class a implements q {
    public static final BdUniqueId iJJ = BdUniqueId.gen();
    public String iJK;
    public String iJL;
    public int iJM;
    public String iJN;
    public String iJO;
    public int iJP;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iJJ;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.iJK = commonInteraction.module_name;
            this.iJL = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.iJM = commonInteraction.has_clicked.intValue();
            this.iJN = commonInteraction.before_click_pic;
            this.iJO = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
