package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes15.dex */
public class a implements q {
    public static final BdUniqueId iJH = BdUniqueId.gen();
    public String iJI;
    public String iJJ;
    public int iJK;
    public String iJL;
    public String iJM;
    public int iJN;
    public long pkId;
    public long totalNum;
    public long userPkId;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iJH;
    }

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction != null) {
            this.iJI = commonInteraction.module_name;
            this.iJJ = commonInteraction.ques_desc;
            this.totalNum = commonInteraction.total_num.longValue();
            this.iJK = commonInteraction.has_clicked.intValue();
            this.iJL = commonInteraction.before_click_pic;
            this.iJM = commonInteraction.after_click_pic;
            this.pkId = commonInteraction.pk_id.longValue();
            this.userPkId = commonInteraction.user_pk_id.longValue();
        }
    }
}
